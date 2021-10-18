package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzjc.zza;

public class zzjf extends zzj<zzjc> {
    public zzjf(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 19, zzf, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzah */
    public zzjc zzV(IBinder iBinder) {
        return zza.zzaf(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public zzjc zzlg() throws DeadObjectException {
        return (zzjc) zzoA();
    }
}
