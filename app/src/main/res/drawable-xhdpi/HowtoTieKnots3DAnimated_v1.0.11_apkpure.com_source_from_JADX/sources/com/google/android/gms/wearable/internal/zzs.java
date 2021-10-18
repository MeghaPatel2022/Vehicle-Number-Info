package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.zzat.zza;

public final class zzs extends zza {
    private zzl zzaZZ;
    private zzt zzbad;
    private final Object zzpc = new Object();

    public void zza(zzt zzt) {
        zzl zzl;
        synchronized (this.zzpc) {
            this.zzbad = (zzt) zzx.zzv(zzt);
            zzl = this.zzaZZ;
        }
        if (zzl != null) {
            zzt.zzb(zzl);
        }
    }

    public void zzx(int i, int i2) {
        zzt zzt;
        zzl zzl;
        synchronized (this.zzpc) {
            zzt = this.zzbad;
            zzl = new zzl(i, i2);
            this.zzaZZ = zzl;
        }
        if (zzt != null) {
            zzt.zzb(zzl);
        }
    }
}
