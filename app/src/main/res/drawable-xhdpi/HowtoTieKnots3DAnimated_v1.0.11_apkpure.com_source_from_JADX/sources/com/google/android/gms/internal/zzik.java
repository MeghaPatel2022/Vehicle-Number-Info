package com.google.android.gms.internal;

import com.google.android.gms.internal.zzij.zzc;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzgk
public class zzik<T> implements zzij<T> {
    protected final BlockingQueue<zza> zzIN = new LinkedBlockingQueue();
    protected T zzIO;
    private final Object zzpc = new Object();
    protected int zzxJ = 0;

    class zza {
        public final zzc<T> zzIP;
        public final com.google.android.gms.internal.zzij.zza zzIQ;

        public zza(zzc<T> zzc, com.google.android.gms.internal.zzij.zza zza) {
            this.zzIP = zzc;
            this.zzIQ = zza;
        }
    }

    public int getStatus() {
        return this.zzxJ;
    }

    public void reject() {
        synchronized (this.zzpc) {
            if (this.zzxJ != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzxJ = -1;
            for (zza zza2 : this.zzIN) {
                zza2.zzIQ.run();
            }
            this.zzIN.clear();
        }
    }

    public void zza(zzc<T> zzc, com.google.android.gms.internal.zzij.zza zza2) {
        synchronized (this.zzpc) {
            if (this.zzxJ == 1) {
                zzc.zzc(this.zzIO);
            } else if (this.zzxJ == -1) {
                zza2.run();
            } else if (this.zzxJ == 0) {
                this.zzIN.add(new zza(zzc, zza2));
            }
        }
    }

    public void zzg(T t) {
        synchronized (this.zzpc) {
            if (this.zzxJ != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzIO = t;
            this.zzxJ = 1;
            for (zza zza2 : this.zzIN) {
                zza2.zzIP.zzc(t);
            }
            this.zzIN.clear();
        }
    }
}
