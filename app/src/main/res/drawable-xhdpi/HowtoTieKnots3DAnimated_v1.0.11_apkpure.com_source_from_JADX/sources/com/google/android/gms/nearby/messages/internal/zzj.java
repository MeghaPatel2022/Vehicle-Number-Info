package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.nearby.messages.internal.zzc.zza;

final class zzj extends zza {
    private final zzb<Status> zzaKb;

    private zzj(zzb<Status> zzb) {
        this.zzaKb = zzb;
    }

    static zzj zzj(zzb<Status> zzb) {
        return new zzj(zzb);
    }

    public void zzaU(Status status) throws RemoteException {
        this.zzaKb.zzn(status);
    }
}
