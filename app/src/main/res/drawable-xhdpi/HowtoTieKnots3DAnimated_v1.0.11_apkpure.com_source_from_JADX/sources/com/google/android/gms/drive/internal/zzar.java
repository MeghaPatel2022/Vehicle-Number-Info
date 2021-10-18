package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import java.io.IOException;

public final class zzar extends zzrr<zzar> {
    public int versionCode;
    public long zzajA;
    public long zzajy;
    public long zzajz;

    public zzar() {
        zzqK();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzar)) {
            return false;
        }
        zzar zzar = (zzar) o;
        if (this.versionCode == zzar.versionCode && this.zzajy == zzar.zzajy && this.zzajz == zzar.zzajz && this.zzajA == zzar.zzajA) {
            return zza(zzar);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.versionCode + 527) * 31) + ((int) (this.zzajy ^ (this.zzajy >>> 32)))) * 31) + ((int) (this.zzajz ^ (this.zzajz >>> 32)))) * 31) + ((int) (this.zzajA ^ (this.zzajA >>> 32)))) * 31) + zzDk();
    }

    /* access modifiers changed from: protected */
    public int zzB() {
        return super.zzB() + zzrq.zzB(1, this.versionCode) + zzrq.zze(2, this.zzajy) + zzrq.zze(3, this.zzajz) + zzrq.zze(4, this.zzajA);
    }

    public void zza(zzrq zzrq) throws IOException {
        zzrq.zzz(1, this.versionCode);
        zzrq.zzc(2, this.zzajy);
        zzrq.zzc(3, this.zzajz);
        zzrq.zzc(4, this.zzajA);
        super.zza(zzrq);
    }

    /* renamed from: zzm */
    public zzar zzb(zzrp zzrp) throws IOException {
        while (true) {
            int zzCT = zzrp.zzCT();
            switch (zzCT) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzrp.zzCW();
                    continue;
                case 16:
                    this.zzajy = zzrp.zzCZ();
                    continue;
                case 24:
                    this.zzajz = zzrp.zzCZ();
                    continue;
                case 32:
                    this.zzajA = zzrp.zzCZ();
                    continue;
                default:
                    if (!zza(zzrp, zzCT)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public zzar zzqK() {
        this.versionCode = 1;
        this.zzajy = -1;
        this.zzajz = -1;
        this.zzajA = -1;
        this.zzbca = null;
        this.zzbcl = -1;
        return this;
    }
}
