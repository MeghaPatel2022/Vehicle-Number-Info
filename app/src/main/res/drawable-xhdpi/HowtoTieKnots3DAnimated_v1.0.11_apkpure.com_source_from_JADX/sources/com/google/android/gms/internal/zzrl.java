package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrm.zza.C1471zza;
import com.google.android.gms.internal.zzrm.zza.C1471zza.C1472zza;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class zzrl {

    public static class zza {
        public final zzrm zzbbp;
        public final List<Asset> zzbbq;

        public zza(zzrm zzrm, List<Asset> list) {
            this.zzbbp = zzrm;
            this.zzbbq = list;
        }
    }

    private static int zza(String str, C1471zza[] zzaArr) {
        int i = 14;
        for (C1471zza zza2 : zzaArr) {
            if (i == 14) {
                if (zza2.type == 9 || zza2.type == 2 || zza2.type == 6) {
                    i = zza2.type;
                } else if (zza2.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + zza2.type + " for key " + str);
                }
            } else if (zza2.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + zza2.type);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzrm zzrm = new zzrm();
        ArrayList arrayList = new ArrayList();
        zzrm.zzbbr = zza(dataMap, (List<Asset>) arrayList);
        return new zza(zzrm, arrayList);
    }

    private static C1471zza zza(List<Asset> list, Object obj) {
        int i;
        int i2 = 0;
        C1471zza zza2 = new C1471zza();
        if (obj == null) {
            zza2.type = 14;
            return zza2;
        }
        zza2.zzbbv = new C1472zza();
        if (obj instanceof String) {
            zza2.type = 2;
            zza2.zzbbv.zzbbx = (String) obj;
        } else if (obj instanceof Integer) {
            zza2.type = 6;
            zza2.zzbbv.zzbbB = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            zza2.type = 5;
            zza2.zzbbv.zzbbA = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            zza2.type = 3;
            zza2.zzbbv.zzbby = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            zza2.type = 4;
            zza2.zzbbv.zzbbz = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            zza2.type = 8;
            zza2.zzbbv.zzbbD = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            zza2.type = 7;
            zza2.zzbbv.zzbbC = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            zza2.type = 1;
            zza2.zzbbv.zzbbw = (byte[]) obj;
        } else if (obj instanceof String[]) {
            zza2.type = 11;
            zza2.zzbbv.zzbbG = (String[]) obj;
        } else if (obj instanceof long[]) {
            zza2.type = 12;
            zza2.zzbbv.zzbbH = (long[]) obj;
        } else if (obj instanceof float[]) {
            zza2.type = 15;
            zza2.zzbbv.zzbbI = (float[]) obj;
        } else if (obj instanceof Asset) {
            zza2.type = 13;
            zza2.zzbbv.zzbbJ = (long) zza(list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            zza2.type = 9;
            DataMap dataMap = (DataMap) obj;
            TreeSet treeSet = new TreeSet(dataMap.keySet());
            com.google.android.gms.internal.zzrm.zza[] zzaArr = new com.google.android.gms.internal.zzrm.zza[treeSet.size()];
            Iterator it = treeSet.iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                zzaArr[i3] = new com.google.android.gms.internal.zzrm.zza();
                zzaArr[i3].name = str;
                zzaArr[i3].zzbbt = zza(list, dataMap.get(str));
                i2 = i3 + 1;
            }
            zza2.zzbbv.zzbbE = zzaArr;
        } else if (obj instanceof ArrayList) {
            zza2.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            C1471zza[] zzaArr2 = new C1471zza[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 14;
            while (i4 < size) {
                Object obj3 = arrayList.get(i4);
                C1471zza zza3 = zza(list, obj3);
                if (zza3.type == 14 || zza3.type == 2 || zza3.type == 6 || zza3.type == 9) {
                    if (i5 == 14 && zza3.type != 14) {
                        i = zza3.type;
                    } else if (zza3.type != i5) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        i = i5;
                    }
                    zzaArr2[i4] = zza3;
                    i4++;
                    i5 = i;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            zza2.zzbbv.zzbbF = zzaArr2;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return zza2;
    }

    public static DataMap zza(zza zza2) {
        com.google.android.gms.internal.zzrm.zza[] zzaArr;
        DataMap dataMap = new DataMap();
        for (com.google.android.gms.internal.zzrm.zza zza3 : zza2.zzbbp.zzbbr) {
            zza(zza2.zzbbq, dataMap, zza3.name, zza3.zzbbt);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, C1472zza zza2, int i) {
        C1471zza[] zzaArr;
        com.google.android.gms.internal.zzrm.zza[] zzaArr2;
        ArrayList arrayList = new ArrayList(zza2.zzbbF.length);
        for (C1471zza zza3 : zza2.zzbbF) {
            if (zza3.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                for (com.google.android.gms.internal.zzrm.zza zza4 : zza3.zzbbv.zzbbE) {
                    zza(list, dataMap, zza4.name, zza4.zzbbt);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(zza3.zzbbv.zzbbx);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(zza3.zzbbv.zzbbB));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, C1471zza zza2) {
        com.google.android.gms.internal.zzrm.zza[] zzaArr;
        int i = zza2.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        C1472zza zza3 = zza2.zzbbv;
        if (i == 1) {
            dataMap.putByteArray(str, zza3.zzbbw);
        } else if (i == 11) {
            dataMap.putStringArray(str, zza3.zzbbG);
        } else if (i == 12) {
            dataMap.putLongArray(str, zza3.zzbbH);
        } else if (i == 15) {
            dataMap.putFloatArray(str, zza3.zzbbI);
        } else if (i == 2) {
            dataMap.putString(str, zza3.zzbbx);
        } else if (i == 3) {
            dataMap.putDouble(str, zza3.zzbby);
        } else if (i == 4) {
            dataMap.putFloat(str, zza3.zzbbz);
        } else if (i == 5) {
            dataMap.putLong(str, zza3.zzbbA);
        } else if (i == 6) {
            dataMap.putInt(str, zza3.zzbbB);
        } else if (i == 7) {
            dataMap.putByte(str, (byte) zza3.zzbbC);
        } else if (i == 8) {
            dataMap.putBoolean(str, zza3.zzbbD);
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, (Asset) list.get((int) zza3.zzbbJ));
        } else if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (com.google.android.gms.internal.zzrm.zza zza4 : zza3.zzbbE) {
                zza(list, dataMap2, zza4.name, zza4.zzbbt);
            }
            dataMap.putDataMap(str, dataMap2);
        } else if (i == 10) {
            int zza5 = zza(str, zza3.zzbbF);
            ArrayList zza6 = zza(list, zza3, zza5);
            if (zza5 == 14) {
                dataMap.putStringArrayList(str, zza6);
            } else if (zza5 == 9) {
                dataMap.putDataMapArrayList(str, zza6);
            } else if (zza5 == 2) {
                dataMap.putStringArrayList(str, zza6);
            } else if (zza5 == 6) {
                dataMap.putIntegerArrayList(str, zza6);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + zza5);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static com.google.android.gms.internal.zzrm.zza[] zza(DataMap dataMap, List<Asset> list) {
        TreeSet treeSet = new TreeSet(dataMap.keySet());
        com.google.android.gms.internal.zzrm.zza[] zzaArr = new com.google.android.gms.internal.zzrm.zza[treeSet.size()];
        int i = 0;
        Iterator it = treeSet.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return zzaArr;
            }
            String str = (String) it.next();
            Object obj = dataMap.get(str);
            zzaArr[i2] = new com.google.android.gms.internal.zzrm.zza();
            zzaArr[i2].name = str;
            zzaArr[i2].zzbbt = zza(list, obj);
            i = i2 + 1;
        }
    }
}
