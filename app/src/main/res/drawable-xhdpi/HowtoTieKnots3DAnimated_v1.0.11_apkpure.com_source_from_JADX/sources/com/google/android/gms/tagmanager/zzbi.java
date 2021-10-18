package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzbi extends zzak {

    /* renamed from: ID */
    private static final String f32ID = zzad.LOWERCASE_STRING.toString();
    private static final String zzaPY = zzae.ARG0.toString();

    public zzbi() {
        super(f32ID, zzaPY);
    }

    public zza zzG(Map<String, zza> map) {
        return zzdf.zzK(zzdf.zzg((zza) map.get(zzaPY)).toLowerCase());
    }

    public boolean zzzx() {
        return true;
    }
}
