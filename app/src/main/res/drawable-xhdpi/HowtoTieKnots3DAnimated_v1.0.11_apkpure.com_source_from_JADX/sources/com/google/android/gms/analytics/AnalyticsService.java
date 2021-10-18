package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqd;

public final class AnalyticsService extends Service {
    private static Boolean zzKe;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler();

    public static boolean zzW(Context context) {
        zzx.zzv(context);
        if (zzKe != null) {
            return zzKe.booleanValue();
        }
        boolean zza = zzam.zza(context, AnalyticsService.class);
        zzKe = Boolean.valueOf(zza);
        return zza;
    }

    private void zzhr() {
        try {
            synchronized (AnalyticsReceiver.zzpm) {
                zzqd zzqd = AnalyticsReceiver.zzKc;
                if (zzqd != null && zzqd.isHeld()) {
                    zzqd.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        zzf zzX = zzf.zzX(this);
        zzaf zzie = zzX.zzie();
        if (zzX.zzif().zzjk()) {
            zzie.zzaY("Device AnalyticsService is starting up");
        } else {
            zzie.zzaY("Local AnalyticsService is starting up");
        }
    }

    public void onDestroy() {
        zzf zzX = zzf.zzX(this);
        zzaf zzie = zzX.zzie();
        if (zzX.zzif().zzjk()) {
            zzie.zzaY("Device AnalyticsService is shutting down");
        } else {
            zzie.zzaY("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, final int startId) {
        zzhr();
        final zzf zzX = zzf.zzX(this);
        final zzaf zzie = zzX.zzie();
        String action = intent.getAction();
        if (zzX.zzif().zzjk()) {
            zzie.zza("Device AnalyticsService called. startId, action", Integer.valueOf(startId), action);
        } else {
            zzie.zza("Local AnalyticsService called. startId, action", Integer.valueOf(startId), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            zzX.zzhz().zza((zzw) new zzw() {
                public void zzc(Throwable th) {
                    AnalyticsService.this.mHandler.post(new Runnable() {
                        public void run() {
                            if (!AnalyticsService.this.stopSelfResult(startId)) {
                                return;
                            }
                            if (zzX.zzif().zzjk()) {
                                zzie.zzaY("Device AnalyticsService processed last dispatch request");
                            } else {
                                zzie.zzaY("Local AnalyticsService processed last dispatch request");
                            }
                        }
                    });
                }
            });
        }
        return 2;
    }
}
