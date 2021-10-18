package com.google.android.gms.analytics.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzx;

abstract class zzt {
    private static volatile Handler zzMR;
    /* access modifiers changed from: private */
    public final zzf zzLy;
    /* access modifiers changed from: private */
    public volatile long zzMS;
    /* access modifiers changed from: private */
    public boolean zzMT;
    private final Runnable zzx = new Runnable() {
        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                zzt.this.zzLy.zzig().zzf(this);
                return;
            }
            boolean zzbr = zzt.this.zzbr();
            zzt.this.zzMS = 0;
            if (zzbr && !zzt.this.zzMT) {
                zzt.this.run();
            }
        }
    };

    zzt(zzf zzf) {
        zzx.zzv(zzf);
        this.zzLy = zzf;
    }

    private Handler getHandler() {
        Handler handler;
        if (zzMR != null) {
            return zzMR;
        }
        synchronized (zzt.class) {
            if (zzMR == null) {
                zzMR = new Handler(this.zzLy.getContext().getMainLooper());
            }
            handler = zzMR;
        }
        return handler;
    }

    public void cancel() {
        this.zzMS = 0;
        getHandler().removeCallbacks(this.zzx);
    }

    public abstract void run();

    public boolean zzbr() {
        return this.zzMS != 0;
    }

    public long zzjR() {
        if (this.zzMS == 0) {
            return 0;
        }
        return Math.abs(this.zzLy.zzid().currentTimeMillis() - this.zzMS);
    }

    public void zzt(long j) {
        cancel();
        if (j >= 0) {
            this.zzMS = this.zzLy.zzid().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzx, j)) {
                this.zzLy.zzie().zze("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public void zzu(long j) {
        long j2 = 0;
        if (zzbr()) {
            if (j < 0) {
                cancel();
                return;
            }
            long abs = j - Math.abs(this.zzLy.zzid().currentTimeMillis() - this.zzMS);
            if (abs >= 0) {
                j2 = abs;
            }
            getHandler().removeCallbacks(this.zzx);
            if (!getHandler().postDelayed(this.zzx, j2)) {
                this.zzLy.zzie().zze("Failed to adjust delayed post. time", Long.valueOf(j2));
            }
        }
    }
}
