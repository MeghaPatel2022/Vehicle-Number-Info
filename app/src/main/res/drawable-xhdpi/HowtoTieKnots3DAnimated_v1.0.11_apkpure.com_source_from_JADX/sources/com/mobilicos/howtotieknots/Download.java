package com.mobilicos.howtotieknots;

import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Download extends Activity implements OnItemClickListener, OnNavigationListener {
    public static final int DIALOG_DOWNLOAD_ITEMLIST_PROGRESS = 1;
    public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
    private final int APPOFTHEDAY_USER_LIMIT = 60;
    private final int REGULAR_USER_LIMIT = 25;
    /* access modifiers changed from: private */
    public int appOfTheDayUser;
    private long interval = 84600;
    /* access modifiers changed from: private */
    public List<ItemDetails> itemDetailsList;
    /* access modifiers changed from: private */
    public HashMap<Integer, Integer> itemStatuses = new HashMap<>();
    /* access modifiers changed from: private */
    public int itemsCounter = 0;
    /* access modifiers changed from: private */
    public boolean listDataLoaded = false;
    /* access modifiers changed from: private */
    public boolean listDataLoading = false;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressDialog;
    private String uri = "http://howset.com/xmlcache/how-to-make-origami/android/list.xml";
    private String uri_details = "http://howset.com/xmlcache/how-to-make-origami/android/details/ident/";

    class DownloadFileAsync extends AsyncTask<ItemDetails, Void, Long> {
        Context context;
        boolean is_success = false;

        public DownloadFileAsync(Context _context) {
            this.context = _context;
        }

        /* access modifiers changed from: protected */
        public Long doInBackground(ItemDetails... items) {
            long total = 0;
            try {
                URL url = new URL(items[0].getItem().icon);
                URLConnection conexion = url.openConnection();
                conexion.connect();
                int contentLength = conexion.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream());
                File saveDir = Utils.getStoragePath(this.context);
                if (!saveDir.exists()) {
                    saveDir.mkdirs();
                }
                OutputStream output = new FileOutputStream(new File(Utils.getStoragePath(this.context), "cache_" + items[0].getItem().ident + "_icon.png").getAbsolutePath());
                byte[] data = new byte[1024];
                while (true) {
                    int count = input.read(data);
                    if (count == -1) {
                        break;
                    }
                    total += (long) count;
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
                this.is_success = true;
            } catch (Exception e) {
                Utils.notificationAlertDialog(Download.this, "Can not download items images.");
                Download.this.dismissDialog(0);
            }
            return Long.valueOf(total);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Long unused) {
            if (this.is_success) {
                if (Download.this.itemsCounter < Download.this.itemDetailsList.size()) {
                    Download.this.itemsCounter = Download.this.itemsCounter + 1;
                    Download.this.mProgressDialog.setProgress(Download.this.itemsCounter);
                }
                if (Download.this.itemsCounter == Download.this.itemDetailsList.size()) {
                    Editor editor = Download.this.getSharedPreferences(Download.this.getPackageName(), 0).edit();
                    editor.putLong("lastItemsListImagesDownloaded", new Date().getTime());
                    editor.commit();
                    Download.this.dismissDialog(0);
                    Download.this.saveItemsToDb(Download.this.itemDetailsList);
                    Download.this.populateList();
                    Download.this.listDataLoaded = true;
                    Download.this.listDataLoading = false;
                    return;
                }
                return;
            }
            Download.this.listDataLoading = false;
        }
    }

    class DownloadItemDetailsAsync extends AsyncTask<String, Void, Integer> {
        ItemDetails currentItemDetails;
        View currentRowView;
        boolean is_success = false;
        ItemDetails itemDetails;
        int position;
        int total = 0;

        public DownloadItemDetailsAsync(List<ItemDetails> itemDetailsList, int position2, View view) {
            this.currentRowView = ((ItemDetails) itemDetailsList.get(position2)).getView();
            this.currentItemDetails = (ItemDetails) itemDetailsList.get(position2);
            this.position = position2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(String... urls) {
            try {
                this.itemDetails = new XMLItemParser(urls[0], this.currentItemDetails).parse();
                this.itemDetails.setIsLoading(true);
                this.itemDetails.setView(this.currentRowView);
                Download.this.itemDetailsList.set(this.position, this.itemDetails);
                this.is_success = true;
            } catch (Exception e) {
            }
            return Integer.valueOf(this.total);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer unused) {
            ProgressBar progressBar = (ProgressBar) this.currentRowView.findViewById(C1295R.C1297id.progressBar);
            if (this.is_success) {
                if (((Integer) progressBar.getTag()).intValue() == ((ItemDetails) Download.this.itemDetailsList.get(this.position)).getItem().ident) {
                    progressBar.setMax(((ItemDetails) Download.this.itemDetailsList.get(this.position)).getProgressMaxValue());
                    progressBar.setProgress(0);
                    progressBar.setVisibility(0);
                }
                Download.this.downloadItemImages(Download.this.itemDetailsList, this.position, this.currentRowView, 0);
            } else if (((Integer) progressBar.getTag()).intValue() == ((ItemDetails) Download.this.itemDetailsList.get(this.position)).getItem().ident) {
                this.currentItemDetails.setIsLoading(false);
                this.currentItemDetails.setIsLoaded(false);
                this.currentItemDetails.setIsWrongLoading(true);
                progressBar.setMax(0);
                progressBar.setProgress(0);
                progressBar.setVisibility(4);
                ((ImageView) this.currentRowView.findViewById(C1295R.C1297id.button)).setBackgroundResource(C1295R.C1296drawable.warning);
            }
        }
    }

    class DownloadItemImageAsync extends AsyncTask<String, Void, Long> {
        Context context;
        ItemDetails currentItemDetails;
        View currentView;
        boolean is_success = false;
        List<ItemDetails> itemDetailsList;
        int position;

        public DownloadItemImageAsync(List<ItemDetails> itemDetailsList2, int position2, View view, int next, Context _context) {
            this.currentItemDetails = (ItemDetails) itemDetailsList2.get(position2);
            this.itemDetailsList = itemDetailsList2;
            this.currentView = ((ItemDetails) itemDetailsList2.get(position2)).getView();
            this.position = position2;
            this.context = _context;
        }

        /* access modifiers changed from: protected */
        public Long doInBackground(String... urls) {
            long total = 0;
            try {
                URL url = new URL(urls[1]);
                URLConnection conexion = url.openConnection();
                conexion.connect();
                int contentLength = conexion.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream());
                File saveDir = Utils.getStoragePath(this.context);
                if (!saveDir.exists()) {
                    saveDir.mkdirs();
                }
                OutputStream output = new FileOutputStream(new File(Utils.getStoragePath(this.context), urls[0]).getAbsolutePath());
                byte[] data = new byte[1024];
                while (true) {
                    int count = input.read(data);
                    if (count == -1) {
                        break;
                    }
                    total += (long) count;
                    output.write(data, 0, count);
                }
                output.flush();
                output.close();
                input.close();
                this.is_success = true;
            } catch (Exception e) {
            }
            return Long.valueOf(total);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Long unused) {
            ProgressBar progressBar = (ProgressBar) this.currentView.findViewById(C1295R.C1297id.progressBar);
            if (!this.is_success) {
                if (((Integer) progressBar.getTag()).intValue() == ((ItemDetails) this.itemDetailsList.get(this.position)).getItem().ident) {
                    progressBar.setMax(0);
                    progressBar.setProgress(0);
                    progressBar.setVisibility(4);
                    ((ImageView) this.currentView.findViewById(C1295R.C1297id.button)).setBackgroundResource(C1295R.C1296drawable.warning);
                }
                ((ItemDetails) this.itemDetailsList.get(this.position)).setIsLoading(false);
                ((ItemDetails) this.itemDetailsList.get(this.position)).setIsLoaded(false);
                ((ItemDetails) this.itemDetailsList.get(this.position)).setIsWrongLoading(true);
            } else if (this.currentItemDetails.getProgressCurrentValue() < this.currentItemDetails.getProgressMaxValue()) {
                this.currentItemDetails.increaseProgressCurrent();
                if (((Integer) progressBar.getTag()).intValue() == ((ItemDetails) this.itemDetailsList.get(this.position)).getItem().ident) {
                    progressBar.setProgress(this.currentItemDetails.getProgressCurrentValue());
                }
                if (this.currentItemDetails.getProgressCurrentValue() < this.currentItemDetails.getProgressMaxValue()) {
                    Download.this.downloadItemImages(this.itemDetailsList, this.position, this.currentView, this.currentItemDetails.getProgressCurrentValue());
                } else {
                    Download.this.saveItemToDb(this.position);
                }
            }
        }
    }

    class DownloadItemsListAsync extends AsyncTask<String, Void, Integer> {
        boolean is_success = false;
        int total = 0;

        public DownloadItemsListAsync() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            Download.this.showDialog(1);
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(String... urls) {
            try {
                XMLParser parser = new XMLParser(urls[0]);
                if (Download.this.appOfTheDayUser != 1) {
                    Download.this.itemDetailsList = parser.parse(25);
                } else {
                    Download.this.itemDetailsList = parser.parse(60);
                }
                this.is_success = true;
            } catch (Exception e) {
                Utils.notificationAlertDialog(Download.this, "Can not download items list.");
                Download.this.dismissDialog(1);
            }
            return Integer.valueOf(this.total);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer unused) {
            if (this.is_success) {
                Download.this.mProgressDialog.setProgress(Download.this.itemsCounter);
                Download.this.dismissDialog(1);
                Download.this.downloadItemsImages();
                return;
            }
            Download.this.listDataLoading = false;
        }
    }

    public class ItemDetailsListAdapter extends ArrayAdapter<ItemDetails> {
        private Context context;
        private List<ItemDetails> itemDetailsList;

        public ItemDetailsListAdapter(Context context2, int layoutResourceId, List<ItemDetails> itemDetailsList2) {
            super(context2, layoutResourceId, itemDetailsList2);
            this.context = context2;
            this.itemDetailsList = itemDetailsList2;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout rowLayout;
            if (convertView == null) {
                rowLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C1295R.layout.download_list_item, null);
            } else {
                rowLayout = (LinearLayout) convertView;
            }
            ItemDetails currentItemDetails = (ItemDetails) this.itemDetailsList.get(position);
            ((ItemDetails) this.itemDetailsList.get(position)).setView(rowLayout);
            TextView firstLine = (TextView) rowLayout.findViewById(C1295R.C1297id.firstLine);
            TextView secondLine = (TextView) rowLayout.findViewById(C1295R.C1297id.secondLine);
            ProgressBar progressBar = (ProgressBar) rowLayout.findViewById(C1295R.C1297id.progressBar);
            ImageView button = (ImageView) rowLayout.findViewById(C1295R.C1297id.button);
            ((ImageView) rowLayout.findViewById(C1295R.C1297id.icon)).setImageBitmap(BitmapFactory.decodeFile(new File(Utils.getStoragePath(this.context), "cache_" + currentItemDetails.getItem().ident + "_icon.png").getAbsolutePath()));
            if (((ItemDetails) this.itemDetailsList.get(position)).getIsLoaded()) {
                button.setBackgroundResource(C1295R.C1296drawable.accept);
            } else if (Download.this.itemStatuses.keySet().contains(Integer.valueOf(((ItemDetails) this.itemDetailsList.get(position)).getItem().ident))) {
                button.setBackgroundResource(C1295R.C1296drawable.accept);
            } else if (((ItemDetails) this.itemDetailsList.get(position)).getIsLoading()) {
                button.setBackgroundResource(C1295R.C1296drawable.down);
            } else if (((ItemDetails) this.itemDetailsList.get(position)).getIsWrongLoading()) {
                button.setBackgroundResource(C1295R.C1296drawable.warning);
            } else {
                button.setBackgroundResource(C1295R.C1296drawable.add);
            }
            firstLine.setText(currentItemDetails.getItem().name);
            secondLine.setText(currentItemDetails.getItem().description);
            progressBar.setTag(Integer.valueOf(((ItemDetails) this.itemDetailsList.get(position)).getItem().ident));
            if (((ItemDetails) this.itemDetailsList.get(position)).getIsLoading()) {
                progressBar.setVisibility(0);
                progressBar.setMax(((ItemDetails) this.itemDetailsList.get(position)).getProgressMaxValue());
                progressBar.setProgress(((ItemDetails) this.itemDetailsList.get(position)).getProgressCurrentValue());
            } else {
                progressBar.setVisibility(4);
            }
            return rowLayout;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1295R.layout.download_list);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.appOfTheDayUser = getSharedPreferences("AppOfTheDayUser", 0).getInt("AppOfTheDayUser", -1);
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this);
        dbOpenHelper.createDataBase();
        Cursor myCursor = dbOpenHelper.getReadableDatabase().rawQuery("SELECT ident FROM lesson_item WHERE is_active=1", null);
        while (myCursor.moveToNext()) {
            this.itemStatuses.put(Integer.valueOf(myCursor.getInt(myCursor.getColumnIndex("ident"))), Integer.valueOf(1));
        }
        myCursor.close();
        dbOpenHelper.close();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case C1295R.C1297id.favorites /*2131624100*/:
                startActivity(new Intent(this, FavoritesList.class));
                break;
            case C1295R.C1297id.more_apps /*2131624101*/:
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://developer?id=Mobilicos")));
                    break;
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/developer?id=Mobilicos")));
                    break;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1295R.C1298menu.downloads_menu, menu);
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (!((ItemDetails) this.itemDetailsList.get(position)).getIsLoaded() && !((ItemDetails) this.itemDetailsList.get(position)).getIsLoading() && !this.itemStatuses.keySet().contains(Integer.valueOf(((ItemDetails) this.itemDetailsList.get(position)).getItem().ident))) {
            ((ImageView) view.findViewById(C1295R.C1297id.button)).setBackgroundResource(C1295R.C1296drawable.down);
            ProgressBar progressBar = (ProgressBar) view.findViewById(C1295R.C1297id.progressBar);
            progressBar.setMax(1);
            progressBar.setProgress(0);
            progressBar.setVisibility(0);
            ((ItemDetails) this.itemDetailsList.get(position)).setIsLoading(true);
            new DownloadItemDetailsAsync(this.itemDetailsList, position, view).execute(new String[]{this.uri_details + ((ItemDetails) this.itemDetailsList.get(position)).getItem().ident + ".xml"});
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.listDataLoaded) {
            populateList();
        } else if (this.listDataLoading) {
        } else {
            if (!Utils.isOnline(this)) {
                Builder builder = new Builder(this);
                builder.setTitle("Internet connection is not available.");
                builder.setPositiveButton("Ok", new OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
                return;
            }
            this.listDataLoading = true;
            new DownloadItemsListAsync().execute(new String[]{this.uri});
        }
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                this.mProgressDialog = new ProgressDialog(this);
                this.mProgressDialog.setMessage("Downloading images..");
                this.mProgressDialog.setProgressStyle(1);
                this.mProgressDialog.setCancelable(false);
                this.mProgressDialog.setMax(this.itemDetailsList.size());
                this.mProgressDialog.show();
                return this.mProgressDialog;
            case 1:
                this.mProgressDialog = new ProgressDialog(this);
                this.mProgressDialog.setMessage("Downloading items list..");
                this.mProgressDialog.setProgressStyle(0);
                this.mProgressDialog.setCancelable(false);
                this.mProgressDialog.setMax(1);
                this.mProgressDialog.show();
                return this.mProgressDialog;
            default:
                return null;
        }
    }

    public void downloadItemsImages() {
        if (new Date().getTime() - getSharedPreferences(getPackageName(), 0).getLong("lastItemsListImagesDownloaded", 0) > this.interval) {
            showDialog(0);
            for (int i = 0; i < this.itemDetailsList.size(); i++) {
                startDownload((ItemDetails) this.itemDetailsList.get(i));
            }
            return;
        }
        populateList();
        this.listDataLoaded = true;
        this.listDataLoading = false;
    }

    public void downloadItemImages(List<ItemDetails> itemDetailsList2, int position, View view, int next) {
        for (Entry<String, String> entry : ((HashMap) ((ItemDetails) itemDetailsList2.get(position)).getAllImages().get(next)).entrySet()) {
            new DownloadItemImageAsync(itemDetailsList2, position, view, next, this).execute(new String[]{(String) entry.getKey(), (String) entry.getValue()});
        }
    }

    private void startDownload(ItemDetails itemDetails) {
        new DownloadFileAsync(this).execute(new ItemDetails[]{itemDetails});
    }

    public void saveItemsToDb(List<ItemDetails> list) {
    }

    public void saveItemToDb(int position) {
        ItemDetails itemDetails = (ItemDetails) this.itemDetailsList.get(position);
        Item item = ((ItemDetails) this.itemDetailsList.get(position)).getItem();
        View view = itemDetails.getView();
        ImageView button = (ImageView) view.findViewById(C1295R.C1297id.button);
        ProgressBar progressBar = (ProgressBar) view.findViewById(C1295R.C1297id.progressBar);
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this);
        dbOpenHelper.createDataBase();
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ident", Integer.valueOf(item.ident));
        cv.put("name", item.name);
        cv.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, item.description);
        cv.put("slug", item.slug);
        cv.put("category_ident", Integer.valueOf(item.category_ident));
        cv.put("alternative_names", item.alternative_names);
        cv.put("sort_order", Integer.valueOf(item.sort_order));
        cv.put("steps_count", Integer.valueOf(item.steps_count));
        cv.put("level", item.level);
        cv.put("is_base", Integer.valueOf(item.is_base));
        cv.put("is_active", Integer.valueOf(item.is_active));
        cv.put("is_paid", Integer.valueOf(item.is_paid));
        long itemId = db.insert("lesson_item", null, cv);
        for (ItemStep step : itemDetails.getSteps()) {
            ContentValues cv2 = new ContentValues();
            cv2.put("item_id", Long.valueOf(itemId));
            cv2.put("step_number", Integer.valueOf(step.step_number));
            cv2.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, step.description);
            cv2.put("sort_order", Integer.valueOf(step.sort_order));
            cv2.put("frames_count", Integer.valueOf(step.frames_count));
            cv2.put("is_active", Integer.valueOf(step.is_active));
            long stepId = db.insert("lesson_step", null, cv2);
            for (StepFrame frame : step.getFrames()) {
                ContentValues cv3 = new ContentValues();
                cv3.put("item_id", Long.valueOf(itemId));
                cv3.put("step_id", Long.valueOf(stepId));
                cv3.put("sort_order", Integer.valueOf(frame.sort_order));
                cv3.put("is_active", Integer.valueOf(frame.is_active));
                db.insert("lesson_frame", null, cv3);
            }
        }
        db.execSQL("UPDATE lesson_category SET items_count=items_count+1 WHERE ident=" + item.category_ident);
        dbOpenHelper.close();
        this.itemStatuses.put(Integer.valueOf(item.ident), Integer.valueOf(1));
        if (((Integer) progressBar.getTag()).intValue() == ((ItemDetails) this.itemDetailsList.get(position)).getItem().ident) {
            progressBar.setVisibility(4);
        }
        button.setBackgroundResource(C1295R.C1296drawable.accept);
        ((ItemDetails) this.itemDetailsList.get(position)).setIsLoading(false);
        ((ItemDetails) this.itemDetailsList.get(position)).setIsLoaded(true);
    }

    public void populateList() {
        ListView lv = (ListView) findViewById(C1295R.C1297id.items_list);
        lv.setAdapter(new ItemDetailsListAdapter(this, C1295R.layout.download_list_item, this.itemDetailsList));
        lv.setOnItemClickListener(this);
    }
}
