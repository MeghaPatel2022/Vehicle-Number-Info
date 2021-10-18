package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzjf;
import com.google.android.gms.internal.zzjh;

public final class zza {
    public static final zzc<zzjf> zzOO = new zzc<>();
    private static final com.google.android.gms.common.api.Api.zza<zzjf, NoOptions> zzOP = new com.google.android.gms.common.api.Api.zza<zzjf, NoOptions>() {
        public zzjf zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjf(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<NoOptions> zzOQ = new Api<>("AppDataSearch.LIGHTWEIGHT_API", zzOP, zzOO);
    public static final zzk zzOR = new zzjh();
}
