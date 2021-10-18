package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.nearby.bootstrap.zza;

public class zzov implements zza {
    public static final zzc<zzou> zzQf = new zzc<>();
    public static final Api.zza<zzou, NoOptions> zzQg = new Api.zza<zzou, NoOptions>() {
        /* renamed from: zzn */
        public zzou zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzou(context, looper, connectionCallbacks, onConnectionFailedListener, zzf);
        }
    };
}
