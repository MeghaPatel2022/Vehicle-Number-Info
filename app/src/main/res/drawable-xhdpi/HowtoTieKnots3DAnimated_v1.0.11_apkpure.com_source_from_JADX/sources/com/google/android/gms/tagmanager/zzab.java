package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzab extends zzak {

    /* renamed from: ID */
    private static final String f17ID = zzad.DEVICE_NAME.toString();

    public zzab() {
        super(f17ID, new String[0]);
    }

    public zza zzG(Map<String, zza> map) {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (!str2.startsWith(str) && !str.equals("unknown")) {
            str2 = str + " " + str2;
        }
        return zzdf.zzK(str2);
    }

    public boolean zzzx() {
        return true;
    }
}
