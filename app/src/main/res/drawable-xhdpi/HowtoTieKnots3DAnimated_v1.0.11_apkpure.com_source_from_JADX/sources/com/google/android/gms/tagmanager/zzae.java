package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzae extends zzcz {

    /* renamed from: ID */
    private static final String f19ID = zzad.ENDS_WITH.toString();

    public zzae() {
        super(f19ID);
    }

    /* access modifiers changed from: protected */
    public boolean zza(String str, String str2, Map<String, zza> map) {
        return str.endsWith(str2);
    }
}
