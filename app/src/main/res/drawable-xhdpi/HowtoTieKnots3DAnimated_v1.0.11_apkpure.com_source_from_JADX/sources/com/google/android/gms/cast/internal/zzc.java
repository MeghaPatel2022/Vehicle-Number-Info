package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public abstract class zzc extends zzd {
    protected final Handler mHandler;
    protected final long zzWG;
    protected final Runnable zzWH;
    protected boolean zzWI;

    private class zza implements Runnable {
        private zza() {
        }

        public void run() {
            zzc.this.zzWI = false;
            zzc.this.zzU(zzc.this.zzz(SystemClock.elapsedRealtime()));
        }
    }

    public zzc(String str, String str2, String str3) {
        this(str, str2, str3, 1000);
    }

    public zzc(String str, String str2, String str3, long j) {
        super(str, str2, str3);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zzWH = new zza();
        this.zzWG = j;
        zzU(false);
    }

    /* access modifiers changed from: protected */
    public final void zzU(boolean z) {
        if (this.zzWI != z) {
            this.zzWI = z;
            if (z) {
                this.mHandler.postDelayed(this.zzWH, this.zzWG);
            } else {
                this.mHandler.removeCallbacks(this.zzWH);
            }
        }
    }

    public void zzmt() {
        zzU(false);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzz(long j);
}
