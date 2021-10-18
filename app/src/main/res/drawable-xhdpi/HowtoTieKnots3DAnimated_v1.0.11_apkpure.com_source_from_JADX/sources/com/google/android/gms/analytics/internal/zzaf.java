package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;
import java.util.Map.Entry;

public class zzaf extends zzd {
    private static String zzOl = "3";
    private static String zzOm = "01VDIWEA?";
    private static zzaf zzOn;

    public zzaf(zzf zzf) {
        super(zzf);
    }

    public static zzaf zzkq() {
        return zzOn;
    }

    public void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        String str2 = (String) zzy.zzNa.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, zzc(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    public void zza(zzab zzab, String str) {
        if (str == null) {
            str = "no reason provided";
        }
        zzd("Discarding hit. " + str, zzab != null ? zzab.toString() : "no hit data");
    }

    public synchronized void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        synchronized (this) {
            zzx.zzv(str);
            if (i >= 0) {
                i2 = i;
            }
            int i3 = i2 >= zzOm.length() ? zzOm.length() - 1 : i2;
            char c = zzif().zzjl() ? zzif().zzjk() ? 'P' : 'C' : zzif().zzjk() ? 'p' : 'c';
            String str2 = zzOl + zzOm.charAt(i3) + c + zze.VERSION + ":" + zzc(str, zzk(obj), zzk(obj2), zzk(obj3));
            if (str2.length() > 1024) {
                str2 = str2.substring(0, 1024);
            }
            zzai zzit = zzia().zzit();
            if (zzit != null) {
                zzit.zzkD().zzbl(str2);
            }
        }
    }

    public void zzh(Map<String, String> map, String str) {
        String str2;
        if (str == null) {
            str = "no reason provided";
        }
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append((String) entry.getKey());
                sb.append('=');
                sb.append((String) entry.getValue());
            }
            str2 = sb.toString();
        } else {
            str2 = "no hit data";
        }
        zzd("Discarding hit. " + str, str2);
    }

    /* access modifiers changed from: protected */
    public void zzhB() {
        synchronized (zzaf.class) {
            zzOn = this;
        }
    }

    /* access modifiers changed from: protected */
    public String zzk(Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj instanceof Integer ? new Long((long) ((Integer) obj).intValue()) : obj;
        if (!(obj2 instanceof Long)) {
            return obj2 instanceof Boolean ? String.valueOf(obj2) : obj2 instanceof Throwable ? obj2.getClass().getCanonicalName() : "-";
        }
        if (Math.abs(((Long) obj2).longValue()) < 100) {
            return String.valueOf(obj2);
        }
        String str = String.valueOf(obj2).charAt(0) == '-' ? "-" : "";
        String valueOf = String.valueOf(Math.abs(((Long) obj2).longValue()));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))));
        sb.append("...");
        sb.append(str);
        sb.append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d));
        return sb.toString();
    }
}
