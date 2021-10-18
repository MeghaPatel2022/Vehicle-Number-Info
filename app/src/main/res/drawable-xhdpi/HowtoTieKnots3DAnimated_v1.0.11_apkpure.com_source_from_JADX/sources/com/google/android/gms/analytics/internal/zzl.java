package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzol;
import java.util.HashMap;
import java.util.Map.Entry;

class zzl extends zzd {
    private boolean mStarted;
    private final zzj zzMn;
    private final zzah zzMo;
    private final zzag zzMp;
    private final zzi zzMq;
    private long zzMr = Long.MIN_VALUE;
    private final zzt zzMs;
    private final zzt zzMt;
    private final zzaj zzMu;
    private long zzMv;
    private boolean zzMw;

    protected zzl(zzf zzf, zzg zzg) {
        super(zzf);
        zzx.zzv(zzg);
        this.zzMp = zzg.zzk(zzf);
        this.zzMn = zzg.zzm(zzf);
        this.zzMo = zzg.zzn(zzf);
        this.zzMq = zzg.zzo(zzf);
        this.zzMu = new zzaj(zzid());
        this.zzMs = new zzt(zzf) {
            public void run() {
                zzl.this.zziO();
            }
        };
        this.zzMt = new zzt(zzf) {
            public void run() {
                zzl.this.zziP();
            }
        };
    }

    private void zza(zzh zzh, zzol zzol) {
        zzx.zzv(zzh);
        zzx.zzv(zzol);
        zza zza = new zza(zzia());
        zza.zzaN(zzh.zzix());
        zza.enableAdvertisingIdCollection(zzh.zziy());
        zzob zzhq = zza.zzhq();
        zzjb zzjb = (zzjb) zzhq.zze(zzjb.class);
        zzjb.zzaS("data");
        zzjb.zzH(true);
        zzhq.zzb(zzol);
        zzja zzja = (zzja) zzhq.zze(zzja.class);
        zzok zzok = (zzok) zzhq.zze(zzok.class);
        for (Entry entry : zzh.zzn().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                zzok.setAppName(str2);
            } else if ("av".equals(str)) {
                zzok.setAppVersion(str2);
            } else if ("aid".equals(str)) {
                zzok.setAppId(str2);
            } else if ("aiid".equals(str)) {
                zzok.setAppInstallerId(str2);
            } else if ("uid".equals(str)) {
                zzjb.setUserId(str2);
            } else {
                zzja.set(str, str2);
            }
        }
        zzb("Sending installation campaign to", zzh.zzix(), zzol);
        zzhq.zzL(zzii().zzky());
        zzhq.zzxl();
    }

    private boolean zzbf(String str) {
        return getContext().checkCallingOrSelfPermission(str) == 0;
    }

    private void zziM() {
        Context context = zzia().getContext();
        if (!AnalyticsReceiver.zzV(context)) {
            zzbb("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!AnalyticsService.zzW(context)) {
            zzbc("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzV(context)) {
            zzbb("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!CampaignTrackingService.zzW(context)) {
            zzbb("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    /* access modifiers changed from: private */
    public void zziO() {
        zzb((zzw) new zzw() {
            public void zzc(Throwable th) {
                zzl.this.zziU();
            }
        });
    }

    /* access modifiers changed from: private */
    public void zziP() {
        try {
            this.zzMn.zziG();
            zziU();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzMt.zzt(zzif().zzjM());
    }

    private boolean zziV() {
        if (this.zzMw) {
            return false;
        }
        return (!zzif().zzjk() || zzif().zzjl()) && zzjb() > 0;
    }

    private void zziW() {
        zzv zzih = zzih();
        if (zzih.zzjU() && !zzih.zzbr()) {
            long zziH = zziH();
            if (zziH != 0 && Math.abs(zzid().currentTimeMillis() - zziH) <= zzif().zzju()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzif().zzjt()));
                zzih.zzjV();
            }
        }
    }

    private void zziX() {
        long min;
        zziW();
        long zzjb = zzjb();
        long zzkA = zzii().zzkA();
        if (zzkA != 0) {
            min = zzjb - Math.abs(zzid().currentTimeMillis() - zzkA);
            if (min <= 0) {
                min = Math.min(zzif().zzjr(), zzjb);
            }
        } else {
            min = Math.min(zzif().zzjr(), zzjb);
        }
        zza("Dispatch scheduled (ms)", Long.valueOf(min));
        if (this.zzMs.zzbr()) {
            this.zzMs.zzu(Math.max(1, min + this.zzMs.zzjR()));
            return;
        }
        this.zzMs.zzt(min);
    }

    private void zziY() {
        zziZ();
        zzja();
    }

    private void zziZ() {
        if (this.zzMs.zzbr()) {
            zzaY("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzMs.cancel();
    }

    private void zzja() {
        zzv zzih = zzih();
        if (zzih.zzbr()) {
            zzih.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onServiceConnected() {
        zzic();
        if (!zzif().zzjk()) {
            zziR();
        }
    }

    /* access modifiers changed from: 0000 */
    public void start() {
        zzio();
        zzx.zza(!this.mStarted, (Object) "Analytics backend already started");
        this.mStarted = true;
        if (!zzif().zzjk()) {
            zziM();
        }
        zzig().zzf(new Runnable() {
            public void run() {
                zzl.this.zziN();
            }
        });
    }

    public void zzI(boolean z) {
        zziU();
    }

    public long zza(zzh zzh, boolean z) {
        long j;
        zzx.zzv(zzh);
        zzio();
        zzic();
        try {
            this.zzMn.beginTransaction();
            this.zzMn.zza(zzh.zziw(), zzh.getClientId());
            j = this.zzMn.zza(zzh.zziw(), zzh.getClientId(), zzh.zzix());
            if (!z) {
                zzh.zzn(j);
            } else {
                zzh.zzn(1 + j);
            }
            this.zzMn.zzb(zzh);
            this.zzMn.setTransactionSuccessful();
            try {
            } catch (SQLiteException e) {
                zze("Failed to end transaction", e);
            }
        } catch (SQLiteException e2) {
            zze("Failed to update Analytics property", e2);
            j = -1;
            try {
            } catch (SQLiteException e3) {
                zze("Failed to end transaction", e3);
            }
        } finally {
            try {
                this.zzMn.endTransaction();
            } catch (SQLiteException e4) {
                zze("Failed to end transaction", e4);
            }
        }
        return j;
    }

    public void zza(zzab zzab) {
        zzx.zzv(zzab);
        zzof.zzic();
        zzio();
        if (this.zzMw) {
            zzaZ("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzab);
        }
        zzab zzf = zzf(zzab);
        zziQ();
        if (this.zzMq.zzb(zzf)) {
            zzaZ("Hit sent to the device AnalyticsService for delivery");
        } else if (zzif().zzjk()) {
            zzie().zza(zzf, "Service unavailable on package side");
        } else {
            try {
                this.zzMn.zzc(zzf);
                zziU();
            } catch (SQLiteException e) {
                zze("Delivery failed to save hit to a database", e);
                zzie().zza(zzf, "deliver: failed to insert hit to database");
            }
        }
    }

    public void zza(final zzw zzw, final long j) {
        zzof.zzic();
        zzio();
        long j2 = -1;
        long zzkA = zzii().zzkA();
        if (zzkA != 0) {
            j2 = Math.abs(zzid().currentTimeMillis() - zzkA);
        }
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!zzif().zzjk()) {
            zziQ();
        }
        try {
            if (zziS()) {
                zzig().zzf(new Runnable() {
                    public void run() {
                        zzl.this.zza(zzw, j);
                    }
                });
                return;
            }
            zzii().zzkB();
            zziU();
            if (zzw != null) {
                zzw.zzc(null);
            }
            if (this.zzMv != j) {
                this.zzMp.zzkt();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            zzii().zzkB();
            zziU();
            if (zzw != null) {
                zzw.zzc(th);
            }
        }
    }

    public void zzb(zzw zzw) {
        zza(zzw, this.zzMv);
    }

    public void zzbg(String str) {
        zzx.zzcs(str);
        zzic();
        zzib();
        zzol zza = zzam.zza(zzie(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String zzkC = zzii().zzkC();
        if (str.equals(zzkC)) {
            zzbb("Ignoring duplicate install campaign");
        } else if (!TextUtils.isEmpty(zzkC)) {
            zzd("Ignoring multiple install campaigns. original, new", zzkC, str);
        } else {
            zzii().zzbk(str);
            if (zzii().zzkz().zzv(zzif().zzjP())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzh zza2 : this.zzMn.zzr(0)) {
                zza(zza2, zza);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzc(zzh zzh) {
        zzic();
        zzb("Sending first hit to property", zzh.zzix());
        if (!zzii().zzkz().zzv(zzif().zzjP())) {
            String zzkC = zzii().zzkC();
            if (!TextUtils.isEmpty(zzkC)) {
                zzol zza = zzam.zza(zzie(), zzkC);
                zzb("Found relevant installation campaign", zza);
                zza(zzh, zza);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public zzab zzf(zzab zzab) {
        if (!TextUtils.isEmpty(zzab.zzko())) {
            return zzab;
        }
        Pair zzkG = zzii().zzkD().zzkG();
        if (zzkG == null) {
            return zzab;
        }
        Long l = (Long) zzkG.second;
        String str = l + ":" + ((String) zzkG.first);
        HashMap hashMap = new HashMap(zzab.zzn());
        hashMap.put("_m", str);
        return zzab.zza(this, zzab, hashMap);
    }

    /* access modifiers changed from: protected */
    public void zzhB() {
        this.zzMn.zza();
        this.zzMo.zza();
        this.zzMq.zza();
    }

    public void zzhU() {
        zzof.zzic();
        zzio();
        if (!zzif().zzjk()) {
            zzaY("Delete all hits from local store");
            try {
                this.zzMn.zziE();
                this.zzMn.zziF();
                zziU();
            } catch (SQLiteException e) {
                zzd("Failed to delete hits from store", e);
            }
        }
        zziQ();
        if (this.zzMq.zziA()) {
            zzaY("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public void zzhX() {
        zzof.zzic();
        zzio();
        zzaY("Service disconnected");
    }

    /* access modifiers changed from: 0000 */
    public void zzhZ() {
        zzic();
        this.zzMv = zzid().currentTimeMillis();
    }

    public long zziH() {
        zzof.zzic();
        zzio();
        try {
            return this.zzMn.zziH();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void zziN() {
        zzio();
        zzii().zzky();
        if (!zzbf("android.permission.ACCESS_NETWORK_STATE")) {
            zzbc("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzjc();
        }
        if (!zzbf("android.permission.INTERNET")) {
            zzbc("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzjc();
        }
        if (AnalyticsService.zzW(getContext())) {
            zzaY("AnalyticsService registered in the app manifest and enabled");
        } else if (zzif().zzjk()) {
            zzbc("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            zzbb("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzMw && !zzif().zzjk() && !this.zzMn.isEmpty()) {
            zziQ();
        }
        zziU();
    }

    /* access modifiers changed from: protected */
    public void zziQ() {
        if (!this.zzMw && zzif().zzjm() && !this.zzMq.isConnected()) {
            if (this.zzMu.zzv(zzif().zzjH())) {
                this.zzMu.start();
                zzaY("Connecting to service");
                if (this.zzMq.connect()) {
                    zzaY("Connected to service");
                    this.zzMu.clear();
                    onServiceConnected();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062 A[LOOP:1: B:18:0x0062->B:17:?, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zziR() {
        /*
            r6 = this;
            com.google.android.gms.internal.zzof.zzic()
            r6.zzio()
            r6.zzib()
            com.google.android.gms.analytics.internal.zzr r0 = r6.zzif()
            boolean r0 = r0.zzjm()
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService"
            r6.zzbb(r0)
        L_0x0018:
            com.google.android.gms.analytics.internal.zzi r0 = r6.zzMq
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = "Service not connected"
            r6.zzaY(r0)
        L_0x0025:
            return
        L_0x0026:
            com.google.android.gms.analytics.internal.zzj r0 = r6.zzMn
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = "Dispatching local hits to device AnalyticsService"
            r6.zzaY(r0)
        L_0x0033:
            com.google.android.gms.analytics.internal.zzj r0 = r6.zzMn     // Catch:{ SQLiteException -> 0x004c }
            com.google.android.gms.analytics.internal.zzr r1 = r6.zzif()     // Catch:{ SQLiteException -> 0x004c }
            int r1 = r1.zzjv()     // Catch:{ SQLiteException -> 0x004c }
            long r2 = (long) r1     // Catch:{ SQLiteException -> 0x004c }
            java.util.List r1 = r0.zzp(r2)     // Catch:{ SQLiteException -> 0x004c }
            boolean r0 = r1.isEmpty()     // Catch:{ SQLiteException -> 0x004c }
            if (r0 == 0) goto L_0x0062
            r6.zziU()     // Catch:{ SQLiteException -> 0x004c }
            goto L_0x0025
        L_0x004c:
            r0 = move-exception
            java.lang.String r1 = "Failed to read hits from store"
            r6.zze(r1, r0)
            r6.zziY()
            goto L_0x0025
        L_0x0056:
            r1.remove(r0)
            com.google.android.gms.analytics.internal.zzj r2 = r6.zzMn     // Catch:{ SQLiteException -> 0x007b }
            long r4 = r0.zzkj()     // Catch:{ SQLiteException -> 0x007b }
            r2.zzq(r4)     // Catch:{ SQLiteException -> 0x007b }
        L_0x0062:
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x0033
            r0 = 0
            java.lang.Object r0 = r1.get(r0)
            com.google.android.gms.analytics.internal.zzab r0 = (com.google.android.gms.analytics.internal.zzab) r0
            com.google.android.gms.analytics.internal.zzi r2 = r6.zzMq
            boolean r2 = r2.zzb(r0)
            if (r2 != 0) goto L_0x0056
            r6.zziU()
            goto L_0x0025
        L_0x007b:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove hit that was send for delivery"
            r6.zze(r1, r0)
            r6.zziY()
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zziR():void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0205, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f9, code lost:
        if (r12.zzMq.isConnected() == false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0103, code lost:
        if (zzif().zzjk() != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0105, code lost:
        zzaY("Service connected, sending hits to the service");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010e, code lost:
        if (r8.isEmpty() != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0110, code lost:
        r0 = (com.google.android.gms.analytics.internal.zzab) r8.get(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011d, code lost:
        if (r12.zzMq.zzb(r0) != false) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011f, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0126, code lost:
        if (r12.zzMo.zzku() == false) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0128, code lost:
        r9 = r12.zzMo.zzf(r8);
        r10 = r9.iterator();
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0137, code lost:
        if (r10.hasNext() == false) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0139, code lost:
        r4 = java.lang.Math.max(r4, ((java.lang.Long) r10.next()).longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0148, code lost:
        r4 = java.lang.Math.max(r4, r0.zzkj());
        r8.remove(r0);
        zzb("Hit sent do device AnalyticsService for delivery", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r12.zzMn.zzq(r0.zzkj());
        r3.add(java.lang.Long.valueOf(r0.zzkj()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        zze("Failed to remove hit that was send for delivery", r0);
        zziY();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r12.zzMn.setTransactionSuccessful();
        r12.zzMn.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0182, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0183, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zziY();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r8.removeAll(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r12.zzMn.zzd(r9);
        r3.addAll(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0198, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x019d, code lost:
        if (r3.isEmpty() == false) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01ab, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ac, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zziY();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        zze("Failed to remove successfully uploaded hits", r0);
        zziY();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r12.zzMn.setTransactionSuccessful();
        r12.zzMn.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01cc, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zziY();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        r12.zzMn.setTransactionSuccessful();
        r12.zzMn.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e4, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zziY();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zziS() {
        /*
            r12 = this;
            r1 = 1
            r2 = 0
            com.google.android.gms.internal.zzof.zzic()
            r12.zzio()
            java.lang.String r0 = "Dispatching a batch of local hits"
            r12.zzaY(r0)
            com.google.android.gms.analytics.internal.zzi r0 = r12.zzMq
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L_0x0032
            com.google.android.gms.analytics.internal.zzr r0 = r12.zzif()
            boolean r0 = r0.zzjk()
            if (r0 != 0) goto L_0x0032
            r0 = r1
        L_0x0020:
            com.google.android.gms.analytics.internal.zzah r3 = r12.zzMo
            boolean r3 = r3.zzku()
            if (r3 != 0) goto L_0x0034
        L_0x0028:
            if (r0 == 0) goto L_0x0036
            if (r1 == 0) goto L_0x0036
            java.lang.String r0 = "No network or service available. Will retry later"
            r12.zzaY(r0)
        L_0x0031:
            return r2
        L_0x0032:
            r0 = r2
            goto L_0x0020
        L_0x0034:
            r1 = r2
            goto L_0x0028
        L_0x0036:
            com.google.android.gms.analytics.internal.zzr r0 = r12.zzif()
            int r0 = r0.zzjv()
            com.google.android.gms.analytics.internal.zzr r1 = r12.zzif()
            int r1 = r1.zzjw()
            int r0 = java.lang.Math.max(r0, r1)
            long r6 = (long) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 0
        L_0x0052:
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ all -> 0x01ee }
            r0.beginTransaction()     // Catch:{ all -> 0x01ee }
            r3.clear()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x00d3 }
            java.util.List r8 = r0.zzp(r6)     // Catch:{ SQLiteException -> 0x00d3 }
            boolean r0 = r8.isEmpty()     // Catch:{ SQLiteException -> 0x00d3 }
            if (r0 == 0) goto L_0x0083
            java.lang.String r0 = "Store is empty, nothing to dispatch"
            r12.zzaY(r0)     // Catch:{ SQLiteException -> 0x00d3 }
            r12.zziY()     // Catch:{ SQLiteException -> 0x00d3 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x0079 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x0079 }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x0079 }
            goto L_0x0031
        L_0x0079:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zziY()
            goto L_0x0031
        L_0x0083:
            java.lang.String r0 = "Hits loaded from store. count"
            int r1 = r8.size()     // Catch:{ SQLiteException -> 0x00d3 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ SQLiteException -> 0x00d3 }
            r12.zza(r0, r1)     // Catch:{ SQLiteException -> 0x00d3 }
            java.util.Iterator r1 = r8.iterator()     // Catch:{ all -> 0x01ee }
        L_0x0094:
            boolean r0 = r1.hasNext()     // Catch:{ all -> 0x01ee }
            if (r0 == 0) goto L_0x00f3
            java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.zzab r0 = (com.google.android.gms.analytics.internal.zzab) r0     // Catch:{ all -> 0x01ee }
            long r10 = r0.zzkj()     // Catch:{ all -> 0x01ee }
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0094
            java.lang.String r0 = "Database contains successfully uploaded hit"
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01ee }
            int r3 = r8.size()     // Catch:{ all -> 0x01ee }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01ee }
            r12.zzd(r0, r1, r3)     // Catch:{ all -> 0x01ee }
            r12.zziY()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x00c8 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x00c8 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x00c8 }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x00c8 }
            goto L_0x0031
        L_0x00c8:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zziY()
            goto L_0x0031
        L_0x00d3:
            r0 = move-exception
            java.lang.String r1 = "Failed to read hits from persisted store"
            r12.zzd(r1, r0)     // Catch:{ all -> 0x01ee }
            r12.zziY()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x00e8 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x00e8 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x00e8 }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x00e8 }
            goto L_0x0031
        L_0x00e8:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zziY()
            goto L_0x0031
        L_0x00f3:
            com.google.android.gms.analytics.internal.zzi r0 = r12.zzMq     // Catch:{ all -> 0x01ee }
            boolean r0 = r0.isConnected()     // Catch:{ all -> 0x01ee }
            if (r0 == 0) goto L_0x0205
            com.google.android.gms.analytics.internal.zzr r0 = r12.zzif()     // Catch:{ all -> 0x01ee }
            boolean r0 = r0.zzjk()     // Catch:{ all -> 0x01ee }
            if (r0 != 0) goto L_0x0205
            java.lang.String r0 = "Service connected, sending hits to the service"
            r12.zzaY(r0)     // Catch:{ all -> 0x01ee }
        L_0x010a:
            boolean r0 = r8.isEmpty()     // Catch:{ all -> 0x01ee }
            if (r0 != 0) goto L_0x0205
            r0 = 0
            java.lang.Object r0 = r8.get(r0)     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.zzab r0 = (com.google.android.gms.analytics.internal.zzab) r0     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.zzi r1 = r12.zzMq     // Catch:{ all -> 0x01ee }
            boolean r1 = r1.zzb(r0)     // Catch:{ all -> 0x01ee }
            if (r1 != 0) goto L_0x0148
            r0 = r4
        L_0x0120:
            com.google.android.gms.analytics.internal.zzah r4 = r12.zzMo     // Catch:{ all -> 0x01ee }
            boolean r4 = r4.zzku()     // Catch:{ all -> 0x01ee }
            if (r4 == 0) goto L_0x0199
            com.google.android.gms.analytics.internal.zzah r4 = r12.zzMo     // Catch:{ all -> 0x01ee }
            java.util.List r9 = r4.zzf(r8)     // Catch:{ all -> 0x01ee }
            java.util.Iterator r10 = r9.iterator()     // Catch:{ all -> 0x01ee }
            r4 = r0
        L_0x0133:
            boolean r0 = r10.hasNext()     // Catch:{ all -> 0x01ee }
            if (r0 == 0) goto L_0x018d
            java.lang.Object r0 = r10.next()     // Catch:{ all -> 0x01ee }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x01ee }
            long r0 = r0.longValue()     // Catch:{ all -> 0x01ee }
            long r4 = java.lang.Math.max(r4, r0)     // Catch:{ all -> 0x01ee }
            goto L_0x0133
        L_0x0148:
            long r10 = r0.zzkj()     // Catch:{ all -> 0x01ee }
            long r4 = java.lang.Math.max(r4, r10)     // Catch:{ all -> 0x01ee }
            r8.remove(r0)     // Catch:{ all -> 0x01ee }
            java.lang.String r1 = "Hit sent do device AnalyticsService for delivery"
            r12.zzb(r1, r0)     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.zzj r1 = r12.zzMn     // Catch:{ SQLiteException -> 0x016d }
            long r10 = r0.zzkj()     // Catch:{ SQLiteException -> 0x016d }
            r1.zzq(r10)     // Catch:{ SQLiteException -> 0x016d }
            long r0 = r0.zzkj()     // Catch:{ SQLiteException -> 0x016d }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ SQLiteException -> 0x016d }
            r3.add(r0)     // Catch:{ SQLiteException -> 0x016d }
            goto L_0x010a
        L_0x016d:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove hit that was send for delivery"
            r12.zze(r1, r0)     // Catch:{ all -> 0x01ee }
            r12.zziY()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x0182 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0182 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x0182 }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x0182 }
            goto L_0x0031
        L_0x0182:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zziY()
            goto L_0x0031
        L_0x018d:
            r8.removeAll(r9)     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x01b6 }
            r0.zzd(r9)     // Catch:{ SQLiteException -> 0x01b6 }
            r3.addAll(r9)     // Catch:{ SQLiteException -> 0x01b6 }
            r0 = r4
        L_0x0199:
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x01ee }
            if (r4 == 0) goto L_0x01d6
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x01ab }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x01ab }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x01ab }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x01ab }
            goto L_0x0031
        L_0x01ab:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zziY()
            goto L_0x0031
        L_0x01b6:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove successfully uploaded hits"
            r12.zze(r1, r0)     // Catch:{ all -> 0x01ee }
            r12.zziY()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x01cb }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x01cb }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzMn     // Catch:{ SQLiteException -> 0x01cb }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x01cb }
            goto L_0x0031
        L_0x01cb:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zziY()
            goto L_0x0031
        L_0x01d6:
            com.google.android.gms.analytics.internal.zzj r4 = r12.zzMn     // Catch:{ SQLiteException -> 0x01e3 }
            r4.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x01e3 }
            com.google.android.gms.analytics.internal.zzj r4 = r12.zzMn     // Catch:{ SQLiteException -> 0x01e3 }
            r4.endTransaction()     // Catch:{ SQLiteException -> 0x01e3 }
            r4 = r0
            goto L_0x0052
        L_0x01e3:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zziY()
            goto L_0x0031
        L_0x01ee:
            r0 = move-exception
            com.google.android.gms.analytics.internal.zzj r1 = r12.zzMn     // Catch:{ SQLiteException -> 0x01fa }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x01fa }
            com.google.android.gms.analytics.internal.zzj r1 = r12.zzMn     // Catch:{ SQLiteException -> 0x01fa }
            r1.endTransaction()     // Catch:{ SQLiteException -> 0x01fa }
            throw r0
        L_0x01fa:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zziY()
            goto L_0x0031
        L_0x0205:
            r0 = r4
            goto L_0x0120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zziS():boolean");
    }

    public void zziT() {
        zzof.zzic();
        zzio();
        zzaZ("Sync dispatching local hits");
        long j = this.zzMv;
        if (!zzif().zzjk()) {
            zziQ();
        }
        do {
            try {
            } catch (Throwable th) {
                zze("Sync local dispatch failed", th);
                zziU();
                return;
            }
        } while (zziS());
        zzii().zzkB();
        zziU();
        if (this.zzMv != j) {
            this.zzMp.zzkt();
        }
    }

    public void zziU() {
        boolean z;
        zzia().zzic();
        zzio();
        if (!zziV()) {
            this.zzMp.unregister();
            zziY();
        } else if (this.zzMn.isEmpty()) {
            this.zzMp.unregister();
            zziY();
        } else {
            if (!((Boolean) zzy.zzNH.get()).booleanValue()) {
                this.zzMp.zzkr();
                z = this.zzMp.isConnected();
            } else {
                z = true;
            }
            if (z) {
                zziX();
                return;
            }
            zziY();
            zziW();
        }
    }

    public long zzjb() {
        if (this.zzMr != Long.MIN_VALUE) {
            return this.zzMr;
        }
        return zzhA().zzke() ? ((long) zzhA().zzkV()) * 1000 : zzif().zzjs();
    }

    public void zzjc() {
        zzio();
        zzic();
        this.zzMw = true;
        this.zzMq.disconnect();
        zziU();
    }

    public void zzs(long j) {
        zzof.zzic();
        zzio();
        if (j < 0) {
            j = 0;
        }
        this.zzMr = j;
        zziU();
    }
}
