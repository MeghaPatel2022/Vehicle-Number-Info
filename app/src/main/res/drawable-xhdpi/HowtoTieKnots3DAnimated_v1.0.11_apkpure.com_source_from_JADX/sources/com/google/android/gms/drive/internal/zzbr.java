package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;

public class zzbr extends zzd {
    private final zzb<Status> zzQz;

    public zzbr(zzb<Status> zzb) {
        this.zzQz = zzb;
    }

    public void onSuccess() throws RemoteException {
        this.zzQz.zzn(Status.zzaaD);
    }

    public void zzy(Status status) throws RemoteException {
        this.zzQz.zzn(status);
    }
}
