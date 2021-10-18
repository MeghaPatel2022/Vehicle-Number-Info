package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class zzam extends zzal {
    /* access modifiers changed from: private */
    public static AdvertisingIdClient zznq = null;
    /* access modifiers changed from: private */
    public static CountDownLatch zznr = new CountDownLatch(1);
    /* access modifiers changed from: private */
    public static boolean zzns;
    private boolean zznt;

    class zza {
        private String zznu;
        private boolean zznv;

        public zza(String str, boolean z) {
            this.zznu = str;
            this.zznv = z;
        }

        public String getId() {
            return this.zznu;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zznv;
        }
    }

    private static final class zzb implements Runnable {
        private Context zznx;

        public zzb(Context context) {
            this.zznx = context.getApplicationContext();
            if (this.zznx == null) {
                this.zznx = context;
            }
        }

        public void run() {
            try {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zznx);
                advertisingIdClient.start();
                synchronized (zzam.class) {
                    if (zzam.zznq == null) {
                        zzam.zznq = advertisingIdClient;
                    } else {
                        advertisingIdClient.finish();
                    }
                }
            } catch (GooglePlayServicesNotAvailableException e) {
                zzam.zzns = true;
            } catch (GooglePlayServicesRepairableException | IOException e2) {
            }
            zzam.zznr.countDown();
        }
    }

    protected zzam(Context context, zzap zzap, zzaq zzaq, boolean z) {
        super(context, zzap, zzaq);
        this.zznt = z;
    }

    public static zzam zza(String str, Context context, boolean z) {
        zzah zzah = new zzah();
        zza(str, context, zzah);
        if (z) {
            synchronized (zzam.class) {
                if (zznq == null) {
                    new Thread(new zzb(context)).start();
                }
            }
        }
        return new zzam(context, zzah, new zzas(239), z);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzam.zza zzY() throws java.io.IOException {
        /*
            r5 = this;
            java.lang.Class<com.google.android.gms.internal.zzam> r1 = com.google.android.gms.internal.zzam.class
            monitor-enter(r1)
            java.util.concurrent.CountDownLatch r0 = zznr     // Catch:{ InterruptedException -> 0x0018 }
            r2 = 2
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0018 }
            boolean r0 = r0.await(r2, r4)     // Catch:{ InterruptedException -> 0x0018 }
            if (r0 != 0) goto L_0x0025
            com.google.android.gms.internal.zzam$zza r0 = new com.google.android.gms.internal.zzam$zza     // Catch:{ InterruptedException -> 0x0018 }
            r2 = 0
            r3 = 0
            r0.<init>(r2, r3)     // Catch:{ InterruptedException -> 0x0018 }
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
        L_0x0017:
            return r0
        L_0x0018:
            r0 = move-exception
            com.google.android.gms.internal.zzam$zza r0 = new com.google.android.gms.internal.zzam$zza     // Catch:{ all -> 0x0022 }
            r2 = 0
            r3 = 0
            r0.<init>(r2, r3)     // Catch:{ all -> 0x0022 }
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
            goto L_0x0017
        L_0x0022:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
            throw r0
        L_0x0025:
            com.google.android.gms.ads.identifier.AdvertisingIdClient r0 = zznq     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0032
            com.google.android.gms.internal.zzam$zza r0 = new com.google.android.gms.internal.zzam$zza     // Catch:{ all -> 0x0022 }
            r2 = 0
            r3 = 0
            r0.<init>(r2, r3)     // Catch:{ all -> 0x0022 }
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
            goto L_0x0017
        L_0x0032:
            com.google.android.gms.ads.identifier.AdvertisingIdClient r0 = zznq     // Catch:{ all -> 0x0022 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r2 = r0.getInfo()     // Catch:{ all -> 0x0022 }
            monitor-exit(r1)     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = r2.getId()
            java.lang.String r1 = r5.zzk(r0)
            com.google.android.gms.internal.zzam$zza r0 = new com.google.android.gms.internal.zzam$zza
            boolean r2 = r2.isLimitAdTrackingEnabled()
            r0.<init>(r1, r2)
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzam.zzY():com.google.android.gms.internal.zzam$zza");
    }

    /* access modifiers changed from: protected */
    public void zzc(Context context) {
        super.zzc(context);
        try {
            if (zzns || !this.zznt) {
                zza(24, zze(context));
                return;
            }
            zza zzY = zzY();
            String id = zzY.getId();
            if (id != null) {
                zza(28, zzY.isLimitAdTrackingEnabled() ? 1 : 0);
                zza(26, 5);
                zza(24, id);
            }
        } catch (zza | IOException e) {
        }
    }
}
