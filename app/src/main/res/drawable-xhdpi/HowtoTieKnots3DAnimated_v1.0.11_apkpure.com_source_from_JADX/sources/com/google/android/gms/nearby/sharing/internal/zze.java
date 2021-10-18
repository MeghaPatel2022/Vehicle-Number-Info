package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.nearby.sharing.internal.zzd.zza;

class zze extends zzj<zzd> {
    public zze(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf zzf) {
        super(context, looper, 49, zzf, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdp */
    public zzd zzV(IBinder iBinder) {
        return zza.zzdo(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.nearby.sharing.service.NearbySharingService.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.nearby.sharing.internal.INearbySharingService";
    }
}
