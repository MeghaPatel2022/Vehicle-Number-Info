package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzbx extends zzak {

    /* renamed from: ID */
    private static final String f34ID = zzad.OS_VERSION.toString();

    public zzbx() {
        super(f34ID, new String[0]);
    }

    public zza zzG(Map<String, zza> map) {
        return zzdf.zzK(VERSION.RELEASE);
    }

    public boolean zzzx() {
        return true;
    }
}
