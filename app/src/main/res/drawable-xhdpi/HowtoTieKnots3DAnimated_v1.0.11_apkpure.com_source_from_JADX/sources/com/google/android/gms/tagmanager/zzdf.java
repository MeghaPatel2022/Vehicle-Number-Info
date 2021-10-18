package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzdf {
    private static final Object zzaSN = null;
    private static Long zzaSO = new Long(0);
    private static Double zzaSP = new Double(0.0d);
    private static zzde zzaSQ = zzde.zzT(0);
    private static String zzaSR = new String("");
    private static Boolean zzaSS = new Boolean(false);
    private static List<Object> zzaST = new ArrayList(0);
    private static Map<Object, Object> zzaSU = new HashMap();
    private static zza zzaSV = zzK(zzaSR);

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        zzbg.m28e("getDouble received non-Number");
        return 0.0d;
    }

    public static Object zzBa() {
        return zzaSN;
    }

    public static Long zzBb() {
        return zzaSO;
    }

    public static Double zzBc() {
        return zzaSP;
    }

    public static Boolean zzBd() {
        return zzaSS;
    }

    public static zzde zzBe() {
        return zzaSQ;
    }

    public static String zzBf() {
        return zzaSR;
    }

    public static zza zzBg() {
        return zzaSV;
    }

    public static String zzF(Object obj) {
        return obj == null ? zzaSR : obj.toString();
    }

    public static zzde zzG(Object obj) {
        return obj instanceof zzde ? (zzde) obj : zzM(obj) ? zzde.zzT(zzN(obj)) : zzL(obj) ? zzde.zza(Double.valueOf(getDouble(obj))) : zzeZ(zzF(obj));
    }

    public static Long zzH(Object obj) {
        return zzM(obj) ? Long.valueOf(zzN(obj)) : zzfa(zzF(obj));
    }

    public static Double zzI(Object obj) {
        return zzL(obj) ? Double.valueOf(getDouble(obj)) : zzfb(zzF(obj));
    }

    public static Boolean zzJ(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : zzfc(zzF(obj));
    }

    public static zza zzK(Object obj) {
        boolean z = false;
        zza zza = new zza();
        if (obj instanceof zza) {
            return (zza) obj;
        }
        if (obj instanceof String) {
            zza.type = 1;
            zza.zziU = (String) obj;
        } else if (obj instanceof List) {
            zza.type = 2;
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            boolean z2 = false;
            for (Object zzK : list) {
                zza zzK2 = zzK(zzK);
                if (zzK2 == zzaSV) {
                    return zzaSV;
                }
                boolean z3 = z2 || zzK2.zzje;
                arrayList.add(zzK2);
                z2 = z3;
            }
            zza.zziV = (zza[]) arrayList.toArray(new zza[0]);
            z = z2;
        } else if (obj instanceof Map) {
            zza.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(entrySet.size());
            ArrayList arrayList3 = new ArrayList(entrySet.size());
            boolean z4 = false;
            for (Entry entry : entrySet) {
                zza zzK3 = zzK(entry.getKey());
                zza zzK4 = zzK(entry.getValue());
                if (zzK3 == zzaSV || zzK4 == zzaSV) {
                    return zzaSV;
                }
                boolean z5 = z4 || zzK3.zzje || zzK4.zzje;
                arrayList2.add(zzK3);
                arrayList3.add(zzK4);
                z4 = z5;
            }
            zza.zziW = (zza[]) arrayList2.toArray(new zza[0]);
            zza.zziX = (zza[]) arrayList3.toArray(new zza[0]);
            z = z4;
        } else if (zzL(obj)) {
            zza.type = 1;
            zza.zziU = obj.toString();
        } else if (zzM(obj)) {
            zza.type = 6;
            zza.zzja = zzN(obj);
        } else if (obj instanceof Boolean) {
            zza.type = 8;
            zza.zzjb = ((Boolean) obj).booleanValue();
        } else {
            zzbg.m28e("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return zzaSV;
        }
        zza.zzje = z;
        return zza;
    }

    private static boolean zzL(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzde) && ((zzde) obj).zzAV());
    }

    private static boolean zzM(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzde) && ((zzde) obj).zzAW());
    }

    private static long zzN(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzbg.m28e("getInt64 received non-Number");
        return 0;
    }

    public static zza zzeY(String str) {
        zza zza = new zza();
        zza.type = 5;
        zza.zziZ = str;
        return zza;
    }

    private static zzde zzeZ(String str) {
        try {
            return zzde.zzeX(str);
        } catch (NumberFormatException e) {
            zzbg.m28e("Failed to convert '" + str + "' to a number.");
            return zzaSQ;
        }
    }

    private static Long zzfa(String str) {
        zzde zzeZ = zzeZ(str);
        return zzeZ == zzaSQ ? zzaSO : Long.valueOf(zzeZ.longValue());
    }

    private static Double zzfb(String str) {
        zzde zzeZ = zzeZ(str);
        return zzeZ == zzaSQ ? zzaSP : Double.valueOf(zzeZ.doubleValue());
    }

    private static Boolean zzfc(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : zzaSS;
    }

    public static String zzg(zza zza) {
        return zzF(zzl(zza));
    }

    public static zzde zzh(zza zza) {
        return zzG(zzl(zza));
    }

    public static Long zzi(zza zza) {
        return zzH(zzl(zza));
    }

    public static Double zzj(zza zza) {
        return zzI(zzl(zza));
    }

    public static Boolean zzk(zza zza) {
        return zzJ(zzl(zza));
    }

    public static Object zzl(zza zza) {
        int i = 0;
        if (zza == null) {
            return zzaSN;
        }
        switch (zza.type) {
            case 1:
                return zza.zziU;
            case 2:
                ArrayList arrayList = new ArrayList(zza.zziV.length);
                zza[] zzaArr = zza.zziV;
                int length = zzaArr.length;
                while (i < length) {
                    Object zzl = zzl(zzaArr[i]);
                    if (zzl == zzaSN) {
                        return zzaSN;
                    }
                    arrayList.add(zzl);
                    i++;
                }
                return arrayList;
            case 3:
                if (zza.zziW.length != zza.zziX.length) {
                    zzbg.m28e("Converting an invalid value to object: " + zza.toString());
                    return zzaSN;
                }
                HashMap hashMap = new HashMap(zza.zziX.length);
                while (i < zza.zziW.length) {
                    Object zzl2 = zzl(zza.zziW[i]);
                    Object zzl3 = zzl(zza.zziX[i]);
                    if (zzl2 == zzaSN || zzl3 == zzaSN) {
                        return zzaSN;
                    }
                    hashMap.put(zzl2, zzl3);
                    i++;
                }
                return hashMap;
            case 4:
                zzbg.m28e("Trying to convert a macro reference to object");
                return zzaSN;
            case 5:
                zzbg.m28e("Trying to convert a function id to object");
                return zzaSN;
            case 6:
                return Long.valueOf(zza.zzja);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                zza[] zzaArr2 = zza.zzjc;
                int length2 = zzaArr2.length;
                while (i < length2) {
                    String zzg = zzg(zzaArr2[i]);
                    if (zzg == zzaSR) {
                        return zzaSN;
                    }
                    stringBuffer.append(zzg);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(zza.zzjb);
            default:
                zzbg.m28e("Failed to convert a value of type: " + zza.type);
                return zzaSN;
        }
    }
}
