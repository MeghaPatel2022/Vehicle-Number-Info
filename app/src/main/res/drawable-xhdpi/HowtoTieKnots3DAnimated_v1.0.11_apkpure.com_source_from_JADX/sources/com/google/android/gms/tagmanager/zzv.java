package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzv extends zzak {

    /* renamed from: ID */
    private static final String f58ID = zzad.CUSTOM_VAR.toString();
    private static final String NAME = zzae.NAME.toString();
    private static final String zzaPI = zzae.DEFAULT_VALUE.toString();
    private final DataLayer zzaOT;

    public zzv(DataLayer dataLayer) {
        super(f58ID, NAME);
        this.zzaOT = dataLayer;
    }

    public zza zzG(Map<String, zza> map) {
        Object obj = this.zzaOT.get(zzdf.zzg((zza) map.get(NAME)));
        if (obj != null) {
            return zzdf.zzK(obj);
        }
        zza zza = (zza) map.get(zzaPI);
        return zza != null ? zza : zzdf.zzBg();
    }

    public boolean zzzx() {
        return false;
    }
}
