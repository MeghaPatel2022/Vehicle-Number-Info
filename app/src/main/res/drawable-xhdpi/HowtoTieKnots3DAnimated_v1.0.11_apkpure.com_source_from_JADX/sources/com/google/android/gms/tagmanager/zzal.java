package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import java.io.File;

class zzal {
    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            zzbg.m28e("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }

    static boolean zzbj(String str) {
        if (version() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
