package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.zzb.zza;
import java.util.concurrent.BlockingQueue;

public class zzc extends Thread {
    private static final boolean DEBUG = zzs.DEBUG;
    private final BlockingQueue<zzk<?>> zzh;
    /* access modifiers changed from: private */
    public final BlockingQueue<zzk<?>> zzi;
    private final zzb zzj;
    private final zzn zzk;
    private volatile boolean zzl = false;

    public zzc(BlockingQueue<zzk<?>> blockingQueue, BlockingQueue<zzk<?>> blockingQueue2, zzb zzb, zzn zzn) {
        this.zzh = blockingQueue;
        this.zzi = blockingQueue2;
        this.zzj = zzb;
        this.zzk = zzn;
    }

    public void quit() {
        this.zzl = true;
        interrupt();
    }

    public void run() {
        if (DEBUG) {
            zzs.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzj.zza();
        while (true) {
            try {
                final zzk zzk2 = (zzk) this.zzh.take();
                zzk2.zzc("cache-queue-take");
                if (zzk2.isCanceled()) {
                    zzk2.zzd("cache-discard-canceled");
                } else {
                    zza zza = this.zzj.zza(zzk2.zzh());
                    if (zza == null) {
                        zzk2.zzc("cache-miss");
                        this.zzi.put(zzk2);
                    } else if (zza.zzb()) {
                        zzk2.zzc("cache-hit-expired");
                        zzk2.zza(zza);
                        this.zzi.put(zzk2);
                    } else {
                        zzk2.zzc("cache-hit");
                        zzm zza2 = zzk2.zza(new zzi(zza.data, zza.zzg));
                        zzk2.zzc("cache-hit-parsed");
                        if (!zza.zzc()) {
                            this.zzk.zza(zzk2, zza2);
                        } else {
                            zzk2.zzc("cache-hit-refresh-needed");
                            zzk2.zza(zza);
                            zza2.zzai = true;
                            this.zzk.zza(zzk2, zza2, new Runnable() {
                                public void run() {
                                    try {
                                        zzc.this.zzi.put(zzk2);
                                    } catch (InterruptedException e) {
                                    }
                                }
                            });
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.zzl) {
                    return;
                }
            }
        }
    }
}
