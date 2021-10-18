package com.google.android.gms.internal;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class zzg extends Thread {
    private final zzb zzj;
    private final zzn zzk;
    private volatile boolean zzl = false;
    private final BlockingQueue<zzk<?>> zzy;
    private final zzf zzz;

    public zzg(BlockingQueue<zzk<?>> blockingQueue, zzf zzf, zzb zzb, zzn zzn) {
        this.zzy = blockingQueue;
        this.zzz = zzf;
        this.zzj = zzb;
        this.zzk = zzn;
    }

    private void zzb(zzk<?> zzk2) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(zzk2.zzg());
        }
    }

    private void zzb(zzk<?> zzk2, zzr zzr) {
        this.zzk.zza(zzk2, zzk2.zzb(zzr));
    }

    public void quit() {
        this.zzl = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                zzk zzk2 = (zzk) this.zzy.take();
                try {
                    zzk2.zzc("network-queue-take");
                    if (zzk2.isCanceled()) {
                        zzk2.zzd("network-discard-cancelled");
                    } else {
                        zzb(zzk2);
                        zzi zza = this.zzz.zza(zzk2);
                        zzk2.zzc("network-http-complete");
                        if (!zza.zzB || !zzk2.zzw()) {
                            zzm zza2 = zzk2.zza(zza);
                            zzk2.zzc("network-parse-complete");
                            if (zzk2.zzr() && zza2.zzag != null) {
                                this.zzj.zza(zzk2.zzh(), zza2.zzag);
                                zzk2.zzc("network-cache-written");
                            }
                            zzk2.zzv();
                            this.zzk.zza(zzk2, zza2);
                        } else {
                            zzk2.zzd("not-modified");
                        }
                    }
                } catch (zzr e) {
                    e.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    zzb(zzk2, e);
                } catch (Exception e2) {
                    zzs.zza(e2, "Unhandled exception %s", e2.toString());
                    zzr zzr = new zzr((Throwable) e2);
                    zzr.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.zzk.zza(zzk2, zzr);
                }
            } catch (InterruptedException e3) {
                if (this.zzl) {
                    return;
                }
            }
        }
    }
}
