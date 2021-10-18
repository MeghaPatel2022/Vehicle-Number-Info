package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzof;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class zzb extends zzd {
    /* access modifiers changed from: private */
    public final zzl zzLq;

    public zzb(zzf zzf, zzg zzg) {
        super(zzf);
        zzx.zzv(zzg);
        this.zzLq = zzg.zzj(zzf);
    }

    /* access modifiers changed from: 0000 */
    public void onServiceConnected() {
        zzic();
        this.zzLq.onServiceConnected();
    }

    public void setLocalDispatchPeriod(final int dispatchPeriodInSeconds) {
        zzio();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(dispatchPeriodInSeconds));
        zzig().zzf(new Runnable() {
            public void run() {
                zzb.this.zzLq.zzs(((long) dispatchPeriodInSeconds) * 1000);
            }
        });
    }

    public void start() {
        this.zzLq.start();
    }

    public void zzI(final boolean z) {
        zza("Network connectivity status changed", Boolean.valueOf(z));
        zzig().zzf(new Runnable() {
            public void run() {
                zzb.this.zzLq.zzI(z);
            }
        });
    }

    public long zza(zzh zzh) {
        zzio();
        zzx.zzv(zzh);
        zzic();
        long zza = this.zzLq.zza(zzh, true);
        if (zza == 0) {
            this.zzLq.zzc(zzh);
        }
        return zza;
    }

    public void zza(final zzab zzab) {
        zzx.zzv(zzab);
        zzio();
        zzb("Hit delivery requested", zzab);
        zzig().zzf(new Runnable() {
            public void run() {
                zzb.this.zzLq.zza(zzab);
            }
        });
    }

    public void zza(final zzw zzw) {
        zzio();
        zzig().zzf(new Runnable() {
            public void run() {
                zzb.this.zzLq.zzb(zzw);
            }
        });
    }

    public void zza(final String str, final Runnable runnable) {
        zzx.zzh(str, "campaign param can't be empty");
        zzig().zzf(new Runnable() {
            public void run() {
                zzb.this.zzLq.zzbg(str);
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void zzhB() {
        this.zzLq.zza();
    }

    public void zzhU() {
        zzio();
        zzib();
        zzig().zzf(new Runnable() {
            public void run() {
                zzb.this.zzLq.zzhU();
            }
        });
    }

    public void zzhV() {
        zzio();
        Context context = getContext();
        if (!AnalyticsReceiver.zzV(context) || !AnalyticsService.zzW(context)) {
            zza((zzw) null);
            return;
        }
        Intent intent = new Intent(context, AnalyticsService.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        context.startService(intent);
    }

    public boolean zzhW() {
        zzio();
        try {
            zzig().zzb((Callable<V>) new Callable<Void>() {
                /* renamed from: zzgp */
                public Void call() throws Exception {
                    zzb.this.zzLq.zziT();
                    return null;
                }
            }).get();
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        }
    }

    public void zzhX() {
        zzio();
        zzof.zzic();
        this.zzLq.zzhX();
    }

    public void zzhY() {
        zzaY("Radio powered up");
        zzhV();
    }

    /* access modifiers changed from: 0000 */
    public void zzhZ() {
        zzic();
        this.zzLq.zzhZ();
    }
}
