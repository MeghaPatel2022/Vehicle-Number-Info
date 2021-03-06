package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.zzb.zza;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;

public class zzd extends zzj<zzb> {
    private final zze zzRS;

    public zzd(Context context, Looper looper, zzf zzf, zze zze, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 87, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzRS = (zze) zzx.zzv(zze);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaz */
    public zzb zzV(IBinder iBinder) {
        return zza.zzay(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
