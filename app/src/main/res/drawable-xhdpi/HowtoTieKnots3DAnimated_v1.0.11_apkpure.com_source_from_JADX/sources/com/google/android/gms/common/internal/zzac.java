package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzac<T extends IInterface> extends zzj<T> {
    private final zzd<T> zzaep;

    public zzac(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf zzf, zzd zzd) {
        super(context, looper, i, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaep = zzd;
    }

    /* access modifiers changed from: protected */
    public T zzV(IBinder iBinder) {
        return this.zzaep.zzV(iBinder);
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, T t) {
        this.zzaep.zza(i, t);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return this.zzaep.zzfA();
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return this.zzaep.zzfB();
    }
}
