package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzr extends zzcz {

    /* renamed from: ID */
    private static final String f56ID = zzad.CONTAINS.toString();

    public zzr() {
        super(f56ID);
    }

    /* access modifiers changed from: protected */
    public boolean zza(String str, String str2, Map<String, zza> map) {
        return str.contains(str2);
    }
}
