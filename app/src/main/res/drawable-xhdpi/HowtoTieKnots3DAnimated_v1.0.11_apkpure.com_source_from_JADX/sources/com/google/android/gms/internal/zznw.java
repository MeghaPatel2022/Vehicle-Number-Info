package com.google.android.gms.internal;

import java.io.IOException;

public interface zznw {

    public static final class zza extends zzrr<zza> {
        public C1448zza[] zzaAm;

        /* renamed from: com.google.android.gms.internal.zznw$zza$zza reason: collision with other inner class name */
        public static final class C1448zza extends zzrr<C1448zza> {
            private static volatile C1448zza[] zzaAn;
            public int viewId;
            public String zzaAo;
            public String zzaAp;

            public C1448zza() {
                zzvq();
            }

            public static C1448zza[] zzvp() {
                if (zzaAn == null) {
                    synchronized (zzrv.zzbck) {
                        if (zzaAn == null) {
                            zzaAn = new C1448zza[0];
                        }
                    }
                }
                return zzaAn;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C1448zza)) {
                    return false;
                }
                C1448zza zza = (C1448zza) o;
                if (this.zzaAo == null) {
                    if (zza.zzaAo != null) {
                        return false;
                    }
                } else if (!this.zzaAo.equals(zza.zzaAo)) {
                    return false;
                }
                if (this.zzaAp == null) {
                    if (zza.zzaAp != null) {
                        return false;
                    }
                } else if (!this.zzaAp.equals(zza.zzaAp)) {
                    return false;
                }
                if (this.viewId == zza.viewId) {
                    return zza(zza);
                }
                return false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.zzaAo == null ? 0 : this.zzaAo.hashCode()) + 527) * 31;
                if (this.zzaAp != null) {
                    i = this.zzaAp.hashCode();
                }
                return ((((hashCode + i) * 31) + this.viewId) * 31) + zzDk();
            }

            /* access modifiers changed from: protected */
            public int zzB() {
                int zzB = super.zzB();
                if (!this.zzaAo.equals("")) {
                    zzB += zzrq.zzl(1, this.zzaAo);
                }
                if (!this.zzaAp.equals("")) {
                    zzB += zzrq.zzl(2, this.zzaAp);
                }
                return this.viewId != 0 ? zzB + zzrq.zzB(3, this.viewId) : zzB;
            }

            public void zza(zzrq zzrq) throws IOException {
                if (!this.zzaAo.equals("")) {
                    zzrq.zzb(1, this.zzaAo);
                }
                if (!this.zzaAp.equals("")) {
                    zzrq.zzb(2, this.zzaAp);
                }
                if (this.viewId != 0) {
                    zzrq.zzz(3, this.viewId);
                }
                super.zza(zzrq);
            }

            /* renamed from: zzq */
            public C1448zza zzb(zzrp zzrp) throws IOException {
                while (true) {
                    int zzCT = zzrp.zzCT();
                    switch (zzCT) {
                        case 0:
                            break;
                        case 10:
                            this.zzaAo = zzrp.readString();
                            continue;
                        case 18:
                            this.zzaAp = zzrp.readString();
                            continue;
                        case 24:
                            this.viewId = zzrp.zzCW();
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

            public C1448zza zzvq() {
                this.zzaAo = "";
                this.zzaAp = "";
                this.viewId = 0;
                this.zzbca = null;
                this.zzbcl = -1;
                return this;
            }
        }

        public zza() {
            zzvo();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (zzrv.equals((Object[]) this.zzaAm, (Object[]) zza.zzaAm)) {
                return zza(zza);
            }
            return false;
        }

        public int hashCode() {
            return ((zzrv.hashCode((Object[]) this.zzaAm) + 527) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzaAm != null && this.zzaAm.length > 0) {
                for (C1448zza zza : this.zzaAm) {
                    if (zza != null) {
                        zzB += zzrq.zzc(1, (zzrx) zza);
                    }
                }
            }
            return zzB;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (this.zzaAm != null && this.zzaAm.length > 0) {
                for (C1448zza zza : this.zzaAm) {
                    if (zza != null) {
                        zzrq.zza(1, (zzrx) zza);
                    }
                }
            }
            super.zza(zzrq);
        }

        /* renamed from: zzp */
        public zza zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        int zzb = zzsa.zzb(zzrp, 10);
                        int length = this.zzaAm == null ? 0 : this.zzaAm.length;
                        C1448zza[] zzaArr = new C1448zza[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzaAm, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new C1448zza();
                            zzrp.zza(zzaArr[length]);
                            zzrp.zzCT();
                            length++;
                        }
                        zzaArr[length] = new C1448zza();
                        zzrp.zza(zzaArr[length]);
                        this.zzaAm = zzaArr;
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

        public zza zzvo() {
            this.zzaAm = C1448zza.zzvp();
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }
    }

    public static final class zzb extends zzrr<zzb> {
        private static volatile zzb[] zzaAq;
        public String name;
        public zzd zzaAr;

        public zzb() {
            zzvs();
        }

        public static zzb[] zzvr() {
            if (zzaAq == null) {
                synchronized (zzrv.zzbck) {
                    if (zzaAq == null) {
                        zzaAq = new zzb[0];
                    }
                }
            }
            return zzaAq;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (this.name == null) {
                if (zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzb.name)) {
                return false;
            }
            if (this.zzaAr == null) {
                if (zzb.zzaAr != null) {
                    return false;
                }
            } else if (!this.zzaAr.equals(zzb.zzaAr)) {
                return false;
            }
            return zza(zzb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.zzaAr != null) {
                i = this.zzaAr.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals("")) {
                zzB += zzrq.zzl(1, this.name);
            }
            return this.zzaAr != null ? zzB + zzrq.zzc(2, (zzrx) this.zzaAr) : zzB;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (!this.name.equals("")) {
                zzrq.zzb(1, this.name);
            }
            if (this.zzaAr != null) {
                zzrq.zza(2, (zzrx) this.zzaAr);
            }
            super.zza(zzrq);
        }

        /* renamed from: zzr */
        public zzb zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrp.readString();
                        continue;
                    case 18:
                        if (this.zzaAr == null) {
                            this.zzaAr = new zzd();
                        }
                        zzrp.zza(this.zzaAr);
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

        public zzb zzvs() {
            this.name = "";
            this.zzaAr = null;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }
    }

    public static final class zzc extends zzrr<zzc> {
        public String type;
        public zzb[] zzaAs;

        public zzc() {
            zzvt();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (this.type == null) {
                if (zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(zzc.type)) {
                return false;
            }
            if (zzrv.equals((Object[]) this.zzaAs, (Object[]) zzc.zzaAs)) {
                return zza(zzc);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.type == null ? 0 : this.type.hashCode()) + 527) * 31) + zzrv.hashCode((Object[]) this.zzaAs)) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (!this.type.equals("")) {
                zzB += zzrq.zzl(1, this.type);
            }
            if (this.zzaAs == null || this.zzaAs.length <= 0) {
                return zzB;
            }
            int i = zzB;
            for (zzb zzb : this.zzaAs) {
                if (zzb != null) {
                    i += zzrq.zzc(2, (zzrx) zzb);
                }
            }
            return i;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (!this.type.equals("")) {
                zzrq.zzb(1, this.type);
            }
            if (this.zzaAs != null && this.zzaAs.length > 0) {
                for (zzb zzb : this.zzaAs) {
                    if (zzb != null) {
                        zzrq.zza(2, (zzrx) zzb);
                    }
                }
            }
            super.zza(zzrq);
        }

        /* renamed from: zzs */
        public zzc zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        this.type = zzrp.readString();
                        continue;
                    case 18:
                        int zzb = zzsa.zzb(zzrp, 18);
                        int length = this.zzaAs == null ? 0 : this.zzaAs.length;
                        zzb[] zzbArr = new zzb[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzaAs, 0, zzbArr, 0, length);
                        }
                        while (length < zzbArr.length - 1) {
                            zzbArr[length] = new zzb();
                            zzrp.zza(zzbArr[length]);
                            zzrp.zzCT();
                            length++;
                        }
                        zzbArr[length] = new zzb();
                        zzrp.zza(zzbArr[length]);
                        this.zzaAs = zzbArr;
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

        public zzc zzvt() {
            this.type = "";
            this.zzaAs = zzb.zzvr();
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }
    }

    public static final class zzd extends zzrr<zzd> {
        public boolean zzaAt;
        public long zzaAu;
        public double zzaAv;
        public zzc zzaAw;
        public String zzaeO;

        public zzd() {
            zzvu();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (this.zzaAt != zzd.zzaAt) {
                return false;
            }
            if (this.zzaeO == null) {
                if (zzd.zzaeO != null) {
                    return false;
                }
            } else if (!this.zzaeO.equals(zzd.zzaeO)) {
                return false;
            }
            if (this.zzaAu != zzd.zzaAu || Double.doubleToLongBits(this.zzaAv) != Double.doubleToLongBits(zzd.zzaAv)) {
                return false;
            }
            if (this.zzaAw == null) {
                if (zzd.zzaAw != null) {
                    return false;
                }
            } else if (!this.zzaAw.equals(zzd.zzaAw)) {
                return false;
            }
            return zza(zzd);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzaeO == null ? 0 : this.zzaeO.hashCode()) + (((this.zzaAt ? 1231 : 1237) + 527) * 31)) * 31) + ((int) (this.zzaAu ^ (this.zzaAu >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzaAv);
            int i2 = ((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
            if (this.zzaAw != null) {
                i = this.zzaAw.hashCode();
            }
            return ((i2 + i) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzaAt) {
                zzB += zzrq.zzc(1, this.zzaAt);
            }
            if (!this.zzaeO.equals("")) {
                zzB += zzrq.zzl(2, this.zzaeO);
            }
            if (this.zzaAu != 0) {
                zzB += zzrq.zzd(3, this.zzaAu);
            }
            if (Double.doubleToLongBits(this.zzaAv) != Double.doubleToLongBits(0.0d)) {
                zzB += zzrq.zzb(4, this.zzaAv);
            }
            return this.zzaAw != null ? zzB + zzrq.zzc(5, (zzrx) this.zzaAw) : zzB;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (this.zzaAt) {
                zzrq.zzb(1, this.zzaAt);
            }
            if (!this.zzaeO.equals("")) {
                zzrq.zzb(2, this.zzaeO);
            }
            if (this.zzaAu != 0) {
                zzrq.zzb(3, this.zzaAu);
            }
            if (Double.doubleToLongBits(this.zzaAv) != Double.doubleToLongBits(0.0d)) {
                zzrq.zza(4, this.zzaAv);
            }
            if (this.zzaAw != null) {
                zzrq.zza(5, (zzrx) this.zzaAw);
            }
            super.zza(zzrq);
        }

        /* renamed from: zzt */
        public zzd zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 8:
                        this.zzaAt = zzrp.zzCX();
                        continue;
                    case 18:
                        this.zzaeO = zzrp.readString();
                        continue;
                    case 24:
                        this.zzaAu = zzrp.zzCV();
                        continue;
                    case 33:
                        this.zzaAv = zzrp.readDouble();
                        continue;
                    case 42:
                        if (this.zzaAw == null) {
                            this.zzaAw = new zzc();
                        }
                        zzrp.zza(this.zzaAw);
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

        public zzd zzvu() {
            this.zzaAt = false;
            this.zzaeO = "";
            this.zzaAu = 0;
            this.zzaAv = 0.0d;
            this.zzaAw = null;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }
    }
}
