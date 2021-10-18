package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzgk
public class zzdu extends zzdr {
    private static final Set<String> zzxB = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzxC = new DecimalFormat("#,###");
    private File zzxD;
    private boolean zzxE;

    public zzdu(zzip zzip) {
        super(zzip);
        File cacheDir = zzip.getContext().getCacheDir();
        if (cacheDir == null) {
            zzb.zzaE("Context.getCacheDir() returned null");
            return;
        }
        this.zzxD = new File(cacheDir, "admobVideoStreams");
        if (!this.zzxD.isDirectory() && !this.zzxD.mkdirs()) {
            zzb.zzaE("Could not create preload cache directory at " + this.zzxD.getAbsolutePath());
            this.zzxD = null;
        } else if (!this.zzxD.setReadable(true, false) || !this.zzxD.setExecutable(true, false)) {
            zzb.zzaE("Could not set cache file permissions at " + this.zzxD.getAbsolutePath());
            this.zzxD = null;
        }
    }

    private File zza(File file) {
        return new File(this.zzxD, file.getName() + ".done");
    }

    private static void zzb(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    public void abort() {
        this.zzxE = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r3 = new java.net.URL(r25).openConnection();
        r2 = ((java.lang.Integer) com.google.android.gms.internal.zzby.zzuo.get()).intValue();
        r3.setConnectTimeout(r2);
        r3.setReadTimeout(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f6, code lost:
        if ((r3 instanceof java.net.HttpURLConnection) == false) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f8, code lost:
        r2 = ((java.net.HttpURLConnection) r3).getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0102, code lost:
        if (r2 < 400) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0128, code lost:
        throw new java.io.IOException("HTTP status code " + r2 + " at " + r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0129, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x012a, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0132, code lost:
        if (r24.zzxE == false) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0134, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaD("Preload aborted for URL \"" + r25 + "\"");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x015e, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("Could not delete partial cache file at " + r9.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0178, code lost:
        zzf(r25, r9.getAbsolutePath());
        zzxB.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r6 = r3.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x018f, code lost:
        if (r6 >= 0) goto L_0x01bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0191, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("Stream cache aborted, missing content-length header at " + r25);
        zzf(r25, r9.getAbsolutePath());
        zzxB.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01bc, code lost:
        r5 = zzxC.format((long) r6);
        r12 = ((java.lang.Integer) com.google.android.gms.internal.zzby.zzuk.get()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01cf, code lost:
        if (r6 <= r12) goto L_0x0206;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01d1, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("Content length " + r5 + " exceeds limit at " + r25);
        zzf(r25, r9.getAbsolutePath());
        zzxB.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0206, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Caching " + r5 + " bytes from " + r25);
        r13 = java.nio.channels.Channels.newChannel(r3.getInputStream());
        r8 = new java.io.FileOutputStream(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r14 = r8.getChannel();
        r15 = java.nio.ByteBuffer.allocate(android.support.p000v4.view.accessibility.AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START);
        r16 = com.google.android.gms.ads.internal.zzp.zzbB();
        r5 = 0;
        r18 = r16.currentTimeMillis();
        r0 = new com.google.android.gms.internal.zzib(((java.lang.Long) com.google.android.gms.internal.zzby.zzun.get()).longValue());
        r20 = ((java.lang.Long) com.google.android.gms.internal.zzby.zzum.get()).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0267, code lost:
        r2 = r13.read(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x026b, code lost:
        if (r2 < 0) goto L_0x02bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x026d, code lost:
        r5 = r5 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x026e, code lost:
        if (r5 <= r12) goto L_0x027c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0277, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0278, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0279, code lost:
        r3 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x027c, code lost:
        r15.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0283, code lost:
        if (r14.write(r15) > 0) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0285, code lost:
        r15.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0294, code lost:
        if ((r16.currentTimeMillis() - r18) <= (1000 * r20)) goto L_0x029e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x029d, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02a2, code lost:
        if (r24.zzxE == false) goto L_0x02ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02ab, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02b0, code lost:
        if (r0.tryAcquire() == false) goto L_0x0267;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x02b2, code lost:
        zza(r25, r9.getAbsolutePath(), r5, r6, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02bf, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02c7, code lost:
        if (com.google.android.gms.ads.internal.util.client.zzb.zzM(3) == false) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02c9, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Preloaded " + zzxC.format((long) r5) + " bytes from " + r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02f2, code lost:
        r9.setReadable(true, false);
        zzb(r10);
        zza(r25, r9.getAbsolutePath(), r5);
        zzxB.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x030d, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Preload failed for URL \"" + r25 + "\"", r2);
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x030d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzZ(java.lang.String r25) {
        /*
            r24 = this;
            r0 = r24
            java.io.File r2 = r0.zzxD
            if (r2 != 0) goto L_0x0010
            r2 = 0
            r0 = r24
            r1 = r25
            r0.zzf(r1, r2)
            r2 = 0
        L_0x000f:
            return r2
        L_0x0010:
            int r3 = r24.zzdH()
            com.google.android.gms.internal.zzbu<java.lang.Integer> r2 = com.google.android.gms.internal.zzby.zzuj
            java.lang.Object r2 = r2.get()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r3 <= r2) goto L_0x0037
            boolean r2 = r24.zzdI()
            if (r2 != 0) goto L_0x0010
            java.lang.String r2 = "Unable to expire stream cache"
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2)
            r2 = 0
            r0 = r24
            r1 = r25
            r0.zzf(r1, r2)
            r2 = 0
            goto L_0x000f
        L_0x0037:
            java.lang.String r2 = r24.zzaa(r25)
            java.io.File r9 = new java.io.File
            r0 = r24
            java.io.File r3 = r0.zzxD
            r9.<init>(r3, r2)
            r0 = r24
            java.io.File r10 = r0.zza(r9)
            boolean r2 = r9.isFile()
            if (r2 == 0) goto L_0x0080
            boolean r2 = r10.isFile()
            if (r2 == 0) goto L_0x0080
            long r2 = r9.length()
            int r2 = (int) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Stream cache hit at "
            java.lang.StringBuilder r3 = r3.append(r4)
            r0 = r25
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r3)
            java.lang.String r3 = r9.getAbsolutePath()
            r0 = r24
            r1 = r25
            r0.zza(r1, r3, r2)
            r2 = 1
            goto L_0x000f
        L_0x0080:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r0 = r24
            java.io.File r3 = r0.zzxD
            java.lang.String r3 = r3.getAbsolutePath()
            java.lang.StringBuilder r2 = r2.append(r3)
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r11 = r2.toString()
            java.util.Set<java.lang.String> r3 = zzxB
            monitor-enter(r3)
            java.util.Set<java.lang.String> r2 = zzxB     // Catch:{ all -> 0x00cd }
            boolean r2 = r2.contains(r11)     // Catch:{ all -> 0x00cd }
            if (r2 == 0) goto L_0x00d0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r2.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.String r4 = "Stream cache already in progress at "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x00cd }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ all -> 0x00cd }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00cd }
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2)     // Catch:{ all -> 0x00cd }
            java.lang.String r2 = r9.getAbsolutePath()     // Catch:{ all -> 0x00cd }
            r0 = r24
            r1 = r25
            r0.zzf(r1, r2)     // Catch:{ all -> 0x00cd }
            r2 = 0
            monitor-exit(r3)     // Catch:{ all -> 0x00cd }
            goto L_0x000f
        L_0x00cd:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00cd }
            throw r2
        L_0x00d0:
            java.util.Set<java.lang.String> r2 = zzxB     // Catch:{ all -> 0x00cd }
            r2.add(r11)     // Catch:{ all -> 0x00cd }
            monitor-exit(r3)     // Catch:{ all -> 0x00cd }
            r4 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0129 }
            r0 = r25
            r2.<init>(r0)     // Catch:{ IOException -> 0x0129 }
            java.net.URLConnection r3 = r2.openConnection()     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.internal.zzbu<java.lang.Integer> r2 = com.google.android.gms.internal.zzby.zzuo     // Catch:{ IOException -> 0x0129 }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x0129 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0129 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x0129 }
            r3.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0129 }
            r3.setReadTimeout(r2)     // Catch:{ IOException -> 0x0129 }
            boolean r2 = r3 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0129 }
            if (r2 == 0) goto L_0x018b
            r0 = r3
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0129 }
            r2 = r0
            int r2 = r2.getResponseCode()     // Catch:{ IOException -> 0x0129 }
            r5 = 400(0x190, float:5.6E-43)
            if (r2 < r5) goto L_0x018b
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0129 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0129 }
            r5.<init>()     // Catch:{ IOException -> 0x0129 }
            java.lang.String r6 = "HTTP status code "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ IOException -> 0x0129 }
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch:{ IOException -> 0x0129 }
            java.lang.String r5 = " at "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ IOException -> 0x0129 }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x0129 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0129 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0129 }
            throw r3     // Catch:{ IOException -> 0x0129 }
        L_0x0129:
            r2 = move-exception
            r3 = r4
        L_0x012b:
            r3.close()     // Catch:{ IOException -> 0x032d, NullPointerException -> 0x0330 }
        L_0x012e:
            r0 = r24
            boolean r3 = r0.zzxE
            if (r3 == 0) goto L_0x030d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Preload aborted for URL \""
            java.lang.StringBuilder r2 = r2.append(r3)
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r3 = "\""
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzaD(r2)
        L_0x0152:
            boolean r2 = r9.exists()
            if (r2 == 0) goto L_0x0178
            boolean r2 = r9.delete()
            if (r2 != 0) goto L_0x0178
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Could not delete partial cache file at "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r9.getAbsolutePath()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2)
        L_0x0178:
            java.lang.String r2 = r9.getAbsolutePath()
            r0 = r24
            r1 = r25
            r0.zzf(r1, r2)
            java.util.Set<java.lang.String> r2 = zzxB
            r2.remove(r11)
            r2 = 0
            goto L_0x000f
        L_0x018b:
            int r6 = r3.getContentLength()     // Catch:{ IOException -> 0x0129 }
            if (r6 >= 0) goto L_0x01bc
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0129 }
            r2.<init>()     // Catch:{ IOException -> 0x0129 }
            java.lang.String r3 = "Stream cache aborted, missing content-length header at "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x0129 }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x0129 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2)     // Catch:{ IOException -> 0x0129 }
            java.lang.String r2 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x0129 }
            r0 = r24
            r1 = r25
            r0.zzf(r1, r2)     // Catch:{ IOException -> 0x0129 }
            java.util.Set<java.lang.String> r2 = zzxB     // Catch:{ IOException -> 0x0129 }
            r2.remove(r11)     // Catch:{ IOException -> 0x0129 }
            r2 = 0
            goto L_0x000f
        L_0x01bc:
            java.text.DecimalFormat r2 = zzxC     // Catch:{ IOException -> 0x0129 }
            long r12 = (long) r6     // Catch:{ IOException -> 0x0129 }
            java.lang.String r5 = r2.format(r12)     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.internal.zzbu<java.lang.Integer> r2 = com.google.android.gms.internal.zzby.zzuk     // Catch:{ IOException -> 0x0129 }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x0129 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x0129 }
            int r12 = r2.intValue()     // Catch:{ IOException -> 0x0129 }
            if (r6 <= r12) goto L_0x0206
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0129 }
            r2.<init>()     // Catch:{ IOException -> 0x0129 }
            java.lang.String r3 = "Content length "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x0129 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ IOException -> 0x0129 }
            java.lang.String r3 = " exceeds limit at "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x0129 }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x0129 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2)     // Catch:{ IOException -> 0x0129 }
            java.lang.String r2 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x0129 }
            r0 = r24
            r1 = r25
            r0.zzf(r1, r2)     // Catch:{ IOException -> 0x0129 }
            java.util.Set<java.lang.String> r2 = zzxB     // Catch:{ IOException -> 0x0129 }
            r2.remove(r11)     // Catch:{ IOException -> 0x0129 }
            r2 = 0
            goto L_0x000f
        L_0x0206:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0129 }
            r2.<init>()     // Catch:{ IOException -> 0x0129 }
            java.lang.String r7 = "Caching "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ IOException -> 0x0129 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ IOException -> 0x0129 }
            java.lang.String r5 = " bytes from "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ IOException -> 0x0129 }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x0129 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r2)     // Catch:{ IOException -> 0x0129 }
            java.io.InputStream r2 = r3.getInputStream()     // Catch:{ IOException -> 0x0129 }
            java.nio.channels.ReadableByteChannel r13 = java.nio.channels.Channels.newChannel(r2)     // Catch:{ IOException -> 0x0129 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0129 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x0129 }
            java.nio.channels.FileChannel r14 = r8.getChannel()     // Catch:{ IOException -> 0x0278 }
            r2 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r15 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ IOException -> 0x0278 }
            com.google.android.gms.internal.zzlm r16 = com.google.android.gms.ads.internal.zzp.zzbB()     // Catch:{ IOException -> 0x0278 }
            r5 = 0
            long r18 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x0278 }
            com.google.android.gms.internal.zzbu<java.lang.Long> r2 = com.google.android.gms.internal.zzby.zzun     // Catch:{ IOException -> 0x0278 }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x0278 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x0278 }
            long r2 = r2.longValue()     // Catch:{ IOException -> 0x0278 }
            com.google.android.gms.internal.zzib r17 = new com.google.android.gms.internal.zzib     // Catch:{ IOException -> 0x0278 }
            r0 = r17
            r0.<init>(r2)     // Catch:{ IOException -> 0x0278 }
            com.google.android.gms.internal.zzbu<java.lang.Long> r2 = com.google.android.gms.internal.zzby.zzum     // Catch:{ IOException -> 0x0278 }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x0278 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x0278 }
            long r20 = r2.longValue()     // Catch:{ IOException -> 0x0278 }
        L_0x0267:
            int r2 = r13.read(r15)     // Catch:{ IOException -> 0x0278 }
            if (r2 < 0) goto L_0x02bf
            int r5 = r5 + r2
            if (r5 <= r12) goto L_0x027c
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0278 }
            java.lang.String r3 = "stream cache file size limit exceeded"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0278 }
            throw r2     // Catch:{ IOException -> 0x0278 }
        L_0x0278:
            r2 = move-exception
            r3 = r8
            goto L_0x012b
        L_0x027c:
            r15.flip()     // Catch:{ IOException -> 0x0278 }
        L_0x027f:
            int r2 = r14.write(r15)     // Catch:{ IOException -> 0x0278 }
            if (r2 > 0) goto L_0x027f
            r15.clear()     // Catch:{ IOException -> 0x0278 }
            long r2 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x0278 }
            long r2 = r2 - r18
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r20
            int r2 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x029e
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0278 }
            java.lang.String r3 = "stream cache time limit exceeded"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0278 }
            throw r2     // Catch:{ IOException -> 0x0278 }
        L_0x029e:
            r0 = r24
            boolean r2 = r0.zzxE     // Catch:{ IOException -> 0x0278 }
            if (r2 == 0) goto L_0x02ac
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0278 }
            java.lang.String r3 = "abort requested"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0278 }
            throw r2     // Catch:{ IOException -> 0x0278 }
        L_0x02ac:
            boolean r2 = r17.tryAcquire()     // Catch:{ IOException -> 0x0278 }
            if (r2 == 0) goto L_0x0267
            java.lang.String r4 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x0278 }
            r7 = 0
            r2 = r24
            r3 = r25
            r2.zza(r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0278 }
            goto L_0x0267
        L_0x02bf:
            r8.close()     // Catch:{ IOException -> 0x0278 }
            r2 = 3
            boolean r2 = com.google.android.gms.ads.internal.util.client.zzb.zzM(r2)     // Catch:{ IOException -> 0x0278 }
            if (r2 == 0) goto L_0x02f2
            java.text.DecimalFormat r2 = zzxC     // Catch:{ IOException -> 0x0278 }
            long r6 = (long) r5     // Catch:{ IOException -> 0x0278 }
            java.lang.String r2 = r2.format(r6)     // Catch:{ IOException -> 0x0278 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0278 }
            r3.<init>()     // Catch:{ IOException -> 0x0278 }
            java.lang.String r4 = "Preloaded "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x0278 }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ IOException -> 0x0278 }
            java.lang.String r3 = " bytes from "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x0278 }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x0278 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0278 }
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r2)     // Catch:{ IOException -> 0x0278 }
        L_0x02f2:
            r2 = 1
            r3 = 0
            r9.setReadable(r2, r3)     // Catch:{ IOException -> 0x0278 }
            zzb(r10)     // Catch:{ IOException -> 0x0278 }
            java.lang.String r2 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x0278 }
            r0 = r24
            r1 = r25
            r0.zza(r1, r2, r5)     // Catch:{ IOException -> 0x0278 }
            java.util.Set<java.lang.String> r2 = zzxB     // Catch:{ IOException -> 0x0278 }
            r2.remove(r11)     // Catch:{ IOException -> 0x0278 }
            r2 = 1
            goto L_0x000f
        L_0x030d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Preload failed for URL \""
            java.lang.StringBuilder r3 = r3.append(r4)
            r0 = r25
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r4 = "\""
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r3, r2)
            goto L_0x0152
        L_0x032d:
            r3 = move-exception
            goto L_0x012e
        L_0x0330:
            r3 = move-exception
            goto L_0x012e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdu.zzZ(java.lang.String):boolean");
    }

    public int zzdH() {
        int i = 0;
        if (this.zzxD != null) {
            for (File name : this.zzxD.listFiles()) {
                if (!name.getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean zzdI() {
        boolean z;
        long j;
        File file;
        if (this.zzxD == null) {
            return false;
        }
        File file2 = null;
        long j2 = Long.MAX_VALUE;
        File[] listFiles = this.zzxD.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file3 = listFiles[i];
            if (!file3.getName().endsWith(".done")) {
                j = file3.lastModified();
                if (j < j2) {
                    file = file3;
                    i++;
                    file2 = file;
                    j2 = j;
                }
            }
            j = j2;
            file = file2;
            i++;
            file2 = file;
            j2 = j;
        }
        if (file2 != null) {
            z = file2.delete();
            File zza = zza(file2);
            if (zza.isFile()) {
                z &= zza.delete();
            }
        } else {
            z = false;
        }
        return z;
    }
}
