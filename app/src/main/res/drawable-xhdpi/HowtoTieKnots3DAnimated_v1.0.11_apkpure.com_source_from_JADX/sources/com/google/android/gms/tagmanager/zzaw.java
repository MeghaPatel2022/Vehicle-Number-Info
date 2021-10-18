package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzaw extends zzak {

    /* renamed from: ID */
    private static final String f26ID = zzad.INSTALL_REFERRER.toString();
    private static final String zzaOJ = zzae.COMPONENT.toString();
    private final Context context;

    public zzaw(Context context2) {
        super(f26ID, new String[0]);
        this.context = context2;
    }

    public zza zzG(Map<String, zza> map) {
        String zzk = zzax.zzk(this.context, ((zza) map.get(zzaOJ)) != null ? zzdf.zzg((zza) map.get(zzaOJ)) : null);
        return zzk != null ? zzdf.zzK(zzk) : zzdf.zzBg();
    }

    public boolean zzzx() {
        return true;
    }
}
