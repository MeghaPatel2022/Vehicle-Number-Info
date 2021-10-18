package com.google.android.gms.internal;

import java.io.IOException;

public interface zzag {

    public static final class zza extends zzrr<zza> {
        private static volatile zza[] zziT;
        public int type;
        public String zziU;
        public zza[] zziV;
        public zza[] zziW;
        public zza[] zziX;
        public String zziY;
        public String zziZ;
        public long zzja;
        public boolean zzjb;
        public zza[] zzjc;
        public int[] zzjd;
        public boolean zzje;

        public zza() {
            zzR();
        }

        public static zza[] zzQ() {
            if (zziT == null) {
                synchronized (zzrv.zzbck) {
                    if (zziT == null) {
                        zziT = new zza[0];
                    }
                }
            }
            return zziT;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.type != zza.type) {
                return false;
            }
            if (this.zziU == null) {
                if (zza.zziU != null) {
                    return false;
                }
            } else if (!this.zziU.equals(zza.zziU)) {
                return false;
            }
            if (!zzrv.equals((Object[]) this.zziV, (Object[]) zza.zziV) || !zzrv.equals((Object[]) this.zziW, (Object[]) zza.zziW) || !zzrv.equals((Object[]) this.zziX, (Object[]) zza.zziX)) {
                return false;
            }
            if (this.zziY == null) {
                if (zza.zziY != null) {
                    return false;
                }
            } else if (!this.zziY.equals(zza.zziY)) {
                return false;
            }
            if (this.zziZ == null) {
                if (zza.zziZ != null) {
                    return false;
                }
            } else if (!this.zziZ.equals(zza.zziZ)) {
                return false;
            }
            if (this.zzja == zza.zzja && this.zzjb == zza.zzjb && zzrv.equals((Object[]) this.zzjc, (Object[]) zza.zzjc) && zzrv.equals(this.zzjd, zza.zzjd) && this.zzje == zza.zzje) {
                return zza(zza);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.zziY == null ? 0 : this.zziY.hashCode()) + (((((((((this.zziU == null ? 0 : this.zziU.hashCode()) + ((this.type + 527) * 31)) * 31) + zzrv.hashCode((Object[]) this.zziV)) * 31) + zzrv.hashCode((Object[]) this.zziW)) * 31) + zzrv.hashCode((Object[]) this.zziX)) * 31)) * 31;
            if (this.zziZ != null) {
                i2 = this.zziZ.hashCode();
            }
            int hashCode2 = ((((((this.zzjb ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.zzja ^ (this.zzja >>> 32)))) * 31)) * 31) + zzrv.hashCode((Object[]) this.zzjc)) * 31) + zzrv.hashCode(this.zzjd)) * 31;
            if (!this.zzje) {
                i = 1237;
            }
            return ((hashCode2 + i) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB() + zzrq.zzB(1, this.type);
            if (!this.zziU.equals("")) {
                zzB += zzrq.zzl(2, this.zziU);
            }
            if (this.zziV != null && this.zziV.length > 0) {
                int i = zzB;
                for (zza zza : this.zziV) {
                    if (zza != null) {
                        i += zzrq.zzc(3, (zzrx) zza);
                    }
                }
                zzB = i;
            }
            if (this.zziW != null && this.zziW.length > 0) {
                int i2 = zzB;
                for (zza zza2 : this.zziW) {
                    if (zza2 != null) {
                        i2 += zzrq.zzc(4, (zzrx) zza2);
                    }
                }
                zzB = i2;
            }
            if (this.zziX != null && this.zziX.length > 0) {
                int i3 = zzB;
                for (zza zza3 : this.zziX) {
                    if (zza3 != null) {
                        i3 += zzrq.zzc(5, (zzrx) zza3);
                    }
                }
                zzB = i3;
            }
            if (!this.zziY.equals("")) {
                zzB += zzrq.zzl(6, this.zziY);
            }
            if (!this.zziZ.equals("")) {
                zzB += zzrq.zzl(7, this.zziZ);
            }
            if (this.zzja != 0) {
                zzB += zzrq.zzd(8, this.zzja);
            }
            if (this.zzje) {
                zzB += zzrq.zzc(9, this.zzje);
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                int i4 = 0;
                for (int zzls : this.zzjd) {
                    i4 += zzrq.zzls(zzls);
                }
                zzB = zzB + i4 + (this.zzjd.length * 1);
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                for (zza zza4 : this.zzjc) {
                    if (zza4 != null) {
                        zzB += zzrq.zzc(11, (zzrx) zza4);
                    }
                }
            }
            return this.zzjb ? zzB + zzrq.zzc(12, this.zzjb) : zzB;
        }

        public zza zzR() {
            this.type = 1;
            this.zziU = "";
            this.zziV = zzQ();
            this.zziW = zzQ();
            this.zziX = zzQ();
            this.zziY = "";
            this.zziZ = "";
            this.zzja = 0;
            this.zzjb = false;
            this.zzjc = zzQ();
            this.zzjd = zzsa.zzbcn;
            this.zzje = false;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            zzrq.zzz(1, this.type);
            if (!this.zziU.equals("")) {
                zzrq.zzb(2, this.zziU);
            }
            if (this.zziV != null && this.zziV.length > 0) {
                for (zza zza : this.zziV) {
                    if (zza != null) {
                        zzrq.zza(3, (zzrx) zza);
                    }
                }
            }
            if (this.zziW != null && this.zziW.length > 0) {
                for (zza zza2 : this.zziW) {
                    if (zza2 != null) {
                        zzrq.zza(4, (zzrx) zza2);
                    }
                }
            }
            if (this.zziX != null && this.zziX.length > 0) {
                for (zza zza3 : this.zziX) {
                    if (zza3 != null) {
                        zzrq.zza(5, (zzrx) zza3);
                    }
                }
            }
            if (!this.zziY.equals("")) {
                zzrq.zzb(6, this.zziY);
            }
            if (!this.zziZ.equals("")) {
                zzrq.zzb(7, this.zziZ);
            }
            if (this.zzja != 0) {
                zzrq.zzb(8, this.zzja);
            }
            if (this.zzje) {
                zzrq.zzb(9, this.zzje);
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                for (int zzz : this.zzjd) {
                    zzrq.zzz(10, zzz);
                }
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                for (zza zza4 : this.zzjc) {
                    if (zza4 != null) {
                        zzrq.zza(11, (zzrx) zza4);
                    }
                }
            }
            if (this.zzjb) {
                zzrq.zzb(12, this.zzjb);
            }
            super.zza(zzrq);
        }

        /* renamed from: zzl */
        public zza zzb(zzrp zzrp) throws IOException {
            int i;
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
                                this.type = zzCW;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zziU = zzrp.readString();
                        continue;
                    case 26:
                        int zzb = zzsa.zzb(zzrp, 26);
                        int length = this.zziV == null ? 0 : this.zziV.length;
                        zza[] zzaArr = new zza[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziV, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new zza();
                            zzrp.zza(zzaArr[length]);
                            zzrp.zzCT();
                            length++;
                        }
                        zzaArr[length] = new zza();
                        zzrp.zza(zzaArr[length]);
                        this.zziV = zzaArr;
                        continue;
                    case 34:
                        int zzb2 = zzsa.zzb(zzrp, 34);
                        int length2 = this.zziW == null ? 0 : this.zziW.length;
                        zza[] zzaArr2 = new zza[(zzb2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziW, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zza();
                            zzrp.zza(zzaArr2[length2]);
                            zzrp.zzCT();
                            length2++;
                        }
                        zzaArr2[length2] = new zza();
                        zzrp.zza(zzaArr2[length2]);
                        this.zziW = zzaArr2;
                        continue;
                    case 42:
                        int zzb3 = zzsa.zzb(zzrp, 42);
                        int length3 = this.zziX == null ? 0 : this.zziX.length;
                        zza[] zzaArr3 = new zza[(zzb3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziX, 0, zzaArr3, 0, length3);
                        }
                        while (length3 < zzaArr3.length - 1) {
                            zzaArr3[length3] = new zza();
                            zzrp.zza(zzaArr3[length3]);
                            zzrp.zzCT();
                            length3++;
                        }
                        zzaArr3[length3] = new zza();
                        zzrp.zza(zzaArr3[length3]);
                        this.zziX = zzaArr3;
                        continue;
                    case 50:
                        this.zziY = zzrp.readString();
                        continue;
                    case 58:
                        this.zziZ = zzrp.readString();
                        continue;
                    case 64:
                        this.zzja = zzrp.zzCV();
                        continue;
                    case 72:
                        this.zzje = zzrp.zzCX();
                        continue;
                    case 80:
                        int zzb4 = zzsa.zzb(zzrp, 80);
                        int[] iArr = new int[zzb4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < zzb4) {
                            if (i2 != 0) {
                                zzrp.zzCT();
                            }
                            int zzCW2 = zzrp.zzCW();
                            switch (zzCW2) {
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
                                    i = i3 + 1;
                                    iArr[i3] = zzCW2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.zzjd == null ? 0 : this.zzjd.length;
                            if (length4 != 0 || i3 != iArr.length) {
                                int[] iArr2 = new int[(length4 + i3)];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzjd, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.zzjd = iArr2;
                                break;
                            } else {
                                this.zzjd = iArr;
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 82:
                        int zzll = zzrp.zzll(zzrp.zzDa());
                        int position = zzrp.getPosition();
                        int i4 = 0;
                        while (zzrp.zzDf() > 0) {
                            switch (zzrp.zzCW()) {
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
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            zzrp.zzln(position);
                            int length5 = this.zzjd == null ? 0 : this.zzjd.length;
                            int[] iArr3 = new int[(i4 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.zzjd, 0, iArr3, 0, length5);
                            }
                            while (zzrp.zzDf() > 0) {
                                int zzCW3 = zzrp.zzCW();
                                switch (zzCW3) {
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
                                        int i5 = length5 + 1;
                                        iArr3[length5] = zzCW3;
                                        length5 = i5;
                                        break;
                                }
                            }
                            this.zzjd = iArr3;
                        }
                        zzrp.zzlm(zzll);
                        continue;
                    case 90:
                        int zzb5 = zzsa.zzb(zzrp, 90);
                        int length6 = this.zzjc == null ? 0 : this.zzjc.length;
                        zza[] zzaArr4 = new zza[(zzb5 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjc, 0, zzaArr4, 0, length6);
                        }
                        while (length6 < zzaArr4.length - 1) {
                            zzaArr4[length6] = new zza();
                            zzrp.zza(zzaArr4[length6]);
                            zzrp.zzCT();
                            length6++;
                        }
                        zzaArr4[length6] = new zza();
                        zzrp.zza(zzaArr4[length6]);
                        this.zzjc = zzaArr4;
                        continue;
                    case 96:
                        this.zzjb = zzrp.zzCX();
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
