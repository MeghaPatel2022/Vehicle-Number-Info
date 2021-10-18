package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

class zzah extends zzd {
    /* access modifiers changed from: private */
    public static final byte[] zzOs = "\n".getBytes();
    private final String zzHj = zza("GoogleAnalytics", zze.VERSION, VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);
    private final zzaj zzOr;

    private class zza {
        private int zzOt;
        private ByteArrayOutputStream zzOu = new ByteArrayOutputStream();

        public zza() {
        }

        public byte[] getPayload() {
            return this.zzOu.toByteArray();
        }

        public boolean zzj(zzab zzab) {
            zzx.zzv(zzab);
            if (this.zzOt + 1 > zzah.this.zzif().zzjw()) {
                return false;
            }
            String zza = zzah.this.zza(zzab, false);
            if (zza == null) {
                zzah.this.zzie().zza(zzab, "Error formatting hit");
                return true;
            }
            byte[] bytes = zza.getBytes();
            int length = bytes.length;
            if (length > zzah.this.zzif().zzjo()) {
                zzah.this.zzie().zza(zzab, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.zzOu.size() > 0) {
                length++;
            }
            if (length + this.zzOu.size() > zzah.this.zzif().zzjq()) {
                return false;
            }
            try {
                if (this.zzOu.size() > 0) {
                    this.zzOu.write(zzah.zzOs);
                }
                this.zzOu.write(bytes);
                this.zzOt++;
                return true;
            } catch (IOException e) {
                zzah.this.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public int zzkx() {
            return this.zzOt;
        }
    }

    zzah(zzf zzf) {
        super(zzf);
        this.zzOr = new zzaj(zzf.zzid());
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e A[SYNTHETIC, Splitter:B:26:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0082 A[SYNTHETIC, Splitter:B:35:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int zza(java.net.URL r6, byte[] r7) {
        /*
            r5 = this;
            r1 = 0
            com.google.android.gms.common.internal.zzx.zzv(r6)
            com.google.android.gms.common.internal.zzx.zzv(r7)
            java.lang.String r0 = "POST bytes, url"
            int r2 = r7.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.zzb(r0, r2, r6)
            boolean r0 = r5.zzin()
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = "Post payload\n"
            java.lang.String r2 = new java.lang.String
            r2.<init>(r7)
            r5.zza(r0, r2)
        L_0x0021:
            java.net.HttpURLConnection r2 = r5.zzc(r6)     // Catch:{ IOException -> 0x0064, all -> 0x007e }
            r0 = 1
            r2.setDoOutput(r0)     // Catch:{ IOException -> 0x0094 }
            int r0 = r7.length     // Catch:{ IOException -> 0x0094 }
            r2.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x0094 }
            r2.connect()     // Catch:{ IOException -> 0x0094 }
            java.io.OutputStream r1 = r2.getOutputStream()     // Catch:{ IOException -> 0x0094 }
            r1.write(r7)     // Catch:{ IOException -> 0x0094 }
            r5.zzb(r2)     // Catch:{ IOException -> 0x0094 }
            int r0 = r2.getResponseCode()     // Catch:{ IOException -> 0x0094 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L_0x0049
            com.google.android.gms.analytics.internal.zzb r3 = r5.zzhz()     // Catch:{ IOException -> 0x0094 }
            r3.zzhZ()     // Catch:{ IOException -> 0x0094 }
        L_0x0049:
            java.lang.String r3 = "POST status"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x0094 }
            r5.zzb(r3, r4)     // Catch:{ IOException -> 0x0094 }
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ IOException -> 0x005d }
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.disconnect()
        L_0x005c:
            return r0
        L_0x005d:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.zze(r3, r1)
            goto L_0x0057
        L_0x0064:
            r0 = move-exception
            r2 = r1
        L_0x0066:
            java.lang.String r3 = "Network POST connection error"
            r5.zzd(r3, r0)     // Catch:{ all -> 0x0092 }
            r0 = 0
            if (r1 == 0) goto L_0x0071
            r1.close()     // Catch:{ IOException -> 0x0077 }
        L_0x0071:
            if (r2 == 0) goto L_0x005c
            r2.disconnect()
            goto L_0x005c
        L_0x0077:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.zze(r3, r1)
            goto L_0x0071
        L_0x007e:
            r0 = move-exception
            r2 = r1
        L_0x0080:
            if (r1 == 0) goto L_0x0085
            r1.close()     // Catch:{ IOException -> 0x008b }
        L_0x0085:
            if (r2 == 0) goto L_0x008a
            r2.disconnect()
        L_0x008a:
            throw r0
        L_0x008b:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.zze(r3, r1)
            goto L_0x0085
        L_0x0092:
            r0 = move-exception
            goto L_0x0080
        L_0x0094:
            r0 = move-exception
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zza(java.net.URL, byte[]):int");
    }

    private static String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    private void zza(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int zzb(URL url) {
        int i;
        zzx.zzv(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection zzc = zzc(url);
            zzc.connect();
            zzb(zzc);
            i = zzc.getResponseCode();
            if (i == 200) {
                zzhz().zzhZ();
            }
            zzb("GET status", Integer.valueOf(i));
            if (zzc != null) {
                zzc.disconnect();
            }
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            i = 0;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af A[SYNTHETIC, Splitter:B:35:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3 A[SYNTHETIC, Splitter:B:44:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int zzb(java.net.URL r9, byte[] r10) {
        /*
            r8 = this;
            r1 = 0
            com.google.android.gms.common.internal.zzx.zzv(r9)
            com.google.android.gms.common.internal.zzx.zzv(r10)
            byte[] r0 = zzg(r10)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.String r2 = "POST compressed size, ratio %, url"
            int r3 = r0.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r4 = 100
            int r6 = r0.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            long r6 = (long) r6     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            long r4 = r4 * r6
            int r6 = r10.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            long r6 = (long) r6     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r8.zza(r2, r3, r4, r9)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            int r2 = r0.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            int r3 = r10.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            if (r2 <= r3) goto L_0x0034
            java.lang.String r2 = "Compressed payload is larger then uncompressed. compressed, uncompressed"
            int r3 = r0.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            int r4 = r10.length     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r8.zzc(r2, r3, r4)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
        L_0x0034:
            boolean r2 = r8.zzin()     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            if (r2 == 0) goto L_0x0057
            java.lang.String r2 = "Post payload"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r3.<init>()     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.String r4 = "\n"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r4.<init>(r10)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r8.zza(r2, r3)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
        L_0x0057:
            java.net.HttpURLConnection r3 = r8.zzc(r9)     // Catch:{ IOException -> 0x00a5, all -> 0x00bf }
            r2 = 1
            r3.setDoOutput(r2)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r4 = "gzip"
            r3.addRequestProperty(r2, r4)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            int r2 = r0.length     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r3.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r3.connect()     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            java.io.OutputStream r2 = r3.getOutputStream()     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r2.write(r0)     // Catch:{ IOException -> 0x00de, all -> 0x00d5 }
            r2.close()     // Catch:{ IOException -> 0x00de, all -> 0x00d5 }
            r2 = 0
            r8.zzb(r3)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            int r0 = r3.getResponseCode()     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 != r4) goto L_0x008a
            com.google.android.gms.analytics.internal.zzb r4 = r8.zzhz()     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r4.zzhZ()     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
        L_0x008a:
            java.lang.String r4 = "POST status"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            r8.zzb(r4, r5)     // Catch:{ IOException -> 0x00db, all -> 0x00d3 }
            if (r1 == 0) goto L_0x0098
            r2.close()     // Catch:{ IOException -> 0x009e }
        L_0x0098:
            if (r3 == 0) goto L_0x009d
            r3.disconnect()
        L_0x009d:
            return r0
        L_0x009e:
            r1 = move-exception
            java.lang.String r2 = "Error closing http compressed post connection output stream"
            r8.zze(r2, r1)
            goto L_0x0098
        L_0x00a5:
            r0 = move-exception
            r2 = r1
        L_0x00a7:
            java.lang.String r3 = "Network compressed POST connection error"
            r8.zzd(r3, r0)     // Catch:{ all -> 0x00d8 }
            r0 = 0
            if (r1 == 0) goto L_0x00b2
            r1.close()     // Catch:{ IOException -> 0x00b8 }
        L_0x00b2:
            if (r2 == 0) goto L_0x009d
            r2.disconnect()
            goto L_0x009d
        L_0x00b8:
            r1 = move-exception
            java.lang.String r3 = "Error closing http compressed post connection output stream"
            r8.zze(r3, r1)
            goto L_0x00b2
        L_0x00bf:
            r0 = move-exception
            r3 = r1
        L_0x00c1:
            if (r1 == 0) goto L_0x00c6
            r1.close()     // Catch:{ IOException -> 0x00cc }
        L_0x00c6:
            if (r3 == 0) goto L_0x00cb
            r3.disconnect()
        L_0x00cb:
            throw r0
        L_0x00cc:
            r1 = move-exception
            java.lang.String r2 = "Error closing http compressed post connection output stream"
            r8.zze(r2, r1)
            goto L_0x00c6
        L_0x00d3:
            r0 = move-exception
            goto L_0x00c1
        L_0x00d5:
            r0 = move-exception
            r1 = r2
            goto L_0x00c1
        L_0x00d8:
            r0 = move-exception
            r3 = r2
            goto L_0x00c1
        L_0x00db:
            r0 = move-exception
            r2 = r3
            goto L_0x00a7
        L_0x00de:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zzb(java.net.URL, byte[]):int");
    }

    private URL zzb(zzab zzab, String str) {
        try {
            return new URL(zzab.zzkm() ? zzif().zzjy() + zzif().zzjA() + "?" + str : zzif().zzjz() + zzif().zzjA() + "?" + str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void zzb(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private boolean zzg(zzab zzab) {
        zzx.zzv(zzab);
        String zza2 = zza(zzab, !zzab.zzkm());
        if (zza2 == null) {
            zzie().zza(zzab, "Error formatting hit for upload");
            return true;
        } else if (zza2.length() <= zzif().zzjn()) {
            URL zzb = zzb(zzab, zza2);
            if (zzb != null) {
                return zzb(zzb) == 200;
            }
            zzbc("Failed to build collect GET endpoint url");
            return false;
        } else {
            String zza3 = zza(zzab, false);
            if (zza3 == null) {
                zzie().zza(zzab, "Error formatting hit for POST upload");
                return true;
            }
            byte[] bytes = zza3.getBytes();
            if (bytes.length > zzif().zzjp()) {
                zzie().zza(zzab, "Hit payload exceeds size limit");
                return true;
            }
            URL zzh = zzh(zzab);
            if (zzh != null) {
                return zza(zzh, bytes) == 200;
            }
            zzbc("Failed to build collect POST endpoint url");
            return false;
        }
    }

    private static byte[] zzg(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL zzh(zzab zzab) {
        try {
            return new URL(zzab.zzkm() ? zzif().zzjy() + zzif().zzjA() : zzif().zzjz() + zzif().zzjA());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String zzi(zzab zzab) {
        return String.valueOf(zzab.zzkj());
    }

    private URL zzkv() {
        try {
            return new URL(zzif().zzjy() + zzif().zzjB());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public String zza(zzab zzab, boolean z) {
        zzx.zzv(zzab);
        StringBuilder sb = new StringBuilder();
        try {
            for (Entry entry : zzab.zzn().entrySet()) {
                String str = (String) entry.getKey();
                if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str) && !"z".equals(str) && !"_gmsv".equals(str)) {
                    zza(sb, str, (String) entry.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzab.zzkk()));
            zza(sb, "qt", String.valueOf(zzid().currentTimeMillis() - zzab.zzkk()));
            if (zzif().zzjk()) {
                zza(sb, "_gmsv", zze.VERSION);
            }
            if (z) {
                long zzkn = zzab.zzkn();
                zza(sb, "z", zzkn != 0 ? String.valueOf(zzkn) : zzi(zzab));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public List<Long> zza(List<zzab> list, boolean z) {
        zzx.zzZ(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza zza2 = new zza();
        ArrayList arrayList = new ArrayList();
        for (zzab zzab : list) {
            if (!zza2.zzj(zzab)) {
                break;
            }
            arrayList.add(Long.valueOf(zzab.zzkj()));
        }
        if (zza2.zzkx() == 0) {
            return arrayList;
        }
        URL zzkv = zzkv();
        if (zzkv == null) {
            zzbc("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int zza3 = z ? zzb(zzkv, zza2.getPayload()) : zza(zzkv, zza2.getPayload());
        if (200 == zza3) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(zza2.zzkx()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(zza3));
        if (zzif().zzjE().contains(Integer.valueOf(zza3))) {
            zzbb("Server instructed the client to stop batching");
            this.zzOr.start();
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: 0000 */
    public HttpURLConnection zzc(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzif().zzjN());
        httpURLConnection.setReadTimeout(zzif().zzjO());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzHj);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    public List<Long> zzf(List<zzab> list) {
        boolean z;
        boolean z2 = true;
        zzic();
        zzio();
        zzx.zzv(list);
        if (zzif().zzjE().isEmpty() || !this.zzOr.zzv(zzif().zzjx() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = zzif().zzjC() != zzm.NONE;
            if (zzif().zzjD() != zzo.GZIP) {
                z2 = false;
            }
        }
        return z ? zza(list, z2) : zzg(list);
    }

    /* access modifiers changed from: 0000 */
    public List<Long> zzg(List<zzab> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (zzab zzab : list) {
            if (zzg(zzab)) {
                arrayList.add(Long.valueOf(zzab.zzkj()));
                if (arrayList.size() >= zzif().zzjv()) {
                    break;
                }
            } else {
                break;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void zzhB() {
        zza("Network initialized. User agent", this.zzHj);
    }

    public boolean zzku() {
        NetworkInfo networkInfo;
        zzic();
        zzio();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzaY("No network connectivity");
        return false;
    }
}
