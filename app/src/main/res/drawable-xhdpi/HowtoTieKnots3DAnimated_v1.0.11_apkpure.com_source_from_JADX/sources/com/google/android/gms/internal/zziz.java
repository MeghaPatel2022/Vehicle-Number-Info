package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zziz extends zzod<zziz> {
    private Map<Integer, Double> zzLb = new HashMap(4);

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.zzLb.entrySet()) {
            hashMap.put("metric" + entry.getKey(), entry.getValue());
        }
        return zzA(hashMap);
    }

    public void zza(zziz zziz) {
        zziz.zzLb.putAll(this.zzLb);
    }

    public Map<Integer, Double> zzhI() {
        return Collections.unmodifiableMap(this.zzLb);
    }
}
