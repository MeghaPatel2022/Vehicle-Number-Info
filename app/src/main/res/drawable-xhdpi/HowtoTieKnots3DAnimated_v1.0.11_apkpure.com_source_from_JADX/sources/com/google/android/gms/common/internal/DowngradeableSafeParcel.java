package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {
    private static final Object zzadj = new Object();
    private static ClassLoader zzadk = null;
    private static Integer zzadl = null;
    private boolean zzadm = false;

    private static boolean zza(Class<?> cls) {
        boolean z = false;
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return z;
        }
    }

    protected static boolean zzcj(String str) {
        ClassLoader zzoq = zzoq();
        if (zzoq == null) {
            return true;
        }
        try {
            return zza(zzoq.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader zzoq() {
        ClassLoader classLoader;
        synchronized (zzadj) {
            classLoader = zzadk;
        }
        return classLoader;
    }

    protected static Integer zzor() {
        Integer num;
        synchronized (zzadj) {
            num = zzadl;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    public boolean zzos() {
        return this.zzadm;
    }
}
