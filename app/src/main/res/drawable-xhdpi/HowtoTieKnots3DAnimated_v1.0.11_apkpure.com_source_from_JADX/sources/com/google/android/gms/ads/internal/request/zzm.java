package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.zza.C1331zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdv;
import com.google.android.gms.internal.zzdv.zzd;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzhq;
import com.google.android.gms.internal.zzip;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@zzgk
public class zzm extends zzhq {
    static final long zzEu = TimeUnit.SECONDS.toMillis(10);
    private static boolean zzEv = false;
    /* access modifiers changed from: private */
    public static zzdv zzEw = null;
    private static zzdh zzEx = null;
    /* access modifiers changed from: private */
    public static zzdl zzEy = null;
    private static zzdg zzEz = null;
    private static final Object zzpm = new Object();
    private final Context mContext;
    private final Object zzCE = new Object();
    /* access modifiers changed from: private */
    public final C1331zza zzDp;
    private final com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zzDq;
    /* access modifiers changed from: private */
    public zzd zzEA;

    public static class zza implements com.google.android.gms.internal.zzdv.zzb<zzbb> {
        /* renamed from: zza */
        public void zzc(zzbb zzbb) {
            zzm.zzd(zzbb);
        }
    }

    public static class zzb implements com.google.android.gms.internal.zzdv.zzb<zzbb> {
        /* renamed from: zza */
        public void zzc(zzbb zzbb) {
            zzm.zzc(zzbb);
        }
    }

    public static class zzc implements zzdg {
        public void zza(zzip zzip, Map<String, String> map) {
            String str = (String) map.get("request_id");
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Invalid request: " + ((String) map.get("errors")));
            zzm.zzEy.zzX(str);
        }
    }

    public zzm(Context context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zza2, C1331zza zza3) {
        this.zzDp = zza3;
        this.mContext = context;
        this.zzDq = zza2;
        synchronized (zzpm) {
            if (!zzEv) {
                zzEy = new zzdl();
                zzEx = new zzdh(context.getApplicationContext(), zza2.zzqb);
                zzEz = new zzc();
                zzEw = new zzdv(this.mContext.getApplicationContext(), this.zzDq.zzqb, (String) zzby.zztW.get(), new zzb(), new zza());
                zzEv = true;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [org.json.JSONObject, com.google.android.gms.internal.zzgt$zza] */
    /* JADX WARNING: type inference failed for: r4v0, types: [android.location.Location] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7, types: [com.google.android.gms.ads.identifier.AdvertisingIdClient$Info] */
    /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.ads.identifier.AdvertisingIdClient$Info] */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v0, types: [org.json.JSONObject, com.google.android.gms.internal.zzgt$zza]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [org.json.JSONObject, ?[OBJECT, ARRAY], com.google.android.gms.internal.zzgt$zza]
      mth insns count: 59
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r12, java.lang.String r13) {
        /*
            r11 = this;
            r3 = 0
            com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r12.zzDy
            android.os.Bundle r0 = r0.extras
            java.lang.String r1 = "sdk_less_server_data"
            android.os.Bundle r9 = r0.getBundle(r1)
            com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r12.zzDy
            android.os.Bundle r0 = r0.extras
            java.lang.String r1 = "sdk_less_network_id"
            java.lang.String r10 = r0.getString(r1)
            if (r9 != 0) goto L_0x0018
        L_0x0017:
            return r3
        L_0x0018:
            android.content.Context r0 = r11.mContext
            com.google.android.gms.internal.zzgs r1 = com.google.android.gms.ads.internal.zzp.zzbD()
            android.content.Context r2 = r11.mContext
            com.google.android.gms.internal.zzgr r2 = r1.zzD(r2)
            com.google.android.gms.internal.zzbr r5 = new com.google.android.gms.internal.zzbr
            com.google.android.gms.internal.zzbu<java.lang.String> r1 = com.google.android.gms.internal.zzby.zztW
            java.lang.Object r1 = r1.get()
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r1)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r1 = r12
            r4 = r3
            r6 = r3
            r7 = r3
            org.json.JSONObject r1 = com.google.android.gms.internal.zzgn.zza(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 == 0) goto L_0x0017
            android.content.Context r0 = r11.mContext     // Catch:{ IOException -> 0x0093, IllegalStateException -> 0x008f, GooglePlayServicesNotAvailableException -> 0x0091, GooglePlayServicesRepairableException -> 0x0083 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r0)     // Catch:{ IOException -> 0x0093, IllegalStateException -> 0x008f, GooglePlayServicesNotAvailableException -> 0x0091, GooglePlayServicesRepairableException -> 0x0083 }
        L_0x0046:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r4 = "request_id"
            r2.put(r4, r13)
            java.lang.String r4 = "network_id"
            r2.put(r4, r10)
            java.lang.String r4 = "request_param"
            r2.put(r4, r1)
            java.lang.String r1 = "data"
            r2.put(r1, r9)
            if (r0 == 0) goto L_0x007a
            java.lang.String r1 = "adid"
            java.lang.String r4 = r0.getId()
            r2.put(r1, r4)
            java.lang.String r1 = "lat"
            boolean r0 = r0.isLimitAdTrackingEnabled()
            if (r0 == 0) goto L_0x008b
            r0 = 1
        L_0x0073:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.put(r1, r0)
        L_0x007a:
            com.google.android.gms.internal.zzhu r0 = com.google.android.gms.ads.internal.zzp.zzbx()     // Catch:{ JSONException -> 0x008d }
            org.json.JSONObject r3 = r0.zzx(r2)     // Catch:{ JSONException -> 0x008d }
            goto L_0x0017
        L_0x0083:
            r0 = move-exception
        L_0x0084:
            java.lang.String r2 = "Cannot get advertising id info"
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r2, r0)
            r0 = r3
            goto L_0x0046
        L_0x008b:
            r0 = 0
            goto L_0x0073
        L_0x008d:
            r0 = move-exception
            goto L_0x0017
        L_0x008f:
            r0 = move-exception
            goto L_0x0084
        L_0x0091:
            r0 = move-exception
            goto L_0x0084
        L_0x0093:
            r0 = move-exception
            goto L_0x0084
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.zzm.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, java.lang.String):org.json.JSONObject");
    }

    protected static void zzc(zzbb zzbb) {
        zzbb.zza("/loadAd", (zzdg) zzEy);
        zzbb.zza("/fetchHttpRequest", (zzdg) zzEx);
        zzbb.zza("/invalidRequest", zzEz);
    }

    protected static void zzd(zzbb zzbb) {
        zzbb.zzb("/loadAd", (zzdg) zzEy);
        zzbb.zzb("/fetchHttpRequest", (zzdg) zzEx);
        zzbb.zzb("/invalidRequest", zzEz);
    }

    private AdResponseParcel zzf(AdRequestInfoParcel adRequestInfoParcel) {
        final String uuid = UUID.randomUUID().toString();
        final JSONObject zza2 = zza(adRequestInfoParcel, uuid);
        if (zza2 == null) {
            return new AdResponseParcel(0);
        }
        long elapsedRealtime = zzp.zzbB().elapsedRealtime();
        Future zzW = zzEy.zzW(uuid);
        com.google.android.gms.ads.internal.util.client.zza.zzIy.post(new Runnable() {
            public void run() {
                zzm.this.zzEA = zzm.zzEw.zzdL();
                zzm.this.zzEA.zza(new com.google.android.gms.internal.zzij.zzc<zzbe>() {
                    /* renamed from: zzb */
                    public void zzc(zzbe zzbe) {
                        try {
                            zzbe.zza("AFMA_getAdapterLessMediationAd", zza2);
                        } catch (Exception e) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", e);
                            zzm.zzEy.zzX(uuid);
                        }
                    }
                }, new com.google.android.gms.internal.zzij.zza() {
                    public void run() {
                        zzm.zzEy.zzX(uuid);
                    }
                });
            }
        });
        try {
            JSONObject jSONObject = (JSONObject) zzW.get(zzEu - (zzp.zzbB().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel zza3 = zzgn.zza(this.mContext, adRequestInfoParcel, jSONObject.toString());
            return (zza3.errorCode == -3 || !TextUtils.isEmpty(zza3.body)) ? zza3 : new AdResponseParcel(3);
        } catch (InterruptedException | CancellationException e) {
            return new AdResponseParcel(-1);
        } catch (TimeoutException e2) {
            return new AdResponseParcel(2);
        } catch (ExecutionException e3) {
            return new AdResponseParcel(0);
        }
    }

    public void onStop() {
        synchronized (this.zzCE) {
            com.google.android.gms.ads.internal.util.client.zza.zzIy.post(new Runnable() {
                public void run() {
                    if (zzm.this.zzEA != null) {
                        zzm.this.zzEA.release();
                        zzm.this.zzEA = null;
                    }
                }
            });
        }
    }

    public void zzdG() {
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.zzDq, null, null, -1);
        AdResponseParcel zzf = zzf(adRequestInfoParcel);
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        final com.google.android.gms.internal.zzhj.zza zza2 = new com.google.android.gms.internal.zzhj.zza(adRequestInfoParcel2, zzf, null, null, zzf.errorCode, zzp.zzbB().elapsedRealtime(), zzf.zzEb, null);
        com.google.android.gms.ads.internal.util.client.zza.zzIy.post(new Runnable() {
            public void run() {
                zzm.this.zzDp.zza(zza2);
                if (zzm.this.zzEA != null) {
                    zzm.this.zzEA.release();
                    zzm.this.zzEA = null;
                }
            }
        });
    }
}
