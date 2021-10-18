package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzlo implements zzlm {
    private static zzlo zzagd;

    public static synchronized zzlm zzpN() {
        zzlo zzlo;
        synchronized (zzlo.class) {
            if (zzagd == null) {
                zzagd = new zzlo();
            }
            zzlo = zzagd;
        }
        return zzlo;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
