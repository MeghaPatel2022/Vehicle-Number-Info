package com.bbotdev.vahaninfo.customclass;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class Utils {

    public static void saveToUserDefaults(Context context, String key,
                                          String value) {

        Log.d("Utils", "Saving:" + key + ":" + value);
        SharedPreferences preferences = context.getSharedPreferences(
                Constant.SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();

    }

    public static String getFromUserDefaults(Context context, String key) {
        Log.d("Utils", "Get:" + key);
        SharedPreferences preferences = context.getSharedPreferences(
                Constant.SHARED_PREFS, Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }
}
