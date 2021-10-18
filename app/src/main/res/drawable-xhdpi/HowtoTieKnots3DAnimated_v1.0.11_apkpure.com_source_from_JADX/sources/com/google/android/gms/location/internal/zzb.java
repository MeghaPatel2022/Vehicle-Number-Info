package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.location.internal.zzg.zza;

public class zzb extends zzj<zzg> {
    protected final zzn<zzg> zzaCs = new zzn<zzg>() {
        public void zzoz() {
            zzb.this.zzoz();
        }

        /* renamed from: zzvN */
        public zzg zzoA() throws DeadObjectException {
            return (zzg) zzb.this.zzoA();
        }
    };
    private final String zzaCy;

    public zzb(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzf zzf) {
        super(context, looper, 23, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaCy = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbY */
    public zzg zzV(IBinder iBinder) {
        return zza.zzca(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* access modifiers changed from: protected */
    public Bundle zzli() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzaCy);
        return bundle;
    }
}
