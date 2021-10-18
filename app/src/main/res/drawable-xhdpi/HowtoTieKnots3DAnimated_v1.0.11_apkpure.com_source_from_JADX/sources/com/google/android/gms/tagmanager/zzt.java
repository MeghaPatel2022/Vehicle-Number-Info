package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class zzt extends zzak {

    /* renamed from: ID */
    private static final String f57ID = zzad.FUNCTION_CALL.toString();
    private static final String zzaOL = zzae.ADDITIONAL_PARAMS.toString();
    private static final String zzaPx = zzae.FUNCTION_CALL_NAME.toString();
    private final zza zzaPy;

    public interface zza {
        Object zzd(String str, Map<String, Object> map);
    }

    public zzt(zza zza2) {
        super(f57ID, zzaPx);
        this.zzaPy = zza2;
    }

    public com.google.android.gms.internal.zzag.zza zzG(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        String zzg = zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(zzaPx));
        HashMap hashMap = new HashMap();
        com.google.android.gms.internal.zzag.zza zza2 = (com.google.android.gms.internal.zzag.zza) map.get(zzaOL);
        if (zza2 != null) {
            Object zzl = zzdf.zzl(zza2);
            if (!(zzl instanceof Map)) {
                zzbg.zzaE("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzdf.zzBg();
            }
            for (Entry entry : ((Map) zzl).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzdf.zzK(this.zzaPy.zzd(zzg, hashMap));
        } catch (Exception e) {
            zzbg.zzaE("Custom macro/tag " + zzg + " threw exception " + e.getMessage());
            return zzdf.zzBg();
        }
    }

    public boolean zzzx() {
        return false;
    }
}
