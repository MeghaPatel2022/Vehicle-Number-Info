package com.google.android.gms.internal;

class zzrt implements Cloneable {
    private static final zzru zzbcd = new zzru();
    private int mSize;
    private boolean zzbce;
    private int[] zzbcf;
    private zzru[] zzbcg;

    public zzrt() {
        this(10);
    }

    public zzrt(int i) {
        this.zzbce = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzbcf = new int[idealIntArraySize];
        this.zzbcg = new zzru[idealIntArraySize];
        this.mSize = 0;
    }

    /* renamed from: gc */
    private void m27gc() {
        int i = this.mSize;
        int[] iArr = this.zzbcf;
        zzru[] zzruArr = this.zzbcg;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzru zzru = zzruArr[i3];
            if (zzru != zzbcd) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzruArr[i2] = zzru;
                    zzruArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzbce = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzru[] zzruArr, zzru[] zzruArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzruArr[i2].equals(zzruArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzlC(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzbcf[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrt)) {
            return false;
        }
        zzrt zzrt = (zzrt) o;
        if (size() != zzrt.size()) {
            return false;
        }
        return zza(this.zzbcf, zzrt.zzbcf, this.mSize) && zza(this.zzbcg, zzrt.zzbcg, this.mSize);
    }

    public int hashCode() {
        if (this.zzbce) {
            m27gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzbcf[i2]) * 31) + this.zzbcg[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        if (this.zzbce) {
            m27gc();
        }
        return this.mSize;
    }

    /* renamed from: zzDn */
    public final zzrt clone() {
        int size = size();
        zzrt zzrt = new zzrt(size);
        System.arraycopy(this.zzbcf, 0, zzrt.zzbcf, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.zzbcg[i] != null) {
                zzrt.zzbcg[i] = this.zzbcg[i].clone();
            }
        }
        zzrt.mSize = size;
        return zzrt;
    }

    public void zza(int i, zzru zzru) {
        int zzlC = zzlC(i);
        if (zzlC >= 0) {
            this.zzbcg[zzlC] = zzru;
            return;
        }
        int i2 = zzlC ^ -1;
        if (i2 >= this.mSize || this.zzbcg[i2] != zzbcd) {
            if (this.zzbce && this.mSize >= this.zzbcf.length) {
                m27gc();
                i2 = zzlC(i) ^ -1;
            }
            if (this.mSize >= this.zzbcf.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzru[] zzruArr = new zzru[idealIntArraySize];
                System.arraycopy(this.zzbcf, 0, iArr, 0, this.zzbcf.length);
                System.arraycopy(this.zzbcg, 0, zzruArr, 0, this.zzbcg.length);
                this.zzbcf = iArr;
                this.zzbcg = zzruArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.zzbcf, i2, this.zzbcf, i2 + 1, this.mSize - i2);
                System.arraycopy(this.zzbcg, i2, this.zzbcg, i2 + 1, this.mSize - i2);
            }
            this.zzbcf[i2] = i;
            this.zzbcg[i2] = zzru;
            this.mSize++;
            return;
        }
        this.zzbcf[i2] = i;
        this.zzbcg[i2] = zzru;
    }

    public zzru zzlA(int i) {
        int zzlC = zzlC(i);
        if (zzlC < 0 || this.zzbcg[zzlC] == zzbcd) {
            return null;
        }
        return this.zzbcg[zzlC];
    }

    public zzru zzlB(int i) {
        if (this.zzbce) {
            m27gc();
        }
        return this.zzbcg[i];
    }
}
