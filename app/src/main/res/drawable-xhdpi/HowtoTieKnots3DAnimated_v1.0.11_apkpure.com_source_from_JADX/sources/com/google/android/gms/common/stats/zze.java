package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.Log;

public class zze {
    private final long zzafP;
    private final int zzafQ;
    private final SimpleArrayMap<String, Long> zzafR;

    public zze() {
        this.zzafP = 60000;
        this.zzafQ = 10;
        this.zzafR = new SimpleArrayMap<>(10);
    }

    public zze(int i, long j) {
        this.zzafP = j;
        this.zzafQ = i;
        this.zzafR = new SimpleArrayMap<>();
    }

    private void zzb(long j, long j2) {
        for (int size = this.zzafR.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.zzafR.valueAt(size)).longValue() > j) {
                this.zzafR.removeAt(size);
            }
        }
    }

    public Long zzcy(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzafP;
        synchronized (this) {
            while (this.zzafR.size() >= this.zzafQ) {
                zzb(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.zzafQ + " is not enough. Current durationThreshold is: " + j);
            }
            l = (Long) this.zzafR.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean zzcz(String str) {
        boolean z;
        synchronized (this) {
            z = this.zzafR.remove(str) != null;
        }
        return z;
    }
}
