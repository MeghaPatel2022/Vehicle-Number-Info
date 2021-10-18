package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzb extends zzak {

    /* renamed from: ID */
    private static final String f28ID = zzad.ADVERTISER_ID.toString();
    private final zza zzaOI;

    public zzb(Context context) {
        this(zza.zzaL(context));
    }

    zzb(zza zza) {
        super(f28ID, new String[0]);
        this.zzaOI = zza;
    }

    public zza zzG(Map<String, zza> map) {
        String zzzt = this.zzaOI.zzzt();
        return zzzt == null ? zzdf.zzBg() : zzdf.zzK(zzzt);
    }

    public boolean zzzx() {
        return false;
    }
}
