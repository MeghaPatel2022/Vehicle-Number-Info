package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzdh extends zzak {

    /* renamed from: ID */
    private static final String f47ID = zzad.UPPERCASE_STRING.toString();
    private static final String zzaPY = zzae.ARG0.toString();

    public zzdh() {
        super(f47ID, zzaPY);
    }

    public zza zzG(Map<String, zza> map) {
        return zzdf.zzK(zzdf.zzg((zza) map.get(zzaPY)).toUpperCase());
    }

    public boolean zzzx() {
        return true;
    }
}
