package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj.zza;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzdv.zzb;
import com.google.android.gms.internal.zzdv.zzc;
import com.google.android.gms.internal.zzdv.zzd;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzgk
public final class zzgm extends zza {
    private static zzgm zzEL;
    private static final Object zzpm = new Object();
    private final Context mContext;
    private final zzgl zzEM;
    private final zzbr zzEN;
    private final zzdv zzqU;

    zzgm(Context context, zzbr zzbr, zzgl zzgl) {
        this.mContext = context;
        this.zzEM = zzgl;
        this.zzEN = zzbr;
        this.zzqU = new zzdv(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(7895000, 7895000, true), zzbr.zzdb(), new zzb<zzbb>() {
            /* renamed from: zza */
            public void zzc(zzbb zzbb) {
                zzbb.zza("/log", zzdf.zzwP);
            }
        }, new zzc());
    }

    private static AdResponseParcel zza(Context context, zzdv zzdv, zzbr zzbr, zzgl zzgl, AdRequestInfoParcel adRequestInfoParcel) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Starting ad request from service.");
        zzby.zzw(context);
        final zzcd zzcd = new zzcd(((Boolean) zzby.zzuB.get()).booleanValue(), "load_ad", adRequestInfoParcel.zzqf.zzsG);
        if (adRequestInfoParcel.versionCode > 10 && adRequestInfoParcel.zzDT != -1) {
            zzcd.zza(zzcd.zzb(adRequestInfoParcel.zzDT), "cts");
        }
        zzcc zzdl = zzcd.zzdl();
        zzgl.zzEH.init();
        zzgr zzD = zzp.zzbD().zzD(context);
        if (zzD.zzFN == -1) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzDQ : UUID.randomUUID().toString();
        final zzgo zzgo = new zzgo(uuid, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzDy.extras != null) {
            String string = adRequestInfoParcel.zzDy.extras.getString("_ad");
            if (string != null) {
                return zzgn.zza(context, adRequestInfoParcel, string);
            }
        }
        Location zzc = zzgl.zzEH.zzc(250);
        String zzc2 = zzgl.zzEI.zzc(context, adRequestInfoParcel.zzDz.packageName);
        List zza = zzgl.zzEG.zza(adRequestInfoParcel);
        JSONObject zza2 = zzgn.zza(context, adRequestInfoParcel, zzD, zzgl.zzEK.zzE(context), zzc, zzbr, zzc2, zzgl.zzEJ.zzau(adRequestInfoParcel.zzDA), zza);
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                zza2.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        if (zza2 == null) {
            return new AdResponseParcel(0);
        }
        final String jSONObject = zza2.toString();
        zzcd.zza(zzdl, "arc");
        final zzcc zzdl2 = zzcd.zzdl();
        if (((Boolean) zzby.zztX.get()).booleanValue()) {
            final zzdv zzdv2 = zzdv;
            final zzgo zzgo2 = zzgo;
            final zzcd zzcd2 = zzcd;
            zzhu.zzHK.post(new Runnable() {
                public void run() {
                    zzd zzdL = zzdv2.zzdL();
                    zzgo2.zzb(zzdL);
                    zzcd2.zza(zzdl2, "rwc");
                    final zzcc zzdl = zzcd2.zzdl();
                    zzdL.zza(new zzij.zzc<zzbe>() {
                        /* renamed from: zzb */
                        public void zzc(zzbe zzbe) {
                            zzcd2.zza(zzdl, "jsf");
                            zzcd2.zzdm();
                            zzbe.zza("/invalidRequest", zzgo2.zzFc);
                            zzbe.zza("/loadAdURL", zzgo2.zzFd);
                            try {
                                zzbe.zza("AFMA_buildAdURL", jSONObject);
                            } catch (Exception e) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", e);
                            }
                        }
                    }, new zzij.zza() {
                        public void run() {
                        }
                    });
                }
            });
        } else {
            final Context context2 = context;
            final AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
            final zzcc zzcc = zzdl2;
            final String str = jSONObject;
            final zzbr zzbr2 = zzbr;
            zzhu.zzHK.post(new Runnable() {
                public void run() {
                    zzip zza = zzp.zzby().zza(context2, new AdSizeParcel(), false, false, null, adRequestInfoParcel2.zzqb);
                    if (zzp.zzbA().zzgi()) {
                        zza.getWebView().clearCache(true);
                    }
                    zza.setWillNotDraw(true);
                    zzgo.zze(zza);
                    zzcd.zza(zzcc, "rwc");
                    zziq.zza zzb = zzgm.zza(str, zzcd, zzcd.zzdl());
                    zziq zzgS = zza.zzgS();
                    zzgS.zza("/invalidRequest", zzgo.zzFc);
                    zzgS.zza("/loadAdURL", zzgo.zzFd);
                    zzgS.zza("/log", zzdf.zzwP);
                    zzgS.zza(zzb);
                    com.google.android.gms.ads.internal.util.client.zzb.zzaC("Loading the JS library.");
                    zza.loadUrl(zzbr2.zzdb());
                }
            });
        }
        try {
            zzgq zzgq = (zzgq) zzgo.zzfI().get(10, TimeUnit.SECONDS);
            if (zzgq == null) {
                return new AdResponseParcel(0);
            }
            if (zzgq.getErrorCode() != -2) {
                AdResponseParcel adResponseParcel = new AdResponseParcel(zzgq.getErrorCode());
                zzhu.zzHK.post(new Runnable() {
                    public void run() {
                        zzgo.zzfJ();
                        if (zzgo.zzfH() != null) {
                            zzgo.zzfH().release();
                        }
                    }
                });
                return adResponseParcel;
            }
            if (zzcd.zzdo() != null) {
                zzcd.zza(zzcd.zzdo(), "rur");
            }
            String str2 = null;
            if (zzgq.zzfM()) {
                str2 = zzgl.zzEF.zzat(adRequestInfoParcel.zzDz.packageName);
            }
            AdResponseParcel zza3 = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzqb.zzIz, zzgq.getUrl(), str2, zzc2, zzgq, zzcd);
            if (zza3.zzEj == 1) {
                zzgl.zzEI.clearToken(context, adRequestInfoParcel.zzDz.packageName);
            }
            zzcd.zza(zzdl, "tts");
            zza3.zzEl = zzcd.zzdn();
            zzhu.zzHK.post(new Runnable() {
                public void run() {
                    zzgo.zzfJ();
                    if (zzgo.zzfH() != null) {
                        zzgo.zzfH().release();
                    }
                }
            });
            return zza3;
        } catch (Exception e2) {
            return new AdResponseParcel(0);
        } finally {
            zzhu.zzHK.post(new Runnable() {
                public void run() {
                    zzgo.zzfJ();
                    if (zzgo.zzfH() != null) {
                        zzgo.zzfH().release();
                    }
                }
            });
        }
    }

    /* JADX INFO: used method not loaded: com.google.android.gms.internal.zzgp.zzj(long):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ac, code lost:
        r4 = r5.toString();
        r5 = com.google.android.gms.ads.internal.zzp.zzbx().zza(new java.io.InputStreamReader(r2.getInputStream()));
        zza(r4, r10, r5, r7);
        r6.zzb(r4, r10, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c7, code lost:
        if (r20 == null) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c9, code lost:
        r20.zza(r3, "ufe");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d6, code lost:
        r3 = r6.zzj(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("Received error HTTP response code: " + r7);
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.google.android.gms.internal.zzgq r19, com.google.android.gms.internal.zzcd r20) {
        /*
            if (r20 == 0) goto L_0x00df
            com.google.android.gms.internal.zzcc r2 = r20.zzdl()
            r3 = r2
        L_0x0007:
            com.google.android.gms.internal.zzgp r6 = new com.google.android.gms.internal.zzgp     // Catch:{ IOException -> 0x0152 }
            r6.<init>(r13)     // Catch:{ IOException -> 0x0152 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0152 }
            r2.<init>()     // Catch:{ IOException -> 0x0152 }
            java.lang.String r4 = "AdRequestServiceImpl: Sending request: "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ IOException -> 0x0152 }
            r0 = r16
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x0152 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0152 }
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r2)     // Catch:{ IOException -> 0x0152 }
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x0152 }
            r0 = r16
            r4.<init>(r0)     // Catch:{ IOException -> 0x0152 }
            r2 = 0
            com.google.android.gms.internal.zzlm r5 = com.google.android.gms.ads.internal.zzp.zzbB()     // Catch:{ IOException -> 0x0152 }
            long r8 = r5.elapsedRealtime()     // Catch:{ IOException -> 0x0152 }
            r5 = r4
            r4 = r2
        L_0x0036:
            java.net.URLConnection r2 = r5.openConnection()     // Catch:{ IOException -> 0x0152 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x0152 }
            com.google.android.gms.internal.zzhu r7 = com.google.android.gms.ads.internal.zzp.zzbx()     // Catch:{ all -> 0x0175 }
            r10 = 0
            r7.zza(r14, r15, r10, r2)     // Catch:{ all -> 0x0175 }
            boolean r7 = android.text.TextUtils.isEmpty(r17)     // Catch:{ all -> 0x0175 }
            if (r7 != 0) goto L_0x0051
            java.lang.String r7 = "x-afma-drt-cookie"
            r0 = r17
            r2.addRequestProperty(r7, r0)     // Catch:{ all -> 0x0175 }
        L_0x0051:
            boolean r7 = android.text.TextUtils.isEmpty(r18)     // Catch:{ all -> 0x0175 }
            if (r7 != 0) goto L_0x0071
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r7.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r10 = "Bearer "
            java.lang.StringBuilder r7 = r7.append(r10)     // Catch:{ all -> 0x0175 }
            r0 = r18
            java.lang.StringBuilder r7 = r7.append(r0)     // Catch:{ all -> 0x0175 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0175 }
            java.lang.String r10 = "Authorization"
            r2.addRequestProperty(r10, r7)     // Catch:{ all -> 0x0175 }
        L_0x0071:
            if (r19 == 0) goto L_0x009c
            java.lang.String r7 = r19.zzfL()     // Catch:{ all -> 0x0175 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0175 }
            if (r7 != 0) goto L_0x009c
            r7 = 1
            r2.setDoOutput(r7)     // Catch:{ all -> 0x0175 }
            java.lang.String r7 = r19.zzfL()     // Catch:{ all -> 0x0175 }
            byte[] r7 = r7.getBytes()     // Catch:{ all -> 0x0175 }
            int r10 = r7.length     // Catch:{ all -> 0x0175 }
            r2.setFixedLengthStreamingMode(r10)     // Catch:{ all -> 0x0175 }
            java.io.BufferedOutputStream r10 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0175 }
            java.io.OutputStream r11 = r2.getOutputStream()     // Catch:{ all -> 0x0175 }
            r10.<init>(r11)     // Catch:{ all -> 0x0175 }
            r10.write(r7)     // Catch:{ all -> 0x0175 }
            r10.close()     // Catch:{ all -> 0x0175 }
        L_0x009c:
            int r7 = r2.getResponseCode()     // Catch:{ all -> 0x0175 }
            java.util.Map r10 = r2.getHeaderFields()     // Catch:{ all -> 0x0175 }
            r11 = 200(0xc8, float:2.8E-43)
            if (r7 < r11) goto L_0x00e3
            r11 = 300(0x12c, float:4.2E-43)
            if (r7 >= r11) goto L_0x00e3
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0175 }
            com.google.android.gms.internal.zzhu r5 = com.google.android.gms.ads.internal.zzp.zzbx()     // Catch:{ all -> 0x0175 }
            java.io.InputStreamReader r11 = new java.io.InputStreamReader     // Catch:{ all -> 0x0175 }
            java.io.InputStream r12 = r2.getInputStream()     // Catch:{ all -> 0x0175 }
            r11.<init>(r12)     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = r5.zza(r11)     // Catch:{ all -> 0x0175 }
            zza(r4, r10, r5, r7)     // Catch:{ all -> 0x0175 }
            r6.zzb(r4, r10, r5)     // Catch:{ all -> 0x0175 }
            if (r20 == 0) goto L_0x00d6
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x0175 }
            r5 = 0
            java.lang.String r7 = "ufe"
            r4[r5] = r7     // Catch:{ all -> 0x0175 }
            r0 = r20
            r0.zza(r3, r4)     // Catch:{ all -> 0x0175 }
        L_0x00d6:
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = r6.zzj(r8)     // Catch:{ all -> 0x0175 }
            r2.disconnect()     // Catch:{ IOException -> 0x0152 }
            r2 = r3
        L_0x00de:
            return r2
        L_0x00df:
            r2 = 0
            r3 = r2
            goto L_0x0007
        L_0x00e3:
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0175 }
            r11 = 0
            zza(r5, r10, r11, r7)     // Catch:{ all -> 0x0175 }
            r5 = 300(0x12c, float:4.2E-43)
            if (r7 < r5) goto L_0x0129
            r5 = 400(0x190, float:5.6E-43)
            if (r7 >= r5) goto L_0x0129
            java.lang.String r5 = "Location"
            java.lang.String r7 = r2.getHeaderField(r5)     // Catch:{ all -> 0x0175 }
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0175 }
            if (r5 == 0) goto L_0x010f
            java.lang.String r3 = "No location header to follow redirect."
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r3)     // Catch:{ all -> 0x0175 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x0175 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0175 }
            r2.disconnect()     // Catch:{ IOException -> 0x0152 }
            r2 = r3
            goto L_0x00de
        L_0x010f:
            java.net.URL r5 = new java.net.URL     // Catch:{ all -> 0x0175 }
            r5.<init>(r7)     // Catch:{ all -> 0x0175 }
            int r4 = r4 + 1
            r7 = 5
            if (r4 <= r7) goto L_0x014a
            java.lang.String r3 = "Too many redirects."
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r3)     // Catch:{ all -> 0x0175 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x0175 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0175 }
            r2.disconnect()     // Catch:{ IOException -> 0x0152 }
            r2 = r3
            goto L_0x00de
        L_0x0129:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r3.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = "Received error HTTP response code: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0175 }
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0175 }
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r3)     // Catch:{ all -> 0x0175 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x0175 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0175 }
            r2.disconnect()     // Catch:{ IOException -> 0x0152 }
            r2 = r3
            goto L_0x00de
        L_0x014a:
            r6.zzh(r10)     // Catch:{ all -> 0x0175 }
            r2.disconnect()     // Catch:{ IOException -> 0x0152 }
            goto L_0x0036
        L_0x0152:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error while connecting to ad server: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2)
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel
            r3 = 2
            r2.<init>(r3)
            goto L_0x00de
        L_0x0175:
            r3 = move-exception
            r2.disconnect()     // Catch:{ IOException -> 0x0152 }
            throw r3     // Catch:{ IOException -> 0x0152 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgm.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzgq, com.google.android.gms.internal.zzcd):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static zzgm zza(Context context, zzbr zzbr, zzgl zzgl) {
        zzgm zzgm;
        synchronized (zzpm) {
            if (zzEL == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzEL = new zzgm(context, zzbr, zzgl);
            }
            zzgm = zzEL;
        }
        return zzgm;
    }

    /* access modifiers changed from: private */
    public static zziq.zza zza(final String str, final zzcd zzcd, final zzcc zzcc) {
        return new zziq.zza() {
            public void zza(zzip zzip, boolean z) {
                zzcd.zza(zzcc, "jsf");
                zzcd.zzdm();
                zzip.zza("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (com.google.android.gms.ads.internal.util.client.zzb.zzM(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.m20v("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.m20v("    " + str3 + ":");
                    for (String str4 : (List) map.get(str3)) {
                        com.google.android.gms.ads.internal.util.client.zzb.m20v("      " + str4);
                    }
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.m20v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    com.google.android.gms.ads.internal.util.client.zzb.m20v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.m20v("    null");
            }
            com.google.android.gms.ads.internal.util.client.zzb.m20v("  Response Code:\n    " + i + "\n}");
        }
    }

    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final zzk zzk) {
        zzp.zzbA().zzb(this.mContext, adRequestInfoParcel.zzqb);
        zzhu.zzb((Runnable) new Runnable() {
            public void run() {
                AdResponseParcel adResponseParcel;
                try {
                    adResponseParcel = zzgm.this.zze(adRequestInfoParcel);
                } catch (Exception e) {
                    zzp.zzbA().zzc((Throwable) e, true);
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response due to an Exception.", e);
                    adResponseParcel = null;
                }
                if (adResponseParcel == null) {
                    adResponseParcel = new AdResponseParcel(0);
                }
                try {
                    zzk.zzb(adResponseParcel);
                } catch (RemoteException e2) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", e2);
                }
            }
        });
    }

    public AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzqU, this.zzEN, this.zzEM, adRequestInfoParcel);
    }
}
