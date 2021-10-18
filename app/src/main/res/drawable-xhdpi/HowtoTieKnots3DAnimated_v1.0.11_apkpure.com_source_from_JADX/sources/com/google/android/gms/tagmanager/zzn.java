package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzn extends zzak {

    /* renamed from: ID */
    private static final String f54ID = zzad.CONSTANT.toString();
    private static final String VALUE = zzae.VALUE.toString();

    public zzn() {
        super(f54ID, VALUE);
    }

    public static String zzzA() {
        return f54ID;
    }

    public static String zzzB() {
        return VALUE;
    }

    public zza zzG(Map<String, zza> map) {
        return (zza) map.get(VALUE);
    }

    public boolean zzzx() {
        return true;
    }
}
