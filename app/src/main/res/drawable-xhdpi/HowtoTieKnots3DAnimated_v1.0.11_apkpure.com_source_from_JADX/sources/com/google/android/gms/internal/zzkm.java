package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzkp.zza;

public class zzkm extends zzj<zzko> implements DeathRecipient {
    /* access modifiers changed from: private */
    public static final zzl zzTy = new zzl("CastRemoteDisplayClientImpl");
    private CastDevice zzTj;
    /* access modifiers changed from: private */
    public CastRemoteDisplaySessionCallbacks zzYd;

    public zzkm(Context context, Looper looper, zzf zzf, CastDevice castDevice, CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 83, zzf, connectionCallbacks, onConnectionFailedListener);
        zzTy.zzb("instance created", new Object[0]);
        this.zzYd = castRemoteDisplaySessionCallbacks;
        this.zzTj = castDevice;
    }

    public void binderDied() {
    }

    public void disconnect() {
        zzTy.zzb("disconnect", new Object[0]);
        this.zzYd = null;
        this.zzTj = null;
        try {
            ((zzko) zzoA()).disconnect();
        } catch (RemoteException e) {
        } finally {
            super.disconnect();
        }
    }

    public void zza(zzkn zzkn) throws RemoteException {
        zzTy.zzb("stopRemoteDisplay", new Object[0]);
        ((zzko) zzoA()).zza(zzkn);
    }

    public void zza(zzkn zzkn, int i) throws RemoteException {
        ((zzko) zzoA()).zza(zzkn, i);
    }

    public void zza(zzkn zzkn, final zzkp zzkp, String str) throws RemoteException {
        zzTy.zzb("startRemoteDisplay", new Object[0]);
        ((zzko) zzoA()).zza(zzkn, new zza() {
            public void zzaZ(int i) throws RemoteException {
                zzkm.zzTy.zzb("onRemoteDisplayEnded", new Object[0]);
                if (zzkp != null) {
                    zzkp.zzaZ(i);
                }
                if (zzkm.this.zzYd != null) {
                    zzkm.this.zzYd.onRemoteDisplayEnded(new Status(i));
                }
            }
        }, this.zzTj.getDeviceId(), str);
    }

    /* renamed from: zzaC */
    public zzko zzV(IBinder iBinder) {
        return zzko.zza.zzaE(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }
}
