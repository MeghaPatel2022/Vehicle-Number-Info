package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzcy extends zzcz {

    /* renamed from: ID */
    private static final String f43ID = zzad.STARTS_WITH.toString();

    public zzcy() {
        super(f43ID);
    }

    /* access modifiers changed from: protected */
    public boolean zza(String str, String str2, Map<String, zza> map) {
        return str.startsWith(str2);
    }
}
