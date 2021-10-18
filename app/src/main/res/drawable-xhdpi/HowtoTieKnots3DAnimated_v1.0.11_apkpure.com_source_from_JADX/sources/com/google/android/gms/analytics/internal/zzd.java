package com.google.android.gms.analytics.internal;

public abstract class zzd extends zzc {
    private boolean zzLA;
    private boolean zzLz;

    protected zzd(zzf zzf) {
        super(zzf);
    }

    public boolean isInitialized() {
        return this.zzLz && !this.zzLA;
    }

    public void zza() {
        zzhB();
        this.zzLz = true;
    }

    /* access modifiers changed from: protected */
    public abstract void zzhB();

    /* access modifiers changed from: protected */
    public void zzio() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
