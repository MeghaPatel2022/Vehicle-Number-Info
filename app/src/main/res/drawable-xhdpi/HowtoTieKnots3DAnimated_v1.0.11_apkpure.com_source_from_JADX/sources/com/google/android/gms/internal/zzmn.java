package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;

public class zzmn extends zzmj<zzmy> {

    public static class zza extends com.google.android.gms.common.api.Api.zza<zzmn, NoOptions> {
        /* renamed from: zzi */
        public zzmn zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmn(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public zzmn(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 61, connectionCallbacks, onConnectionFailedListener, zzf);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbp */
    public zzmy zzV(IBinder iBinder) {
        return com.google.android.gms.internal.zzmy.zza.zzbA(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.fitness.InternalApi";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.fitness.internal.IGoogleFitInternalApi";
    }
}
