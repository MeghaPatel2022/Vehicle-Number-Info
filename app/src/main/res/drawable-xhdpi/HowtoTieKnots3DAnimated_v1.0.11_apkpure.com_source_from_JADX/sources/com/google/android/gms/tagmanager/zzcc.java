package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzcc extends zzak {

    /* renamed from: ID */
    private static final String f37ID = zzad.RANDOM.toString();
    private static final String zzaRg = zzae.MIN.toString();
    private static final String zzaRh = zzae.MAX.toString();

    public zzcc() {
        super(f37ID, new String[0]);
    }

    public zza zzG(Map<String, zza> map) {
        double d;
        double d2;
        zza zza = (zza) map.get(zzaRg);
        zza zza2 = (zza) map.get(zzaRh);
        if (!(zza == null || zza == zzdf.zzBg() || zza2 == null || zza2 == zzdf.zzBg())) {
            zzde zzh = zzdf.zzh(zza);
            zzde zzh2 = zzdf.zzh(zza2);
            if (!(zzh == zzdf.zzBe() || zzh2 == zzdf.zzBe())) {
                double doubleValue = zzh.doubleValue();
                d = zzh2.doubleValue();
                if (doubleValue <= d) {
                    d2 = doubleValue;
                    return zzdf.zzK(Long.valueOf(Math.round(((d - d2) * Math.random()) + d2)));
                }
            }
        }
        d = 2.147483647E9d;
        d2 = 0.0d;
        return zzdf.zzK(Long.valueOf(Math.round(((d - d2) * Math.random()) + d2)));
    }

    public boolean zzzx() {
        return false;
    }
}
