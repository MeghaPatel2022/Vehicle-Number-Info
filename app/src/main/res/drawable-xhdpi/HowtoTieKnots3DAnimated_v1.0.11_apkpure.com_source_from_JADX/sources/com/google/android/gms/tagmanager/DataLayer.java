package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    private static final Pattern zzaPA = Pattern.compile("(\\d+)\\s*([smhd]?)");
    static final String[] zzaPz = "gtm.lifetime".toString().split("\\.");
    private final ConcurrentHashMap<zzb, Integer> zzaPB;
    private final Map<String, Object> zzaPC;
    private final ReentrantLock zzaPD;
    private final LinkedList<Map<String, Object>> zzaPE;
    private final zzc zzaPF;
    /* access modifiers changed from: private */
    public final CountDownLatch zzaPG;

    static final class zza {
        public final Object zzID;
        public final String zztP;

        zza(String str, Object obj) {
            this.zztP = str;
            this.zzID = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            return this.zztP.equals(zza.zztP) && this.zzID.equals(zza.zzID);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zztP.hashCode()), Integer.valueOf(this.zzID.hashCode())});
        }

        public String toString() {
            return "Key: " + this.zztP + " value: " + this.zzID.toString();
        }
    }

    interface zzb {
        void zzH(Map<String, Object> map);
    }

    interface zzc {

        public interface zza {
            void zzo(List<zza> list);
        }

        void zza(zza zza2);

        void zza(List<zza> list, long j);

        void zzeE(String str);
    }

    DataLayer() {
        this(new zzc() {
            public void zza(zza zza) {
                zza.zzo(new ArrayList());
            }

            public void zza(List<zza> list, long j) {
            }

            public void zzeE(String str) {
            }
        });
    }

    DataLayer(zzc persistentStore) {
        this.zzaPF = persistentStore;
        this.zzaPB = new ConcurrentHashMap<>();
        this.zzaPC = new HashMap();
        this.zzaPD = new ReentrantLock();
        this.zzaPE = new LinkedList<>();
        this.zzaPG = new CountDownLatch(1);
        zzzO();
    }

    public static List<Object> listOf(Object... objects) {
        ArrayList arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objects.length) {
                return hashMap;
            }
            if (!(objects[i2] instanceof String)) {
                throw new IllegalArgumentException("key is not a string: " + objects[i2]);
            }
            hashMap.put(objects[i2], objects[i2 + 1]);
            i = i2 + 2;
        }
    }

    /* access modifiers changed from: private */
    public void zzJ(Map<String, Object> map) {
        this.zzaPD.lock();
        try {
            this.zzaPE.offer(map);
            if (this.zzaPD.getHoldCount() == 1) {
                zzzP();
            }
            zzK(map);
        } finally {
            this.zzaPD.unlock();
        }
    }

    private void zzK(Map<String, Object> map) {
        Long zzL = zzL(map);
        if (zzL != null) {
            List zzN = zzN(map);
            zzN.remove("gtm.lifetime");
            this.zzaPF.zza(zzN, zzL.longValue());
        }
    }

    private Long zzL(Map<String, Object> map) {
        Object zzM = zzM(map);
        if (zzM == null) {
            return null;
        }
        return zzeD(zzM.toString());
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Map<java.lang.String, java.lang.Object>, code=java.lang.Object, for r7v0, types: [java.util.Map<java.lang.String, java.lang.Object>, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object zzM(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.String[] r2 = zzaPz
            int r3 = r2.length
            r0 = 0
            r1 = r0
            r0 = r7
        L_0x0006:
            if (r1 >= r3) goto L_0x000f
            r4 = r2[r1]
            boolean r5 = r0 instanceof java.util.Map
            if (r5 != 0) goto L_0x0010
            r0 = 0
        L_0x000f:
            return r0
        L_0x0010:
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r7 = r0.get(r4)
            int r0 = r1 + 1
            r1 = r0
            r0 = r7
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.DataLayer.zzM(java.util.Map):java.lang.Object");
    }

    private List<zza> zzN(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        zza(map, "", arrayList);
        return arrayList;
    }

    private void zzO(Map<String, Object> map) {
        synchronized (this.zzaPC) {
            for (String str : map.keySet()) {
                zzc(zzj(str, map.get(str)), this.zzaPC);
            }
        }
        zzP(map);
    }

    private void zzP(Map<String, Object> map) {
        for (zzb zzH : this.zzaPB.keySet()) {
            zzH.zzH(map);
        }
    }

    private void zza(Map<String, Object> map, String str, Collection<zza> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                zza((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new zza(str2, entry.getValue()));
            }
        }
    }

    static Long zzeD(String str) {
        long j;
        Matcher matcher = zzaPA.matcher(str);
        if (!matcher.matches()) {
            zzbg.zzaD("unknown _lifetime: " + str);
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException e) {
            zzbg.zzaE("illegal number in _lifetime value: " + str);
            j = 0;
        }
        if (j <= 0) {
            zzbg.zzaD("non-positive _lifetime: " + str);
            return null;
        }
        String group = matcher.group(2);
        if (group.length() == 0) {
            return Long.valueOf(j);
        }
        switch (group.charAt(0)) {
            case 'd':
                return Long.valueOf(j * 1000 * 60 * 60 * 24);
            case 'h':
                return Long.valueOf(j * 1000 * 60 * 60);
            case 'm':
                return Long.valueOf(j * 1000 * 60);
            case 's':
                return Long.valueOf(j * 1000);
            default:
                zzbg.zzaE("unknown units in _lifetime: " + str);
                return null;
        }
    }

    private void zzzO() {
        this.zzaPF.zza(new zza() {
            public void zzo(List<zza> list) {
                for (zza zza : list) {
                    DataLayer.this.zzJ(DataLayer.this.zzj(zza.zztP, zza.zzID));
                }
                DataLayer.this.zzaPG.countDown();
            }
        });
    }

    private void zzzP() {
        int i = 0;
        while (true) {
            int i2 = i;
            Map map = (Map) this.zzaPE.poll();
            if (map != null) {
                zzO(map);
                i = i2 + 1;
                if (i > 500) {
                    this.zzaPE.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
            } else {
                return;
            }
        }
    }

    public Object get(String key) {
        synchronized (this.zzaPC) {
            Object obj = this.zzaPC;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj2 = obj;
            int i = 0;
            while (i < length) {
                String str = split[i];
                if (!(obj2 instanceof Map)) {
                    return null;
                }
                Object obj3 = ((Map) obj2).get(str);
                if (obj3 == null) {
                    return null;
                }
                i++;
                obj2 = obj3;
            }
            return obj2;
        }
    }

    public void push(String key, Object value) {
        push(zzj(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.zzaPG.await();
        } catch (InterruptedException e) {
            zzbg.zzaE("DataLayer.push: unexpected InterruptedException");
        }
        zzJ(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        HashMap hashMap = new HashMap(update);
        hashMap.put("event", eventName);
        push(hashMap);
    }

    public String toString() {
        String sb;
        synchronized (this.zzaPC) {
            StringBuilder sb2 = new StringBuilder();
            for (Entry entry : this.zzaPC.entrySet()) {
                sb2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzb zzb2) {
        this.zzaPB.put(zzb2, Integer.valueOf(0));
    }

    /* access modifiers changed from: 0000 */
    public void zzb(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                Object obj = list.get(i2);
                if (obj instanceof List) {
                    if (!(list2.get(i2) instanceof List)) {
                        list2.set(i2, new ArrayList());
                    }
                    zzb((List) obj, (List) list2.get(i2));
                } else if (obj instanceof Map) {
                    if (!(list2.get(i2) instanceof Map)) {
                        list2.set(i2, new HashMap());
                    }
                    zzc((Map) obj, (Map) list2.get(i2));
                } else if (obj != OBJECT_NOT_PRESENT) {
                    list2.set(i2, obj);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzc(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                zzb((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                zzc((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzeC(String str) {
        push(str, null);
        this.zzaPF.zzeE(str);
    }

    /* access modifiers changed from: 0000 */
    public Map<String, Object> zzj(String str, Object obj) {
        HashMap hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        HashMap hashMap2 = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap3 = new HashMap();
            hashMap2.put(split[i], hashMap3);
            i++;
            hashMap2 = hashMap3;
        }
        hashMap2.put(split[split.length - 1], obj);
        return hashMap;
    }
}
