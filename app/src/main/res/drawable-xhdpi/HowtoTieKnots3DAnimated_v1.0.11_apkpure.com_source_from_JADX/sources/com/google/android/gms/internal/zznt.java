package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.internal.zznh.zza;

public class zznt extends zza {
    private final zzb<Status> zzQz;

    public zznt(zzb<Status> zzb) {
        this.zzQz = zzb;
    }

    public void zzr(Status status) {
        this.zzQz.zzn(status);
    }
}
