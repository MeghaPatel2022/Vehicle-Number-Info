package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzav;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private static boolean zzog = false;
    private final Context mContext;
    com.google.android.gms.common.zza zzoa;
    zzav zzob;
    boolean zzoc;
    Object zzod;
    zza zzoe;
    final long zzof;

    public static final class Info {
        private final String zzol;
        private final boolean zzom;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.zzol = advertisingId;
            this.zzom = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.zzol;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzom;
        }

        public String toString() {
            return "{" + this.zzol + "}" + this.zzom;
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzoh;
        private long zzoi;
        CountDownLatch zzoj = new CountDownLatch(1);
        boolean zzok = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzoh = new WeakReference<>(advertisingIdClient);
            this.zzoi = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzoh.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzok = true;
            }
        }

        public void cancel() {
            this.zzoj.countDown();
        }

        public void run() {
            try {
                if (!this.zzoj.await(this.zzoi, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }

        public boolean zzaK() {
            return this.zzok;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long timeoutInMillis) {
        this.zzod = new Object();
        zzx.zzv(context);
        this.mContext = context;
        this.zzoc = false;
        this.zzof = timeoutInMillis;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzb(false);
            return advertisingIdClient.getInfo();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean shouldSkipGmsCoreVersionCheck) {
        zzog = shouldSkipGmsCoreVersionCheck;
    }

    static zzav zza(Context context, com.google.android.gms.common.zza zza2) throws IOException {
        try {
            return com.google.android.gms.internal.zzav.zza.zzb(zza2.zzmS());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private void zzaJ() {
        synchronized (this.zzod) {
            if (this.zzoe != null) {
                this.zzoe.cancel();
                try {
                    this.zzoe.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzof > 0) {
                this.zzoe = new zza(this, this.zzof);
            }
        }
    }

    static com.google.android.gms.common.zza zzo(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            if (zzog) {
                Log.d(AdRequest.LOGTAG, "Skipping gmscore version check");
                switch (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            } else {
                try {
                    GooglePlayServicesUtil.zzaa(context);
                } catch (GooglePlayServicesNotAvailableException e) {
                    throw new IOException(e);
                }
            }
            com.google.android.gms.common.zza zza2 = new com.google.android.gms.common.zza();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (zzb.zzpD().zza(context, intent, (ServiceConnection) zza2, 1)) {
                    return zza2;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.zzx.zzci(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.mContext     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000e
            com.google.android.gms.common.zza r0 = r3.zzoa     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
        L_0x000f:
            return
        L_0x0010:
            boolean r0 = r3.zzoc     // Catch:{ IllegalArgumentException -> 0x002d }
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.common.stats.zzb r0 = com.google.android.gms.common.stats.zzb.zzpD()     // Catch:{ IllegalArgumentException -> 0x002d }
            android.content.Context r1 = r3.mContext     // Catch:{ IllegalArgumentException -> 0x002d }
            com.google.android.gms.common.zza r2 = r3.zzoa     // Catch:{ IllegalArgumentException -> 0x002d }
            r0.zza(r1, r2)     // Catch:{ IllegalArgumentException -> 0x002d }
        L_0x001f:
            r0 = 0
            r3.zzoc = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.zzob = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.zzoa = r0     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            goto L_0x000f
        L_0x002a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r0
        L_0x002d:
            r0 = move-exception
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r2 = "AdvertisingIdClient unbindService failed."
            android.util.Log.i(r1, r2, r0)     // Catch:{ all -> 0x002a }
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        zzx.zzci("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzoc) {
                synchronized (this.zzod) {
                    if (this.zzoe == null || !this.zzoe.zzaK()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.zzoc) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzx.zzv(this.zzoa);
            zzx.zzv(this.zzob);
            info = new Info(this.zzob.getId(), this.zzob.zzc(true));
        }
        zzaJ();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb(true);
    }

    /* access modifiers changed from: protected */
    public void zzb(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzx.zzci("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzoc) {
                finish();
            }
            this.zzoa = zzo(this.mContext);
            this.zzob = zza(this.mContext, this.zzoa);
            this.zzoc = true;
            if (z) {
                zzaJ();
            }
        }
    }
}
