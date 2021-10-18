package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import java.util.Collections;

public class zzi extends zzd {
    /* access modifiers changed from: private */
    public final zza zzLW = new zza();
    private zzac zzLX;
    private final zzt zzLY;
    private zzaj zzLZ;

    protected class zza implements ServiceConnection {
        private volatile zzac zzMb;
        private volatile boolean zzMc;

        protected zza() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r4.zzMa.zzbc("Service connect failed to get IAnalyticsService");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005e, code lost:
            throw r0;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0008, B:9:0x0015] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
            /*
                r4 = this;
                java.lang.String r0 = "AnalyticsServiceConnection.onServiceConnected"
                com.google.android.gms.common.internal.zzx.zzch(r0)
                monitor-enter(r4)
                if (r6 != 0) goto L_0x0014
                com.google.android.gms.analytics.internal.zzi r0 = com.google.android.gms.analytics.internal.zzi.this     // Catch:{ all -> 0x005a }
                java.lang.String r1 = "Service connected with null binder"
                r0.zzbc(r1)     // Catch:{ all -> 0x005a }
                r4.notifyAll()     // Catch:{ all -> 0x0046 }
                monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            L_0x0013:
                return
            L_0x0014:
                r0 = 0
                java.lang.String r1 = r6.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0051 }
                java.lang.String r2 = "com.google.android.gms.analytics.internal.IAnalyticsService"
                boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0051 }
                if (r2 == 0) goto L_0x0049
                com.google.android.gms.analytics.internal.zzac r0 = com.google.android.gms.analytics.internal.zzac.zza.zzae(r6)     // Catch:{ RemoteException -> 0x0051 }
                com.google.android.gms.analytics.internal.zzi r1 = com.google.android.gms.analytics.internal.zzi.this     // Catch:{ RemoteException -> 0x0051 }
                java.lang.String r2 = "Bound to IAnalyticsService interface"
                r1.zzaY(r2)     // Catch:{ RemoteException -> 0x0051 }
            L_0x002c:
                if (r0 != 0) goto L_0x005f
                com.google.android.gms.common.stats.zzb r0 = com.google.android.gms.common.stats.zzb.zzpD()     // Catch:{ IllegalArgumentException -> 0x007c }
                com.google.android.gms.analytics.internal.zzi r1 = com.google.android.gms.analytics.internal.zzi.this     // Catch:{ IllegalArgumentException -> 0x007c }
                android.content.Context r1 = r1.getContext()     // Catch:{ IllegalArgumentException -> 0x007c }
                com.google.android.gms.analytics.internal.zzi r2 = com.google.android.gms.analytics.internal.zzi.this     // Catch:{ IllegalArgumentException -> 0x007c }
                com.google.android.gms.analytics.internal.zzi$zza r2 = r2.zzLW     // Catch:{ IllegalArgumentException -> 0x007c }
                r0.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x007c }
            L_0x0041:
                r4.notifyAll()     // Catch:{ all -> 0x0046 }
                monitor-exit(r4)     // Catch:{ all -> 0x0046 }
                goto L_0x0013
            L_0x0046:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0046 }
                throw r0
            L_0x0049:
                com.google.android.gms.analytics.internal.zzi r2 = com.google.android.gms.analytics.internal.zzi.this     // Catch:{ RemoteException -> 0x0051 }
                java.lang.String r3 = "Got binder with a wrong descriptor"
                r2.zze(r3, r1)     // Catch:{ RemoteException -> 0x0051 }
                goto L_0x002c
            L_0x0051:
                r1 = move-exception
                com.google.android.gms.analytics.internal.zzi r1 = com.google.android.gms.analytics.internal.zzi.this     // Catch:{ all -> 0x005a }
                java.lang.String r2 = "Service connect failed to get IAnalyticsService"
                r1.zzbc(r2)     // Catch:{ all -> 0x005a }
                goto L_0x002c
            L_0x005a:
                r0 = move-exception
                r4.notifyAll()     // Catch:{ all -> 0x0046 }
                throw r0     // Catch:{ all -> 0x0046 }
            L_0x005f:
                boolean r1 = r4.zzMc     // Catch:{ all -> 0x005a }
                if (r1 != 0) goto L_0x0079
                com.google.android.gms.analytics.internal.zzi r1 = com.google.android.gms.analytics.internal.zzi.this     // Catch:{ all -> 0x005a }
                java.lang.String r2 = "onServiceConnected received after the timeout limit"
                r1.zzbb(r2)     // Catch:{ all -> 0x005a }
                com.google.android.gms.analytics.internal.zzi r1 = com.google.android.gms.analytics.internal.zzi.this     // Catch:{ all -> 0x005a }
                com.google.android.gms.internal.zzof r1 = r1.zzig()     // Catch:{ all -> 0x005a }
                com.google.android.gms.analytics.internal.zzi$zza$1 r2 = new com.google.android.gms.analytics.internal.zzi$zza$1     // Catch:{ all -> 0x005a }
                r2.<init>(r0)     // Catch:{ all -> 0x005a }
                r1.zzf(r2)     // Catch:{ all -> 0x005a }
                goto L_0x0041
            L_0x0079:
                r4.zzMb = r0     // Catch:{ all -> 0x005a }
                goto L_0x0041
            L_0x007c:
                r0 = move-exception
                goto L_0x0041
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzi.zza.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(final ComponentName name) {
            zzx.zzch("AnalyticsServiceConnection.onServiceDisconnected");
            zzi.this.zzig().zzf(new Runnable() {
                public void run() {
                    zzi.this.onServiceDisconnected(name);
                }
            });
        }

        public zzac zziD() {
            zzac zzac = null;
            zzi.this.zzic();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            Context context = zzi.this.getContext();
            intent.putExtra("app_package_name", context.getPackageName());
            zzb zzpD = zzb.zzpD();
            synchronized (this) {
                this.zzMb = null;
                this.zzMc = true;
                boolean zza = zzpD.zza(context, intent, (ServiceConnection) zzi.this.zzLW, 129);
                zzi.this.zza("Bind to service requested", Boolean.valueOf(zza));
                if (!zza) {
                    this.zzMc = false;
                } else {
                    try {
                        wait(zzi.this.zzif().zzjG());
                    } catch (InterruptedException e) {
                        zzi.this.zzbb("Wait for service connect was interrupted");
                    }
                    this.zzMc = false;
                    zzac = this.zzMb;
                    this.zzMb = null;
                    if (zzac == null) {
                        zzi.this.zzbc("Successfully bound to service but never got onServiceConnected callback");
                    }
                }
            }
            return zzac;
        }
    }

    protected zzi(zzf zzf) {
        super(zzf);
        this.zzLZ = new zzaj(zzf.zzid());
        this.zzLY = new zzt(zzf) {
            public void run() {
                zzi.this.zziC();
            }
        };
    }

    private void onDisconnect() {
        zzhz().zzhX();
    }

    /* access modifiers changed from: private */
    public void onServiceDisconnected(ComponentName name) {
        zzic();
        if (this.zzLX != null) {
            this.zzLX = null;
            zza("Disconnected from device AnalyticsService", name);
            onDisconnect();
        }
    }

    /* access modifiers changed from: private */
    public void zza(zzac zzac) {
        zzic();
        this.zzLX = zzac;
        zziB();
        zzhz().onServiceConnected();
    }

    private void zziB() {
        this.zzLZ.start();
        this.zzLY.zzt(zzif().zzjF());
    }

    /* access modifiers changed from: private */
    public void zziC() {
        zzic();
        if (isConnected()) {
            zzaY("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    public boolean connect() {
        zzic();
        zzio();
        if (this.zzLX != null) {
            return true;
        }
        zzac zziD = this.zzLW.zziD();
        if (zziD == null) {
            return false;
        }
        this.zzLX = zziD;
        zziB();
        return true;
    }

    public void disconnect() {
        zzic();
        zzio();
        try {
            zzb.zzpD().zza(getContext(), this.zzLW);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        if (this.zzLX != null) {
            this.zzLX = null;
            onDisconnect();
        }
    }

    public boolean isConnected() {
        zzic();
        zzio();
        return this.zzLX != null;
    }

    public boolean zzb(zzab zzab) {
        zzx.zzv(zzab);
        zzic();
        zzio();
        zzac zzac = this.zzLX;
        if (zzac == null) {
            return false;
        }
        try {
            zzac.zza(zzab.zzn(), zzab.zzkk(), zzab.zzkm() ? zzif().zzjy() : zzif().zzjz(), Collections.emptyList());
            zziB();
            return true;
        } catch (RemoteException e) {
            zzaY("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void zzhB() {
    }

    public boolean zziA() {
        zzic();
        zzio();
        zzac zzac = this.zzLX;
        if (zzac == null) {
            return false;
        }
        try {
            zzac.zzhU();
            zziB();
            return true;
        } catch (RemoteException e) {
            zzaY("Failed to clear hits from AnalyticsService");
            return false;
        }
    }
}
