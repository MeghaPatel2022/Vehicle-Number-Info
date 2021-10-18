package com.google.android.gms.vision;

import android.util.SparseArray;

public class zza {
    private static int zzaVg = 0;
    private static final Object zzpm = new Object();
    private SparseArray<Integer> zzaVh = new SparseArray<>();
    private SparseArray<Integer> zzaVi = new SparseArray<>();

    public int zzjo(int i) {
        int i2;
        synchronized (zzpm) {
            Integer num = (Integer) this.zzaVh.get(i);
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = zzaVg;
                zzaVg++;
                this.zzaVh.append(i, Integer.valueOf(i2));
                this.zzaVi.append(i2, Integer.valueOf(i));
            }
        }
        return i2;
    }

    public int zzjp(int i) {
        int intValue;
        synchronized (zzpm) {
            intValue = ((Integer) this.zzaVi.get(i)).intValue();
        }
        return intValue;
    }
}
