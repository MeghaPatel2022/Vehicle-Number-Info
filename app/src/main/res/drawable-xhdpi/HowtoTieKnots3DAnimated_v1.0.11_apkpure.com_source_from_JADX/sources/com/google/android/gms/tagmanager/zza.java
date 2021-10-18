package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlo;
import java.io.IOException;

public class zza {
    private static Object zzaOF = new Object();
    private static zza zzaOG;
    private volatile boolean mClosed;
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Thread zzHt;
    private volatile Info zzLl;
    private volatile long zzaOB;
    private volatile long zzaOC;
    private volatile long zzaOD;
    private C1543zza zzaOE;
    private final zzlm zzpO;

    /* renamed from: com.google.android.gms.tagmanager.zza$zza reason: collision with other inner class name */
    public interface C1543zza {
        Info zzzw();
    }

    private zza(Context context) {
        this(context, null, zzlo.zzpN());
    }

    public zza(Context context, C1543zza zza, zzlm zzlm) {
        this.zzaOB = 900000;
        this.zzaOC = 30000;
        this.mClosed = false;
        this.zzaOE = new C1543zza() {
            public Info zzzw() {
                boolean z = false;
                try {
                    return AdvertisingIdClient.getAdvertisingIdInfo(zza.this.mContext);
                } catch (IllegalStateException e) {
                    zzbg.zzaE("IllegalStateException getting Advertising Id Info");
                    return z;
                } catch (GooglePlayServicesRepairableException e2) {
                    zzbg.zzaE("GooglePlayServicesRepairableException getting Advertising Id Info");
                    return z;
                } catch (IOException e3) {
                    zzbg.zzaE("IOException getting Ad Id Info");
                    return z;
                } catch (GooglePlayServicesNotAvailableException e4) {
                    zzbg.zzaE("GooglePlayServicesNotAvailableException getting Advertising Id Info");
                    return z;
                } catch (Exception e5) {
                    zzbg.zzaE("Unknown exception. Could not get the Advertising Id Info.");
                    return z;
                }
            }
        };
        this.zzpO = zzlm;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (zza != null) {
            this.zzaOE = zza;
        }
        this.zzHt = new Thread(new Runnable() {
            public void run() {
                zza.this.zzzu();
            }
        });
    }

    public static zza zzaL(Context context) {
        if (zzaOG == null) {
            synchronized (zzaOF) {
                if (zzaOG == null) {
                    zzaOG = new zza(context);
                    zzaOG.start();
                }
            }
        }
        return zzaOG;
    }

    /* access modifiers changed from: private */
    public void zzzu() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.zzLl = this.zzaOE.zzzw();
                Thread.sleep(this.zzaOB);
            } catch (InterruptedException e) {
                zzbg.zzaD("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void zzzv() {
        if (this.zzpO.currentTimeMillis() - this.zzaOD >= this.zzaOC) {
            interrupt();
            this.zzaOD = this.zzpO.currentTimeMillis();
        }
    }

    public void interrupt() {
        this.zzHt.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        zzzv();
        if (this.zzLl == null) {
            return true;
        }
        return this.zzLl.isLimitAdTrackingEnabled();
    }

    public void start() {
        this.zzHt.start();
    }

    public String zzzt() {
        zzzv();
        if (this.zzLl == null) {
            return null;
        }
        return this.zzLl.getId();
    }
}
