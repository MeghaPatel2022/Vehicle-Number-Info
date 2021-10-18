package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;

public final class zzky implements zzkx {

    private static class zza extends zzkv {
        private final zzb<Status> zzQz;

        public zza(zzb<Status> zzb) {
            this.zzQz = zzb;
        }

        public void zzbI(int i) throws RemoteException {
            this.zzQz.zzn(new Status(i));
        }
    }

    public PendingResult<Status> zzc(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzla zzla) throws RemoteException {
                ((zzlc) zzla.zzoA()).zza(new zza(this));
            }
        });
    }
}
