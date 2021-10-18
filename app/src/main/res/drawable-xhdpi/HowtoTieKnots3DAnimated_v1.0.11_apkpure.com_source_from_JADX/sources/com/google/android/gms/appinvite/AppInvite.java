package com.google.android.gms.appinvite;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjj;

public final class AppInvite {
    public static final Api<NoOptions> API = new Api<>("AppInvite.API", zzQg, zzQf);
    public static final AppInviteApi AppInviteApi = new zzji();
    public static final zzc<zzjj> zzQf = new zzc<>();
    private static final zza<zzjj, NoOptions> zzQg = new zza<zzjj, NoOptions>() {
        /* renamed from: zzb */
        public zzjj zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjj(context, looper, connectionCallbacks, onConnectionFailedListener, zzf);
        }
    };

    private AppInvite() {
    }
}
