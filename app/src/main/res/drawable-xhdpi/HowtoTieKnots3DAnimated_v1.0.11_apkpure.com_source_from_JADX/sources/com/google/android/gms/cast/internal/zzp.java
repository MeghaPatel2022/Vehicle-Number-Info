package com.google.android.gms.cast.internal;

import android.os.SystemClock;

public final class zzp {
    private static final zzl zzTy = new zzl("RequestTracker");
    public static final Object zzXT = new Object();
    private long zzWo = -1;
    private long zzXQ;
    private long zzXR = 0;
    private zzo zzXS;

    public zzp(long j) {
        this.zzXQ = j;
    }

    private void zzmN() {
        this.zzWo = -1;
        this.zzXS = null;
        this.zzXR = 0;
    }

    public void clear() {
        synchronized (zzXT) {
            if (this.zzWo != -1) {
                zzmN();
            }
        }
    }

    public boolean zzB(long j) {
        boolean z;
        synchronized (zzXT) {
            z = this.zzWo != -1 && this.zzWo == j;
        }
        return z;
    }

    public void zza(long j, zzo zzo) {
        zzo zzo2;
        long j2;
        synchronized (zzXT) {
            zzo2 = this.zzXS;
            j2 = this.zzWo;
            this.zzWo = j;
            this.zzXS = zzo;
            this.zzXR = SystemClock.elapsedRealtime();
        }
        if (zzo2 != null) {
            zzo2.zzy(j2);
        }
    }

    public boolean zzc(long j, int i) {
        return zzc(j, i, null);
    }

    public boolean zzc(long j, int i, Object obj) {
        boolean z = true;
        zzo zzo = null;
        synchronized (zzXT) {
            if (this.zzWo == -1 || this.zzWo != j) {
                z = false;
            } else {
                zzTy.zzb("request %d completed", Long.valueOf(this.zzWo));
                zzo = this.zzXS;
                zzmN();
            }
        }
        if (zzo != null) {
            zzo.zza(j, i, obj);
        }
        return z;
    }

    public boolean zzd(long j, int i) {
        zzo zzo;
        boolean z = true;
        long j2 = 0;
        synchronized (zzXT) {
            if (this.zzWo == -1 || j - this.zzXR < this.zzXQ) {
                z = false;
                zzo = null;
            } else {
                zzTy.zzb("request %d timed out", Long.valueOf(this.zzWo));
                j2 = this.zzWo;
                zzo = this.zzXS;
                zzmN();
            }
        }
        if (zzo != null) {
            zzo.zza(j2, i, null);
        }
        return z;
    }

    public boolean zzmO() {
        boolean z;
        synchronized (zzXT) {
            z = this.zzWo != -1;
        }
        return z;
    }
}
