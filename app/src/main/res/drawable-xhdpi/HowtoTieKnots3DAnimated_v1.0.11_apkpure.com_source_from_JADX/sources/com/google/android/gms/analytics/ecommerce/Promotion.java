package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzod;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    Map<String, String> zzLj = new HashMap();

    /* access modifiers changed from: 0000 */
    public void put(String name, String value) {
        zzx.zzb(name, (Object) "Name should be non-null");
        this.zzLj.put(name, value);
    }

    public Promotion setCreative(String value) {
        put("cr", value);
        return this;
    }

    public Promotion setId(String value) {
        put("id", value);
        return this;
    }

    public Promotion setName(String value) {
        put("nm", value);
        return this;
    }

    public Promotion setPosition(String value) {
        put("ps", value);
        return this;
    }

    public String toString() {
        return zzod.zzF(this.zzLj);
    }

    public Map<String, String> zzaV(String str) {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.zzLj.entrySet()) {
            hashMap.put(str + ((String) entry.getKey()), entry.getValue());
        }
        return hashMap;
    }
}
