package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzqa.zza;

public class zzqb extends zzj<zzqa> {
    public zzqb(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf zzf) {
        super(context, context.getMainLooper(), 73, zzf, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdF */
    public zzqa zzV(IBinder iBinder) {
        return zza.zzdE(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }
}
