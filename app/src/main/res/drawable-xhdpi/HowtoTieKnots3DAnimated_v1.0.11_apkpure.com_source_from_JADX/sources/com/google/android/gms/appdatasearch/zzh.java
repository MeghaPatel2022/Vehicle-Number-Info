package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh {
    private static final String[] zzPy = {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> zzPz = new HashMap(zzPy.length);

    static {
        for (int i = 0; i < zzPy.length; i++) {
            zzPz.put(zzPy[i], Integer.valueOf(i));
        }
    }

    public static String zzaj(int i) {
        if (i < 0 || i >= zzPy.length) {
            return null;
        }
        return zzPy[i];
    }

    public static int zzbx(String str) {
        Integer num = (Integer) zzPz.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    public static int zzlc() {
        return zzPy.length;
    }
}
