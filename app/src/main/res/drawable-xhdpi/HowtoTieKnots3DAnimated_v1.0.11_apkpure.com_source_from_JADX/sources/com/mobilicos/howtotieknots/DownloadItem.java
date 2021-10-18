package com.mobilicos.howtotieknots;

import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import com.google.android.gms.plus.PlusShare;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class DownloadItem {
    LessonsList context;
    ProgressDialog dialog;
    int ident;
    String uri_details;

    class DownloadItemDetailsAsync extends AsyncTask<String, Void, Long> {
        LessonsList context;
        int count;
        String errorMessage;
        int ident;
        boolean is_success = false;
        long total;
        String uri;

        public DownloadItemDetailsAsync(LessonsList _context, int _ident, String _uri) {
            this.context = _context;
            this.ident = _ident;
            this.uri = _uri;
            DownloadItem.this.dialog = ProgressDialog.show(this.context, "Loading", "Please wait...", true);
        }

        /* access modifiers changed from: protected */
        public Long doInBackground(String... urls) {
            try {
                URL url = new URL(this.uri + this.ident + ".zip");
                url.openConnection().connect();
                InputStream input = new BufferedInputStream(url.openStream());
                File saveDir = Utils.getStoragePath(this.context);
                if (!saveDir.exists()) {
                    saveDir.mkdirs();
                }
                OutputStream output = new FileOutputStream(new File(Utils.getStoragePath(this.context), this.ident + ".zip").getAbsolutePath());
                byte[] data = new byte[1024];
                while (true) {
                    int read = input.read(data);
                    this.count = read;
                    if (read == -1) {
                        break;
                    }
                    this.total += (long) this.count;
                    output.write(data, 0, this.count);
                }
                output.flush();
                output.close();
                input.close();
                DownloadItem.this.unpackZip(Utils.getStoragePath(this.context).getAbsolutePath(), this.ident + ".zip");
                DownloadItem.this.saveData(DownloadItem.this.parseJSONFile(new File(Utils.getStoragePath(this.context), this.ident + ".json")), this.context);
                this.is_success = true;
            } catch (Exception e) {
                this.errorMessage = e.getMessage();
            }
            return Long.valueOf(this.total);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Long unused) {
            DownloadItem.this.dialog.dismiss();
            if (!this.is_success) {
                Builder alertDialogBuilder = new Builder(this.context);
                alertDialogBuilder.setMessage("Error: " + this.errorMessage);
                alertDialogBuilder.create().show();
                return;
            }
            this.context.selectData();
            this.context.adapter.notifyDataSetChanged();
        }
    }

    public DownloadItem(LessonsList _context, int _ident, String _uri_details) {
        this.context = _context;
        this.ident = _ident;
        this.uri_details = _uri_details;
    }

    public void download() {
        new DownloadItemDetailsAsync(this.context, this.ident, this.uri_details).execute(new String[0]);
    }

    /* access modifiers changed from: private */
    public boolean unpackZip(String path, String zipname) throws Exception {
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(new File(path, zipname).getAbsolutePath())));
        byte[] buffer = new byte[1024];
        while (true) {
            ZipEntry ze = zis.getNextEntry();
            if (ze != null) {
                String filename = ze.getName();
                if (ze.isDirectory()) {
                    new File(path, filename).mkdirs();
                } else {
                    FileOutputStream fout = new FileOutputStream(new File(path, filename).getAbsolutePath());
                    while (true) {
                        int count = zis.read(buffer);
                        if (count == -1) {
                            break;
                        }
                        fout.write(buffer, 0, count);
                    }
                    fout.close();
                    zis.closeEntry();
                }
            } else {
                zis.close();
                return true;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public JSONObject parseJSONFile(File file) throws Exception {
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            while (true) {
                int n = reader.read(buffer);
                if (n != -1) {
                    writer.write(buffer, 0, n);
                } else {
                    is.close();
                    return new JSONObject(writer.toString());
                }
            }
        } catch (Throwable th) {
            is.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public boolean saveData(JSONObject mainObject, Context context2) throws Exception {
        DbOpenHelper dbOpenHelper = new DbOpenHelper(context2);
        dbOpenHelper.createDataBase();
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        JSONObject itemJSON = mainObject.getJSONObject("item");
        ContentValues cv = new ContentValues();
        cv.put("ident", Integer.valueOf(itemJSON.getInt("ident")));
        cv.put("name", itemJSON.getString("name"));
        cv.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, itemJSON.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
        cv.put("slug", itemJSON.getString("slug"));
        cv.put("category_ident", Integer.valueOf(itemJSON.getInt("category_ident")));
        cv.put("sort_order", Integer.valueOf(itemJSON.getInt("sort_order")));
        cv.put("steps_count", Integer.valueOf(itemJSON.getInt("steps_count")));
        cv.put("level", itemJSON.getString("level"));
        cv.put("tech_data", itemJSON.getString("tech_data"));
        cv.put("is_base", Integer.valueOf(0));
        cv.put("is_active", Integer.valueOf(1));
        cv.put("is_paid", Integer.valueOf(0));
        long itemId = db.insert("lesson_item", null, cv);
        JSONArray categoriesArray = itemJSON.getJSONArray("categories");
        for (int i = 0; i < categoriesArray.length(); i++) {
            JSONObject categoryObject = categoriesArray.getJSONObject(i);
            ContentValues cv2 = new ContentValues();
            cv2.put("category_ident", Integer.valueOf(categoryObject.getInt("category_ident")));
            cv2.put("item_ident", Integer.valueOf(itemJSON.getInt("ident")));
            db.insert("lesson_categories_items", null, cv2);
        }
        JSONArray purposesArray = itemJSON.getJSONArray("purposes");
        for (int i2 = 0; i2 < purposesArray.length(); i2++) {
            JSONObject purposeObject = purposesArray.getJSONObject(i2);
            ContentValues cv3 = new ContentValues();
            cv3.put("purpose_ident", Integer.valueOf(purposeObject.getInt("purpose_ident")));
            cv3.put("item_ident", Integer.valueOf(itemJSON.getInt("ident")));
            db.insert("lesson_purposes_items", null, cv3);
        }
        JSONArray stepsArray = itemJSON.getJSONArray("steps");
        for (int i3 = 0; i3 < stepsArray.length(); i3++) {
            JSONObject stepObject = stepsArray.getJSONObject(i3);
            ContentValues cv4 = new ContentValues();
            cv4.put("item_id", Long.valueOf(itemId));
            cv4.put("step_number", Integer.valueOf(stepObject.getInt("step_number")));
            cv4.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, stepObject.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
            cv4.put("sort_order", Integer.valueOf(stepObject.getInt("sort_order")));
            cv4.put("frames_count", Integer.valueOf(stepObject.getInt("frames_count")));
            cv4.put("is_active", Integer.valueOf(1));
            long stepId = db.insert("lesson_step", null, cv4);
            JSONArray framesArray = stepObject.getJSONArray("frames");
            for (int j = 0; j < framesArray.length(); j++) {
                JSONObject frameObject = framesArray.getJSONObject(j);
                ContentValues cv5 = new ContentValues();
                cv5.put("item_id", Long.valueOf(itemId));
                cv5.put("step_id", Long.valueOf(stepId));
                cv5.put("sort_order", Integer.valueOf(frameObject.getInt("sort_order")));
                cv5.put("is_active", Integer.valueOf(1));
                db.insert("lesson_frame", null, cv5);
            }
        }
        db.execSQL("UPDATE lesson_category SET items_count=items_count+1 WHERE ident=" + itemJSON.getInt("category_ident"));
        dbOpenHelper.close();
        return true;
    }
}
