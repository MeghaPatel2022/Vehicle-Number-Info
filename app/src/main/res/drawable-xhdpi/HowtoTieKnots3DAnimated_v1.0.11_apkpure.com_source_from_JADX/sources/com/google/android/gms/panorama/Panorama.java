package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;

public final class Panorama {
    public static final Api<NoOptions> API = new Api<>("Panorama.API", zzQg, zzQf);
    public static final PanoramaApi PanoramaApi = new zzpi();
    public static final zzc<zzpj> zzQf = new zzc<>();
    static final zza<zzpj, NoOptions> zzQg = new zza<zzpj, NoOptions>() {
        /* renamed from: zzq */
        public zzpj zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzpj(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };

    private Panorama() {
    }
}
