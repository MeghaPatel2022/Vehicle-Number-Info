package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Map;

public final class zzot implements ActivityLifecycleCallbacks {
    private final zzoj zzaIR;
    private final Map<Activity, zzoq> zzaIS = new HashMap();

    public zzot(zzoj zzoj) {
        zzx.zzv(zzoj);
        this.zzaIR = zzoj;
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Bundle bundle = savedInstanceState.getBundle("com.google.android.gms.measurement.screen_view");
            if (bundle != null) {
                int i = bundle.getInt("id");
                if (i <= 0) {
                    Log.w("com.google.android.gms.measurement.internal.ActivityLifecycleTracker", "Invalid screenId in saved activity state");
                    return;
                }
                zzoq zza = zza(activity, i);
                zza.setScreenName(bundle.getString("name"));
                zza.zzhT(bundle.getInt("referrer_id"));
                zza.zzdU(bundle.getString("referrer_name"));
                zza.zzam(bundle.getBoolean("interstitial"));
                zza.zzxX();
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.zzaIS.remove(activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        if (outState != null) {
            zzoq zzoq = (zzoq) this.zzaIS.get(activity);
            if (zzoq != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", zzoq.zzbp());
                bundle.putString("name", zzoq.zzxT());
                bundle.putInt("referrer_id", zzoq.zzxU());
                bundle.putString("referrer_name", zzoq.zzxV());
                bundle.putBoolean("interstitial", zzoq.zzxY());
                outState.putBundle("com.google.android.gms.measurement.screen_view", bundle);
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        this.zzaIR.zzb(zza(activity, 0), activity);
    }

    public void onActivityStopped(Activity activity) {
    }

    /* access modifiers changed from: 0000 */
    public zzoq zza(Activity activity, int i) {
        zzx.zzv(activity);
        zzoq zzoq = (zzoq) this.zzaIS.get(activity);
        if (zzoq == null) {
            zzoq = i == 0 ? new zzoq(true) : new zzoq(true, i);
            zzoq.setScreenName(activity.getClass().getCanonicalName());
            this.zzaIS.put(activity, zzoq);
        }
        return zzoq;
    }
}
