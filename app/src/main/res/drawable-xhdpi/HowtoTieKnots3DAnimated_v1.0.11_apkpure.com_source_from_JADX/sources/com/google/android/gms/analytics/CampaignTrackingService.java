package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqd;

public class CampaignTrackingService extends Service {
    private static Boolean zzKe;
    private Handler mHandler;

    private Handler getHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(getMainLooper());
        this.mHandler = handler2;
        return handler2;
    }

    public static boolean zzW(Context context) {
        zzx.zzv(context);
        if (zzKe != null) {
            return zzKe.booleanValue();
        }
        boolean zza = zzam.zza(context, CampaignTrackingService.class);
        zzKe = Boolean.valueOf(zza);
        return zza;
    }

    private void zzhr() {
        try {
            synchronized (CampaignTrackingReceiver.zzpm) {
                zzqd zzqd = CampaignTrackingReceiver.zzKc;
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
        zzf.zzX(this).zzie().zzaY("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        zzf.zzX(this).zzie().zzaY("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, final int startId) {
        zzhr();
        zzf zzX = zzf.zzX(this);
        final zzaf zzie = zzX.zzie();
        String str = null;
        if (zzX.zzif().zzjk()) {
            zzie.zzbc("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        final Handler handler = getHandler();
        if (TextUtils.isEmpty(str)) {
            if (!zzX.zzif().zzjk()) {
                zzie.zzbb("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            zzX.zzig().zzf(new Runnable() {
                public void run() {
                    CampaignTrackingService.this.zza(zzie, handler, startId);
                }
            });
        } else {
            int zzjo = zzX.zzif().zzjo();
            if (str.length() > zzjo) {
                zzie.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(zzjo));
                str = str.substring(0, zzjo);
            }
            zzie.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(startId), str);
            zzX.zzhz().zza(str, new Runnable() {
                public void run() {
                    CampaignTrackingService.this.zza(zzie, handler, startId);
                }
            });
        }
        return 2;
    }

    /* access modifiers changed from: protected */
    public void zza(final zzaf zzaf, Handler handler, final int i) {
        handler.post(new Runnable() {
            public void run() {
                boolean stopSelfResult = CampaignTrackingService.this.stopSelfResult(i);
                if (stopSelfResult) {
                    zzaf.zza("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
                }
            }
        });
    }
}
