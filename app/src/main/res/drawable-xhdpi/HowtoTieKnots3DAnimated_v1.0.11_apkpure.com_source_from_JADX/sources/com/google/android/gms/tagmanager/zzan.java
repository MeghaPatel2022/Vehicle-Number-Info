package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzan extends zzbv {

    /* renamed from: ID */
    private static final String f23ID = zzad.GREATER_THAN.toString();

    public zzan() {
        super(f23ID);
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzde zzde, zzde zzde2, Map<String, zza> map) {
        return zzde.compareTo(zzde2) > 0;
    }
}
