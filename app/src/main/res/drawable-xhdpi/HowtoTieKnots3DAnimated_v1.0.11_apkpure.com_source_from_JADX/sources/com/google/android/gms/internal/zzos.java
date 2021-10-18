package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

public final class zzos extends zzod<zzos> {
    public String mCategory;
    public String zzaID;
    public String zzaIP;
    public long zzaIQ;

    public String getLabel() {
        return this.zzaID;
    }

    public long getTimeInMillis() {
        return this.zzaIQ;
    }

    public void setTimeInMillis(long milliseconds) {
        this.zzaIQ = milliseconds;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("variableName", this.zzaIP);
        hashMap.put("timeInMillis", Long.valueOf(this.zzaIQ));
        hashMap.put("category", this.mCategory);
        hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzaID);
        return zzA(hashMap);
    }

    public void zza(zzos zzos) {
        if (!TextUtils.isEmpty(this.zzaIP)) {
            zzos.zzdY(this.zzaIP);
        }
        if (this.zzaIQ != 0) {
            zzos.setTimeInMillis(this.zzaIQ);
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzos.zzdR(this.mCategory);
        }
        if (!TextUtils.isEmpty(this.zzaID)) {
            zzos.zzdT(this.zzaID);
        }
    }

    public void zzdR(String str) {
        this.mCategory = str;
    }

    public void zzdT(String str) {
        this.zzaID = str;
    }

    public void zzdY(String str) {
        this.zzaIP = str;
    }

    public String zzxQ() {
        return this.mCategory;
    }

    public String zzyb() {
        return this.zzaIP;
    }
}
