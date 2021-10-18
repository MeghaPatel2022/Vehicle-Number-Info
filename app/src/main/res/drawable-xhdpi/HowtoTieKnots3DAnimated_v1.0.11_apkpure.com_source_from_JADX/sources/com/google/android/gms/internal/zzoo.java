package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

public final class zzoo extends zzod<zzoo> {
    private String mCategory;
    private String zzOj;
    private String zzaID;
    private long zzasE;

    public String getAction() {
        return this.zzOj;
    }

    public String getLabel() {
        return this.zzaID;
    }

    public long getValue() {
        return this.zzasE;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.mCategory);
        hashMap.put("action", this.zzOj);
        hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzaID);
        hashMap.put("value", Long.valueOf(this.zzasE));
        return zzA(hashMap);
    }

    public void zzM(long j) {
        this.zzasE = j;
    }

    public void zza(zzoo zzoo) {
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzoo.zzdR(this.mCategory);
        }
        if (!TextUtils.isEmpty(this.zzOj)) {
            zzoo.zzdS(this.zzOj);
        }
        if (!TextUtils.isEmpty(this.zzaID)) {
            zzoo.zzdT(this.zzaID);
        }
        if (this.zzasE != 0) {
            zzoo.zzM(this.zzasE);
        }
    }

    public void zzdR(String str) {
        this.mCategory = str;
    }

    public void zzdS(String str) {
        this.zzOj = str;
    }

    public void zzdT(String str) {
        this.zzaID = str;
    }

    public String zzxQ() {
        return this.mCategory;
    }
}
