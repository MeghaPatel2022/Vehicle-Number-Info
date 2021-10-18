package com.google.android.gms.analytics.internal;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

public class zzal implements zzp {
    public double zzOE = -1.0d;
    public int zzOF = -1;
    public int zzOG = -1;
    public int zzOH = -1;
    public int zzOI = -1;
    public Map<String, String> zzOJ = new HashMap();
    public String zztw;

    public int getSessionTimeout() {
        return this.zzOF;
    }

    public String getTrackingId() {
        return this.zztw;
    }

    public String zzbm(String str) {
        String str2 = (String) this.zzOJ.get(str);
        return str2 != null ? str2 : str;
    }

    public boolean zzkM() {
        return this.zztw != null;
    }

    public boolean zzkN() {
        return this.zzOE >= 0.0d;
    }

    public double zzkO() {
        return this.zzOE;
    }

    public boolean zzkP() {
        return this.zzOF >= 0;
    }

    public boolean zzkQ() {
        return this.zzOG != -1;
    }

    public boolean zzkR() {
        return this.zzOG == 1;
    }

    public boolean zzkS() {
        return this.zzOH != -1;
    }

    public boolean zzkT() {
        return this.zzOH == 1;
    }

    public boolean zzkU() {
        return this.zzOI == 1;
    }

    public String zzr(Activity activity) {
        return zzbm(activity.getClass().getCanonicalName());
    }
}
