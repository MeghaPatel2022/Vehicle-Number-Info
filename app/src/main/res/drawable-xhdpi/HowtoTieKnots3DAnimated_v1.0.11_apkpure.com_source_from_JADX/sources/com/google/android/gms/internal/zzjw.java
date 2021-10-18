package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public final class zzjw extends zzj<zzjy> {
    private final Bundle zzQZ;

    public zzjw(Context context, Looper looper, zzf zzf, zza zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzQZ = zza == null ? new Bundle() : zza.zzlq();
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzau */
    public zzjy zzV(IBinder iBinder) {
        return zzjy.zza.zzaw(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.auth.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    /* access modifiers changed from: protected */
    public Bundle zzli() {
        return this.zzQZ;
    }

    public boolean zzlm() {
        zzf zzoy = zzoy();
        return !TextUtils.isEmpty(zzoy.getAccountName()) && !zzoy.zzb(Auth.PROXY_API).isEmpty();
    }
}
