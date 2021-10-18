package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzcr extends zzak {

    /* renamed from: ID */
    private static final String f42ID = zzad.SDK_VERSION.toString();

    public zzcr() {
        super(f42ID, new String[0]);
    }

    public zza zzG(Map<String, zza> map) {
        return zzdf.zzK(Integer.valueOf(VERSION.SDK_INT));
    }

    public boolean zzzx() {
        return true;
    }
}
