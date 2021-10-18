package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzh;
import com.google.android.gms.signin.internal.zzi;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public final class zzb {
    public static final Api<zze> API = new Api<>("SignIn.API", zzQg, zzQf);
    public static final zzc<zzi> zzQf = new zzc<>();
    public static final zza<zzi, zze> zzQg = new zza<zzi, zze>() {
        public zzi zza(Context context, Looper looper, zzf zzf, zze zze, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzi(context, looper, true, zzf, zze, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
        }

        /* renamed from: zza */
        public List<Scope> zzl(zze zze) {
            return Arrays.asList(new Scope[]{zzb.zzaOa, zzb.zzaOb});
        }
    };
    static final zza<zzi, NoOptions> zzaNZ = new zza<zzi, NoOptions>() {
        /* renamed from: zzt */
        public zzi zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzi(context, looper, false, zzf, zze.zzaOd, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
        }
    };
    public static final Scope zzaOa = new Scope(Scopes.PROFILE);
    public static final Scope zzaOb = new Scope("email");
    public static final zzc zzaOc = new zzh();
    public static final Api<NoOptions> zzagz = new Api<>("SignIn.INTERNAL_API", zzaNZ, zzanf);
    public static final zzc<zzi> zzanf = new zzc<>();
}
