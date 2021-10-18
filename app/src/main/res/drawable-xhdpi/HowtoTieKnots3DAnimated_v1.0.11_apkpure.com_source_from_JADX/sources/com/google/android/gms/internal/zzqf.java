package com.google.android.gms.internal;

public final class zzqf {
    private final boolean zzaTm;
    private final boolean zzaTn;
    private final String zzaTo;
    private final String zztw;

    public static final class zza {
        /* access modifiers changed from: private */
        public boolean zzaTm = true;
        /* access modifiers changed from: private */
        public boolean zzaTn = false;
        /* access modifiers changed from: private */
        public final String zzaTo;
        /* access modifiers changed from: private */
        public String zztw;

        public zza(String str) {
            this.zzaTo = str;
        }

        public zzqf zzBm() {
            return new zzqf(this);
        }

        public zza zzau(boolean z) {
            this.zzaTm = z;
            return this;
        }

        public zza zzav(boolean z) {
            this.zzaTn = z;
            return this;
        }

        public zza zzfh(String str) {
            this.zztw = str;
            return this;
        }
    }

    private zzqf(zza zza2) {
        this.zzaTo = zza2.zzaTo;
        this.zzaTm = zza2.zzaTm;
        this.zzaTn = zza2.zzaTn;
        this.zztw = zza2.zztw;
    }

    public String getTrackingId() {
        return this.zztw;
    }

    public String zzBj() {
        return this.zzaTo;
    }

    public boolean zzBk() {
        return this.zzaTm;
    }

    public boolean zzBl() {
        return this.zzaTn;
    }
}
