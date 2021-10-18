package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import java.io.IOException;

public final class zzas extends zzrr<zzas> {
    public int versionCode;
    public String zzajB;
    public long zzajC;
    public int zzajD;
    public long zzajz;

    public zzas() {
        zzqL();
    }

    public static zzas zzl(byte[] bArr) throws zzrw {
        return (zzas) zzrx.zza(new zzas(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzas)) {
            return false;
        }
        zzas zzas = (zzas) o;
        if (this.versionCode != zzas.versionCode) {
            return false;
        }
        if (this.zzajB == null) {
            if (zzas.zzajB != null) {
                return false;
            }
        } else if (!this.zzajB.equals(zzas.zzajB)) {
            return false;
        }
        if (this.zzajC == zzas.zzajC && this.zzajz == zzas.zzajz && this.zzajD == zzas.zzajD) {
            return zza(zzas);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.zzajB == null ? 0 : this.zzajB.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.zzajC ^ (this.zzajC >>> 32)))) * 31) + ((int) (this.zzajz ^ (this.zzajz >>> 32)))) * 31) + this.zzajD) * 31) + zzDk();
    }

    /* access modifiers changed from: protected */
    public int zzB() {
        int zzB = super.zzB() + zzrq.zzB(1, this.versionCode) + zzrq.zzl(2, this.zzajB) + zzrq.zze(3, this.zzajC) + zzrq.zze(4, this.zzajz);
        return this.zzajD != -1 ? zzB + zzrq.zzB(5, this.zzajD) : zzB;
    }

    public void zza(zzrq zzrq) throws IOException {
        zzrq.zzz(1, this.versionCode);
        zzrq.zzb(2, this.zzajB);
        zzrq.zzc(3, this.zzajC);
        zzrq.zzc(4, this.zzajz);
        if (this.zzajD != -1) {
            zzrq.zzz(5, this.zzajD);
        }
        super.zza(zzrq);
    }

    /* renamed from: zzn */
    public zzas zzb(zzrp zzrp) throws IOException {
        while (true) {
            int zzCT = zzrp.zzCT();
            switch (zzCT) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzrp.zzCW();
                    continue;
                case 18:
                    this.zzajB = zzrp.readString();
                    continue;
                case 24:
                    this.zzajC = zzrp.zzCZ();
                    continue;
                case 32:
                    this.zzajz = zzrp.zzCZ();
                    continue;
                case 40:
                    this.zzajD = zzrp.zzCW();
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

    public zzas zzqL() {
        this.versionCode = 1;
        this.zzajB = "";
        this.zzajC = -1;
        this.zzajz = -1;
        this.zzajD = -1;
        this.zzbca = null;
        this.zzbcl = -1;
        return this;
    }
}
