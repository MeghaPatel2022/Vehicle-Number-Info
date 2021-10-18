package com.google.android.gms.safetynet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzpy;

public final class SafetyNet {
    public static final Api<NoOptions> API = new Api<>("SafetyNet.API", zzQg, zzQf);
    public static final SafetyNetApi SafetyNetApi = new zzpw();
    public static final zzc<zzpx> zzQf = new zzc<>();
    public static final zza<zzpx, NoOptions> zzQg = new zza<zzpx, NoOptions>() {
        /* renamed from: zzr */
        public zzpx zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzpx(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final zzc zzaNC = new zzpy();

    private SafetyNet() {
    }
}
