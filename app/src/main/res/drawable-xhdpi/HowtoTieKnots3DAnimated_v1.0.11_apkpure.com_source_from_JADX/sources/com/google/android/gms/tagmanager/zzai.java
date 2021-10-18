package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzai extends zzak {

    /* renamed from: ID */
    private static final String f21ID = zzad.EVENT.toString();
    private final zzcp zzaOU;

    public zzai(zzcp zzcp) {
        super(f21ID, new String[0]);
        this.zzaOU = zzcp;
    }

    public zza zzG(Map<String, zza> map) {
        String zzAF = this.zzaOU.zzAF();
        return zzAF == null ? zzdf.zzBg() : zzdf.zzK(zzAF);
    }

    public boolean zzzx() {
        return false;
    }
}
