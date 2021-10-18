package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzrm extends zzrr<zzrm> {
    public zza[] zzbbr;

    public static final class zza extends zzrr<zza> {
        private static volatile zza[] zzbbs;
        public String name;
        public C1471zza zzbbt;

        /* renamed from: com.google.android.gms.internal.zzrm$zza$zza reason: collision with other inner class name */
        public static final class C1471zza extends zzrr<C1471zza> {
            private static volatile C1471zza[] zzbbu;
            public int type;
            public C1472zza zzbbv;

            /* renamed from: com.google.android.gms.internal.zzrm$zza$zza$zza reason: collision with other inner class name */
            public static final class C1472zza extends zzrr<C1472zza> {
                public long zzbbA;
                public int zzbbB;
                public int zzbbC;
                public boolean zzbbD;
                public zza[] zzbbE;
                public C1471zza[] zzbbF;
                public String[] zzbbG;
                public long[] zzbbH;
                public float[] zzbbI;
                public long zzbbJ;
                public byte[] zzbbw;
                public String zzbbx;
                public double zzbby;
                public float zzbbz;

                public C1472zza() {
                    zzCR();
                }

                public boolean equals(Object o) {
                    if (o == this) {
                        return true;
                    }
                    if (!(o instanceof C1472zza)) {
                        return false;
                    }
                    C1472zza zza = (C1472zza) o;
                    if (!Arrays.equals(this.zzbbw, zza.zzbbw)) {
                        return false;
                    }
                    if (this.zzbbx == null) {
                        if (zza.zzbbx != null) {
                            return false;
                        }
                    } else if (!this.zzbbx.equals(zza.zzbbx)) {
                        return false;
                    }
                    if (Double.doubleToLongBits(this.zzbby) == Double.doubleToLongBits(zza.zzbby) && Float.floatToIntBits(this.zzbbz) == Float.floatToIntBits(zza.zzbbz) && this.zzbbA == zza.zzbbA && this.zzbbB == zza.zzbbB && this.zzbbC == zza.zzbbC && this.zzbbD == zza.zzbbD && zzrv.equals((Object[]) this.zzbbE, (Object[]) zza.zzbbE) && zzrv.equals((Object[]) this.zzbbF, (Object[]) zza.zzbbF) && zzrv.equals((Object[]) this.zzbbG, (Object[]) zza.zzbbG) && zzrv.equals(this.zzbbH, zza.zzbbH) && zzrv.equals(this.zzbbI, zza.zzbbI) && this.zzbbJ == zza.zzbbJ) {
                        return zza(zza);
                    }
                    return false;
                }

                public int hashCode() {
                    int hashCode = (this.zzbbx == null ? 0 : this.zzbbx.hashCode()) + ((Arrays.hashCode(this.zzbbw) + 527) * 31);
                    long doubleToLongBits = Double.doubleToLongBits(this.zzbby);
                    return (((((((((((((((this.zzbbD ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.zzbbz)) * 31) + ((int) (this.zzbbA ^ (this.zzbbA >>> 32)))) * 31) + this.zzbbB) * 31) + this.zzbbC) * 31)) * 31) + zzrv.hashCode((Object[]) this.zzbbE)) * 31) + zzrv.hashCode((Object[]) this.zzbbF)) * 31) + zzrv.hashCode((Object[]) this.zzbbG)) * 31) + zzrv.hashCode(this.zzbbH)) * 31) + zzrv.hashCode(this.zzbbI)) * 31) + ((int) (this.zzbbJ ^ (this.zzbbJ >>> 32)))) * 31) + zzDk();
                }

                /* access modifiers changed from: protected */
                public int zzB() {
                    int zzB = super.zzB();
                    if (!Arrays.equals(this.zzbbw, zzsa.zzbcu)) {
                        zzB += zzrq.zzb(1, this.zzbbw);
                    }
                    if (!this.zzbbx.equals("")) {
                        zzB += zzrq.zzl(2, this.zzbbx);
                    }
                    if (Double.doubleToLongBits(this.zzbby) != Double.doubleToLongBits(0.0d)) {
                        zzB += zzrq.zzb(3, this.zzbby);
                    }
                    if (Float.floatToIntBits(this.zzbbz) != Float.floatToIntBits(0.0f)) {
                        zzB += zzrq.zzc(4, this.zzbbz);
                    }
                    if (this.zzbbA != 0) {
                        zzB += zzrq.zzd(5, this.zzbbA);
                    }
                    if (this.zzbbB != 0) {
                        zzB += zzrq.zzB(6, this.zzbbB);
                    }
                    if (this.zzbbC != 0) {
                        zzB += zzrq.zzC(7, this.zzbbC);
                    }
                    if (this.zzbbD) {
                        zzB += zzrq.zzc(8, this.zzbbD);
                    }
                    if (this.zzbbE != null && this.zzbbE.length > 0) {
                        int i = zzB;
                        for (zza zza : this.zzbbE) {
                            if (zza != null) {
                                i += zzrq.zzc(9, (zzrx) zza);
                            }
                        }
                        zzB = i;
                    }
                    if (this.zzbbF != null && this.zzbbF.length > 0) {
                        int i2 = zzB;
                        for (C1471zza zza2 : this.zzbbF) {
                            if (zza2 != null) {
                                i2 += zzrq.zzc(10, (zzrx) zza2);
                            }
                        }
                        zzB = i2;
                    }
                    if (this.zzbbG != null && this.zzbbG.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str : this.zzbbG) {
                            if (str != null) {
                                i4++;
                                i3 += zzrq.zzfy(str);
                            }
                        }
                        zzB = zzB + i3 + (i4 * 1);
                    }
                    if (this.zzbbH != null && this.zzbbH.length > 0) {
                        int i5 = 0;
                        for (long zzY : this.zzbbH) {
                            i5 += zzrq.zzY(zzY);
                        }
                        zzB = zzB + i5 + (this.zzbbH.length * 1);
                    }
                    if (this.zzbbJ != 0) {
                        zzB += zzrq.zzd(13, this.zzbbJ);
                    }
                    return (this.zzbbI == null || this.zzbbI.length <= 0) ? zzB : zzB + (this.zzbbI.length * 4) + (this.zzbbI.length * 1);
                }

                public C1472zza zzCR() {
                    this.zzbbw = zzsa.zzbcu;
                    this.zzbbx = "";
                    this.zzbby = 0.0d;
                    this.zzbbz = 0.0f;
                    this.zzbbA = 0;
                    this.zzbbB = 0;
                    this.zzbbC = 0;
                    this.zzbbD = false;
                    this.zzbbE = zza.zzCN();
                    this.zzbbF = C1471zza.zzCP();
                    this.zzbbG = zzsa.zzbcs;
                    this.zzbbH = zzsa.zzbco;
                    this.zzbbI = zzsa.zzbcp;
                    this.zzbbJ = 0;
                    this.zzbca = null;
                    this.zzbcl = -1;
                    return this;
                }

                public void zza(zzrq zzrq) throws IOException {
                    if (!Arrays.equals(this.zzbbw, zzsa.zzbcu)) {
                        zzrq.zza(1, this.zzbbw);
                    }
                    if (!this.zzbbx.equals("")) {
                        zzrq.zzb(2, this.zzbbx);
                    }
                    if (Double.doubleToLongBits(this.zzbby) != Double.doubleToLongBits(0.0d)) {
                        zzrq.zza(3, this.zzbby);
                    }
                    if (Float.floatToIntBits(this.zzbbz) != Float.floatToIntBits(0.0f)) {
                        zzrq.zzb(4, this.zzbbz);
                    }
                    if (this.zzbbA != 0) {
                        zzrq.zzb(5, this.zzbbA);
                    }
                    if (this.zzbbB != 0) {
                        zzrq.zzz(6, this.zzbbB);
                    }
                    if (this.zzbbC != 0) {
                        zzrq.zzA(7, this.zzbbC);
                    }
                    if (this.zzbbD) {
                        zzrq.zzb(8, this.zzbbD);
                    }
                    if (this.zzbbE != null && this.zzbbE.length > 0) {
                        for (zza zza : this.zzbbE) {
                            if (zza != null) {
                                zzrq.zza(9, (zzrx) zza);
                            }
                        }
                    }
                    if (this.zzbbF != null && this.zzbbF.length > 0) {
                        for (C1471zza zza2 : this.zzbbF) {
                            if (zza2 != null) {
                                zzrq.zza(10, (zzrx) zza2);
                            }
                        }
                    }
                    if (this.zzbbG != null && this.zzbbG.length > 0) {
                        for (String str : this.zzbbG) {
                            if (str != null) {
                                zzrq.zzb(11, str);
                            }
                        }
                    }
                    if (this.zzbbH != null && this.zzbbH.length > 0) {
                        for (long zzb : this.zzbbH) {
                            zzrq.zzb(12, zzb);
                        }
                    }
                    if (this.zzbbJ != 0) {
                        zzrq.zzb(13, this.zzbbJ);
                    }
                    if (this.zzbbI != null && this.zzbbI.length > 0) {
                        for (float zzb2 : this.zzbbI) {
                            zzrq.zzb(14, zzb2);
                        }
                    }
                    super.zza(zzrq);
                }

                /* renamed from: zzy */
                public C1472zza zzb(zzrp zzrp) throws IOException {
                    while (true) {
                        int zzCT = zzrp.zzCT();
                        switch (zzCT) {
                            case 0:
                                break;
                            case 10:
                                this.zzbbw = zzrp.readBytes();
                                continue;
                            case 18:
                                this.zzbbx = zzrp.readString();
                                continue;
                            case 25:
                                this.zzbby = zzrp.readDouble();
                                continue;
                            case 37:
                                this.zzbbz = zzrp.readFloat();
                                continue;
                            case 40:
                                this.zzbbA = zzrp.zzCV();
                                continue;
                            case 48:
                                this.zzbbB = zzrp.zzCW();
                                continue;
                            case 56:
                                this.zzbbC = zzrp.zzCY();
                                continue;
                            case 64:
                                this.zzbbD = zzrp.zzCX();
                                continue;
                            case 74:
                                int zzb = zzsa.zzb(zzrp, 74);
                                int length = this.zzbbE == null ? 0 : this.zzbbE.length;
                                zza[] zzaArr = new zza[(zzb + length)];
                                if (length != 0) {
                                    System.arraycopy(this.zzbbE, 0, zzaArr, 0, length);
                                }
                                while (length < zzaArr.length - 1) {
                                    zzaArr[length] = new zza();
                                    zzrp.zza(zzaArr[length]);
                                    zzrp.zzCT();
                                    length++;
                                }
                                zzaArr[length] = new zza();
                                zzrp.zza(zzaArr[length]);
                                this.zzbbE = zzaArr;
                                continue;
                            case 82:
                                int zzb2 = zzsa.zzb(zzrp, 82);
                                int length2 = this.zzbbF == null ? 0 : this.zzbbF.length;
                                C1471zza[] zzaArr2 = new C1471zza[(zzb2 + length2)];
                                if (length2 != 0) {
                                    System.arraycopy(this.zzbbF, 0, zzaArr2, 0, length2);
                                }
                                while (length2 < zzaArr2.length - 1) {
                                    zzaArr2[length2] = new C1471zza();
                                    zzrp.zza(zzaArr2[length2]);
                                    zzrp.zzCT();
                                    length2++;
                                }
                                zzaArr2[length2] = new C1471zza();
                                zzrp.zza(zzaArr2[length2]);
                                this.zzbbF = zzaArr2;
                                continue;
                            case 90:
                                int zzb3 = zzsa.zzb(zzrp, 90);
                                int length3 = this.zzbbG == null ? 0 : this.zzbbG.length;
                                String[] strArr = new String[(zzb3 + length3)];
                                if (length3 != 0) {
                                    System.arraycopy(this.zzbbG, 0, strArr, 0, length3);
                                }
                                while (length3 < strArr.length - 1) {
                                    strArr[length3] = zzrp.readString();
                                    zzrp.zzCT();
                                    length3++;
                                }
                                strArr[length3] = zzrp.readString();
                                this.zzbbG = strArr;
                                continue;
                            case 96:
                                int zzb4 = zzsa.zzb(zzrp, 96);
                                int length4 = this.zzbbH == null ? 0 : this.zzbbH.length;
                                long[] jArr = new long[(zzb4 + length4)];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzbbH, 0, jArr, 0, length4);
                                }
                                while (length4 < jArr.length - 1) {
                                    jArr[length4] = zzrp.zzCV();
                                    zzrp.zzCT();
                                    length4++;
                                }
                                jArr[length4] = zzrp.zzCV();
                                this.zzbbH = jArr;
                                continue;
                            case 98:
                                int zzll = zzrp.zzll(zzrp.zzDa());
                                int position = zzrp.getPosition();
                                int i = 0;
                                while (zzrp.zzDf() > 0) {
                                    zzrp.zzCV();
                                    i++;
                                }
                                zzrp.zzln(position);
                                int length5 = this.zzbbH == null ? 0 : this.zzbbH.length;
                                long[] jArr2 = new long[(i + length5)];
                                if (length5 != 0) {
                                    System.arraycopy(this.zzbbH, 0, jArr2, 0, length5);
                                }
                                while (length5 < jArr2.length) {
                                    jArr2[length5] = zzrp.zzCV();
                                    length5++;
                                }
                                this.zzbbH = jArr2;
                                zzrp.zzlm(zzll);
                                continue;
                            case 104:
                                this.zzbbJ = zzrp.zzCV();
                                continue;
                            case 114:
                                int zzDa = zzrp.zzDa();
                                int zzll2 = zzrp.zzll(zzDa);
                                int i2 = zzDa / 4;
                                int length6 = this.zzbbI == null ? 0 : this.zzbbI.length;
                                float[] fArr = new float[(i2 + length6)];
                                if (length6 != 0) {
                                    System.arraycopy(this.zzbbI, 0, fArr, 0, length6);
                                }
                                while (length6 < fArr.length) {
                                    fArr[length6] = zzrp.readFloat();
                                    length6++;
                                }
                                this.zzbbI = fArr;
                                zzrp.zzlm(zzll2);
                                continue;
                            case 117:
                                int zzb5 = zzsa.zzb(zzrp, 117);
                                int length7 = this.zzbbI == null ? 0 : this.zzbbI.length;
                                float[] fArr2 = new float[(zzb5 + length7)];
                                if (length7 != 0) {
                                    System.arraycopy(this.zzbbI, 0, fArr2, 0, length7);
                                }
                                while (length7 < fArr2.length - 1) {
                                    fArr2[length7] = zzrp.readFloat();
                                    zzrp.zzCT();
                                    length7++;
                                }
                                fArr2[length7] = zzrp.readFloat();
                                this.zzbbI = fArr2;
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

            public C1471zza() {
                zzCQ();
            }

            public static C1471zza[] zzCP() {
                if (zzbbu == null) {
                    synchronized (zzrv.zzbck) {
                        if (zzbbu == null) {
                            zzbbu = new C1471zza[0];
                        }
                    }
                }
                return zzbbu;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C1471zza)) {
                    return false;
                }
                C1471zza zza = (C1471zza) o;
                if (this.type != zza.type) {
                    return false;
                }
                if (this.zzbbv == null) {
                    if (zza.zzbbv != null) {
                        return false;
                    }
                } else if (!this.zzbbv.equals(zza.zzbbv)) {
                    return false;
                }
                return zza(zza);
            }

            public int hashCode() {
                return (((this.zzbbv == null ? 0 : this.zzbbv.hashCode()) + ((this.type + 527) * 31)) * 31) + zzDk();
            }

            /* access modifiers changed from: protected */
            public int zzB() {
                int zzB = super.zzB() + zzrq.zzB(1, this.type);
                return this.zzbbv != null ? zzB + zzrq.zzc(2, (zzrx) this.zzbbv) : zzB;
            }

            public C1471zza zzCQ() {
                this.type = 1;
                this.zzbbv = null;
                this.zzbca = null;
                this.zzbcl = -1;
                return this;
            }

            public void zza(zzrq zzrq) throws IOException {
                zzrq.zzz(1, this.type);
                if (this.zzbbv != null) {
                    zzrq.zza(2, (zzrx) this.zzbbv);
                }
                super.zza(zzrq);
            }

            /* renamed from: zzx */
            public C1471zza zzb(zzrp zzrp) throws IOException {
                while (true) {
                    int zzCT = zzrp.zzCT();
                    switch (zzCT) {
                        case 0:
                            break;
                        case 8:
                            int zzCW = zzrp.zzCW();
                            switch (zzCW) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                    this.type = zzCW;
                                    break;
                                default:
                                    continue;
                            }
                        case 18:
                            if (this.zzbbv == null) {
                                this.zzbbv = new C1472zza();
                            }
                            zzrp.zza(this.zzbbv);
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

        public zza() {
            zzCO();
        }

        public static zza[] zzCN() {
            if (zzbbs == null) {
                synchronized (zzrv.zzbck) {
                    if (zzbbs == null) {
                        zzbbs = new zza[0];
                    }
                }
            }
            return zzbbs;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.name == null) {
                if (zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zza.name)) {
                return false;
            }
            if (this.zzbbt == null) {
                if (zza.zzbbt != null) {
                    return false;
                }
            } else if (!this.zzbbt.equals(zza.zzbbt)) {
                return false;
            }
            return zza(zza);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.zzbbt != null) {
                i = this.zzbbt.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB() + zzrq.zzl(1, this.name);
            return this.zzbbt != null ? zzB + zzrq.zzc(2, (zzrx) this.zzbbt) : zzB;
        }

        public zza zzCO() {
            this.name = "";
            this.zzbbt = null;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            zzrq.zzb(1, this.name);
            if (this.zzbbt != null) {
                zzrq.zza(2, (zzrx) this.zzbbt);
            }
            super.zza(zzrq);
        }

        /* renamed from: zzw */
        public zza zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrp.readString();
                        continue;
                    case 18:
                        if (this.zzbbt == null) {
                            this.zzbbt = new C1471zza();
                        }
                        zzrp.zza(this.zzbbt);
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

    public zzrm() {
        zzCM();
    }

    public static zzrm zzw(byte[] bArr) throws zzrw {
        return (zzrm) zzrx.zza(new zzrm(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrm)) {
            return false;
        }
        zzrm zzrm = (zzrm) o;
        if (zzrv.equals((Object[]) this.zzbbr, (Object[]) zzrm.zzbbr)) {
            return zza(zzrm);
        }
        return false;
    }

    public int hashCode() {
        return ((zzrv.hashCode((Object[]) this.zzbbr) + 527) * 31) + zzDk();
    }

    /* access modifiers changed from: protected */
    public int zzB() {
        int zzB = super.zzB();
        if (this.zzbbr != null && this.zzbbr.length > 0) {
            for (zza zza2 : this.zzbbr) {
                if (zza2 != null) {
                    zzB += zzrq.zzc(1, (zzrx) zza2);
                }
            }
        }
        return zzB;
    }

    public zzrm zzCM() {
        this.zzbbr = zza.zzCN();
        this.zzbca = null;
        this.zzbcl = -1;
        return this;
    }

    public void zza(zzrq zzrq) throws IOException {
        if (this.zzbbr != null && this.zzbbr.length > 0) {
            for (zza zza2 : this.zzbbr) {
                if (zza2 != null) {
                    zzrq.zza(1, (zzrx) zza2);
                }
            }
        }
        super.zza(zzrq);
    }

    /* renamed from: zzv */
    public zzrm zzb(zzrp zzrp) throws IOException {
        while (true) {
            int zzCT = zzrp.zzCT();
            switch (zzCT) {
                case 0:
                    break;
                case 10:
                    int zzb = zzsa.zzb(zzrp, 10);
                    int length = this.zzbbr == null ? 0 : this.zzbbr.length;
                    zza[] zzaArr = new zza[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbbr, 0, zzaArr, 0, length);
                    }
                    while (length < zzaArr.length - 1) {
                        zzaArr[length] = new zza();
                        zzrp.zza(zzaArr[length]);
                        zzrp.zzCT();
                        length++;
                    }
                    zzaArr[length] = new zza();
                    zzrp.zza(zzaArr[length]);
                    this.zzbbr = zzaArr;
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
