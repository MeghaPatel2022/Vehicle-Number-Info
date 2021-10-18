package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb.zza;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class zzt implements zzf {
    protected static final boolean DEBUG = zzs.DEBUG;
    private static int zzao = 3000;
    private static int zzap = 4096;
    protected final zzy zzaq;
    protected final zzu zzar;

    public zzt(zzy zzy) {
        this(zzy, new zzu(zzap));
    }

    public zzt(zzy zzy, zzu zzu) {
        this.zzaq = zzy;
        this.zzar = zzu;
    }

    protected static Map<String, String> zza(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private void zza(long j, zzk<?> zzk, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > ((long) zzao)) {
            String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
            Object[] objArr = new Object[5];
            objArr[0] = zzk;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(zzk.zzu().zze());
            zzs.zzb(str, objArr);
        }
    }

    private static void zza(String str, zzk<?> zzk, zzr zzr) throws zzr {
        zzo zzu = zzk.zzu();
        int zzt = zzk.zzt();
        try {
            zzu.zza(zzr);
            zzk.zzc(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(zzt)}));
        } catch (zzr e) {
            zzk.zzc(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(zzt)}));
            throw e;
        }
    }

    private void zza(Map<String, String> map, zza zza) {
        if (zza != null) {
            if (zza.zzb != null) {
                map.put("If-None-Match", zza.zzb);
            }
            if (zza.zzd > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(zza.zzd)));
            }
        }
    }

    private byte[] zza(HttpEntity httpEntity) throws IOException, zzp {
        zzaa zzaa = new zzaa(this.zzar, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new zzp();
            }
            bArr = this.zzar.zzb(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                zzaa.write(bArr, 0, read);
            }
            byte[] byteArray = zzaa.toByteArray();
            try {
            } catch (IOException e) {
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            return byteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.zzar.zza(bArr);
            zzaa.close();
        }
    }

    /* JADX INFO: used method not loaded: com.google.android.gms.internal.zzh.<init>(com.google.android.gms.internal.zzi):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0091, code lost:
        zza("socket", r19, new com.google.android.gms.internal.zzq());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b2, code lost:
        zza("connection", r19, new com.google.android.gms.internal.zzq());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00dd, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r19.getUrl(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00de, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00df, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e3, code lost:
        r4 = r3.getStatusLine().getStatusCode();
        com.google.android.gms.internal.zzs.zzc("Unexpected response code %d for %s", java.lang.Integer.valueOf(r4), r19.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0101, code lost:
        if (r5 != null) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0103, code lost:
        r3 = new com.google.android.gms.internal.zzi(r4, r5, r6, false, android.os.SystemClock.elapsedRealtime() - r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0111, code lost:
        if (r4 == 401) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0117, code lost:
        zza("auth", r19, new com.google.android.gms.internal.zza(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012a, code lost:
        throw new com.google.android.gms.internal.zzj(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0130, code lost:
        throw new com.google.android.gms.internal.zzp(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0136, code lost:
        throw new com.google.android.gms.internal.zzh((com.google.android.gms.internal.zzi) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0137, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0138, code lost:
        r5 = null;
        r3 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b1 A[ExcHandler: ConnectTimeoutException (e org.apache.http.conn.ConnectTimeoutException), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c0 A[ExcHandler: MalformedURLException (r2v9 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0125 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzi zza(com.google.android.gms.internal.zzk<?> r19) throws com.google.android.gms.internal.zzr {
        /*
            r18 = this;
            long r16 = android.os.SystemClock.elapsedRealtime()
        L_0x0004:
            r3 = 0
            r14 = 0
            java.util.Map r6 = java.util.Collections.emptyMap()
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
            r2.<init>()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
            com.google.android.gms.internal.zzb$zza r4 = r19.zzi()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
            r0 = r18
            r0.zza(r2, r4)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
            r0 = r18
            com.google.android.gms.internal.zzy r4 = r0.zzaq     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
            r0 = r19
            org.apache.http.HttpResponse r15 = r4.zza(r0, r2)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x00de }
            org.apache.http.StatusLine r12 = r15.getStatusLine()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            int r4 = r12.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            org.apache.http.Header[] r2 = r15.getAllHeaders()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            java.util.Map r6 = zza(r2)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            r2 = 304(0x130, float:4.26E-43)
            if (r4 != r2) goto L_0x0065
            com.google.android.gms.internal.zzb$zza r2 = r19.zzi()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            if (r2 != 0) goto L_0x004c
            com.google.android.gms.internal.zzi r3 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            r4 = 304(0x130, float:4.26E-43)
            r5 = 0
            r7 = 1
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            long r8 = r8 - r16
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        L_0x004b:
            return r3
        L_0x004c:
            java.util.Map<java.lang.String, java.lang.String> r3 = r2.zzg     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            r3.putAll(r6)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            com.google.android.gms.internal.zzi r7 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            r8 = 304(0x130, float:4.26E-43)
            byte[] r9 = r2.data     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            java.util.Map<java.lang.String, java.lang.String> r10 = r2.zzg     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            r11 = 1
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            long r12 = r2 - r16
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            r3 = r7
            goto L_0x004b
        L_0x0065:
            org.apache.http.HttpEntity r2 = r15.getEntity()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            if (r2 == 0) goto L_0x009f
            org.apache.http.HttpEntity r2 = r15.getEntity()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            r0 = r18
            byte[] r11 = r0.zza(r2)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
        L_0x0075:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            long r8 = r2 - r16
            r7 = r18
            r10 = r19
            r7.zza(r8, r10, r11, r12)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            r2 = 200(0xc8, float:2.8E-43)
            if (r4 < r2) goto L_0x008a
            r2 = 299(0x12b, float:4.19E-43)
            if (r4 <= r2) goto L_0x00a3
        L_0x008a:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            r2.<init>()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            throw r2     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
        L_0x0090:
            r2 = move-exception
            java.lang.String r2 = "socket"
            com.google.android.gms.internal.zzq r3 = new com.google.android.gms.internal.zzq
            r3.<init>()
            r0 = r19
            zza(r2, r0, r3)
            goto L_0x0004
        L_0x009f:
            r2 = 0
            byte[] r11 = new byte[r2]     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x0137 }
            goto L_0x0075
        L_0x00a3:
            com.google.android.gms.internal.zzi r3 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            r7 = 0
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            long r8 = r8 - r16
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ SocketTimeoutException -> 0x0090, ConnectTimeoutException -> 0x00b1, MalformedURLException -> 0x00c0, IOException -> 0x013b }
            goto L_0x004b
        L_0x00b1:
            r2 = move-exception
            java.lang.String r2 = "connection"
            com.google.android.gms.internal.zzq r3 = new com.google.android.gms.internal.zzq
            r3.<init>()
            r0 = r19
            zza(r2, r0, r3)
            goto L_0x0004
        L_0x00c0:
            r2 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Bad URL "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = r19.getUrl()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4, r2)
            throw r3
        L_0x00de:
            r2 = move-exception
            r5 = r14
        L_0x00e0:
            r7 = 0
            if (r3 == 0) goto L_0x0125
            org.apache.http.StatusLine r2 = r3.getStatusLine()
            int r4 = r2.getStatusCode()
            java.lang.String r2 = "Unexpected response code %d for %s"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            r3[r8] = r9
            r8 = 1
            java.lang.String r9 = r19.getUrl()
            r3[r8] = r9
            com.google.android.gms.internal.zzs.zzc(r2, r3)
            if (r5 == 0) goto L_0x0131
            com.google.android.gms.internal.zzi r3 = new com.google.android.gms.internal.zzi
            r7 = 0
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r8 = r8 - r16
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = 401(0x191, float:5.62E-43)
            if (r4 == r2) goto L_0x0117
            r2 = 403(0x193, float:5.65E-43)
            if (r4 != r2) goto L_0x012b
        L_0x0117:
            java.lang.String r2 = "auth"
            com.google.android.gms.internal.zza r4 = new com.google.android.gms.internal.zza
            r4.<init>(r3)
            r0 = r19
            zza(r2, r0, r4)
            goto L_0x0004
        L_0x0125:
            com.google.android.gms.internal.zzj r3 = new com.google.android.gms.internal.zzj
            r3.<init>(r2)
            throw r3
        L_0x012b:
            com.google.android.gms.internal.zzp r2 = new com.google.android.gms.internal.zzp
            r2.<init>(r3)
            throw r2
        L_0x0131:
            com.google.android.gms.internal.zzh r2 = new com.google.android.gms.internal.zzh
            r2.<init>(r7)
            throw r2
        L_0x0137:
            r2 = move-exception
            r5 = r14
            r3 = r15
            goto L_0x00e0
        L_0x013b:
            r2 = move-exception
            r5 = r11
            r3 = r15
            goto L_0x00e0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzt.zza(com.google.android.gms.internal.zzk):com.google.android.gms.internal.zzi");
    }
}
