package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

public final class zzop extends zzod<zzop> {
    public boolean zzaIE;
    public String zzaoB;

    public String getDescription() {
        return this.zzaoB;
    }

    public void setDescription(String description) {
        this.zzaoB = description;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzaoB);
        hashMap.put("fatal", Boolean.valueOf(this.zzaIE));
        return zzA(hashMap);
    }

    public void zza(zzop zzop) {
        if (!TextUtils.isEmpty(this.zzaoB)) {
            zzop.setDescription(this.zzaoB);
        }
        if (this.zzaIE) {
            zzop.zzak(this.zzaIE);
        }
    }

    public void zzak(boolean z) {
        this.zzaIE = z;
    }

    public boolean zzxR() {
        return this.zzaIE;
    }
}
