package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzok;

public class zzk extends zzd {
    private final zzok zzMm = new zzok();

    zzk(zzf zzf) {
        super(zzf);
    }

    /* access modifiers changed from: protected */
    public void zzhB() {
        zzig().zzxu().zza(this.zzMm);
        zzhw();
    }

    public void zzhw() {
        zzan zzhA = zzhA();
        String zzjZ = zzhA.zzjZ();
        if (zzjZ != null) {
            this.zzMm.setAppName(zzjZ);
        }
        String zzkb = zzhA.zzkb();
        if (zzkb != null) {
            this.zzMm.setAppVersion(zzkb);
        }
    }

    public zzok zziL() {
        zzio();
        return this.zzMm;
    }
}
