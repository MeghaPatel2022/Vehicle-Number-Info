package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import java.io.IOException;

public final class zzat extends zzrr<zzat> {
    public long zzajC;
    public long zzajz;

    public zzat() {
        zzqM();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzat)) {
            return false;
        }
        zzat zzat = (zzat) o;
        if (this.zzajC == zzat.zzajC && this.zzajz == zzat.zzajz) {
            return zza(zzat);
        }
        return false;
    }

    public int hashCode() {
        return ((((((int) (this.zzajC ^ (this.zzajC >>> 32))) + 527) * 31) + ((int) (this.zzajz ^ (this.zzajz >>> 32)))) * 31) + zzDk();
    }

    /* access modifiers changed from: protected */
    public int zzB() {
        return super.zzB() + zzrq.zze(1, this.zzajC) + zzrq.zze(2, this.zzajz);
    }

    public void zza(zzrq zzrq) throws IOException {
        zzrq.zzc(1, this.zzajC);
        zzrq.zzc(2, this.zzajz);
        super.zza(zzrq);
    }

    /* renamed from: zzo */
    public zzat zzb(zzrp zzrp) throws IOException {
        while (true) {
            int zzCT = zzrp.zzCT();
            switch (zzCT) {
                case 0:
                    break;
                case 8:
                    this.zzajC = zzrp.zzCZ();
                    continue;
                case 16:
                    this.zzajz = zzrp.zzCZ();
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

    public zzat zzqM() {
        this.zzajC = -1;
        this.zzajz = -1;
        this.zzbca = null;
        this.zzbcl = -1;
        return this;
    }
}
