package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.util.Log;

public class zzmi {
    private static int zzaoL = -1;

    public static boolean zzat(Context context) {
        return zzaw(context) == 3;
    }

    private static int zzau(Context context) {
        return ((zzav(context) % 1000) / 100) + 5;
    }

    private static int zzav(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    public static int zzaw(Context context) {
        if (zzaoL == -1) {
            switch (zzau(context)) {
                case 8:
                case 13:
                    zzaoL = 0;
                    break;
                case 10:
                    zzaoL = 3;
                    break;
                default:
                    zzaoL = zzax(context) ? 1 : 2;
                    break;
            }
        }
        return zzaoL;
    }

    private static boolean zzax(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
    }
}
