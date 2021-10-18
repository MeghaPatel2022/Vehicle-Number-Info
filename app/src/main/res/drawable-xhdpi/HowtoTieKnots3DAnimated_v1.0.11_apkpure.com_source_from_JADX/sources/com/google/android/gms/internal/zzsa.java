package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsa {
    public static final int[] zzbcn = new int[0];
    public static final long[] zzbco = new long[0];
    public static final float[] zzbcp = new float[0];
    public static final double[] zzbcq = new double[0];
    public static final boolean[] zzbcr = new boolean[0];
    public static final String[] zzbcs = new String[0];
    public static final byte[][] zzbct = new byte[0][];
    public static final byte[] zzbcu = new byte[0];

    static int zzE(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int zzb(zzrp zzrp, int i) throws IOException {
        int i2 = 1;
        int position = zzrp.getPosition();
        zzrp.zzlj(i);
        while (zzrp.zzCT() == i) {
            zzrp.zzlj(i);
            i2++;
        }
        zzrp.zzln(position);
        return i2;
    }

    static int zzlD(int i) {
        return i & 7;
    }

    public static int zzlE(int i) {
        return i >>> 3;
    }
}
