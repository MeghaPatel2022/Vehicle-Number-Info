package com.google.android.gms.internal;

import java.io.IOException;

public final class zzrp {
    private final byte[] buffer;
    private int zzbbQ;
    private int zzbbR;
    private int zzbbS;
    private int zzbbT;
    private int zzbbU;
    private int zzbbV = Integer.MAX_VALUE;
    private int zzbbW;
    private int zzbbX = 64;
    private int zzbbY = 67108864;

    private zzrp(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbbQ = i;
        this.zzbbR = i + i2;
        this.zzbbT = i;
    }

    private void zzDe() {
        this.zzbbR += this.zzbbS;
        int i = this.zzbbR;
        if (i > this.zzbbV) {
            this.zzbbS = i - this.zzbbV;
            this.zzbbR -= this.zzbbS;
            return;
        }
        this.zzbbS = 0;
    }

    public static long zzV(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static zzrp zza(byte[] bArr, int i, int i2) {
        return new zzrp(bArr, i, i2);
    }

    public static int zzlk(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static zzrp zzz(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public int getPosition() {
        return this.zzbbT - this.zzbbQ;
    }

    public byte[] readBytes() throws IOException {
        int zzDa = zzDa();
        if (zzDa > this.zzbbR - this.zzbbT || zzDa <= 0) {
            return zzlo(zzDa);
        }
        byte[] bArr = new byte[zzDa];
        System.arraycopy(this.buffer, this.zzbbT, bArr, 0, zzDa);
        this.zzbbT = zzDa + this.zzbbT;
        return bArr;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzDd());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzDc());
    }

    public String readString() throws IOException {
        int zzDa = zzDa();
        if (zzDa > this.zzbbR - this.zzbbT || zzDa <= 0) {
            return new String(zzlo(zzDa), "UTF-8");
        }
        String str = new String(this.buffer, this.zzbbT, zzDa, "UTF-8");
        this.zzbbT = zzDa + this.zzbbT;
        return str;
    }

    public int zzCT() throws IOException {
        if (zzDg()) {
            this.zzbbU = 0;
            return 0;
        }
        this.zzbbU = zzDa();
        if (this.zzbbU != 0) {
            return this.zzbbU;
        }
        throw zzrw.zzDs();
    }

    public void zzCU() throws IOException {
        int zzCT;
        do {
            zzCT = zzCT();
            if (zzCT == 0) {
                return;
            }
        } while (zzlj(zzCT));
    }

    public long zzCV() throws IOException {
        return zzDb();
    }

    public int zzCW() throws IOException {
        return zzDa();
    }

    public boolean zzCX() throws IOException {
        return zzDa() != 0;
    }

    public int zzCY() throws IOException {
        return zzlk(zzDa());
    }

    public long zzCZ() throws IOException {
        return zzV(zzDb());
    }

    public int zzDa() throws IOException {
        byte zzDh = zzDh();
        if (zzDh >= 0) {
            return zzDh;
        }
        byte b = zzDh & Byte.MAX_VALUE;
        byte zzDh2 = zzDh();
        if (zzDh2 >= 0) {
            return b | (zzDh2 << 7);
        }
        byte b2 = b | ((zzDh2 & Byte.MAX_VALUE) << 7);
        byte zzDh3 = zzDh();
        if (zzDh3 >= 0) {
            return b2 | (zzDh3 << 14);
        }
        byte b3 = b2 | ((zzDh3 & Byte.MAX_VALUE) << 14);
        byte zzDh4 = zzDh();
        if (zzDh4 >= 0) {
            return b3 | (zzDh4 << 21);
        }
        byte b4 = b3 | ((zzDh4 & Byte.MAX_VALUE) << 21);
        byte zzDh5 = zzDh();
        byte b5 = b4 | (zzDh5 << 28);
        if (zzDh5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (zzDh() >= 0) {
                return b5;
            }
        }
        throw zzrw.zzDr();
    }

    public long zzDb() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzDh = zzDh();
            j |= ((long) (zzDh & Byte.MAX_VALUE)) << i;
            if ((zzDh & 128) == 0) {
                return j;
            }
        }
        throw zzrw.zzDr();
    }

    public int zzDc() throws IOException {
        return (zzDh() & 255) | ((zzDh() & 255) << 8) | ((zzDh() & 255) << 16) | ((zzDh() & 255) << 24);
    }

    public long zzDd() throws IOException {
        byte zzDh = zzDh();
        byte zzDh2 = zzDh();
        return ((((long) zzDh2) & 255) << 8) | (((long) zzDh) & 255) | ((((long) zzDh()) & 255) << 16) | ((((long) zzDh()) & 255) << 24) | ((((long) zzDh()) & 255) << 32) | ((((long) zzDh()) & 255) << 40) | ((((long) zzDh()) & 255) << 48) | ((((long) zzDh()) & 255) << 56);
    }

    public int zzDf() {
        if (this.zzbbV == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbbV - this.zzbbT;
    }

    public boolean zzDg() {
        return this.zzbbT == this.zzbbR;
    }

    public byte zzDh() throws IOException {
        if (this.zzbbT == this.zzbbR) {
            throw zzrw.zzDp();
        }
        byte[] bArr = this.buffer;
        int i = this.zzbbT;
        this.zzbbT = i + 1;
        return bArr[i];
    }

    public void zza(zzrx zzrx) throws IOException {
        int zzDa = zzDa();
        if (this.zzbbW >= this.zzbbX) {
            throw zzrw.zzDv();
        }
        int zzll = zzll(zzDa);
        this.zzbbW++;
        zzrx.zzb(this);
        zzli(0);
        this.zzbbW--;
        zzlm(zzll);
    }

    public void zza(zzrx zzrx, int i) throws IOException {
        if (this.zzbbW >= this.zzbbX) {
            throw zzrw.zzDv();
        }
        this.zzbbW++;
        zzrx.zzb(this);
        zzli(zzsa.zzE(i, 4));
        this.zzbbW--;
    }

    public void zzli(int i) throws zzrw {
        if (this.zzbbU != i) {
            throw zzrw.zzDt();
        }
    }

    public boolean zzlj(int i) throws IOException {
        switch (zzsa.zzlD(i)) {
            case 0:
                zzCW();
                return true;
            case 1:
                zzDd();
                return true;
            case 2:
                zzlp(zzDa());
                return true;
            case 3:
                zzCU();
                zzli(zzsa.zzE(zzsa.zzlE(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                zzDc();
                return true;
            default:
                throw zzrw.zzDu();
        }
    }

    public int zzll(int i) throws zzrw {
        if (i < 0) {
            throw zzrw.zzDq();
        }
        int i2 = this.zzbbT + i;
        int i3 = this.zzbbV;
        if (i2 > i3) {
            throw zzrw.zzDp();
        }
        this.zzbbV = i2;
        zzDe();
        return i3;
    }

    public void zzlm(int i) {
        this.zzbbV = i;
        zzDe();
    }

    public void zzln(int i) {
        if (i > this.zzbbT - this.zzbbQ) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzbbT - this.zzbbQ));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.zzbbT = this.zzbbQ + i;
        }
    }

    public byte[] zzlo(int i) throws IOException {
        if (i < 0) {
            throw zzrw.zzDq();
        } else if (this.zzbbT + i > this.zzbbV) {
            zzlp(this.zzbbV - this.zzbbT);
            throw zzrw.zzDp();
        } else if (i <= this.zzbbR - this.zzbbT) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.zzbbT, bArr, 0, i);
            this.zzbbT += i;
            return bArr;
        } else {
            throw zzrw.zzDp();
        }
    }

    public void zzlp(int i) throws IOException {
        if (i < 0) {
            throw zzrw.zzDq();
        } else if (this.zzbbT + i > this.zzbbV) {
            zzlp(this.zzbbV - this.zzbbT);
            throw zzrw.zzDp();
        } else if (i <= this.zzbbR - this.zzbbT) {
            this.zzbbT += i;
        } else {
            throw zzrw.zzDp();
        }
    }

    public byte[] zzy(int i, int i2) {
        if (i2 == 0) {
            return zzsa.zzbcu;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbbQ + i, bArr, 0, i2);
        return bArr;
    }
}
