package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.List;
import java.util.Map;

class zzx extends zzdd {

    /* renamed from: ID */
    private static final String f59ID = zzad.DATA_LAYER_WRITE.toString();
    private static final String VALUE = zzae.VALUE.toString();
    private static final String zzaPT = zzae.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer zzaOT;

    public zzx(DataLayer dataLayer) {
        super(f59ID, VALUE);
        this.zzaOT = dataLayer;
    }

    private void zza(zza zza) {
        if (zza != null && zza != zzdf.zzBa()) {
            String zzg = zzdf.zzg(zza);
            if (zzg != zzdf.zzBf()) {
                this.zzaOT.zzeC(zzg);
            }
        }
    }

    private void zzb(zza zza) {
        if (zza != null && zza != zzdf.zzBa()) {
            Object zzl = zzdf.zzl(zza);
            if (zzl instanceof List) {
                for (Object next : (List) zzl) {
                    if (next instanceof Map) {
                        this.zzaOT.push((Map) next);
                    }
                }
            }
        }
    }

    public void zzI(Map<String, zza> map) {
        zzb((zza) map.get(VALUE));
        zza((zza) map.get(zzaPT));
    }
}
