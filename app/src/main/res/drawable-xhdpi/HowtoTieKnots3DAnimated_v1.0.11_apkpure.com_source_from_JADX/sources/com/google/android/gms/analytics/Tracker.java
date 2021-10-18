package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzok;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Tracker extends zzd {
    private boolean zzKH;
    private final Map<String, String> zzKI = new HashMap();
    /* access modifiers changed from: private */
    public final zzad zzKJ;
    /* access modifiers changed from: private */
    public final zza zzKK;
    private ExceptionReporter zzKL;
    /* access modifiers changed from: private */
    public zzal zzKM;
    private final Map<String, String> zzvs = new HashMap();

    private class zza extends zzd implements zza {
        private boolean zzKV;
        private int zzKW;
        private long zzKX = -1;
        private boolean zzKY;
        private long zzKZ;

        protected zza(zzf zzf) {
            super(zzf);
        }

        private void zzhF() {
            if (this.zzKX >= 0 || this.zzKV) {
                zzhu().zza(Tracker.this.zzKK);
            } else {
                zzhu().zzb(Tracker.this.zzKK);
            }
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.zzKV = enabled;
            zzhF();
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.zzKX = sessionTimeout;
            zzhF();
        }

        /* access modifiers changed from: protected */
        public void zzhB() {
        }

        public synchronized boolean zzhE() {
            boolean z;
            z = this.zzKY;
            this.zzKY = false;
            return z;
        }

        /* access modifiers changed from: 0000 */
        public boolean zzhG() {
            return zzid().elapsedRealtime() >= this.zzKZ + Math.max(1000, this.zzKX);
        }

        public void zzo(Activity activity) {
            if (this.zzKW == 0 && zzhG()) {
                this.zzKY = true;
            }
            this.zzKW++;
            if (this.zzKV) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Tracker.this.setCampaignParamsOnNextHit(intent.getData());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                Tracker.this.set("&cd", Tracker.this.zzKM != null ? Tracker.this.zzKM.zzr(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    String zzq = Tracker.zzq(activity);
                    if (!TextUtils.isEmpty(zzq)) {
                        hashMap.put("&dr", zzq);
                    }
                }
                Tracker.this.send(hashMap);
            }
        }

        public void zzp(Activity activity) {
            this.zzKW--;
            this.zzKW = Math.max(0, this.zzKW);
            if (this.zzKW == 0) {
                this.zzKZ = zzid().elapsedRealtime();
            }
        }
    }

    Tracker(zzf analytics, String trackingId, zzad rateLimiter) {
        super(analytics);
        if (trackingId != null) {
            this.zzvs.put("&tid", trackingId);
        }
        this.zzvs.put("useSecure", "1");
        this.zzvs.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        if (rateLimiter == null) {
            this.zzKJ = new zzad("tracking");
        } else {
            this.zzKJ = rateLimiter;
        }
        this.zzKK = new zza(analytics);
    }

    private static void zza(Map<String, String> map, Map<String, String> map2) {
        zzx.zzv(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String zzb = zzb(entry);
                if (zzb != null) {
                    map2.put(zzb, entry.getValue());
                }
            }
        }
    }

    private static boolean zza(Entry<String, String> entry) {
        String str = (String) entry.getKey();
        String str2 = (String) entry.getValue();
        return str.startsWith("&") && str.length() >= 2;
    }

    private static String zzb(Entry<String, String> entry) {
        if (!zza(entry)) {
            return null;
        }
        return ((String) entry.getKey()).substring(1);
    }

    private static void zzb(Map<String, String> map, Map<String, String> map2) {
        zzx.zzv(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String zzb = zzb(entry);
                if (zzb != null && !map2.containsKey(zzb)) {
                    map2.put(zzb, entry.getValue());
                }
            }
        }
    }

    private boolean zzhC() {
        return this.zzKL != null;
    }

    static String zzq(Activity activity) {
        zzx.zzv(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        return null;
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        this.zzKH = enabled;
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.zzKK.enableAutoActivityTracking(enabled);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enableExceptionReporting(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzhC()     // Catch:{ all -> 0x0026 }
            if (r0 != r4) goto L_0x0009
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
        L_0x0008:
            return
        L_0x0009:
            if (r4 == 0) goto L_0x0029
            android.content.Context r0 = r3.getContext()     // Catch:{ all -> 0x0026 }
            java.lang.Thread$UncaughtExceptionHandler r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch:{ all -> 0x0026 }
            com.google.android.gms.analytics.ExceptionReporter r2 = new com.google.android.gms.analytics.ExceptionReporter     // Catch:{ all -> 0x0026 }
            r2.<init>(r3, r1, r0)     // Catch:{ all -> 0x0026 }
            r3.zzKL = r2     // Catch:{ all -> 0x0026 }
            com.google.android.gms.analytics.ExceptionReporter r0 = r3.zzKL     // Catch:{ all -> 0x0026 }
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r0)     // Catch:{ all -> 0x0026 }
            java.lang.String r0 = "Uncaught exceptions will be reported to Google Analytics"
            r3.zzaY(r0)     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            goto L_0x0008
        L_0x0026:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            throw r0
        L_0x0029:
            com.google.android.gms.analytics.ExceptionReporter r0 = r3.zzKL     // Catch:{ all -> 0x0026 }
            java.lang.Thread$UncaughtExceptionHandler r0 = r0.zzhv()     // Catch:{ all -> 0x0026 }
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r0)     // Catch:{ all -> 0x0026 }
            java.lang.String r0 = "Uncaught exceptions will not be reported to Google Analytics"
            r3.zzaY(r0)     // Catch:{ all -> 0x0026 }
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.Tracker.enableExceptionReporting(boolean):void");
    }

    public String get(String key) {
        zzio();
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.zzvs.containsKey(key)) {
            return (String) this.zzvs.get(key);
        }
        if (key.equals("&ul")) {
            return zzam.zza(Locale.getDefault());
        }
        if (key.equals("&cid")) {
            return zzij().zzjd();
        }
        if (key.equals("&sr")) {
            return zzim().zzjT();
        }
        if (key.equals("&aid")) {
            return zzil().zziL().zztW();
        }
        if (key.equals("&an")) {
            return zzil().zziL().zzjZ();
        }
        if (key.equals("&av")) {
            return zzil().zziL().zzkb();
        }
        if (key.equals("&aiid")) {
            return zzil().zziL().zzxA();
        }
        return null;
    }

    public void send(Map<String, String> params) {
        final long currentTimeMillis = zzid().currentTimeMillis();
        if (zzhu().getAppOptOut()) {
            zzaZ("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        final boolean isDryRunEnabled = zzhu().isDryRunEnabled();
        final HashMap hashMap = new HashMap();
        zza(this.zzvs, hashMap);
        zza(params, hashMap);
        final boolean zze = zzam.zze((String) this.zzvs.get("useSecure"), true);
        zzb(this.zzKI, hashMap);
        this.zzKI.clear();
        final String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            zzie().zzh(hashMap, "Missing hit type parameter");
            return;
        }
        final String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zzie().zzh(hashMap, "Missing tracking id parameter");
            return;
        }
        final boolean zzhD = zzhD();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt((String) this.zzvs.get("&a")) + 1;
                if (parseInt >= Integer.MAX_VALUE) {
                    parseInt = 1;
                }
                this.zzvs.put("&a", Integer.toString(parseInt));
            }
        }
        zzig().zzf(new Runnable() {
            public void run() {
                boolean z = true;
                if (Tracker.this.zzKK.zzhE()) {
                    hashMap.put("sc", "start");
                }
                zzam.zzc(hashMap, "cid", Tracker.this.zzhu().getClientId());
                String str = (String) hashMap.get("sf");
                if (str != null) {
                    double zza = zzam.zza(str, 100.0d);
                    if (zzam.zza(zza, (String) hashMap.get("cid"))) {
                        Tracker.this.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(zza));
                        return;
                    }
                }
                com.google.android.gms.analytics.internal.zza zzb = Tracker.this.zzik();
                if (zzhD) {
                    zzam.zzb(hashMap, "ate", zzb.zzhM());
                    zzam.zzb(hashMap, "adid", zzb.zzhQ());
                } else {
                    hashMap.remove("ate");
                    hashMap.remove("adid");
                }
                zzok zziL = Tracker.this.zzil().zziL();
                zzam.zzb(hashMap, "an", zziL.zzjZ());
                zzam.zzb(hashMap, "av", zziL.zzkb());
                zzam.zzb(hashMap, "aid", zziL.zztW());
                zzam.zzb(hashMap, "aiid", zziL.zzxA());
                hashMap.put("v", "1");
                hashMap.put("_v", zze.zzLB);
                zzam.zzb(hashMap, "ul", Tracker.this.zzim().zzjS().getLanguage());
                zzam.zzb(hashMap, "sr", Tracker.this.zzim().zzjT());
                if ((str.equals("transaction") || str.equals("item")) || Tracker.this.zzKJ.zzkp()) {
                    long zzbo = zzam.zzbo((String) hashMap.get("ht"));
                    if (zzbo == 0) {
                        zzbo = currentTimeMillis;
                    }
                    if (isDryRunEnabled) {
                        Tracker.this.zzie().zzc("Dry run enabled. Would have sent hit", new zzab(Tracker.this, hashMap, zzbo, zze));
                        return;
                    }
                    String str2 = (String) hashMap.get("cid");
                    HashMap hashMap = new HashMap();
                    zzam.zza((Map<String, String>) hashMap, "uid", hashMap);
                    zzam.zza((Map<String, String>) hashMap, "an", hashMap);
                    zzam.zza((Map<String, String>) hashMap, "aid", hashMap);
                    zzam.zza((Map<String, String>) hashMap, "av", hashMap);
                    zzam.zza((Map<String, String>) hashMap, "aiid", hashMap);
                    String str3 = str2;
                    if (TextUtils.isEmpty((CharSequence) hashMap.get("adid"))) {
                        z = false;
                    }
                    hashMap.put("_s", String.valueOf(Tracker.this.zzhz().zza(new zzh(0, str2, str3, z, 0, hashMap))));
                    Tracker.this.zzhz().zza(new zzab(Tracker.this, hashMap, zzbo, zze));
                    return;
                }
                Tracker.this.zzie().zzh(hashMap, "Too many hits sent too quickly, rate limiting invoked");
            }
        });
    }

    public void set(String key, String value) {
        zzx.zzb(key, (Object) "Key should be non-null");
        if (!TextUtils.isEmpty(key)) {
            this.zzvs.put(key, value);
        }
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", zzam.zzJ(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            String queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                Uri parse = Uri.parse("http://hostname/?" + queryParameter);
                String queryParameter2 = parse.getQueryParameter("utm_id");
                if (queryParameter2 != null) {
                    this.zzKI.put("&ci", queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("anid");
                if (queryParameter3 != null) {
                    this.zzKI.put("&anid", queryParameter3);
                }
                String queryParameter4 = parse.getQueryParameter("utm_campaign");
                if (queryParameter4 != null) {
                    this.zzKI.put("&cn", queryParameter4);
                }
                String queryParameter5 = parse.getQueryParameter("utm_content");
                if (queryParameter5 != null) {
                    this.zzKI.put("&cc", queryParameter5);
                }
                String queryParameter6 = parse.getQueryParameter("utm_medium");
                if (queryParameter6 != null) {
                    this.zzKI.put("&cm", queryParameter6);
                }
                String queryParameter7 = parse.getQueryParameter("utm_source");
                if (queryParameter7 != null) {
                    this.zzKI.put("&cs", queryParameter7);
                }
                String queryParameter8 = parse.getQueryParameter("utm_term");
                if (queryParameter8 != null) {
                    this.zzKI.put("&ck", queryParameter8);
                }
                String queryParameter9 = parse.getQueryParameter("dclid");
                if (queryParameter9 != null) {
                    this.zzKI.put("&dclid", queryParameter9);
                }
                String queryParameter10 = parse.getQueryParameter("gclid");
                if (queryParameter10 != null) {
                    this.zzKI.put("&gclid", queryParameter10);
                }
                String queryParameter11 = parse.getQueryParameter("aclid");
                if (queryParameter11 != null) {
                    this.zzKI.put("&aclid", queryParameter11);
                }
            }
        }
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            zzbb("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.zzKK.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", zzam.zzJ(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzal zzal) {
        zzaY("Loading Tracker config values");
        this.zzKM = zzal;
        if (this.zzKM.zzkM()) {
            String trackingId = this.zzKM.getTrackingId();
            set("&tid", trackingId);
            zza("trackingId loaded", trackingId);
        }
        if (this.zzKM.zzkN()) {
            String d = Double.toString(this.zzKM.zzkO());
            set("&sf", d);
            zza("Sample frequency loaded", d);
        }
        if (this.zzKM.zzkP()) {
            int sessionTimeout = this.zzKM.getSessionTimeout();
            setSessionTimeout((long) sessionTimeout);
            zza("Session timeout loaded", Integer.valueOf(sessionTimeout));
        }
        if (this.zzKM.zzkQ()) {
            boolean zzkR = this.zzKM.zzkR();
            enableAutoActivityTracking(zzkR);
            zza("Auto activity tracking loaded", Boolean.valueOf(zzkR));
        }
        if (this.zzKM.zzkS()) {
            boolean zzkT = this.zzKM.zzkT();
            if (zzkT) {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(zzkT));
        }
        enableExceptionReporting(this.zzKM.zzkU());
    }

    /* access modifiers changed from: protected */
    public void zzhB() {
        this.zzKK.zza();
        String zzjZ = zzhA().zzjZ();
        if (zzjZ != null) {
            set("&an", zzjZ);
        }
        String zzkb = zzhA().zzkb();
        if (zzkb != null) {
            set("&av", zzkb);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzhD() {
        return this.zzKH;
    }
}
