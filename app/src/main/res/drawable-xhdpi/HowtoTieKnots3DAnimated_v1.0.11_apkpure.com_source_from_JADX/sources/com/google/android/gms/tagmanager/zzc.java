package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzc extends zzak {

    /* renamed from: ID */
    private static final String f36ID = zzad.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza zzaOI;

    public zzc(Context context) {
        this(zza.zzaL(context));
    }

    zzc(zza zza) {
        super(f36ID, new String[0]);
        this.zzaOI = zza;
    }

    public zza zzG(Map<String, zza> map) {
        return zzdf.zzK(Boolean.valueOf(!this.zzaOI.isLimitAdTrackingEnabled()));
    }

    public boolean zzzx() {
        return false;
    }
}
