package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import java.io.IOException;

public interface zzaf {

    public static final class zza extends zzrr<zza> {
        public int level;
        public int zzhN;
        public int zzhO;

        public zza() {
            zzA();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.level == zza.level && this.zzhN == zza.zzhN && this.zzhO == zza.zzhO) {
                return zza(zza);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.level + 527) * 31) + this.zzhN) * 31) + this.zzhO) * 31) + zzDk();
        }

        public zza zzA() {
            this.level = 1;
            this.zzhN = 0;
            this.zzhO = 0;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.level != 1) {
                zzB += zzrq.zzB(1, this.level);
            }
            if (this.zzhN != 0) {
                zzB += zzrq.zzB(2, this.zzhN);
            }
            return this.zzhO != 0 ? zzB + zzrq.zzB(3, this.zzhO) : zzB;
        }

        /* renamed from: zza */
        public zza zzb(zzrp zzrp) throws IOException {
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
                                this.level = zzCW;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zzhN = zzrp.zzCW();
                        continue;
                    case 24:
                        this.zzhO = zzrp.zzCW();
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
            if (this.level != 1) {
                zzrq.zzz(1, this.level);
            }
            if (this.zzhN != 0) {
                zzrq.zzz(2, this.zzhN);
            }
            if (this.zzhO != 0) {
                zzrq.zzz(3, this.zzhO);
            }
            super.zza(zzrq);
        }
    }

    public static final class zzb extends zzrr<zzb> {
        private static volatile zzb[] zzhP;
        public int name;
        public int[] zzhQ;
        public int zzhR;
        public boolean zzhS;
        public boolean zzhT;

        public zzb() {
            zzD();
        }

        public static zzb[] zzC() {
            if (zzhP == null) {
                synchronized (zzrv.zzbck) {
                    if (zzhP == null) {
                        zzhP = new zzb[0];
                    }
                }
            }
            return zzhP;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (zzrv.equals(this.zzhQ, zzb.zzhQ) && this.zzhR == zzb.zzhR && this.name == zzb.name && this.zzhS == zzb.zzhS && this.zzhT == zzb.zzhT) {
                return zza(zzb);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzhS ? 1231 : 1237) + ((((((zzrv.hashCode(this.zzhQ) + 527) * 31) + this.zzhR) * 31) + this.name) * 31)) * 31;
            if (!this.zzhT) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int i;
            int i2 = 0;
            int zzB = super.zzB();
            if (this.zzhT) {
                zzB += zzrq.zzc(1, this.zzhT);
            }
            int zzB2 = zzrq.zzB(2, this.zzhR) + zzB;
            if (this.zzhQ == null || this.zzhQ.length <= 0) {
                i = zzB2;
            } else {
                for (int zzls : this.zzhQ) {
                    i2 += zzrq.zzls(zzls);
                }
                i = zzB2 + i2 + (this.zzhQ.length * 1);
            }
            if (this.name != 0) {
                i += zzrq.zzB(4, this.name);
            }
            return this.zzhS ? i + zzrq.zzc(6, this.zzhS) : i;
        }

        public zzb zzD() {
            this.zzhQ = zzsa.zzbcn;
            this.zzhR = 0;
            this.name = 0;
            this.zzhS = false;
            this.zzhT = false;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (this.zzhT) {
                zzrq.zzb(1, this.zzhT);
            }
            zzrq.zzz(2, this.zzhR);
            if (this.zzhQ != null && this.zzhQ.length > 0) {
                for (int zzz : this.zzhQ) {
                    zzrq.zzz(3, zzz);
                }
            }
            if (this.name != 0) {
                zzrq.zzz(4, this.name);
            }
            if (this.zzhS) {
                zzrq.zzb(6, this.zzhS);
            }
            super.zza(zzrq);
        }

        /* renamed from: zzc */
        public zzb zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 8:
                        this.zzhT = zzrp.zzCX();
                        continue;
                    case 16:
                        this.zzhR = zzrp.zzCW();
                        continue;
                    case 24:
                        int zzb = zzsa.zzb(zzrp, 24);
                        int length = this.zzhQ == null ? 0 : this.zzhQ.length;
                        int[] iArr = new int[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzhQ, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzrp.zzCW();
                            zzrp.zzCT();
                            length++;
                        }
                        iArr[length] = zzrp.zzCW();
                        this.zzhQ = iArr;
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
                        int length2 = this.zzhQ == null ? 0 : this.zzhQ.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzhQ, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzrp.zzCW();
                            length2++;
                        }
                        this.zzhQ = iArr2;
                        zzrp.zzlm(zzll);
                        continue;
                    case 32:
                        this.name = zzrp.zzCW();
                        continue;
                    case 48:
                        this.zzhS = zzrp.zzCX();
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

    public static final class zzc extends zzrr<zzc> {
        private static volatile zzc[] zzhU;
        public String key;
        public long zzhV;
        public long zzhW;
        public boolean zzhX;
        public long zzhY;

        public zzc() {
            zzF();
        }

        public static zzc[] zzE() {
            if (zzhU == null) {
                synchronized (zzrv.zzbck) {
                    if (zzhU == null) {
                        zzhU = new zzc[0];
                    }
                }
            }
            return zzhU;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (this.key == null) {
                if (zzc.key != null) {
                    return false;
                }
            } else if (!this.key.equals(zzc.key)) {
                return false;
            }
            if (this.zzhV == zzc.zzhV && this.zzhW == zzc.zzhW && this.zzhX == zzc.zzhX && this.zzhY == zzc.zzhY) {
                return zza(zzc);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.zzhX ? 1231 : 1237) + (((((((this.key == null ? 0 : this.key.hashCode()) + 527) * 31) + ((int) (this.zzhV ^ (this.zzhV >>> 32)))) * 31) + ((int) (this.zzhW ^ (this.zzhW >>> 32)))) * 31)) * 31) + ((int) (this.zzhY ^ (this.zzhY >>> 32)))) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (!this.key.equals("")) {
                zzB += zzrq.zzl(1, this.key);
            }
            if (this.zzhV != 0) {
                zzB += zzrq.zzd(2, this.zzhV);
            }
            if (this.zzhW != 2147483647L) {
                zzB += zzrq.zzd(3, this.zzhW);
            }
            if (this.zzhX) {
                zzB += zzrq.zzc(4, this.zzhX);
            }
            return this.zzhY != 0 ? zzB + zzrq.zzd(5, this.zzhY) : zzB;
        }

        public zzc zzF() {
            this.key = "";
            this.zzhV = 0;
            this.zzhW = 2147483647L;
            this.zzhX = false;
            this.zzhY = 0;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (!this.key.equals("")) {
                zzrq.zzb(1, this.key);
            }
            if (this.zzhV != 0) {
                zzrq.zzb(2, this.zzhV);
            }
            if (this.zzhW != 2147483647L) {
                zzrq.zzb(3, this.zzhW);
            }
            if (this.zzhX) {
                zzrq.zzb(4, this.zzhX);
            }
            if (this.zzhY != 0) {
                zzrq.zzb(5, this.zzhY);
            }
            super.zza(zzrq);
        }

        /* renamed from: zzd */
        public zzc zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzrp.readString();
                        continue;
                    case 16:
                        this.zzhV = zzrp.zzCV();
                        continue;
                    case 24:
                        this.zzhW = zzrp.zzCV();
                        continue;
                    case 32:
                        this.zzhX = zzrp.zzCX();
                        continue;
                    case 40:
                        this.zzhY = zzrp.zzCV();
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

    public static final class zzd extends zzrr<zzd> {
        public com.google.android.gms.internal.zzag.zza[] zzhZ;
        public com.google.android.gms.internal.zzag.zza[] zzia;
        public zzc[] zzib;

        public zzd() {
            zzG();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (!zzrv.equals((Object[]) this.zzhZ, (Object[]) zzd.zzhZ) || !zzrv.equals((Object[]) this.zzia, (Object[]) zzd.zzia) || !zzrv.equals((Object[]) this.zzib, (Object[]) zzd.zzib)) {
                return false;
            }
            return zza(zzd);
        }

        public int hashCode() {
            return ((((((zzrv.hashCode((Object[]) this.zzhZ) + 527) * 31) + zzrv.hashCode((Object[]) this.zzia)) * 31) + zzrv.hashCode((Object[]) this.zzib)) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzhZ != null && this.zzhZ.length > 0) {
                int i = zzB;
                for (com.google.android.gms.internal.zzag.zza zza : this.zzhZ) {
                    if (zza != null) {
                        i += zzrq.zzc(1, (zzrx) zza);
                    }
                }
                zzB = i;
            }
            if (this.zzia != null && this.zzia.length > 0) {
                int i2 = zzB;
                for (com.google.android.gms.internal.zzag.zza zza2 : this.zzia) {
                    if (zza2 != null) {
                        i2 += zzrq.zzc(2, (zzrx) zza2);
                    }
                }
                zzB = i2;
            }
            if (this.zzib != null && this.zzib.length > 0) {
                for (zzc zzc : this.zzib) {
                    if (zzc != null) {
                        zzB += zzrq.zzc(3, (zzrx) zzc);
                    }
                }
            }
            return zzB;
        }

        public zzd zzG() {
            this.zzhZ = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zzia = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zzib = zzc.zzE();
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (this.zzhZ != null && this.zzhZ.length > 0) {
                for (com.google.android.gms.internal.zzag.zza zza : this.zzhZ) {
                    if (zza != null) {
                        zzrq.zza(1, (zzrx) zza);
                    }
                }
            }
            if (this.zzia != null && this.zzia.length > 0) {
                for (com.google.android.gms.internal.zzag.zza zza2 : this.zzia) {
                    if (zza2 != null) {
                        zzrq.zza(2, (zzrx) zza2);
                    }
                }
            }
            if (this.zzib != null && this.zzib.length > 0) {
                for (zzc zzc : this.zzib) {
                    if (zzc != null) {
                        zzrq.zza(3, (zzrx) zzc);
                    }
                }
            }
            super.zza(zzrq);
        }

        /* renamed from: zze */
        public zzd zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        int zzb = zzsa.zzb(zzrp, 10);
                        int length = this.zzhZ == null ? 0 : this.zzhZ.length;
                        com.google.android.gms.internal.zzag.zza[] zzaArr = new com.google.android.gms.internal.zzag.zza[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzhZ, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new com.google.android.gms.internal.zzag.zza();
                            zzrp.zza(zzaArr[length]);
                            zzrp.zzCT();
                            length++;
                        }
                        zzaArr[length] = new com.google.android.gms.internal.zzag.zza();
                        zzrp.zza(zzaArr[length]);
                        this.zzhZ = zzaArr;
                        continue;
                    case 18:
                        int zzb2 = zzsa.zzb(zzrp, 18);
                        int length2 = this.zzia == null ? 0 : this.zzia.length;
                        com.google.android.gms.internal.zzag.zza[] zzaArr2 = new com.google.android.gms.internal.zzag.zza[(zzb2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzia, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new com.google.android.gms.internal.zzag.zza();
                            zzrp.zza(zzaArr2[length2]);
                            zzrp.zzCT();
                            length2++;
                        }
                        zzaArr2[length2] = new com.google.android.gms.internal.zzag.zza();
                        zzrp.zza(zzaArr2[length2]);
                        this.zzia = zzaArr2;
                        continue;
                    case 26:
                        int zzb3 = zzsa.zzb(zzrp, 26);
                        int length3 = this.zzib == null ? 0 : this.zzib.length;
                        zzc[] zzcArr = new zzc[(zzb3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzib, 0, zzcArr, 0, length3);
                        }
                        while (length3 < zzcArr.length - 1) {
                            zzcArr[length3] = new zzc();
                            zzrp.zza(zzcArr[length3]);
                            zzrp.zzCT();
                            length3++;
                        }
                        zzcArr[length3] = new zzc();
                        zzrp.zza(zzcArr[length3]);
                        this.zzib = zzcArr;
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

    public static final class zze extends zzrr<zze> {
        private static volatile zze[] zzic;
        public int key;
        public int value;

        public zze() {
            zzI();
        }

        public static zze[] zzH() {
            if (zzic == null) {
                synchronized (zzrv.zzbck) {
                    if (zzic == null) {
                        zzic = new zze[0];
                    }
                }
            }
            return zzic;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zze = (zze) o;
            if (this.key == zze.key && this.value == zze.value) {
                return zza(zze);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.key + 527) * 31) + this.value) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            return super.zzB() + zzrq.zzB(1, this.key) + zzrq.zzB(2, this.value);
        }

        public zze zzI() {
            this.key = 0;
            this.value = 0;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            zzrq.zzz(1, this.key);
            zzrq.zzz(2, this.value);
            super.zza(zzrq);
        }

        /* renamed from: zzf */
        public zze zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 8:
                        this.key = zzrp.zzCW();
                        continue;
                    case 16:
                        this.value = zzrp.zzCW();
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

    public static final class zzf extends zzrr<zzf> {
        public String version;
        public String[] zzid;
        public String[] zzie;
        public com.google.android.gms.internal.zzag.zza[] zzif;
        public zze[] zzig;
        public zzb[] zzih;
        public zzb[] zzii;
        public zzb[] zzij;
        public zzg[] zzik;
        public String zzil;
        public String zzim;
        public String zzin;
        public zza zzio;
        public float zzip;
        public boolean zziq;
        public String[] zzir;
        public int zzis;

        public zzf() {
            zzJ();
        }

        public static zzf zzc(byte[] bArr) throws zzrw {
            return (zzf) zzrx.zza(new zzf(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) o;
            if (!zzrv.equals((Object[]) this.zzid, (Object[]) zzf.zzid) || !zzrv.equals((Object[]) this.zzie, (Object[]) zzf.zzie) || !zzrv.equals((Object[]) this.zzif, (Object[]) zzf.zzif) || !zzrv.equals((Object[]) this.zzig, (Object[]) zzf.zzig) || !zzrv.equals((Object[]) this.zzih, (Object[]) zzf.zzih) || !zzrv.equals((Object[]) this.zzii, (Object[]) zzf.zzii) || !zzrv.equals((Object[]) this.zzij, (Object[]) zzf.zzij) || !zzrv.equals((Object[]) this.zzik, (Object[]) zzf.zzik)) {
                return false;
            }
            if (this.zzil == null) {
                if (zzf.zzil != null) {
                    return false;
                }
            } else if (!this.zzil.equals(zzf.zzil)) {
                return false;
            }
            if (this.zzim == null) {
                if (zzf.zzim != null) {
                    return false;
                }
            } else if (!this.zzim.equals(zzf.zzim)) {
                return false;
            }
            if (this.zzin == null) {
                if (zzf.zzin != null) {
                    return false;
                }
            } else if (!this.zzin.equals(zzf.zzin)) {
                return false;
            }
            if (this.version == null) {
                if (zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzf.version)) {
                return false;
            }
            if (this.zzio == null) {
                if (zzf.zzio != null) {
                    return false;
                }
            } else if (!this.zzio.equals(zzf.zzio)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzip) == Float.floatToIntBits(zzf.zzip) && this.zziq == zzf.zziq && zzrv.equals((Object[]) this.zzir, (Object[]) zzf.zzir) && this.zzis == zzf.zzis) {
                return zza(zzf);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzin == null ? 0 : this.zzin.hashCode()) + (((this.zzim == null ? 0 : this.zzim.hashCode()) + (((this.zzil == null ? 0 : this.zzil.hashCode()) + ((((((((((((((((zzrv.hashCode((Object[]) this.zzid) + 527) * 31) + zzrv.hashCode((Object[]) this.zzie)) * 31) + zzrv.hashCode((Object[]) this.zzif)) * 31) + zzrv.hashCode((Object[]) this.zzig)) * 31) + zzrv.hashCode((Object[]) this.zzih)) * 31) + zzrv.hashCode((Object[]) this.zzii)) * 31) + zzrv.hashCode((Object[]) this.zzij)) * 31) + zzrv.hashCode((Object[]) this.zzik)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzio != null) {
                i = this.zzio.hashCode();
            }
            return (((((((this.zziq ? 1231 : 1237) + ((((hashCode + i) * 31) + Float.floatToIntBits(this.zzip)) * 31)) * 31) + zzrv.hashCode((Object[]) this.zzir)) * 31) + this.zzis) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zzie == null || this.zzie.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.zzie) {
                    if (str != null) {
                        i3++;
                        i2 += zzrq.zzfy(str);
                    }
                }
                i = zzB + i2 + (i3 * 1);
            }
            if (this.zzif != null && this.zzif.length > 0) {
                int i4 = i;
                for (com.google.android.gms.internal.zzag.zza zza : this.zzif) {
                    if (zza != null) {
                        i4 += zzrq.zzc(2, (zzrx) zza);
                    }
                }
                i = i4;
            }
            if (this.zzig != null && this.zzig.length > 0) {
                int i5 = i;
                for (zze zze : this.zzig) {
                    if (zze != null) {
                        i5 += zzrq.zzc(3, (zzrx) zze);
                    }
                }
                i = i5;
            }
            if (this.zzih != null && this.zzih.length > 0) {
                int i6 = i;
                for (zzb zzb : this.zzih) {
                    if (zzb != null) {
                        i6 += zzrq.zzc(4, (zzrx) zzb);
                    }
                }
                i = i6;
            }
            if (this.zzii != null && this.zzii.length > 0) {
                int i7 = i;
                for (zzb zzb2 : this.zzii) {
                    if (zzb2 != null) {
                        i7 += zzrq.zzc(5, (zzrx) zzb2);
                    }
                }
                i = i7;
            }
            if (this.zzij != null && this.zzij.length > 0) {
                int i8 = i;
                for (zzb zzb3 : this.zzij) {
                    if (zzb3 != null) {
                        i8 += zzrq.zzc(6, (zzrx) zzb3);
                    }
                }
                i = i8;
            }
            if (this.zzik != null && this.zzik.length > 0) {
                int i9 = i;
                for (zzg zzg : this.zzik) {
                    if (zzg != null) {
                        i9 += zzrq.zzc(7, (zzrx) zzg);
                    }
                }
                i = i9;
            }
            if (!this.zzil.equals("")) {
                i += zzrq.zzl(9, this.zzil);
            }
            if (!this.zzim.equals("")) {
                i += zzrq.zzl(10, this.zzim);
            }
            if (!this.zzin.equals("0")) {
                i += zzrq.zzl(12, this.zzin);
            }
            if (!this.version.equals("")) {
                i += zzrq.zzl(13, this.version);
            }
            if (this.zzio != null) {
                i += zzrq.zzc(14, (zzrx) this.zzio);
            }
            if (Float.floatToIntBits(this.zzip) != Float.floatToIntBits(0.0f)) {
                i += zzrq.zzc(15, this.zzip);
            }
            if (this.zzir != null && this.zzir.length > 0) {
                int i10 = 0;
                int i11 = 0;
                for (String str2 : this.zzir) {
                    if (str2 != null) {
                        i11++;
                        i10 += zzrq.zzfy(str2);
                    }
                }
                i = i + i10 + (i11 * 2);
            }
            if (this.zzis != 0) {
                i += zzrq.zzB(17, this.zzis);
            }
            if (this.zziq) {
                i += zzrq.zzc(18, this.zziq);
            }
            if (this.zzid == null || this.zzid.length <= 0) {
                return i;
            }
            int i12 = 0;
            int i13 = 0;
            for (String str3 : this.zzid) {
                if (str3 != null) {
                    i13++;
                    i12 += zzrq.zzfy(str3);
                }
            }
            return i + i12 + (i13 * 2);
        }

        public zzf zzJ() {
            this.zzid = zzsa.zzbcs;
            this.zzie = zzsa.zzbcs;
            this.zzif = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zzig = zze.zzH();
            this.zzih = zzb.zzC();
            this.zzii = zzb.zzC();
            this.zzij = zzb.zzC();
            this.zzik = zzg.zzK();
            this.zzil = "";
            this.zzim = "";
            this.zzin = "0";
            this.version = "";
            this.zzio = null;
            this.zzip = 0.0f;
            this.zziq = false;
            this.zzir = zzsa.zzbcs;
            this.zzis = 0;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (this.zzie != null && this.zzie.length > 0) {
                for (String str : this.zzie) {
                    if (str != null) {
                        zzrq.zzb(1, str);
                    }
                }
            }
            if (this.zzif != null && this.zzif.length > 0) {
                for (com.google.android.gms.internal.zzag.zza zza : this.zzif) {
                    if (zza != null) {
                        zzrq.zza(2, (zzrx) zza);
                    }
                }
            }
            if (this.zzig != null && this.zzig.length > 0) {
                for (zze zze : this.zzig) {
                    if (zze != null) {
                        zzrq.zza(3, (zzrx) zze);
                    }
                }
            }
            if (this.zzih != null && this.zzih.length > 0) {
                for (zzb zzb : this.zzih) {
                    if (zzb != null) {
                        zzrq.zza(4, (zzrx) zzb);
                    }
                }
            }
            if (this.zzii != null && this.zzii.length > 0) {
                for (zzb zzb2 : this.zzii) {
                    if (zzb2 != null) {
                        zzrq.zza(5, (zzrx) zzb2);
                    }
                }
            }
            if (this.zzij != null && this.zzij.length > 0) {
                for (zzb zzb3 : this.zzij) {
                    if (zzb3 != null) {
                        zzrq.zza(6, (zzrx) zzb3);
                    }
                }
            }
            if (this.zzik != null && this.zzik.length > 0) {
                for (zzg zzg : this.zzik) {
                    if (zzg != null) {
                        zzrq.zza(7, (zzrx) zzg);
                    }
                }
            }
            if (!this.zzil.equals("")) {
                zzrq.zzb(9, this.zzil);
            }
            if (!this.zzim.equals("")) {
                zzrq.zzb(10, this.zzim);
            }
            if (!this.zzin.equals("0")) {
                zzrq.zzb(12, this.zzin);
            }
            if (!this.version.equals("")) {
                zzrq.zzb(13, this.version);
            }
            if (this.zzio != null) {
                zzrq.zza(14, (zzrx) this.zzio);
            }
            if (Float.floatToIntBits(this.zzip) != Float.floatToIntBits(0.0f)) {
                zzrq.zzb(15, this.zzip);
            }
            if (this.zzir != null && this.zzir.length > 0) {
                for (String str2 : this.zzir) {
                    if (str2 != null) {
                        zzrq.zzb(16, str2);
                    }
                }
            }
            if (this.zzis != 0) {
                zzrq.zzz(17, this.zzis);
            }
            if (this.zziq) {
                zzrq.zzb(18, this.zziq);
            }
            if (this.zzid != null && this.zzid.length > 0) {
                for (String str3 : this.zzid) {
                    if (str3 != null) {
                        zzrq.zzb(19, str3);
                    }
                }
            }
            super.zza(zzrq);
        }

        /* renamed from: zzg */
        public zzf zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        int zzb = zzsa.zzb(zzrp, 10);
                        int length = this.zzie == null ? 0 : this.zzie.length;
                        String[] strArr = new String[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzie, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzrp.readString();
                            zzrp.zzCT();
                            length++;
                        }
                        strArr[length] = zzrp.readString();
                        this.zzie = strArr;
                        continue;
                    case 18:
                        int zzb2 = zzsa.zzb(zzrp, 18);
                        int length2 = this.zzif == null ? 0 : this.zzif.length;
                        com.google.android.gms.internal.zzag.zza[] zzaArr = new com.google.android.gms.internal.zzag.zza[(zzb2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzif, 0, zzaArr, 0, length2);
                        }
                        while (length2 < zzaArr.length - 1) {
                            zzaArr[length2] = new com.google.android.gms.internal.zzag.zza();
                            zzrp.zza(zzaArr[length2]);
                            zzrp.zzCT();
                            length2++;
                        }
                        zzaArr[length2] = new com.google.android.gms.internal.zzag.zza();
                        zzrp.zza(zzaArr[length2]);
                        this.zzif = zzaArr;
                        continue;
                    case 26:
                        int zzb3 = zzsa.zzb(zzrp, 26);
                        int length3 = this.zzig == null ? 0 : this.zzig.length;
                        zze[] zzeArr = new zze[(zzb3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzig, 0, zzeArr, 0, length3);
                        }
                        while (length3 < zzeArr.length - 1) {
                            zzeArr[length3] = new zze();
                            zzrp.zza(zzeArr[length3]);
                            zzrp.zzCT();
                            length3++;
                        }
                        zzeArr[length3] = new zze();
                        zzrp.zza(zzeArr[length3]);
                        this.zzig = zzeArr;
                        continue;
                    case 34:
                        int zzb4 = zzsa.zzb(zzrp, 34);
                        int length4 = this.zzih == null ? 0 : this.zzih.length;
                        zzb[] zzbArr = new zzb[(zzb4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzih, 0, zzbArr, 0, length4);
                        }
                        while (length4 < zzbArr.length - 1) {
                            zzbArr[length4] = new zzb();
                            zzrp.zza(zzbArr[length4]);
                            zzrp.zzCT();
                            length4++;
                        }
                        zzbArr[length4] = new zzb();
                        zzrp.zza(zzbArr[length4]);
                        this.zzih = zzbArr;
                        continue;
                    case 42:
                        int zzb5 = zzsa.zzb(zzrp, 42);
                        int length5 = this.zzii == null ? 0 : this.zzii.length;
                        zzb[] zzbArr2 = new zzb[(zzb5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzii, 0, zzbArr2, 0, length5);
                        }
                        while (length5 < zzbArr2.length - 1) {
                            zzbArr2[length5] = new zzb();
                            zzrp.zza(zzbArr2[length5]);
                            zzrp.zzCT();
                            length5++;
                        }
                        zzbArr2[length5] = new zzb();
                        zzrp.zza(zzbArr2[length5]);
                        this.zzii = zzbArr2;
                        continue;
                    case 50:
                        int zzb6 = zzsa.zzb(zzrp, 50);
                        int length6 = this.zzij == null ? 0 : this.zzij.length;
                        zzb[] zzbArr3 = new zzb[(zzb6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzij, 0, zzbArr3, 0, length6);
                        }
                        while (length6 < zzbArr3.length - 1) {
                            zzbArr3[length6] = new zzb();
                            zzrp.zza(zzbArr3[length6]);
                            zzrp.zzCT();
                            length6++;
                        }
                        zzbArr3[length6] = new zzb();
                        zzrp.zza(zzbArr3[length6]);
                        this.zzij = zzbArr3;
                        continue;
                    case 58:
                        int zzb7 = zzsa.zzb(zzrp, 58);
                        int length7 = this.zzik == null ? 0 : this.zzik.length;
                        zzg[] zzgArr = new zzg[(zzb7 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzik, 0, zzgArr, 0, length7);
                        }
                        while (length7 < zzgArr.length - 1) {
                            zzgArr[length7] = new zzg();
                            zzrp.zza(zzgArr[length7]);
                            zzrp.zzCT();
                            length7++;
                        }
                        zzgArr[length7] = new zzg();
                        zzrp.zza(zzgArr[length7]);
                        this.zzik = zzgArr;
                        continue;
                    case 74:
                        this.zzil = zzrp.readString();
                        continue;
                    case 82:
                        this.zzim = zzrp.readString();
                        continue;
                    case 98:
                        this.zzin = zzrp.readString();
                        continue;
                    case 106:
                        this.version = zzrp.readString();
                        continue;
                    case 114:
                        if (this.zzio == null) {
                            this.zzio = new zza();
                        }
                        zzrp.zza(this.zzio);
                        continue;
                    case 125:
                        this.zzip = zzrp.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        int zzb8 = zzsa.zzb(zzrp, TransportMediator.KEYCODE_MEDIA_RECORD);
                        int length8 = this.zzir == null ? 0 : this.zzir.length;
                        String[] strArr2 = new String[(zzb8 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzir, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = zzrp.readString();
                            zzrp.zzCT();
                            length8++;
                        }
                        strArr2[length8] = zzrp.readString();
                        this.zzir = strArr2;
                        continue;
                    case 136:
                        this.zzis = zzrp.zzCW();
                        continue;
                    case 144:
                        this.zziq = zzrp.zzCX();
                        continue;
                    case 154:
                        int zzb9 = zzsa.zzb(zzrp, 154);
                        int length9 = this.zzid == null ? 0 : this.zzid.length;
                        String[] strArr3 = new String[(zzb9 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zzid, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = zzrp.readString();
                            zzrp.zzCT();
                            length9++;
                        }
                        strArr3[length9] = zzrp.readString();
                        this.zzid = strArr3;
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

    public static final class zzg extends zzrr<zzg> {
        private static volatile zzg[] zzit;
        public int[] zziA;
        public int[] zziB;
        public int[] zziC;
        public int[] zziD;
        public int[] zziu;
        public int[] zziv;
        public int[] zziw;
        public int[] zzix;
        public int[] zziy;
        public int[] zziz;

        public zzg() {
            zzL();
        }

        public static zzg[] zzK() {
            if (zzit == null) {
                synchronized (zzrv.zzbck) {
                    if (zzit == null) {
                        zzit = new zzg[0];
                    }
                }
            }
            return zzit;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) o;
            if (!zzrv.equals(this.zziu, zzg.zziu) || !zzrv.equals(this.zziv, zzg.zziv) || !zzrv.equals(this.zziw, zzg.zziw) || !zzrv.equals(this.zzix, zzg.zzix) || !zzrv.equals(this.zziy, zzg.zziy) || !zzrv.equals(this.zziz, zzg.zziz) || !zzrv.equals(this.zziA, zzg.zziA) || !zzrv.equals(this.zziB, zzg.zziB) || !zzrv.equals(this.zziC, zzg.zziC) || !zzrv.equals(this.zziD, zzg.zziD)) {
                return false;
            }
            return zza(zzg);
        }

        public int hashCode() {
            return ((((((((((((((((((((zzrv.hashCode(this.zziu) + 527) * 31) + zzrv.hashCode(this.zziv)) * 31) + zzrv.hashCode(this.zziw)) * 31) + zzrv.hashCode(this.zzix)) * 31) + zzrv.hashCode(this.zziy)) * 31) + zzrv.hashCode(this.zziz)) * 31) + zzrv.hashCode(this.zziA)) * 31) + zzrv.hashCode(this.zziB)) * 31) + zzrv.hashCode(this.zziC)) * 31) + zzrv.hashCode(this.zziD)) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zziu == null || this.zziu.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                for (int zzls : this.zziu) {
                    i2 += zzrq.zzls(zzls);
                }
                i = zzB + i2 + (this.zziu.length * 1);
            }
            if (this.zziv != null && this.zziv.length > 0) {
                int i3 = 0;
                for (int zzls2 : this.zziv) {
                    i3 += zzrq.zzls(zzls2);
                }
                i = i + i3 + (this.zziv.length * 1);
            }
            if (this.zziw != null && this.zziw.length > 0) {
                int i4 = 0;
                for (int zzls3 : this.zziw) {
                    i4 += zzrq.zzls(zzls3);
                }
                i = i + i4 + (this.zziw.length * 1);
            }
            if (this.zzix != null && this.zzix.length > 0) {
                int i5 = 0;
                for (int zzls4 : this.zzix) {
                    i5 += zzrq.zzls(zzls4);
                }
                i = i + i5 + (this.zzix.length * 1);
            }
            if (this.zziy != null && this.zziy.length > 0) {
                int i6 = 0;
                for (int zzls5 : this.zziy) {
                    i6 += zzrq.zzls(zzls5);
                }
                i = i + i6 + (this.zziy.length * 1);
            }
            if (this.zziz != null && this.zziz.length > 0) {
                int i7 = 0;
                for (int zzls6 : this.zziz) {
                    i7 += zzrq.zzls(zzls6);
                }
                i = i + i7 + (this.zziz.length * 1);
            }
            if (this.zziA != null && this.zziA.length > 0) {
                int i8 = 0;
                for (int zzls7 : this.zziA) {
                    i8 += zzrq.zzls(zzls7);
                }
                i = i + i8 + (this.zziA.length * 1);
            }
            if (this.zziB != null && this.zziB.length > 0) {
                int i9 = 0;
                for (int zzls8 : this.zziB) {
                    i9 += zzrq.zzls(zzls8);
                }
                i = i + i9 + (this.zziB.length * 1);
            }
            if (this.zziC != null && this.zziC.length > 0) {
                int i10 = 0;
                for (int zzls9 : this.zziC) {
                    i10 += zzrq.zzls(zzls9);
                }
                i = i + i10 + (this.zziC.length * 1);
            }
            if (this.zziD == null || this.zziD.length <= 0) {
                return i;
            }
            int i11 = 0;
            for (int zzls10 : this.zziD) {
                i11 += zzrq.zzls(zzls10);
            }
            return i + i11 + (this.zziD.length * 1);
        }

        public zzg zzL() {
            this.zziu = zzsa.zzbcn;
            this.zziv = zzsa.zzbcn;
            this.zziw = zzsa.zzbcn;
            this.zzix = zzsa.zzbcn;
            this.zziy = zzsa.zzbcn;
            this.zziz = zzsa.zzbcn;
            this.zziA = zzsa.zzbcn;
            this.zziB = zzsa.zzbcn;
            this.zziC = zzsa.zzbcn;
            this.zziD = zzsa.zzbcn;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (this.zziu != null && this.zziu.length > 0) {
                for (int zzz : this.zziu) {
                    zzrq.zzz(1, zzz);
                }
            }
            if (this.zziv != null && this.zziv.length > 0) {
                for (int zzz2 : this.zziv) {
                    zzrq.zzz(2, zzz2);
                }
            }
            if (this.zziw != null && this.zziw.length > 0) {
                for (int zzz3 : this.zziw) {
                    zzrq.zzz(3, zzz3);
                }
            }
            if (this.zzix != null && this.zzix.length > 0) {
                for (int zzz4 : this.zzix) {
                    zzrq.zzz(4, zzz4);
                }
            }
            if (this.zziy != null && this.zziy.length > 0) {
                for (int zzz5 : this.zziy) {
                    zzrq.zzz(5, zzz5);
                }
            }
            if (this.zziz != null && this.zziz.length > 0) {
                for (int zzz6 : this.zziz) {
                    zzrq.zzz(6, zzz6);
                }
            }
            if (this.zziA != null && this.zziA.length > 0) {
                for (int zzz7 : this.zziA) {
                    zzrq.zzz(7, zzz7);
                }
            }
            if (this.zziB != null && this.zziB.length > 0) {
                for (int zzz8 : this.zziB) {
                    zzrq.zzz(8, zzz8);
                }
            }
            if (this.zziC != null && this.zziC.length > 0) {
                for (int zzz9 : this.zziC) {
                    zzrq.zzz(9, zzz9);
                }
            }
            if (this.zziD != null && this.zziD.length > 0) {
                for (int zzz10 : this.zziD) {
                    zzrq.zzz(10, zzz10);
                }
            }
            super.zza(zzrq);
        }

        /* renamed from: zzh */
        public zzg zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 8:
                        int zzb = zzsa.zzb(zzrp, 8);
                        int length = this.zziu == null ? 0 : this.zziu.length;
                        int[] iArr = new int[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziu, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzrp.zzCW();
                            zzrp.zzCT();
                            length++;
                        }
                        iArr[length] = zzrp.zzCW();
                        this.zziu = iArr;
                        continue;
                    case 10:
                        int zzll = zzrp.zzll(zzrp.zzDa());
                        int position = zzrp.getPosition();
                        int i = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i++;
                        }
                        zzrp.zzln(position);
                        int length2 = this.zziu == null ? 0 : this.zziu.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziu, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzrp.zzCW();
                            length2++;
                        }
                        this.zziu = iArr2;
                        zzrp.zzlm(zzll);
                        continue;
                    case 16:
                        int zzb2 = zzsa.zzb(zzrp, 16);
                        int length3 = this.zziv == null ? 0 : this.zziv.length;
                        int[] iArr3 = new int[(zzb2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziv, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzrp.zzCW();
                            zzrp.zzCT();
                            length3++;
                        }
                        iArr3[length3] = zzrp.zzCW();
                        this.zziv = iArr3;
                        continue;
                    case 18:
                        int zzll2 = zzrp.zzll(zzrp.zzDa());
                        int position2 = zzrp.getPosition();
                        int i2 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i2++;
                        }
                        zzrp.zzln(position2);
                        int length4 = this.zziv == null ? 0 : this.zziv.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zziv, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzrp.zzCW();
                            length4++;
                        }
                        this.zziv = iArr4;
                        zzrp.zzlm(zzll2);
                        continue;
                    case 24:
                        int zzb3 = zzsa.zzb(zzrp, 24);
                        int length5 = this.zziw == null ? 0 : this.zziw.length;
                        int[] iArr5 = new int[(zzb3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zziw, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzrp.zzCW();
                            zzrp.zzCT();
                            length5++;
                        }
                        iArr5[length5] = zzrp.zzCW();
                        this.zziw = iArr5;
                        continue;
                    case 26:
                        int zzll3 = zzrp.zzll(zzrp.zzDa());
                        int position3 = zzrp.getPosition();
                        int i3 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i3++;
                        }
                        zzrp.zzln(position3);
                        int length6 = this.zziw == null ? 0 : this.zziw.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zziw, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzrp.zzCW();
                            length6++;
                        }
                        this.zziw = iArr6;
                        zzrp.zzlm(zzll3);
                        continue;
                    case 32:
                        int zzb4 = zzsa.zzb(zzrp, 32);
                        int length7 = this.zzix == null ? 0 : this.zzix.length;
                        int[] iArr7 = new int[(zzb4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzix, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzrp.zzCW();
                            zzrp.zzCT();
                            length7++;
                        }
                        iArr7[length7] = zzrp.zzCW();
                        this.zzix = iArr7;
                        continue;
                    case 34:
                        int zzll4 = zzrp.zzll(zzrp.zzDa());
                        int position4 = zzrp.getPosition();
                        int i4 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i4++;
                        }
                        zzrp.zzln(position4);
                        int length8 = this.zzix == null ? 0 : this.zzix.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzix, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzrp.zzCW();
                            length8++;
                        }
                        this.zzix = iArr8;
                        zzrp.zzlm(zzll4);
                        continue;
                    case 40:
                        int zzb5 = zzsa.zzb(zzrp, 40);
                        int length9 = this.zziy == null ? 0 : this.zziy.length;
                        int[] iArr9 = new int[(zzb5 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zziy, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = zzrp.zzCW();
                            zzrp.zzCT();
                            length9++;
                        }
                        iArr9[length9] = zzrp.zzCW();
                        this.zziy = iArr9;
                        continue;
                    case 42:
                        int zzll5 = zzrp.zzll(zzrp.zzDa());
                        int position5 = zzrp.getPosition();
                        int i5 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i5++;
                        }
                        zzrp.zzln(position5);
                        int length10 = this.zziy == null ? 0 : this.zziy.length;
                        int[] iArr10 = new int[(i5 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.zziy, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = zzrp.zzCW();
                            length10++;
                        }
                        this.zziy = iArr10;
                        zzrp.zzlm(zzll5);
                        continue;
                    case 48:
                        int zzb6 = zzsa.zzb(zzrp, 48);
                        int length11 = this.zziz == null ? 0 : this.zziz.length;
                        int[] iArr11 = new int[(zzb6 + length11)];
                        if (length11 != 0) {
                            System.arraycopy(this.zziz, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = zzrp.zzCW();
                            zzrp.zzCT();
                            length11++;
                        }
                        iArr11[length11] = zzrp.zzCW();
                        this.zziz = iArr11;
                        continue;
                    case 50:
                        int zzll6 = zzrp.zzll(zzrp.zzDa());
                        int position6 = zzrp.getPosition();
                        int i6 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i6++;
                        }
                        zzrp.zzln(position6);
                        int length12 = this.zziz == null ? 0 : this.zziz.length;
                        int[] iArr12 = new int[(i6 + length12)];
                        if (length12 != 0) {
                            System.arraycopy(this.zziz, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = zzrp.zzCW();
                            length12++;
                        }
                        this.zziz = iArr12;
                        zzrp.zzlm(zzll6);
                        continue;
                    case 56:
                        int zzb7 = zzsa.zzb(zzrp, 56);
                        int length13 = this.zziA == null ? 0 : this.zziA.length;
                        int[] iArr13 = new int[(zzb7 + length13)];
                        if (length13 != 0) {
                            System.arraycopy(this.zziA, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = zzrp.zzCW();
                            zzrp.zzCT();
                            length13++;
                        }
                        iArr13[length13] = zzrp.zzCW();
                        this.zziA = iArr13;
                        continue;
                    case 58:
                        int zzll7 = zzrp.zzll(zzrp.zzDa());
                        int position7 = zzrp.getPosition();
                        int i7 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i7++;
                        }
                        zzrp.zzln(position7);
                        int length14 = this.zziA == null ? 0 : this.zziA.length;
                        int[] iArr14 = new int[(i7 + length14)];
                        if (length14 != 0) {
                            System.arraycopy(this.zziA, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = zzrp.zzCW();
                            length14++;
                        }
                        this.zziA = iArr14;
                        zzrp.zzlm(zzll7);
                        continue;
                    case 64:
                        int zzb8 = zzsa.zzb(zzrp, 64);
                        int length15 = this.zziB == null ? 0 : this.zziB.length;
                        int[] iArr15 = new int[(zzb8 + length15)];
                        if (length15 != 0) {
                            System.arraycopy(this.zziB, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = zzrp.zzCW();
                            zzrp.zzCT();
                            length15++;
                        }
                        iArr15[length15] = zzrp.zzCW();
                        this.zziB = iArr15;
                        continue;
                    case 66:
                        int zzll8 = zzrp.zzll(zzrp.zzDa());
                        int position8 = zzrp.getPosition();
                        int i8 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i8++;
                        }
                        zzrp.zzln(position8);
                        int length16 = this.zziB == null ? 0 : this.zziB.length;
                        int[] iArr16 = new int[(i8 + length16)];
                        if (length16 != 0) {
                            System.arraycopy(this.zziB, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = zzrp.zzCW();
                            length16++;
                        }
                        this.zziB = iArr16;
                        zzrp.zzlm(zzll8);
                        continue;
                    case 72:
                        int zzb9 = zzsa.zzb(zzrp, 72);
                        int length17 = this.zziC == null ? 0 : this.zziC.length;
                        int[] iArr17 = new int[(zzb9 + length17)];
                        if (length17 != 0) {
                            System.arraycopy(this.zziC, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = zzrp.zzCW();
                            zzrp.zzCT();
                            length17++;
                        }
                        iArr17[length17] = zzrp.zzCW();
                        this.zziC = iArr17;
                        continue;
                    case 74:
                        int zzll9 = zzrp.zzll(zzrp.zzDa());
                        int position9 = zzrp.getPosition();
                        int i9 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i9++;
                        }
                        zzrp.zzln(position9);
                        int length18 = this.zziC == null ? 0 : this.zziC.length;
                        int[] iArr18 = new int[(i9 + length18)];
                        if (length18 != 0) {
                            System.arraycopy(this.zziC, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = zzrp.zzCW();
                            length18++;
                        }
                        this.zziC = iArr18;
                        zzrp.zzlm(zzll9);
                        continue;
                    case 80:
                        int zzb10 = zzsa.zzb(zzrp, 80);
                        int length19 = this.zziD == null ? 0 : this.zziD.length;
                        int[] iArr19 = new int[(zzb10 + length19)];
                        if (length19 != 0) {
                            System.arraycopy(this.zziD, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = zzrp.zzCW();
                            zzrp.zzCT();
                            length19++;
                        }
                        iArr19[length19] = zzrp.zzCW();
                        this.zziD = iArr19;
                        continue;
                    case 82:
                        int zzll10 = zzrp.zzll(zzrp.zzDa());
                        int position10 = zzrp.getPosition();
                        int i10 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i10++;
                        }
                        zzrp.zzln(position10);
                        int length20 = this.zziD == null ? 0 : this.zziD.length;
                        int[] iArr20 = new int[(i10 + length20)];
                        if (length20 != 0) {
                            System.arraycopy(this.zziD, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = zzrp.zzCW();
                            length20++;
                        }
                        this.zziD = iArr20;
                        zzrp.zzlm(zzll10);
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

    public static final class zzh extends zzrr<zzh> {
        public static final zzrs<com.google.android.gms.internal.zzag.zza, zzh> zziE = zzrs.zza(11, zzh.class, 810);
        private static final zzh[] zziF = new zzh[0];
        public int[] zziG;
        public int[] zziH;
        public int[] zziI;
        public int zziJ;
        public int[] zziK;
        public int zziL;
        public int zziM;

        public zzh() {
            zzM();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzh)) {
                return false;
            }
            zzh zzh = (zzh) o;
            if (!zzrv.equals(this.zziG, zzh.zziG) || !zzrv.equals(this.zziH, zzh.zziH) || !zzrv.equals(this.zziI, zzh.zziI) || this.zziJ != zzh.zziJ || !zzrv.equals(this.zziK, zzh.zziK) || this.zziL != zzh.zziL || this.zziM != zzh.zziM) {
                return false;
            }
            return zza(zzh);
        }

        public int hashCode() {
            return ((((((((((((((zzrv.hashCode(this.zziG) + 527) * 31) + zzrv.hashCode(this.zziH)) * 31) + zzrv.hashCode(this.zziI)) * 31) + this.zziJ) * 31) + zzrv.hashCode(this.zziK)) * 31) + this.zziL) * 31) + this.zziM) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zziG == null || this.zziG.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                for (int zzls : this.zziG) {
                    i2 += zzrq.zzls(zzls);
                }
                i = zzB + i2 + (this.zziG.length * 1);
            }
            if (this.zziH != null && this.zziH.length > 0) {
                int i3 = 0;
                for (int zzls2 : this.zziH) {
                    i3 += zzrq.zzls(zzls2);
                }
                i = i + i3 + (this.zziH.length * 1);
            }
            if (this.zziI != null && this.zziI.length > 0) {
                int i4 = 0;
                for (int zzls3 : this.zziI) {
                    i4 += zzrq.zzls(zzls3);
                }
                i = i + i4 + (this.zziI.length * 1);
            }
            if (this.zziJ != 0) {
                i += zzrq.zzB(4, this.zziJ);
            }
            if (this.zziK != null && this.zziK.length > 0) {
                int i5 = 0;
                for (int zzls4 : this.zziK) {
                    i5 += zzrq.zzls(zzls4);
                }
                i = i + i5 + (this.zziK.length * 1);
            }
            if (this.zziL != 0) {
                i += zzrq.zzB(6, this.zziL);
            }
            return this.zziM != 0 ? i + zzrq.zzB(7, this.zziM) : i;
        }

        public zzh zzM() {
            this.zziG = zzsa.zzbcn;
            this.zziH = zzsa.zzbcn;
            this.zziI = zzsa.zzbcn;
            this.zziJ = 0;
            this.zziK = zzsa.zzbcn;
            this.zziL = 0;
            this.zziM = 0;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (this.zziG != null && this.zziG.length > 0) {
                for (int zzz : this.zziG) {
                    zzrq.zzz(1, zzz);
                }
            }
            if (this.zziH != null && this.zziH.length > 0) {
                for (int zzz2 : this.zziH) {
                    zzrq.zzz(2, zzz2);
                }
            }
            if (this.zziI != null && this.zziI.length > 0) {
                for (int zzz3 : this.zziI) {
                    zzrq.zzz(3, zzz3);
                }
            }
            if (this.zziJ != 0) {
                zzrq.zzz(4, this.zziJ);
            }
            if (this.zziK != null && this.zziK.length > 0) {
                for (int zzz4 : this.zziK) {
                    zzrq.zzz(5, zzz4);
                }
            }
            if (this.zziL != 0) {
                zzrq.zzz(6, this.zziL);
            }
            if (this.zziM != 0) {
                zzrq.zzz(7, this.zziM);
            }
            super.zza(zzrq);
        }

        /* renamed from: zzi */
        public zzh zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 8:
                        int zzb = zzsa.zzb(zzrp, 8);
                        int length = this.zziG == null ? 0 : this.zziG.length;
                        int[] iArr = new int[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziG, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzrp.zzCW();
                            zzrp.zzCT();
                            length++;
                        }
                        iArr[length] = zzrp.zzCW();
                        this.zziG = iArr;
                        continue;
                    case 10:
                        int zzll = zzrp.zzll(zzrp.zzDa());
                        int position = zzrp.getPosition();
                        int i = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i++;
                        }
                        zzrp.zzln(position);
                        int length2 = this.zziG == null ? 0 : this.zziG.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziG, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzrp.zzCW();
                            length2++;
                        }
                        this.zziG = iArr2;
                        zzrp.zzlm(zzll);
                        continue;
                    case 16:
                        int zzb2 = zzsa.zzb(zzrp, 16);
                        int length3 = this.zziH == null ? 0 : this.zziH.length;
                        int[] iArr3 = new int[(zzb2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziH, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzrp.zzCW();
                            zzrp.zzCT();
                            length3++;
                        }
                        iArr3[length3] = zzrp.zzCW();
                        this.zziH = iArr3;
                        continue;
                    case 18:
                        int zzll2 = zzrp.zzll(zzrp.zzDa());
                        int position2 = zzrp.getPosition();
                        int i2 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i2++;
                        }
                        zzrp.zzln(position2);
                        int length4 = this.zziH == null ? 0 : this.zziH.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zziH, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzrp.zzCW();
                            length4++;
                        }
                        this.zziH = iArr4;
                        zzrp.zzlm(zzll2);
                        continue;
                    case 24:
                        int zzb3 = zzsa.zzb(zzrp, 24);
                        int length5 = this.zziI == null ? 0 : this.zziI.length;
                        int[] iArr5 = new int[(zzb3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zziI, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzrp.zzCW();
                            zzrp.zzCT();
                            length5++;
                        }
                        iArr5[length5] = zzrp.zzCW();
                        this.zziI = iArr5;
                        continue;
                    case 26:
                        int zzll3 = zzrp.zzll(zzrp.zzDa());
                        int position3 = zzrp.getPosition();
                        int i3 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i3++;
                        }
                        zzrp.zzln(position3);
                        int length6 = this.zziI == null ? 0 : this.zziI.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zziI, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzrp.zzCW();
                            length6++;
                        }
                        this.zziI = iArr6;
                        zzrp.zzlm(zzll3);
                        continue;
                    case 32:
                        this.zziJ = zzrp.zzCW();
                        continue;
                    case 40:
                        int zzb4 = zzsa.zzb(zzrp, 40);
                        int length7 = this.zziK == null ? 0 : this.zziK.length;
                        int[] iArr7 = new int[(zzb4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zziK, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzrp.zzCW();
                            zzrp.zzCT();
                            length7++;
                        }
                        iArr7[length7] = zzrp.zzCW();
                        this.zziK = iArr7;
                        continue;
                    case 42:
                        int zzll4 = zzrp.zzll(zzrp.zzDa());
                        int position4 = zzrp.getPosition();
                        int i4 = 0;
                        while (zzrp.zzDf() > 0) {
                            zzrp.zzCW();
                            i4++;
                        }
                        zzrp.zzln(position4);
                        int length8 = this.zziK == null ? 0 : this.zziK.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zziK, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzrp.zzCW();
                            length8++;
                        }
                        this.zziK = iArr8;
                        zzrp.zzlm(zzll4);
                        continue;
                    case 48:
                        this.zziL = zzrp.zzCW();
                        continue;
                    case 56:
                        this.zziM = zzrp.zzCW();
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

    public static final class zzi extends zzrr<zzi> {
        private static volatile zzi[] zziN;
        public String name;
        public com.google.android.gms.internal.zzag.zza zziO;
        public zzd zziP;

        public zzi() {
            zzO();
        }

        public static zzi[] zzN() {
            if (zziN == null) {
                synchronized (zzrv.zzbck) {
                    if (zziN == null) {
                        zziN = new zzi[0];
                    }
                }
            }
            return zziN;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzi)) {
                return false;
            }
            zzi zzi = (zzi) o;
            if (this.name == null) {
                if (zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzi.name)) {
                return false;
            }
            if (this.zziO == null) {
                if (zzi.zziO != null) {
                    return false;
                }
            } else if (!this.zziO.equals(zzi.zziO)) {
                return false;
            }
            if (this.zziP == null) {
                if (zzi.zziP != null) {
                    return false;
                }
            } else if (!this.zziP.equals(zzi.zziP)) {
                return false;
            }
            return zza(zzi);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zziO == null ? 0 : this.zziO.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.zziP != null) {
                i = this.zziP.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals("")) {
                zzB += zzrq.zzl(1, this.name);
            }
            if (this.zziO != null) {
                zzB += zzrq.zzc(2, (zzrx) this.zziO);
            }
            return this.zziP != null ? zzB + zzrq.zzc(3, (zzrx) this.zziP) : zzB;
        }

        public zzi zzO() {
            this.name = "";
            this.zziO = null;
            this.zziP = null;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (!this.name.equals("")) {
                zzrq.zzb(1, this.name);
            }
            if (this.zziO != null) {
                zzrq.zza(2, (zzrx) this.zziO);
            }
            if (this.zziP != null) {
                zzrq.zza(3, (zzrx) this.zziP);
            }
            super.zza(zzrq);
        }

        /* renamed from: zzj */
        public zzi zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrp.readString();
                        continue;
                    case 18:
                        if (this.zziO == null) {
                            this.zziO = new com.google.android.gms.internal.zzag.zza();
                        }
                        zzrp.zza(this.zziO);
                        continue;
                    case 26:
                        if (this.zziP == null) {
                            this.zziP = new zzd();
                        }
                        zzrp.zza(this.zziP);
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

    public static final class zzj extends zzrr<zzj> {
        public zzi[] zziQ;
        public zzf zziR;
        public String zziS;

        public zzj() {
            zzP();
        }

        public static zzj zzd(byte[] bArr) throws zzrw {
            return (zzj) zzrx.zza(new zzj(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzj)) {
                return false;
            }
            zzj zzj = (zzj) o;
            if (!zzrv.equals((Object[]) this.zziQ, (Object[]) zzj.zziQ)) {
                return false;
            }
            if (this.zziR == null) {
                if (zzj.zziR != null) {
                    return false;
                }
            } else if (!this.zziR.equals(zzj.zziR)) {
                return false;
            }
            if (this.zziS == null) {
                if (zzj.zziS != null) {
                    return false;
                }
            } else if (!this.zziS.equals(zzj.zziS)) {
                return false;
            }
            return zza(zzj);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zziR == null ? 0 : this.zziR.hashCode()) + ((zzrv.hashCode((Object[]) this.zziQ) + 527) * 31)) * 31;
            if (this.zziS != null) {
                i = this.zziS.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.zziQ != null && this.zziQ.length > 0) {
                for (zzi zzi : this.zziQ) {
                    if (zzi != null) {
                        zzB += zzrq.zzc(1, (zzrx) zzi);
                    }
                }
            }
            if (this.zziR != null) {
                zzB += zzrq.zzc(2, (zzrx) this.zziR);
            }
            return !this.zziS.equals("") ? zzB + zzrq.zzl(3, this.zziS) : zzB;
        }

        public zzj zzP() {
            this.zziQ = zzi.zzN();
            this.zziR = null;
            this.zziS = "";
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq zzrq) throws IOException {
            if (this.zziQ != null && this.zziQ.length > 0) {
                for (zzi zzi : this.zziQ) {
                    if (zzi != null) {
                        zzrq.zza(1, (zzrx) zzi);
                    }
                }
            }
            if (this.zziR != null) {
                zzrq.zza(2, (zzrx) this.zziR);
            }
            if (!this.zziS.equals("")) {
                zzrq.zzb(3, this.zziS);
            }
            super.zza(zzrq);
        }

        /* renamed from: zzk */
        public zzj zzb(zzrp zzrp) throws IOException {
            while (true) {
                int zzCT = zzrp.zzCT();
                switch (zzCT) {
                    case 0:
                        break;
                    case 10:
                        int zzb = zzsa.zzb(zzrp, 10);
                        int length = this.zziQ == null ? 0 : this.zziQ.length;
                        zzi[] zziArr = new zzi[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziQ, 0, zziArr, 0, length);
                        }
                        while (length < zziArr.length - 1) {
                            zziArr[length] = new zzi();
                            zzrp.zza(zziArr[length]);
                            zzrp.zzCT();
                            length++;
                        }
                        zziArr[length] = new zzi();
                        zzrp.zza(zziArr[length]);
                        this.zziQ = zziArr;
                        continue;
                    case 18:
                        if (this.zziR == null) {
                            this.zziR = new zzf();
                        }
                        zzrp.zza(this.zziR);
                        continue;
                    case 26:
                        this.zziS = zzrp.readString();
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
