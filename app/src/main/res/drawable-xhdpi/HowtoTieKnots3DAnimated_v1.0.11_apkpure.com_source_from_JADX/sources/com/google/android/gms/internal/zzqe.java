package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.tagmanager.Container;

class zzqe {
    private final Context mContext;
    private final zzqf zzpo;

    static class zza implements com.google.android.gms.internal.zzoj.zza {
        private final Tracker zzKq;

        zza(Tracker tracker) {
            this.zzKq = tracker;
        }

        public void zza(zzoq zzoq) {
            this.zzKq.setScreenName(zzoq.zzxT());
            ScreenViewBuilder screenViewBuilder = new ScreenViewBuilder();
            screenViewBuilder.set("&a", String.valueOf(zzoq.zzbp()));
            this.zzKq.send(screenViewBuilder.build());
        }

        public void zza(zzoq zzoq, Activity activity) {
        }
    }

    public zzqe(Context context, Container container, zzqf zzqf) {
        this.mContext = context;
        this.zzpo = zza(container, zzqf);
        zzBi();
    }

    private void zzBi() {
        if (this.zzpo.zzBk() && !TextUtils.isEmpty(this.zzpo.getTrackingId())) {
            Tracker zzfg = zzfg(this.zzpo.getTrackingId());
            zzfg.enableAdvertisingIdCollection(this.zzpo.zzBl());
            zzb(new zza(zzfg));
        }
    }

    static zzqf zza(Container container, zzqf zzqf) {
        if (container == null || container.isDefault()) {
            return zzqf;
        }
        com.google.android.gms.internal.zzqf.zza zza2 = new com.google.android.gms.internal.zzqf.zza(zzqf.zzBj());
        zza2.zzfh(container.getString("trackingId")).zzau(container.getBoolean("trackScreenViews")).zzav(container.getBoolean("collectAdIdentifiers"));
        return zza2.zzBm();
    }

    public zzqf zzBh() {
        return this.zzpo;
    }

    /* access modifiers changed from: 0000 */
    public void zzb(com.google.android.gms.internal.zzoj.zza zza2) {
        zzx.zzv(zza2);
        zzoj zzaJ = zzoj.zzaJ(this.mContext);
        zzaJ.zzaj(true);
        zzaJ.zza(zza2);
    }

    /* access modifiers changed from: 0000 */
    public Tracker zzfg(String str) {
        return GoogleAnalytics.getInstance(this.mContext).newTracker(str);
    }
}
