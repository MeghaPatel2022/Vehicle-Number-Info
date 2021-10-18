package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlm;

class zzaj {
    private long zzOC;
    private final zzlm zzpO;

    public zzaj(zzlm zzlm) {
        zzx.zzv(zzlm);
        this.zzpO = zzlm;
    }

    public zzaj(zzlm zzlm, long j) {
        zzx.zzv(zzlm);
        this.zzpO = zzlm;
        this.zzOC = j;
    }

    public void clear() {
        this.zzOC = 0;
    }

    public void start() {
        this.zzOC = this.zzpO.elapsedRealtime();
    }

    public boolean zzv(long j) {
        return this.zzOC == 0 || this.zzpO.elapsedRealtime() - this.zzOC > j;
    }
}
