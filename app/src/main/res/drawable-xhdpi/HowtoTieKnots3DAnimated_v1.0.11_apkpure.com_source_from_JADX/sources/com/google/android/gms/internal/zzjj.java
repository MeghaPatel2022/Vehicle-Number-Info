package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzjl.zza;

public class zzjj extends zzj<zzjl> {
    private final String zzQl;

    public zzjj(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf zzf) {
        super(context, looper, 77, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzQl = zzf.zzol();
    }

    private Bundle zzlj() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzQl);
        return bundle;
    }

    public void zza(zzjk zzjk, String str) {
        try {
            ((zzjl) zzoA()).zza(zzjk, str);
        } catch (RemoteException e) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzai */
    public zzjl zzV(IBinder iBinder) {
        return zza.zzak(iBinder);
    }

    public void zzb(zzjk zzjk, String str) {
        try {
            ((zzjl) zzoA()).zzb(zzjk, str);
        } catch (RemoteException e) {
        }
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.appinvite.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    /* access modifiers changed from: protected */
    public Bundle zzli() {
        return zzlj();
    }
}
