package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import java.io.IOException;
import java.util.Arrays;

public interface zzsb {

    public static final class zza extends zzrr<zza> {
        public String[] zzbcv;
        public String[] zzbcw;
        public int[] zzbcx;
        public long[] zzbcy;

        public zza() {
            zzDy();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (!zzrv.equals((Object[]) this.zzbcv, (Object[]) zza.zzbcv) || !zzrv.equals((Object[]) this.zzbcw, (Object[]) zza.zzbcw) || !zzrv.equals(this.zzbcx, zza.zzbcx) || !zzrv.equals(this.zzbcy, zza.zzbcy)) {
                return false;
            }
            return zza(zza);
        }

        public int hashCode() {
            return ((((((((zzrv.hashCode((Object[]) this.zzbcv) + 527) * 31) + zzrv.hashCode((Object[]) this.zzbcw)) * 31) + zzrv.hashCode(this.zzbcx)) * 31) + zzrv.hashCode(this.zzbcy)) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zzbcv == null || this.zzbcv.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.zzbcv) {
                    if (str != null) {
                        i3++;
                        i2 += zzrq.zzfy(str);
                    }
                }
                i = zzB + i2 + (i3 * 1);
            }
            if (this.zzbcw != null && this.zzbcw.length > 0) {
                int i4 = 0;
                int i5 = 0;
                for (String str2 : this.zzbcw) {
                    if (str2 != null) {
                        i5++;
                        i4 += zzrq.zzfy(str2);
                    }
                }
                i = i + i4 + (i5 * 1);
            }
            if (this.zzbcx != null && this.zzbcx.length > 0) {
                int i6 = 0;
                for (int zzls : this.zzbcx) {
                    i6 += zzrq.zzls(zzls);
                }
                i = i + i6 + (this.zzbcx.length * 1);
            }
            if (this.zzbcy == null || this.zzbcy.length <= 0) {
                return i;
            }
            int i7 = 0;
            for (long zzY : this.zzbcy) {
                i7 += zzrq.zzY(zzY);
            }
            return i + i7 + (this.zzbcy.length * 1);
        }

        /* renamed from: zzB */
        public zza zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        int zzb = zzsa.zzb(zzrp, 10);
                        int length = this.zzbcv == null ? 0 : this.zzbcv.length;
                        String[] strArr = new String[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbcv, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzrp.readString();
                            zzrp.zzCT();
                            length++;
                        }
                        strArr[length] = zzrp.readString();
                        this.zzbcv = strArr;
                        continue;
                    case 18:
                        int zzb2 = zzsa.zzb(zzrp, 18);
                        int length2 = this.zzbcw == null ? 0 : this.zzbcw.length;
                        String[] strArr2 = new String[(zzb2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbcw, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = zzrp.readString();
                            zzrp.zzCT();
                            length2++;
                        }
                        strArr2[length2] = zzrp.readString();
                        this.zzbcw = strArr2;
                        continue;
                    case 24:
                        int zzb3 = zzsa.zzb(zzrp, 24);
                        int length3 = this.zzbcx == null ? 0 : this.zzbcx.length;
                        int[] iArr = new int[(zzb3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbcx, 0, iArr, 0, length3);
                        }
                        while (length3 < iArr.length - 1) {
                            iArr[length3] = zzrp.zzCW();
                            zzrp.zzCT();
                            length3++;
                        }
                        iArr[length3] = zzrp.zzCW();
                        this.zzbcx = iArr;
                        continue;
                    case 26:
                        int zzll = zzrp.zzll(zzrp.zzDa());
                        int position = zzrp.getPosition();
                        int i = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i++;
                        }
                        zzrp.zzln(position);
                        int length4 = this.zzbcx == null ? 0 : this.zzbcx.length;
                        int[] iArr2 = new int[(i + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzbcx, 0, iArr2, 0, length4);
                        }
                        while (length4 < iArr2.length) {
                            iArr2[length4] = zzrp.zzCW();
                            length4++;
                        }
                        this.zzbcx = iArr2;
                        zzrp.zzlm(zzll);
                        continue;
                    case 32:
                        int zzb4 = zzsa.zzb(zzrp, 32);
                        int length5 = this.zzbcy == null ? 0 : this.zzbcy.length;
                        long[] jArr = new long[(zzb4 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzbcy, 0, jArr, 0, length5);
                        }
                        while (length5 < jArr.length - 1) {
                            jArr[length5] = zzrp.zzCV();
                            zzrp.zzCT();
                            length5++;
                        }
                        jArr[length5] = zzrp.zzCV();
                        this.zzbcy = jArr;
                        continue;
                    case 34:
                        int zzll2 = zzrp.zzll(zzrp.zzDa());
                        int position2 = zzrp.getPosition();
                        int i2 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCV();
                            i2++;
                        }
                        zzrp.zzln(position2);
                        int length6 = this.zzbcy == null ? 0 : this.zzbcy.length;
                        long[] jArr2 = new long[(i2 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzbcy, 0, jArr2, 0, length6);
                        }
                        while (length6 < jArr2.length) {
                            jArr2[length6] = zzrp.zzCV();
                            length6++;
                        }
                        this.zzbcy = jArr2;
                        zzrp.zzlm(zzll2);
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

        public zza zzDy() {
            this.zzbcv = zzsa.zzbcs;
            this.zzbcw = zzsa.zzbcs;
            this.zzbcx = zzsa.zzbcn;
            this.zzbcy = zzsa.zzbco;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (this.zzbcv != null && this.zzbcv.length > 0) {
                for (String str : this.zzbcv) {
                    if (str != null) {
                        zzrq.zzb(1, str);
                    }
                }
            }
            if (this.zzbcw != null && this.zzbcw.length > 0) {
                for (String str2 : this.zzbcw) {
                    if (str2 != null) {
                        zzrq.zzb(2, str2);
                    }
                }
            }
            if (this.zzbcx != null && this.zzbcx.length > 0) {
                for (int zzz : this.zzbcx) {
                    zzrq.zzz(3, zzz);
                }
            }
            if (this.zzbcy != null && this.zzbcy.length > 0) {
                for (long zzb : this.zzbcy) {
                    zzrq.zzb(4, zzb);
                }
            }
            super.zza(zzrq);
        }
    }

    public static final class zzb extends zzrr<zzb> {
        public String version;
        public String zzbcA;
        public int zzbcz;

        public zzb() {
            zzDz();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (this.zzbcz != zzb.zzbcz) {
                return false;
            }
            if (this.zzbcA == null) {
                if (zzb.zzbcA != null) {
                    return false;
                }
            } else if (!this.zzbcA.equals(zzb.zzbcA)) {
                return false;
            }
            if (this.version == null) {
                if (zzb.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzb.version)) {
                return false;
            }
            return zza(zzb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbcA == null ? 0 : this.zzbcA.hashCode()) + ((this.zzbcz + 527) * 31)) * 31;
            if (this.version != null) {
                i = this.version.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzbcz != 0) {
                zzB += zzrq.zzB(1, this.zzbcz);
            }
            if (!this.zzbcA.equals("")) {
                zzB += zzrq.zzl(2, this.zzbcA);
            }
            return !this.version.equals("") ? zzB + zzrq.zzl(3, this.version) : zzB;
        }

        /* renamed from: zzC */
        public zzb zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 8:
                        int zzCW = zzrp.zzCW();
                        switch (zzCW) {
                            case 0:
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
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.zzbcz = zzCW;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzbcA = zzrp.readString();
                        continue;
                    case 26:
                        this.version = zzrp.readString();
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

        public zzb zzDz() {
            this.zzbcz = 0;
            this.zzbcA = "";
            this.version = "";
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (this.zzbcz != 0) {
                zzrq.zzz(1, this.zzbcz);
            }
            if (!this.zzbcA.equals("")) {
                zzrq.zzb(2, this.zzbcA);
            }
            if (!this.version.equals("")) {
                zzrq.zzb(3, this.version);
            }
            super.zza(zzrq);
        }
    }

    public static final class zzc extends zzrr<zzc> {
        public byte[] zzbcB;
        public byte[][] zzbcC;
        public boolean zzbcD;

        public zzc() {
            zzDA();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (!Arrays.equals(this.zzbcB, zzc.zzbcB) || !zzrv.zza(this.zzbcC, zzc.zzbcC) || this.zzbcD != zzc.zzbcD) {
                return false;
            }
            return zza(zzc);
        }

        public int hashCode() {
            return (((this.zzbcD ? 1231 : 1237) + ((((Arrays.hashCode(this.zzbcB) + 527) * 31) + zzrv.zza(this.zzbcC)) * 31)) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (!Arrays.equals(this.zzbcB, zzsa.zzbcu)) {
                zzB += zzrq.zzb(1, this.zzbcB);
            }
            if (this.zzbcC != null && this.zzbcC.length > 0) {
                int i = 0;
                int i2 = 0;
                for (byte[] bArr : this.zzbcC) {
                    if (bArr != null) {
                        i2++;
                        i += zzrq.zzC(bArr);
                    }
                }
                zzB = zzB + i + (i2 * 1);
            }
            return this.zzbcD ? zzB + zzrq.zzc(3, this.zzbcD) : zzB;
        }

        /* renamed from: zzD */
        public zzc zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        this.zzbcB = zzrp.readBytes();
                        continue;
                    case 18:
                        int zzb = zzsa.zzb(zzrp, 18);
                        int length = this.zzbcC == null ? 0 : this.zzbcC.length;
                        byte[][] bArr = new byte[(zzb + length)][];
                        if (length != 0) {
                            System.arraycopy(this.zzbcC, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzrp.readBytes();
                            zzrp.zzCT();
                            length++;
                        }
                        bArr[length] = zzrp.readBytes();
                        this.zzbcC = bArr;
                        continue;
                    case 24:
                        this.zzbcD = zzrp.zzCX();
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

        public zzc zzDA() {
            this.zzbcB = zzsa.zzbcu;
            this.zzbcC = zzsa.zzbct;
            this.zzbcD = false;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (!Arrays.equals(this.zzbcB, zzsa.zzbcu)) {
                zzrq.zza(1, this.zzbcB);
            }
            if (this.zzbcC != null && this.zzbcC.length > 0) {
                for (byte[] bArr : this.zzbcC) {
                    if (bArr != null) {
                        zzrq.zza(2, bArr);
                    }
                }
            }
            if (this.zzbcD) {
                zzrq.zzb(3, this.zzbcD);
            }
            super.zza(zzrq);
        }
    }

    public static final class zzd extends zzrr<zzd> {
        public String tag;
        public long zzbcE;
        public long zzbcF;
        public int zzbcG;
        public int zzbcH;
        public boolean zzbcI;
        public zze[] zzbcJ;
        public zzb zzbcK;
        public byte[] zzbcL;
        public byte[] zzbcM;
        public byte[] zzbcN;
        public zza zzbcO;
        public String zzbcP;
        public long zzbcQ;
        public zzc zzbcR;
        public byte[] zzbcS;
        public int zzbcT;
        public int[] zzbcU;

        public zzd() {
            zzDB();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (this.zzbcE != zzd.zzbcE || this.zzbcF != zzd.zzbcF) {
                return false;
            }
            if (this.tag == null) {
                if (zzd.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(zzd.tag)) {
                return false;
            }
            if (this.zzbcG != zzd.zzbcG || this.zzbcH != zzd.zzbcH || this.zzbcI != zzd.zzbcI || !zzrv.equals((Object[]) this.zzbcJ, (Object[]) zzd.zzbcJ)) {
                return false;
            }
            if (this.zzbcK == null) {
                if (zzd.zzbcK != null) {
                    return false;
                }
            } else if (!this.zzbcK.equals(zzd.zzbcK)) {
                return false;
            }
            if (!Arrays.equals(this.zzbcL, zzd.zzbcL) || !Arrays.equals(this.zzbcM, zzd.zzbcM) || !Arrays.equals(this.zzbcN, zzd.zzbcN)) {
                return false;
            }
            if (this.zzbcO == null) {
                if (zzd.zzbcO != null) {
                    return false;
                }
            } else if (!this.zzbcO.equals(zzd.zzbcO)) {
                return false;
            }
            if (this.zzbcP == null) {
                if (zzd.zzbcP != null) {
                    return false;
                }
            } else if (!this.zzbcP.equals(zzd.zzbcP)) {
                return false;
            }
            if (this.zzbcQ != zzd.zzbcQ) {
                return false;
            }
            if (this.zzbcR == null) {
                if (zzd.zzbcR != null) {
                    return false;
                }
            } else if (!this.zzbcR.equals(zzd.zzbcR)) {
                return false;
            }
            if (!Arrays.equals(this.zzbcS, zzd.zzbcS) || this.zzbcT != zzd.zzbcT || !zzrv.equals(this.zzbcU, zzd.zzbcU)) {
                return false;
            }
            return zza(zzd);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzbcP == null ? 0 : this.zzbcP.hashCode()) + (((this.zzbcO == null ? 0 : this.zzbcO.hashCode()) + (((((((((this.zzbcK == null ? 0 : this.zzbcK.hashCode()) + (((((this.zzbcI ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((int) (this.zzbcE ^ (this.zzbcE >>> 32))) + 527) * 31) + ((int) (this.zzbcF ^ (this.zzbcF >>> 32)))) * 31)) * 31) + this.zzbcG) * 31) + this.zzbcH) * 31)) * 31) + zzrv.hashCode((Object[]) this.zzbcJ)) * 31)) * 31) + Arrays.hashCode(this.zzbcL)) * 31) + Arrays.hashCode(this.zzbcM)) * 31) + Arrays.hashCode(this.zzbcN)) * 31)) * 31)) * 31) + ((int) (this.zzbcQ ^ (this.zzbcQ >>> 32)))) * 31;
            if (this.zzbcR != null) {
                i = this.zzbcR.hashCode();
            }
            return ((((((((hashCode + i) * 31) + Arrays.hashCode(this.zzbcS)) * 31) + this.zzbcT) * 31) + zzrv.hashCode(this.zzbcU)) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzbcE != 0) {
                zzB += zzrq.zzd(1, this.zzbcE);
            }
            if (!this.tag.equals("")) {
                zzB += zzrq.zzl(2, this.tag);
            }
            if (this.zzbcJ != null && this.zzbcJ.length > 0) {
                int i = zzB;
                for (zze zze : this.zzbcJ) {
                    if (zze != null) {
                        i += zzrq.zzc(3, (zzrx) zze);
                    }
                }
                zzB = i;
            }
            if (!Arrays.equals(this.zzbcL, zzsa.zzbcu)) {
                zzB += zzrq.zzb(6, this.zzbcL);
            }
            if (this.zzbcO != null) {
                zzB += zzrq.zzc(7, (zzrx) this.zzbcO);
            }
            if (!Arrays.equals(this.zzbcM, zzsa.zzbcu)) {
                zzB += zzrq.zzb(8, this.zzbcM);
            }
            if (this.zzbcK != null) {
                zzB += zzrq.zzc(9, (zzrx) this.zzbcK);
            }
            if (this.zzbcI) {
                zzB += zzrq.zzc(10, this.zzbcI);
            }
            if (this.zzbcG != 0) {
                zzB += zzrq.zzB(11, this.zzbcG);
            }
            if (this.zzbcH != 0) {
                zzB += zzrq.zzB(12, this.zzbcH);
            }
            if (!Arrays.equals(this.zzbcN, zzsa.zzbcu)) {
                zzB += zzrq.zzb(13, this.zzbcN);
            }
            if (!this.zzbcP.equals("")) {
                zzB += zzrq.zzl(14, this.zzbcP);
            }
            if (this.zzbcQ != 180000) {
                zzB += zzrq.zze(15, this.zzbcQ);
            }
            if (this.zzbcR != null) {
                zzB += zzrq.zzc(16, (zzrx) this.zzbcR);
            }
            if (this.zzbcF != 0) {
                zzB += zzrq.zzd(17, this.zzbcF);
            }
            if (!Arrays.equals(this.zzbcS, zzsa.zzbcu)) {
                zzB += zzrq.zzb(18, this.zzbcS);
            }
            if (this.zzbcT != 0) {
                zzB += zzrq.zzB(19, this.zzbcT);
            }
            if (this.zzbcU == null || this.zzbcU.length <= 0) {
                return zzB;
            }
            int i2 = 0;
            for (int zzls : this.zzbcU) {
                i2 += zzrq.zzls(zzls);
            }
            return zzB + i2 + (this.zzbcU.length * 2);
        }

        public zzd zzDB() {
            this.zzbcE = 0;
            this.zzbcF = 0;
            this.tag = "";
            this.zzbcG = 0;
            this.zzbcH = 0;
            this.zzbcI = false;
            this.zzbcJ = zze.zzDC();
            this.zzbcK = null;
            this.zzbcL = zzsa.zzbcu;
            this.zzbcM = zzsa.zzbcu;
            this.zzbcN = zzsa.zzbcu;
            this.zzbcO = null;
            this.zzbcP = "";
            this.zzbcQ = 180000;
            this.zzbcR = null;
            this.zzbcS = zzsa.zzbcu;
            this.zzbcT = 0;
            this.zzbcU = zzsa.zzbcn;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        /* renamed from: zzE */
        public zzd zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 8:
                        this.zzbcE = zzrp.zzCV();
                        continue;
                    case 18:
                        this.tag = zzrp.readString();
                        continue;
                    case 26:
                        int zzb = zzsa.zzb(zzrp, 26);
                        int length = this.zzbcJ == null ? 0 : this.zzbcJ.length;
                        zze[] zzeArr = new zze[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbcJ, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzrp.zza(zzeArr[length]);
                            zzrp.zzCT();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzrp.zza(zzeArr[length]);
                        this.zzbcJ = zzeArr;
                        continue;
                    case 50:
                        this.zzbcL = zzrp.readBytes();
                        continue;
                    case 58:
                        if (this.zzbcO == null) {
                            this.zzbcO = new zza();
                        }
                        zzrp.zza(this.zzbcO);
                        continue;
                    case 66:
                        this.zzbcM = zzrp.readBytes();
                        continue;
                    case 74:
                        if (this.zzbcK == null) {
                            this.zzbcK = new zzb();
                        }
                        zzrp.zza(this.zzbcK);
                        continue;
                    case 80:
                        this.zzbcI = zzrp.zzCX();
                        continue;
                    case 88:
                        this.zzbcG = zzrp.zzCW();
                        continue;
                    case 96:
                        this.zzbcH = zzrp.zzCW();
                        continue;
                    case 106:
                        this.zzbcN = zzrp.readBytes();
                        continue;
                    case 114:
                        this.zzbcP = zzrp.readString();
                        continue;
                    case 120:
                        this.zzbcQ = zzrp.zzCZ();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        if (this.zzbcR == null) {
                            this.zzbcR = new zzc();
                        }
                        zzrp.zza(this.zzbcR);
                        continue;
                    case 136:
                        this.zzbcF = zzrp.zzCV();
                        continue;
                    case 146:
                        this.zzbcS = zzrp.readBytes();
                        continue;
                    case 152:
                        int zzCW = zzrp.zzCW();
                        switch (zzCW) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzbcT = zzCW;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        int zzb2 = zzsa.zzb(zzrp, 160);
                        int length2 = this.zzbcU == null ? 0 : this.zzbcU.length;
                        int[] iArr = new int[(zzb2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbcU, 0, iArr, 0, length2);
                        }
                        while (length2 < iArr.length - 1) {
                            iArr[length2] = zzrp.zzCW();
                            zzrp.zzCT();
                            length2++;
                        }
                        iArr[length2] = zzrp.zzCW();
                        this.zzbcU = iArr;
                        continue;
                    case 162:
                        int zzll = zzrp.zzll(zzrp.zzDa());
                        int position = zzrp.getPosition();
                        int i = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i++;
                        }
                        zzrp.zzln(position);
                        int length3 = this.zzbcU == null ? 0 : this.zzbcU.length;
                        int[] iArr2 = new int[(i + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbcU, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzrp.zzCW();
                            length3++;
                        }
                        this.zzbcU = iArr2;
                        zzrp.zzlm(zzll);
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

        public void zza(zzrq zzrq) throws IOException {
            if (this.zzbcE != 0) {
                zzrq.zzb(1, this.zzbcE);
            }
            if (!this.tag.equals("")) {
                zzrq.zzb(2, this.tag);
            }
            if (this.zzbcJ != null && this.zzbcJ.length > 0) {
                for (zze zze : this.zzbcJ) {
                    if (zze != null) {
                        zzrq.zza(3, (zzrx) zze);
                    }
                }
            }
            if (!Arrays.equals(this.zzbcL, zzsa.zzbcu)) {
                zzrq.zza(6, this.zzbcL);
            }
            if (this.zzbcO != null) {
                zzrq.zza(7, (zzrx) this.zzbcO);
            }
            if (!Arrays.equals(this.zzbcM, zzsa.zzbcu)) {
                zzrq.zza(8, this.zzbcM);
            }
            if (this.zzbcK != null) {
                zzrq.zza(9, (zzrx) this.zzbcK);
            }
            if (this.zzbcI) {
                zzrq.zzb(10, this.zzbcI);
            }
            if (this.zzbcG != 0) {
                zzrq.zzz(11, this.zzbcG);
            }
            if (this.zzbcH != 0) {
                zzrq.zzz(12, this.zzbcH);
            }
            if (!Arrays.equals(this.zzbcN, zzsa.zzbcu)) {
                zzrq.zza(13, this.zzbcN);
            }
            if (!this.zzbcP.equals("")) {
                zzrq.zzb(14, this.zzbcP);
            }
            if (this.zzbcQ != 180000) {
                zzrq.zzc(15, this.zzbcQ);
            }
            if (this.zzbcR != null) {
                zzrq.zza(16, (zzrx) this.zzbcR);
            }
            if (this.zzbcF != 0) {
                zzrq.zzb(17, this.zzbcF);
            }
            if (!Arrays.equals(this.zzbcS, zzsa.zzbcu)) {
                zzrq.zza(18, this.zzbcS);
            }
            if (this.zzbcT != 0) {
                zzrq.zzz(19, this.zzbcT);
            }
            if (this.zzbcU != null && this.zzbcU.length > 0) {
                for (int zzz : this.zzbcU) {
                    zzrq.zzz(20, zzz);
                }
            }
            super.zza(zzrq);
        }
    }

    public static final class zze extends zzrr<zze> {
        private static volatile zze[] zzbcV;
        public String key;
        public String value;

        public zze() {
            zzDD();
        }

        public static zze[] zzDC() {
            if (zzbcV == null) {
                synchronized (zzrv.zzbck) {
                    if (zzbcV == null) {
                        zzbcV = new zze[0];
                    }
                }
            }
            return zzbcV;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zze = (zze) o;
            if (this.key == null) {
                if (zze.key != null) {
                    return false;
                }
            } else if (!this.key.equals(zze.key)) {
                return false;
            }
            if (this.value == null) {
                if (zze.value != null) {
                    return false;
                }
            } else if (!this.value.equals(zze.value)) {
                return false;
            }
            return zza(zze);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.key == null ? 0 : this.key.hashCode()) + 527) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (!this.key.equals("")) {
                zzB += zzrq.zzl(1, this.key);
            }
            return !this.value.equals("") ? zzB + zzrq.zzl(2, this.value) : zzB;
        }

        public zze zzDD() {
            this.key = "";
            this.value = "";
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        /* renamed from: zzF */
        public zze zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzrp.readString();
                        continue;
                    case 18:
                        this.value = zzrp.readString();
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

        public void zza(zzrq zzrq) throws IOException {
            if (!this.key.equals("")) {
                zzrq.zzb(1, this.key);
            }
            if (!this.value.equals("")) {
                zzrq.zzb(2, this.value);
            }
            super.zza(zzrq);
        }
    }
}
