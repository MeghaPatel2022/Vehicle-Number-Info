package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

public class zzdc {
    private Context mContext;
    private Tracker zzKq;
    private GoogleAnalytics zzKs;

    static class zza implements Logger {
        zza() {
        }

        private static int zzjl(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            zzbg.zzb("", exception);
        }

        public void error(String message) {
            zzbg.m28e(message);
        }

        public int getLogLevel() {
            return zzjl(zzbg.getLogLevel());
        }

        public void info(String message) {
            zzbg.zzaD(message);
        }

        public void setLogLevel(int logLevel) {
            zzbg.zzaE("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            zzbg.m29v(message);
        }

        public void warn(String message) {
            zzbg.zzaE(message);
        }
    }

    public zzdc(Context context) {
        this.mContext = context;
    }

    private synchronized void zzeW(String str) {
        if (this.zzKs == null) {
            this.zzKs = GoogleAnalytics.getInstance(this.mContext);
            this.zzKs.setLogger(new zza());
            this.zzKq = this.zzKs.newTracker(str);
        }
    }

    public Tracker zzeV(String str) {
        zzeW(str);
        return this.zzKq;
    }
}
