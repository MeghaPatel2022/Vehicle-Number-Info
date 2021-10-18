package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzab {
    private final List<Command> zzNY;
    private final long zzNZ;
    private final long zzOa;
    private final int zzOb;
    private final boolean zzOc;
    private final String zzOd;
    private final Map<String, String> zzvs;

    public zzab(zzc zzc, Map<String, String> map, long j, boolean z) {
        this(zzc, map, j, z, 0, 0, null);
    }

    public zzab(zzc zzc, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzc, map, j, z, j2, i, null);
    }

    public zzab(zzc zzc, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        zzx.zzv(zzc);
        zzx.zzv(map);
        this.zzOa = j;
        this.zzOc = z;
        this.zzNZ = j2;
        this.zzOb = i;
        this.zzNY = list != null ? list : Collections.EMPTY_LIST;
        this.zzOd = zze(list);
        HashMap hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (zzj(entry.getKey())) {
                String zza = zza(zzc, entry.getKey());
                if (zza != null) {
                    hashMap.put(zza, zzb(zzc, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!zzj(entry2.getKey())) {
                String zza2 = zza(zzc, entry2.getKey());
                if (zza2 != null) {
                    hashMap.put(zza2, zzb(zzc, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.zzOd)) {
            zzam.zzb((Map<String, String>) hashMap, "_v", this.zzOd);
            if (this.zzOd.equals("ma4.0.0") || this.zzOd.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.zzvs = Collections.unmodifiableMap(hashMap);
    }

    public static zzab zza(zzc zzc, zzab zzab, Map<String, String> map) {
        return new zzab(zzc, map, zzab.zzkk(), zzab.zzkm(), zzab.zzkj(), zzab.zzki(), zzab.zzkl());
    }

    private static String zza(zzc zzc, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            zzc.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    private static String zzb(zzc zzc, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, 8192);
        zzc.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zze(java.util.List<com.google.android.gms.analytics.internal.Command> r5) {
        /*
            r1 = 0
            if (r5 == 0) goto L_0x002c
            java.util.Iterator r2 = r5.iterator()
        L_0x0007:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002c
            java.lang.Object r0 = r2.next()
            com.google.android.gms.analytics.internal.Command r0 = (com.google.android.gms.analytics.internal.Command) r0
            java.lang.String r3 = "appendVersion"
            java.lang.String r4 = r0.getId()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0007
            java.lang.String r0 = r0.getValue()
        L_0x0023:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x002a
        L_0x0029:
            return r1
        L_0x002a:
            r1 = r0
            goto L_0x0029
        L_0x002c:
            r0 = r1
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzab.zze(java.util.List):java.lang.String");
    }

    private static boolean zzj(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private String zzo(String str, String str2) {
        zzx.zzcs(str);
        zzx.zzb(!str.startsWith("&"), (Object) "Short param name required");
        String str3 = (String) this.zzvs.get(str);
        return str3 != null ? str3 : str2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.zzOa);
        if (this.zzNZ != 0) {
            stringBuffer.append(", dbId=").append(this.zzNZ);
        }
        if (((long) this.zzOb) != 0) {
            stringBuffer.append(", appUID=").append(this.zzOb);
        }
        ArrayList<String> arrayList = new ArrayList<>(this.zzvs.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append((String) this.zzvs.get(str));
        }
        return stringBuffer.toString();
    }

    public int zzki() {
        return this.zzOb;
    }

    public long zzkj() {
        return this.zzNZ;
    }

    public long zzkk() {
        return this.zzOa;
    }

    public List<Command> zzkl() {
        return this.zzNY;
    }

    public boolean zzkm() {
        return this.zzOc;
    }

    public long zzkn() {
        return zzam.zzbo(zzo("_s", "0"));
    }

    public String zzko() {
        return zzo("_m", "");
    }

    public Map<String, String> zzn() {
        return this.zzvs;
    }
}
