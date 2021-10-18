package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class zzal extends zzak {
    private static long startTime = 0;
    private static Method zzmY;
    private static Method zzmZ;
    private static Method zzna;
    private static Method zznb;
    private static Method zznc;
    private static Method zznd;
    private static Method zzne;
    private static Method zznf;
    private static Method zzng;
    private static Method zznh;
    private static Method zzni;
    private static Method zznj;
    private static Method zznk;
    private static String zznl;
    private static String zznm;
    private static String zznn;
    private static zzar zzno;
    static boolean zznp = false;

    static class zza extends Exception {
        public zza() {
        }

        public zza(Throwable th) {
            super(th);
        }
    }

    protected zzal(Context context, zzap zzap, zzaq zzaq) {
        super(context, zzap, zzaq);
    }

    static String zzU() throws zza {
        if (zznl != null) {
            return zznl;
        }
        throw new zza();
    }

    static Long zzV() throws zza {
        if (zzmY == null) {
            throw new zza();
        }
        try {
            return (Long) zzmY.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zzW() throws zza {
        if (zzna == null) {
            throw new zza();
        }
        try {
            return (String) zzna.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static Long zzX() throws zza {
        if (zzmZ == null) {
            throw new zza();
        }
        try {
            return (Long) zzmZ.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zza(Context context, zzap zzap) throws zza {
        if (zznm != null) {
            return zznm;
        }
        if (zznb == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zznb.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new zza();
            }
            zznm = zzap.zza(byteBuffer.array(), true);
            return zznm;
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zza(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zza {
        if (zznc == null || motionEvent == null) {
            throw new zza();
        }
        try {
            return (ArrayList) zznc.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    protected static synchronized void zza(String str, Context context, zzap zzap) {
        synchronized (zzal.class) {
            if (!zznp) {
                try {
                    zzno = new zzar(zzap, null);
                    zznl = str;
                    zzl(context);
                    startTime = zzV().longValue();
                    zznp = true;
                } catch (zza | UnsupportedOperationException e) {
                }
            }
        }
    }

    static String zzb(Context context, zzap zzap) throws zza {
        if (zznn != null) {
            return zznn;
        }
        if (zzne == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zzne.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new zza();
            }
            zznn = zzap.zza(byteBuffer.array(), true);
            return zznn;
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    private static String zzb(byte[] bArr, String str) throws zza {
        try {
            return new String(zzno.zzc(bArr, str), "UTF-8");
        } catch (com.google.android.gms.internal.zzar.zza e) {
            throw new zza(e);
        } catch (UnsupportedEncodingException e2) {
            throw new zza(e2);
        }
    }

    static String zze(Context context) throws zza {
        if (zznd == null) {
            throw new zza();
        }
        try {
            String str = (String) zznd.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new zza();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zzf(Context context) throws zza {
        if (zznh == null) {
            throw new zza();
        }
        try {
            return (String) zznh.invoke(null, new Object[]{context});
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static Long zzg(Context context) throws zza {
        if (zzni == null) {
            throw new zza();
        }
        try {
            return (Long) zzni.invoke(null, new Object[]{context});
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zzh(Context context) throws zza {
        if (zznf == null) {
            throw new zza();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) zznf.invoke(null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new zza();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int[] zzi(Context context) throws zza {
        if (zzng == null) {
            throw new zza();
        }
        try {
            return (int[]) zzng.invoke(null, new Object[]{context});
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int zzj(Context context) throws zza {
        if (zznj == null) {
            throw new zza();
        }
        try {
            return ((Integer) zznj.invoke(null, new Object[]{context})).intValue();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int zzk(Context context) throws zza {
        if (zznk == null) {
            throw new zza();
        }
        try {
            return ((Integer) zznk.invoke(null, new Object[]{context})).intValue();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    private static void zzl(Context context) throws zza {
        File file;
        File createTempFile;
        try {
            byte[] zzl = zzno.zzl(zzat.getKey());
            byte[] zzc = zzno.zzc(zzl, zzat.zzad());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new zza();
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(zzc, 0, zzc.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(zzb(zzl, zzat.zzam()));
            Class loadClass2 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaA()));
            Class loadClass3 = dexClassLoader.loadClass(zzb(zzl, zzat.zzau()));
            Class loadClass4 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaq()));
            Class loadClass5 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaC()));
            Class loadClass6 = dexClassLoader.loadClass(zzb(zzl, zzat.zzao()));
            Class loadClass7 = dexClassLoader.loadClass(zzb(zzl, zzat.zzay()));
            Class loadClass8 = dexClassLoader.loadClass(zzb(zzl, zzat.zzaw()));
            Class loadClass9 = dexClassLoader.loadClass(zzb(zzl, zzat.zzak()));
            Class loadClass10 = dexClassLoader.loadClass(zzb(zzl, zzat.zzai()));
            Class loadClass11 = dexClassLoader.loadClass(zzb(zzl, zzat.zzag()));
            Class loadClass12 = dexClassLoader.loadClass(zzb(zzl, zzat.zzas()));
            Class loadClass13 = dexClassLoader.loadClass(zzb(zzl, zzat.zzae()));
            zzmY = loadClass.getMethod(zzb(zzl, zzat.zzan()), new Class[0]);
            zzmZ = loadClass2.getMethod(zzb(zzl, zzat.zzaB()), new Class[0]);
            zzna = loadClass3.getMethod(zzb(zzl, zzat.zzav()), new Class[0]);
            zznb = loadClass4.getMethod(zzb(zzl, zzat.zzar()), new Class[]{Context.class});
            zznc = loadClass5.getMethod(zzb(zzl, zzat.zzaD()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            zznd = loadClass6.getMethod(zzb(zzl, zzat.zzap()), new Class[]{Context.class});
            zzne = loadClass7.getMethod(zzb(zzl, zzat.zzaz()), new Class[]{Context.class});
            zznf = loadClass8.getMethod(zzb(zzl, zzat.zzax()), new Class[]{Context.class});
            zzng = loadClass9.getMethod(zzb(zzl, zzat.zzal()), new Class[]{Context.class});
            zznh = loadClass10.getMethod(zzb(zzl, zzat.zzaj()), new Class[]{Context.class});
            zzni = loadClass11.getMethod(zzb(zzl, zzat.zzah()), new Class[]{Context.class});
            zznj = loadClass12.getMethod(zzb(zzl, zzat.zzat()), new Class[]{Context.class});
            zznk = loadClass13.getMethod(zzb(zzl, zzat.zzaf()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (FileNotFoundException e) {
            throw new zza(e);
        } catch (IOException e2) {
            throw new zza(e2);
        } catch (ClassNotFoundException e3) {
            throw new zza(e3);
        } catch (com.google.android.gms.internal.zzar.zza e4) {
            throw new zza(e4);
        } catch (NoSuchMethodException e5) {
            throw new zza(e5);
        } catch (NullPointerException e6) {
            throw new zza(e6);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b9 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:6:0x0010] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzc(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 1
            java.lang.String r1 = zzW()     // Catch:{ zza -> 0x00d3, IOException -> 0x00b9 }
            r6.zza(r0, r1)     // Catch:{ zza -> 0x00d3, IOException -> 0x00b9 }
        L_0x0008:
            r0 = 2
            java.lang.String r1 = zzU()     // Catch:{ zza -> 0x00d0, IOException -> 0x00b9 }
            r6.zza(r0, r1)     // Catch:{ zza -> 0x00d0, IOException -> 0x00b9 }
        L_0x0010:
            java.lang.Long r0 = zzV()     // Catch:{ zza -> 0x00cd, IOException -> 0x00b9 }
            long r0 = r0.longValue()     // Catch:{ zza -> 0x00cd, IOException -> 0x00b9 }
            r2 = 25
            r6.zza(r2, r0)     // Catch:{ zza -> 0x00cd, IOException -> 0x00b9 }
            long r2 = startTime     // Catch:{ zza -> 0x00cd, IOException -> 0x00b9 }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0034
            r2 = 17
            long r4 = startTime     // Catch:{ zza -> 0x00cd, IOException -> 0x00b9 }
            long r0 = r0 - r4
            r6.zza(r2, r0)     // Catch:{ zza -> 0x00cd, IOException -> 0x00b9 }
            r0 = 23
            long r2 = startTime     // Catch:{ zza -> 0x00cd, IOException -> 0x00b9 }
            r6.zza(r0, r2)     // Catch:{ zza -> 0x00cd, IOException -> 0x00b9 }
        L_0x0034:
            java.util.ArrayList r1 = zzh(r7)     // Catch:{ zza -> 0x00cb, IOException -> 0x00b9 }
            r2 = 31
            r0 = 0
            java.lang.Object r0 = r1.get(r0)     // Catch:{ zza -> 0x00cb, IOException -> 0x00b9 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ zza -> 0x00cb, IOException -> 0x00b9 }
            long r4 = r0.longValue()     // Catch:{ zza -> 0x00cb, IOException -> 0x00b9 }
            r6.zza(r2, r4)     // Catch:{ zza -> 0x00cb, IOException -> 0x00b9 }
            r2 = 32
            r0 = 1
            java.lang.Object r0 = r1.get(r0)     // Catch:{ zza -> 0x00cb, IOException -> 0x00b9 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ zza -> 0x00cb, IOException -> 0x00b9 }
            long r0 = r0.longValue()     // Catch:{ zza -> 0x00cb, IOException -> 0x00b9 }
            r6.zza(r2, r0)     // Catch:{ zza -> 0x00cb, IOException -> 0x00b9 }
        L_0x0058:
            r0 = 33
            java.lang.Long r1 = zzX()     // Catch:{ zza -> 0x00c9, IOException -> 0x00b9 }
            long r2 = r1.longValue()     // Catch:{ zza -> 0x00c9, IOException -> 0x00b9 }
            r6.zza(r0, r2)     // Catch:{ zza -> 0x00c9, IOException -> 0x00b9 }
        L_0x0065:
            r0 = 27
            com.google.android.gms.internal.zzap r1 = r6.zzmW     // Catch:{ zza -> 0x00c7, IOException -> 0x00b9 }
            java.lang.String r1 = zza(r7, r1)     // Catch:{ zza -> 0x00c7, IOException -> 0x00b9 }
            r6.zza(r0, r1)     // Catch:{ zza -> 0x00c7, IOException -> 0x00b9 }
        L_0x0070:
            r0 = 29
            com.google.android.gms.internal.zzap r1 = r6.zzmW     // Catch:{ zza -> 0x00c5, IOException -> 0x00b9 }
            java.lang.String r1 = zzb(r7, r1)     // Catch:{ zza -> 0x00c5, IOException -> 0x00b9 }
            r6.zza(r0, r1)     // Catch:{ zza -> 0x00c5, IOException -> 0x00b9 }
        L_0x007b:
            int[] r0 = zzi(r7)     // Catch:{ zza -> 0x00c3, IOException -> 0x00b9 }
            r1 = 5
            r2 = 0
            r2 = r0[r2]     // Catch:{ zza -> 0x00c3, IOException -> 0x00b9 }
            long r2 = (long) r2     // Catch:{ zza -> 0x00c3, IOException -> 0x00b9 }
            r6.zza(r1, r2)     // Catch:{ zza -> 0x00c3, IOException -> 0x00b9 }
            r1 = 6
            r2 = 1
            r0 = r0[r2]     // Catch:{ zza -> 0x00c3, IOException -> 0x00b9 }
            long r2 = (long) r0     // Catch:{ zza -> 0x00c3, IOException -> 0x00b9 }
            r6.zza(r1, r2)     // Catch:{ zza -> 0x00c3, IOException -> 0x00b9 }
        L_0x008f:
            int r0 = zzj(r7)     // Catch:{ zza -> 0x00c1, IOException -> 0x00b9 }
            r1 = 12
            long r2 = (long) r0     // Catch:{ zza -> 0x00c1, IOException -> 0x00b9 }
            r6.zza(r1, r2)     // Catch:{ zza -> 0x00c1, IOException -> 0x00b9 }
        L_0x0099:
            int r0 = zzk(r7)     // Catch:{ zza -> 0x00bf, IOException -> 0x00b9 }
            r1 = 3
            long r2 = (long) r0     // Catch:{ zza -> 0x00bf, IOException -> 0x00b9 }
            r6.zza(r1, r2)     // Catch:{ zza -> 0x00bf, IOException -> 0x00b9 }
        L_0x00a2:
            r0 = 34
            java.lang.String r1 = zzf(r7)     // Catch:{ zza -> 0x00bd, IOException -> 0x00b9 }
            r6.zza(r0, r1)     // Catch:{ zza -> 0x00bd, IOException -> 0x00b9 }
        L_0x00ab:
            r0 = 35
            java.lang.Long r1 = zzg(r7)     // Catch:{ zza -> 0x00bb, IOException -> 0x00b9 }
            long r2 = r1.longValue()     // Catch:{ zza -> 0x00bb, IOException -> 0x00b9 }
            r6.zza(r0, r2)     // Catch:{ zza -> 0x00bb, IOException -> 0x00b9 }
        L_0x00b8:
            return
        L_0x00b9:
            r0 = move-exception
            goto L_0x00b8
        L_0x00bb:
            r0 = move-exception
            goto L_0x00b8
        L_0x00bd:
            r0 = move-exception
            goto L_0x00ab
        L_0x00bf:
            r0 = move-exception
            goto L_0x00a2
        L_0x00c1:
            r0 = move-exception
            goto L_0x0099
        L_0x00c3:
            r0 = move-exception
            goto L_0x008f
        L_0x00c5:
            r0 = move-exception
            goto L_0x007b
        L_0x00c7:
            r0 = move-exception
            goto L_0x0070
        L_0x00c9:
            r0 = move-exception
            goto L_0x0065
        L_0x00cb:
            r0 = move-exception
            goto L_0x0058
        L_0x00cd:
            r0 = move-exception
            goto L_0x0034
        L_0x00d0:
            r0 = move-exception
            goto L_0x0010
        L_0x00d3:
            r0 = move-exception
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzal.zzc(android.content.Context):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzd(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 2
            java.lang.String r1 = zzU()     // Catch:{ zza -> 0x007f, IOException -> 0x0073 }
            r6.zza(r0, r1)     // Catch:{ zza -> 0x007f, IOException -> 0x0073 }
        L_0x0008:
            r0 = 1
            java.lang.String r1 = zzW()     // Catch:{ zza -> 0x007d, IOException -> 0x0073 }
            r6.zza(r0, r1)     // Catch:{ zza -> 0x007d, IOException -> 0x0073 }
        L_0x0010:
            r0 = 25
            java.lang.Long r1 = zzV()     // Catch:{ zza -> 0x007b, IOException -> 0x0073 }
            long r2 = r1.longValue()     // Catch:{ zza -> 0x007b, IOException -> 0x0073 }
            r6.zza(r0, r2)     // Catch:{ zza -> 0x007b, IOException -> 0x0073 }
        L_0x001d:
            android.view.MotionEvent r0 = r6.zzmU     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            android.util.DisplayMetrics r1 = r6.zzmV     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            java.util.ArrayList r1 = zza(r0, r1)     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            r2 = 14
            r0 = 0
            java.lang.Object r0 = r1.get(r0)     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            long r4 = r0.longValue()     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            r6.zza(r2, r4)     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            r2 = 15
            r0 = 1
            java.lang.Object r0 = r1.get(r0)     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            long r4 = r0.longValue()     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            r6.zza(r2, r4)     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            int r0 = r1.size()     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            r2 = 3
            if (r0 < r2) goto L_0x005c
            r2 = 16
            r0 = 2
            java.lang.Object r0 = r1.get(r0)     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            long r0 = r0.longValue()     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
            r6.zza(r2, r0)     // Catch:{ zza -> 0x0079, IOException -> 0x0073 }
        L_0x005c:
            r0 = 34
            java.lang.String r1 = zzf(r7)     // Catch:{ zza -> 0x0077, IOException -> 0x0073 }
            r6.zza(r0, r1)     // Catch:{ zza -> 0x0077, IOException -> 0x0073 }
        L_0x0065:
            r0 = 35
            java.lang.Long r1 = zzg(r7)     // Catch:{ zza -> 0x0075, IOException -> 0x0073 }
            long r2 = r1.longValue()     // Catch:{ zza -> 0x0075, IOException -> 0x0073 }
            r6.zza(r0, r2)     // Catch:{ zza -> 0x0075, IOException -> 0x0073 }
        L_0x0072:
            return
        L_0x0073:
            r0 = move-exception
            goto L_0x0072
        L_0x0075:
            r0 = move-exception
            goto L_0x0072
        L_0x0077:
            r0 = move-exception
            goto L_0x0065
        L_0x0079:
            r0 = move-exception
            goto L_0x005c
        L_0x007b:
            r0 = move-exception
            goto L_0x001d
        L_0x007d:
            r0 = move-exception
            goto L_0x0010
        L_0x007f:
            r0 = move-exception
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzal.zzd(android.content.Context):void");
    }
}
