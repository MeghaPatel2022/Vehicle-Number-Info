package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.List;

class zzii {
    private final Object zzIJ = new Object();
    private final List<Runnable> zzIK = new ArrayList();
    private final List<Runnable> zzIL = new ArrayList();
    private boolean zzIM = false;

    private void zzd(Runnable runnable) {
        zzht.zza(runnable);
    }

    private void zze(Runnable runnable) {
        zza.zzIy.post(runnable);
    }

    public void zzc(Runnable runnable) {
        synchronized (this.zzIJ) {
            if (this.zzIM) {
                zzd(runnable);
            } else {
                this.zzIK.add(runnable);
            }
        }
    }

    public void zzgK() {
        synchronized (this.zzIJ) {
            if (!this.zzIM) {
                for (Runnable zzd : this.zzIK) {
                    zzd(zzd);
                }
                for (Runnable zze : this.zzIL) {
                    zze(zze);
                }
                this.zzIK.clear();
                this.zzIL.clear();
                this.zzIM = true;
            }
        }
    }
}
