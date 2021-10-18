package com.google.android.gms.internal;

import java.io.IOException;

public final class zzrn extends zzrr<zzrn> {
    public String[] zzbbK;
    public int[] zzbbL;
    public byte[][] zzbbM;

    public zzrn() {
        zzCS();
    }

    public static zzrn zzx(byte[] bArr) throws zzrw {
        return (zzrn) zzrx.zza(new zzrn(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrn)) {
            return false;
        }
        zzrn zzrn = (zzrn) o;
        if (!zzrv.equals((Object[]) this.zzbbK, (Object[]) zzrn.zzbbK) || !zzrv.equals(this.zzbbL, zzrn.zzbbL) || !zzrv.zza(this.zzbbM, zzrn.zzbbM)) {
            return false;
        }
        return zza(zzrn);
    }

    public int hashCode() {
        return ((((((zzrv.hashCode((Object[]) this.zzbbK) + 527) * 31) + zzrv.hashCode(this.zzbbL)) * 31) + zzrv.zza(this.zzbbM)) * 31) + zzDk();
    }

    /* access modifiers changed from: protected */
    public int zzB() {
        int i;
        int zzB = super.zzB();
        if (this.zzbbK == null || this.zzbbK.length <= 0) {
            i = zzB;
        } else {
            int i2 = 0;
            int i3 = 0;
            for (String str : this.zzbbK) {
                if (str != null) {
                    i3++;
                    i2 += zzrq.zzfy(str);
                }
            }
            i = zzB + i2 + (i3 * 1);
        }
        if (this.zzbbL != null && this.zzbbL.length > 0) {
            int i4 = 0;
            for (int zzls : this.zzbbL) {
                i4 += zzrq.zzls(zzls);
            }
            i = i + i4 + (this.zzbbL.length * 1);
        }
        if (this.zzbbM == null || this.zzbbM.length <= 0) {
            return i;
        }
        int i5 = 0;
        int i6 = 0;
        for (byte[] bArr : this.zzbbM) {
            if (bArr != null) {
                i6++;
                i5 += zzrq.zzC(bArr);
            }
        }
        return i + i5 + (i6 * 1);
    }

    public zzrn zzCS() {
        this.zzbbK = zzsa.zzbcs;
        this.zzbbL = zzsa.zzbcn;
        this.zzbbM = zzsa.zzbct;
        this.zzbca = null;
        this.zzbcl = -1;
        return this;
    }

    public void zza(zzrq zzrq) throws IOException {
        if (this.zzbbK != null && this.zzbbK.length > 0) {
            for (String str : this.zzbbK) {
                if (str != null) {
                    zzrq.zzb(1, str);
                }
            }
        }
        if (this.zzbbL != null && this.zzbbL.length > 0) {
            for (int zzz : this.zzbbL) {
                zzrq.zzz(2, zzz);
            }
        }
        if (this.zzbbM != null && this.zzbbM.length > 0) {
            for (byte[] bArr : this.zzbbM) {
                if (bArr != null) {
                    zzrq.zza(3, bArr);
                }
            }
        }
        super.zza(zzrq);
    }

    /* renamed from: zzz */
    public zzrn zzb(zzrp zzrp) throws IOException {
        while (true) {
            int zzCT = zzrp.zzCT();
            switch (zzCT) {
                case 0:
                    break;
                case 10:
                    int zzb = zzsa.zzb(zzrp, 10);
                    int length = this.zzbbK == null ? 0 : this.zzbbK.length;
                    String[] strArr = new String[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbbK, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzrp.readString();
                        zzrp.zzCT();
                        length++;
                    }
                    strArr[length] = zzrp.readString();
                    this.zzbbK = strArr;
                    continue;
                case 16:
                    int zzb2 = zzsa.zzb(zzrp, 16);
                    int length2 = this.zzbbL == null ? 0 : this.zzbbL.length;
                    int[] iArr = new int[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzbbL, 0, iArr, 0, length2);
                    }
                    while (length2 < iArr.length - 1) {
                        iArr[length2] = zzrp.zzCW();
                        zzrp.zzCT();
                        length2++;
                    }
                    iArr[length2] = zzrp.zzCW();
                    this.zzbbL = iArr;
                    continue;
                case 18:
                    int zzll = zzrp.zzll(zzrp.zzDa());
                    int position = zzrp.getPosition();
                    int i = 0;
                    while (zzrp.zzDf() > 0) {
                        zzrp.zzCW();
                        i++;
                    }
                    zzrp.zzln(position);
                    int length3 = this.zzbbL == null ? 0 : this.zzbbL.length;
                    int[] iArr2 = new int[(i + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzbbL, 0, iArr2, 0, length3);
                    }
                    while (length3 < iArr2.length) {
                        iArr2[length3] = zzrp.zzCW();
                        length3++;
                    }
                    this.zzbbL = iArr2;
                    zzrp.zzlm(zzll);
                    continue;
                case 26:
                    int zzb3 = zzsa.zzb(zzrp, 26);
                    int length4 = this.zzbbM == null ? 0 : this.zzbbM.length;
                    byte[][] bArr = new byte[(zzb3 + length4)][];
                    if (length4 != 0) {
                        System.arraycopy(this.zzbbM, 0, bArr, 0, length4);
                    }
                    while (length4 < bArr.length - 1) {
                        bArr[length4] = zzrp.readBytes();
                        zzrp.zzCT();
                        length4++;
                    }
                    bArr[length4] = zzrp.readBytes();
                    this.zzbbM = bArr;
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
