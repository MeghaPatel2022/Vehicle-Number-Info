package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.nearby.sharing.zzd;

public final class zzh implements zzd {
    public static final zzc<zze> zzQf = new zzc<>();
    public static final zza<zze, NoOptions> zzQg = new zza<zze, NoOptions>() {
        /* renamed from: zzp */
        public zze zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, connectionCallbacks, onConnectionFailedListener, zzf);
        }
    };
}
