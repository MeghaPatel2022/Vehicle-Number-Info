package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzrx {
    protected volatile int zzbcl = -1;

    public static final <T extends zzrx> T zza(T t, byte[] bArr) throws zzrw {
        return zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzrx zzrx, byte[] bArr, int i, int i2) {
        try {
            zzrq zzb = zzrq.zzb(bArr, i, i2);
            zzrx.zza(zzb);
            zzb.zzDj();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzrx> T zzb(T t, byte[] bArr, int i, int i2) throws zzrw {
        try {
            zzrp zza = zzrp.zza(bArr, i, i2);
            t.zzb(zza);
            zza.zzli(0);
            return t;
        } catch (zzrw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] zzf(zzrx zzrx) {
        byte[] bArr = new byte[zzrx.zzDx()];
        zza(zzrx, bArr, 0, bArr.length);
        return bArr;
    }

    public String toString() {
        return zzry.zzg(this);
    }

    /* access modifiers changed from: protected */
    public int zzB() {
        return 0;
    }

    /* renamed from: zzDm */
    public zzrx clone() throws CloneNotSupportedException {
        return (zzrx) super.clone();
    }

    public int zzDw() {
        if (this.zzbcl < 0) {
            zzDx();
        }
        return this.zzbcl;
    }

    public int zzDx() {
        int zzB = zzB();
        this.zzbcl = zzB;
        return zzB;
    }

    public void zza(zzrq zzrq) throws IOException {
    }

    public abstract zzrx zzb(zzrp zzrp) throws IOException;
}
