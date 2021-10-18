package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzda extends zzak {

    /* renamed from: ID */
    private static final String f44ID = zzad.TIME.toString();

    public zzda() {
        super(f44ID, new String[0]);
    }

    public zza zzG(Map<String, zza> map) {
        return zzdf.zzK(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean zzzx() {
        return false;
    }
}
