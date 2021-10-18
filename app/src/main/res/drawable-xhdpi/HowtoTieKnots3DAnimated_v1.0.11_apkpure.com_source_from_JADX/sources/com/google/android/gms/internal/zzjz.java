package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zza;

abstract class zzjz extends zza<ProxyResult, zzjw> {
    public zzjz(GoogleApiClient googleApiClient) {
        super(Auth.zzQL, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, zzjy zzjy) throws RemoteException;

    /* access modifiers changed from: protected */
    public final void zza(zzjw zzjw) throws RemoteException {
        zza(zzjw.getContext(), (zzjy) zzjw.zzoA());
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzo */
    public ProxyResult zzb(Status status) {
        return new zzkb(status);
    }
}
