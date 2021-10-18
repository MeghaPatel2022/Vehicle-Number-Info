package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.Fitness;

public class zzmo extends zzmj<zzmz> {

    static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzmo> {
        public zza(GoogleApiClient googleApiClient) {
            super(Fitness.zzang, googleApiClient);
        }
    }

    public static class zzb extends com.google.android.gms.common.api.Api.zza<zzmo, NoOptions> {
        /* renamed from: zzj */
        public zzmo zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmo(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static abstract class zzc extends zza<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzd */
        public Status zzb(Status status) {
            zzx.zzZ(!status.isSuccess());
            return status;
        }
    }

    public zzmo(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 56, connectionCallbacks, onConnectionFailedListener, zzf);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbq */
    public zzmz zzV(IBinder iBinder) {
        return com.google.android.gms.internal.zzmz.zza.zzbB(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.fitness.RecordingApi";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.fitness.internal.IGoogleFitRecordingApi";
    }
}
