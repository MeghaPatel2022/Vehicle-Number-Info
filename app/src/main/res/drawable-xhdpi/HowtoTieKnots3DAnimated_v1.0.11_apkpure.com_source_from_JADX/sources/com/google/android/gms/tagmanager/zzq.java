package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzq extends zzak {

    /* renamed from: ID */
    private static final String f55ID = zzad.CONTAINER_VERSION.toString();
    private final String zzWs;

    public zzq(String str) {
        super(f55ID, new String[0]);
        this.zzWs = str;
    }

    public zza zzG(Map<String, zza> map) {
        return this.zzWs == null ? zzdf.zzBg() : zzdf.zzK(this.zzWs);
    }

    public boolean zzzx() {
        return true;
    }
}
