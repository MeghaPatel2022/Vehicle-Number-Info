package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzam extends zzbv {

    /* renamed from: ID */
    private static final String f22ID = zzad.GREATER_EQUALS.toString();

    public zzam() {
        super(f22ID);
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzde zzde, zzde zzde2, Map<String, zza> map) {
        return zzde.compareTo(zzde2) >= 0;
    }
}
