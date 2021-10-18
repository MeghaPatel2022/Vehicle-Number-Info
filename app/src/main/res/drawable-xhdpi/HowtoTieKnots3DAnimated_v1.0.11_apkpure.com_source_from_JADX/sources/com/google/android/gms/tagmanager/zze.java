package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zze extends zzak {

    /* renamed from: ID */
    private static final String f48ID = zzad.ADWORDS_CLICK_REFERRER.toString();
    private static final String zzaOJ = zzae.COMPONENT.toString();
    private static final String zzaOK = zzae.CONVERSION_ID.toString();
    private final Context context;

    public zze(Context context2) {
        super(f48ID, zzaOK);
        this.context = context2;
    }

    public zza zzG(Map<String, zza> map) {
        zza zza = (zza) map.get(zzaOK);
        if (zza == null) {
            return zzdf.zzBg();
        }
        String zzg = zzdf.zzg(zza);
        zza zza2 = (zza) map.get(zzaOJ);
        String zzg2 = zzax.zzg(this.context, zzg, zza2 != null ? zzdf.zzg(zza2) : null);
        return zzg2 != null ? zzdf.zzK(zzg2) : zzdf.zzBg();
    }

    public boolean zzzx() {
        return true;
    }
}
