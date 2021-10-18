package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;
import java.util.Set;

public abstract class zzca extends zzak {
    private static final String zzaPY = zzae.ARG0.toString();
    private static final String zzaQW = zzae.ARG1.toString();

    public zzca(String str) {
        super(str, zzaPY, zzaQW);
    }

    public /* bridge */ /* synthetic */ String zzAc() {
        return super.zzAc();
    }

    public /* bridge */ /* synthetic */ Set zzAd() {
        return super.zzAd();
    }

    public zza zzG(Map<String, zza> map) {
        for (zza zza : map.values()) {
            if (zza == zzdf.zzBg()) {
                return zzdf.zzK(Boolean.valueOf(false));
            }
        }
        zza zza2 = (zza) map.get(zzaPY);
        zza zza3 = (zza) map.get(zzaQW);
        return zzdf.zzK(Boolean.valueOf((zza2 == null || zza3 == null) ? false : zza(zza2, zza3, map)));
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zza zza, zza zza2, Map<String, zza> map);

    public boolean zzzx() {
        return true;
    }
}
