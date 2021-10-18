package com.mobilicos.howtotieknotspro;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

public class Utils {

    /* renamed from: ct */
    public static Context f76ct;

    /* renamed from: mg */
    public static String f77mg;

    public static File getStoragePath(Context context) {
        File path;
        if (checkExternalMedia()) {
            path = context.getExternalFilesDir(null);
        } else {
            path = context.getFilesDir();
        }
        Log.e("FILE PATH: ", path.getAbsolutePath());
        return path;
    }

    public static File getDBStoragePath(Context context, String dbName) {
        return context.getDatabasePath(dbName);
    }

    public static boolean checkExternalMedia() {
        String state = Environment.getExternalStorageState();
        if ("mounted".equals(state)) {
            Log.e("Can r/w the media", "1");
            return true;
        } else if ("mounted_ro".equals(state)) {
            Log.e("Can only read the media", "2");
            return false;
        } else {
            Log.e("Can't read or write", "3");
            return false;
        }
    }

    public static void notificationAlertDialog(Context context, String message) {
        f76ct = context;
        f77mg = message;
        ((Activity) context).runOnUiThread(new Runnable() {
            public void run() {
                Builder builder = new Builder(Utils.f76ct);
                builder.setTitle(Utils.f77mg);
                builder.setPositiveButton("Ok", new OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
    }

    public static boolean isOnline(Context context) {
        NetworkInfo netInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (netInfo == null || !netInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static JSONObject parseJSONAssetFile(InputStream ais) throws Exception {
        InputStream is = new BufferedInputStream(ais);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
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
    }
}
