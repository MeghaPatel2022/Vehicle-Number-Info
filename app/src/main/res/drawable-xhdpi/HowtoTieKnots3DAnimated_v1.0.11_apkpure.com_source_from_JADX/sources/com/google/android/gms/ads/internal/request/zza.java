package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzhq;

@zzgk
public class zza {

    /* renamed from: com.google.android.gms.ads.internal.request.zza$zza reason: collision with other inner class name */
    public interface C1331zza {
        void zza(com.google.android.gms.internal.zzhj.zza zza);
    }

    public zzhq zza(Context context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zza, zzan zzan, C1331zza zza2) {
        zzhq zzb = zza.zzDy.extras.getBundle("sdk_less_server_data") != null ? new zzm(context, zza, zza2) : new zzb(context, zza, zzan, zza2);
        zzb.zzgo();
        return zzb;
    }
}
