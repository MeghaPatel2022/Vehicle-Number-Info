package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics extends zza {
    private static List<Runnable> zzKt = new ArrayList();
    private boolean zzKu;
    private Set<zza> zzKv = new HashSet();
    private boolean zzKw;
    private boolean zzKx;
    private volatile boolean zzKy;
    private boolean zzKz;
    private boolean zzpr;

    interface zza {
        void zzo(Activity activity);

        void zzp(Activity activity);
    }

    class zzb implements ActivityLifecycleCallbacks {
        zzb() {
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.zzm(activity);
        }

        public void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.zzn(activity);
        }
    }

    public GoogleAnalytics(zzf context) {
        super(context);
    }

    public static GoogleAnalytics getInstance(Context context) {
        return zzf.zzX(context).zzis();
    }

    private zzan zzhA() {
        return zzhp().zzhA();
    }

    public static void zzhx() {
        synchronized (GoogleAnalytics.class) {
            if (zzKt != null) {
                for (Runnable run : zzKt) {
                    run.run();
                }
                zzKt = null;
            }
        }
    }

    private com.google.android.gms.analytics.internal.zzb zzhz() {
        return zzhp().zzhz();
    }

    public void dispatchLocalHits() {
        zzhz().zzhV();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.zzKw) {
            application.registerActivityLifecycleCallbacks(new zzb());
            this.zzKw = true;
        }
    }

    public boolean getAppOptOut() {
        return this.zzKy;
    }

    public String getClientId() {
        zzx.zzci("getClientId can not be called from the main thread");
        return zzhp().zziv().zzjd();
    }

    @Deprecated
    public Logger getLogger() {
        return zzae.getLogger();
    }

    public boolean isDryRunEnabled() {
        return this.zzKx;
    }

    public boolean isInitialized() {
        return this.zzpr && !this.zzKu;
    }

    public Tracker newTracker(int configResId) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzhp(), null, null);
            if (configResId > 0) {
                zzal zzal = (zzal) new zzak(zzhp()).zzac(configResId);
                if (zzal != null) {
                    tracker.zza(zzal);
                }
            }
            tracker.zza();
        }
        return tracker;
    }

    public Tracker newTracker(String trackingId) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzhp(), trackingId, null);
            tracker.zza();
        }
        return tracker;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.zzKw) {
            zzm(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.zzKw) {
            zzn(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        this.zzKy = optOut;
        if (this.zzKy) {
            zzhz().zzhU();
        }
    }

    public void setDryRun(boolean dryRun) {
        this.zzKx = dryRun;
    }

    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        zzhz().setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    @Deprecated
    public void setLogger(Logger logger) {
        zzae.setLogger(logger);
        if (!this.zzKz) {
            Log.i((String) zzy.zzNa.get(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzy.zzNa.get()) + " DEBUG");
            this.zzKz = true;
        }
    }

    public void zza() {
        zzhw();
        this.zzpr = true;
    }

    /* access modifiers changed from: 0000 */
    public void zza(zza zza2) {
        this.zzKv.add(zza2);
        Context context = zzhp().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzb(zza zza2) {
        this.zzKv.remove(zza2);
    }

    /* access modifiers changed from: 0000 */
    public void zzhw() {
        zzan zzhA = zzhA();
        if (zzhA.zzkc()) {
            getLogger().setLogLevel(zzhA.getLogLevel());
        }
        if (zzhA.zzkg()) {
            setDryRun(zzhA.zzkh());
        }
        if (zzhA.zzkc()) {
            Logger logger = zzae.getLogger();
            if (logger != null) {
                logger.setLogLevel(zzhA.getLogLevel());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzhy() {
        zzhz().zzhW();
    }

    /* access modifiers changed from: 0000 */
    public void zzm(Activity activity) {
        for (zza zzo : this.zzKv) {
            zzo.zzo(activity);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzn(Activity activity) {
        for (zza zzp : this.zzKv) {
            zzp.zzp(activity);
        }
    }
}
