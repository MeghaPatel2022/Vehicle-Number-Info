package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzaf.zzj;
import java.io.IOException;

public interface zzqh {

    public static final class zza extends zzrr<zza> {
        public long zzaTt;
        public zzj zzaTu;
        public zzf zziR;

        public zza() {
            zzBo();
        }

        public static zza zzs(byte[] bArr) throws zzrw {
            return (zza) zzrx.zza(new zza(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.zzaTt != zza.zzaTt) {
                return false;
            }
            if (this.zziR == null) {
                if (zza.zziR != null) {
                    return false;
                }
            } else if (!this.zziR.equals(zza.zziR)) {
                return false;
            }
            if (this.zzaTu == null) {
                if (zza.zzaTu != null) {
                    return false;
                }
            } else if (!this.zzaTu.equals(zza.zzaTu)) {
                return false;
            }
            return zza(zza);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zziR == null ? 0 : this.zziR.hashCode()) + ((((int) (this.zzaTt ^ (this.zzaTt >>> 32))) + 527) * 31)) * 31;
            if (this.zzaTu != null) {
                i = this.zzaTu.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB() + zzrq.zzd(1, this.zzaTt);
            if (this.zziR != null) {
                zzB += zzrq.zzc(2, (zzrx) this.zziR);
            }
            return this.zzaTu != null ? zzB + zzrq.zzc(3, (zzrx) this.zzaTu) : zzB;
        }

        public zza zzBo() {
            this.zzaTt = 0;
            this.zziR = null;
            this.zzaTu = null;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            zzrq.zzb(1, this.zzaTt);
            if (this.zziR != null) {
                zzrq.zza(2, (zzrx) this.zziR);
            }
            if (this.zzaTu != null) {
                zzrq.zza(3, (zzrx) this.zzaTu);
            }
            super.zza(zzrq);
        }

        /* renamed from: zzu */
        public zza zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 8:
                        this.zzaTt = zzrp.zzCV();
                        continue;
                    case 18:
                        if (this.zziR == null) {
                            this.zziR = new zzf();
                        }
                        zzrp.zza(this.zziR);
                        continue;
                    case 26:
                        if (this.zzaTu == null) {
                            this.zzaTu = new zzj();
                        }
                        zzrp.zza(this.zzaTu);
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
    }
}
