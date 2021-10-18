package com.bbotdev.vahaninfo.customclass;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefValue {

    public static final String VEHICLE_INFO = "pref_vehicle_info";


    public static String getVehicleInfo(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getString(VEHICLE_INFO, "");
    }

    public static void setVehicleInfo(Context context, String bytes) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putString(VEHICLE_INFO, bytes).commit();
    }

}