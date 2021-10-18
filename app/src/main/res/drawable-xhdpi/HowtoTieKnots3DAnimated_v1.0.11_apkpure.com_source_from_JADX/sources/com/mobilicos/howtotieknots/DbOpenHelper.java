package com.mobilicos.howtotieknots;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class DbOpenHelper extends SQLiteOpenHelper {
    private static String ASSETS_DB_NAME = "data.sqlite";
    private static String DB_NAME = (Utils.checkExternalMedia() ? "dataex.sqlite" : "data.sqlite");
    private static String DB_PATH = "";
    private final Context myContext;
    private SQLiteDatabase myDataBase;

    public DbOpenHelper(Context context) {
        super(context, DB_NAME, null, 1);
        DB_PATH = Utils.getDBStoragePath(context, DB_NAME).getAbsolutePath();
        this.myContext = context;
    }

    public void createDataBase() {
        int versionCode = 0;
        try {
            versionCode = this.myContext.getPackageManager().getPackageInfo(this.myContext.getPackageName(), 0).versionCode;
        } catch (Exception e) {
        }
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this.myContext);
        int i = sharedPref.getInt("currentDBVersionCode", 0);
        if (!checkDataBase()) {
            try {
                copyDataBase();
                Editor editor = sharedPref.edit();
                editor.putInt("currentDBVersionCode", versionCode);
                editor.commit();
            } catch (IOException e2) {
                e2.printStackTrace();
                throw new Error("Error copying database: " + e2.getMessage());
            }
        }
    }

    private void copyDataBase() throws IOException {
        Log.e("!!! DB_PATH", DB_PATH);
        InputStream myInput = this.myContext.getAssets().open(ASSETS_DB_NAME);
        Log.e("!!! DB_PATH", DB_PATH);
        File saveDir = new File(DB_PATH);
        if (!saveDir.exists()) {
            saveDir.getParentFile().mkdirs();
        }
        String outFileName = DB_PATH;
        Log.e("!!! outFileName", outFileName);
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        while (true) {
            int length = myInput.read(buffer);
            if (length > 0) {
                myOutput.write(buffer, 0, length);
            } else {
                myOutput.flush();
                myOutput.close();
                myInput.close();
                Log.e("!!! outFileName !!!", outFileName);
                return;
            }
        }
    }

    private boolean checkDataBase() {
        return new File(DB_PATH).exists();
    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
