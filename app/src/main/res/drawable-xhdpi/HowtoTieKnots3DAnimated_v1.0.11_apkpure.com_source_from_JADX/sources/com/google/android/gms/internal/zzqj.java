package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag.zza;
import com.google.android.gms.internal.zzqp.zzb;
import com.google.android.gms.internal.zzqp.zzc;
import com.google.android.gms.internal.zzqp.zzd;
import com.google.android.gms.internal.zzqp.zze;
import com.google.android.gms.internal.zzqp.zzf;
import com.google.android.gms.internal.zzqp.zzg;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzqj {
    static zza zza(int i, JSONArray jSONArray, zza[] zzaArr, Set<Integer> set) throws zzg, JSONException {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            zzfi("Value cycle detected. Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        Object zza = zza(jSONArray, i, "values");
        if (zzaArr[i] != null) {
            return zzaArr[i];
        }
        set.add(Integer.valueOf(i));
        zza zza2 = new zza();
        if (zza instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) zza;
            zza2.type = 2;
            zza2.zzje = true;
            zza2.zziV = new zza[jSONArray2.length()];
            while (i2 < zza2.zziV.length) {
                zza2.zziV[i2] = zza(jSONArray2.getInt(i2), jSONArray, zzaArr, set);
                i2++;
            }
        } else if (zza instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) zza;
            JSONArray optJSONArray = jSONObject.optJSONArray("escaping");
            if (optJSONArray != null) {
                zza2.zzjd = new int[optJSONArray.length()];
                for (int i3 = 0; i3 < zza2.zzjd.length; i3++) {
                    zza2.zzjd[i3] = optJSONArray.getInt(i3);
                }
            }
            if (!jSONObject.has("function_id")) {
                if (!jSONObject.has("macro_reference")) {
                    if (!jSONObject.has("template_token")) {
                        zza2.type = 3;
                        zza2.zzje = true;
                        int length = jSONObject.length();
                        zza2.zziW = new zza[length];
                        zza2.zziX = new zza[length];
                        Iterator keys = jSONObject.keys();
                        while (true) {
                            int i4 = i2;
                            if (!keys.hasNext()) {
                                break;
                            }
                            String str = (String) keys.next();
                            zza2.zziW[i4] = zza(new Integer(str).intValue(), jSONArray, zzaArr, set);
                            zza2.zziX[i4] = zza(jSONObject.getInt(str), jSONArray, zzaArr, set);
                            i2 = i4 + 1;
                        }
                    } else {
                        zza2.type = 7;
                        zza2.zzje = true;
                        JSONArray jSONArray3 = jSONObject.getJSONArray("template_token");
                        zza2.zzjc = new zza[jSONArray3.length()];
                        while (i2 < zza2.zzjc.length) {
                            zza2.zzjc[i2] = zza(jSONArray3.getInt(i2), jSONArray, zzaArr, set);
                            i2++;
                        }
                    }
                } else {
                    zza2.type = 4;
                    zza2.zzje = true;
                    zza2.zziY = zzdf.zzg(zza(jSONObject.getInt("macro_reference"), jSONArray, zzaArr, set));
                }
            } else {
                zza2.type = 5;
                zza2.zziZ = jSONObject.getString("function_id");
            }
        } else if (zza instanceof String) {
            zza2.zziU = (String) zza;
            zza2.type = 1;
        } else if (zza instanceof Boolean) {
            zza2.zzjb = ((Boolean) zza).booleanValue();
            zza2.type = 8;
        } else if (zza instanceof Integer) {
            zza2.zzja = (long) ((Integer) zza).intValue();
            zza2.type = 6;
        } else {
            zzfi("Invalid value type: " + zza);
        }
        zzaArr[i] = zza2;
        set.remove(Integer.valueOf(i));
        return zza2;
    }

    static zzqp.zza zza(JSONObject jSONObject, JSONArray jSONArray, JSONArray jSONArray2, zza[] zzaArr, int i) throws zzg, JSONException {
        zzb zzBC = zzqp.zza.zzBC();
        JSONArray jSONArray3 = jSONObject.getJSONArray("property");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= jSONArray3.length()) {
                return zzBC.zzBE();
            }
            JSONObject jSONObject2 = (JSONObject) zza(jSONArray, jSONArray3.getInt(i3), "properties");
            String str = (String) zza(jSONArray2, jSONObject2.getInt("key"), "key");
            zza zza = (zza) zza((T[]) zzaArr, jSONObject2.getInt("value"), "value");
            if (zzae.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzBC.zzq(zza);
            } else {
                zzBC.zzb(str, zza);
            }
            i2 = i3 + 1;
        }
    }

    static zze zza(JSONObject jSONObject, List<zzqp.zza> list, List<zzqp.zza> list2, List<zzqp.zza> list3, zza[] zzaArr) throws JSONException {
        zzf zzBJ = zze.zzBJ();
        JSONArray optJSONArray = jSONObject.optJSONArray("positive_predicate");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("negative_predicate");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("add_tag");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("remove_tag");
        JSONArray optJSONArray5 = jSONObject.optJSONArray("add_tag_rule_name");
        JSONArray optJSONArray6 = jSONObject.optJSONArray("remove_tag_rule_name");
        JSONArray optJSONArray7 = jSONObject.optJSONArray("add_macro");
        JSONArray optJSONArray8 = jSONObject.optJSONArray("remove_macro");
        JSONArray optJSONArray9 = jSONObject.optJSONArray("add_macro_rule_name");
        JSONArray optJSONArray10 = jSONObject.optJSONArray("remove_macro_rule_name");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                zzBJ.zzd((zzqp.zza) list3.get(optJSONArray.getInt(i2)));
                i = i2 + 1;
            }
        }
        if (optJSONArray2 != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= optJSONArray2.length()) {
                    break;
                }
                zzBJ.zze((zzqp.zza) list3.get(optJSONArray2.getInt(i4)));
                i3 = i4 + 1;
            }
        }
        if (optJSONArray3 != null) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= optJSONArray3.length()) {
                    break;
                }
                zzBJ.zzf((zzqp.zza) list.get(optJSONArray3.getInt(i6)));
                i5 = i6 + 1;
            }
        }
        if (optJSONArray4 != null) {
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= optJSONArray4.length()) {
                    break;
                }
                zzBJ.zzg((zzqp.zza) list.get(optJSONArray4.getInt(i8)));
                i7 = i8 + 1;
            }
        }
        if (optJSONArray5 != null) {
            for (int i9 = 0; i9 < optJSONArray5.length(); i9++) {
                zzBJ.zzfl(zzaArr[optJSONArray5.getInt(i9)].zziU);
            }
        }
        if (optJSONArray6 != null) {
            for (int i10 = 0; i10 < optJSONArray6.length(); i10++) {
                zzBJ.zzfm(zzaArr[optJSONArray6.getInt(i10)].zziU);
            }
        }
        if (optJSONArray7 != null) {
            int i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= optJSONArray7.length()) {
                    break;
                }
                zzBJ.zzh((zzqp.zza) list2.get(optJSONArray7.getInt(i12)));
                i11 = i12 + 1;
            }
        }
        if (optJSONArray8 != null) {
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 >= optJSONArray8.length()) {
                    break;
                }
                zzBJ.zzi((zzqp.zza) list2.get(optJSONArray8.getInt(i14)));
                i13 = i14 + 1;
            }
        }
        if (optJSONArray9 != null) {
            for (int i15 = 0; i15 < optJSONArray9.length(); i15++) {
                zzBJ.zzfn(zzaArr[optJSONArray9.getInt(i15)].zziU);
            }
        }
        if (optJSONArray10 != null) {
            for (int i16 = 0; i16 < optJSONArray10.length(); i16++) {
                zzBJ.zzfo(zzaArr[optJSONArray10.getInt(i16)].zziU);
            }
        }
        return zzBJ.zzBU();
    }

    private static <T> T zza(JSONArray jSONArray, int i, String str) throws zzg {
        if (i >= 0 && i < jSONArray.length()) {
            try {
                return jSONArray.get(i);
            } catch (JSONException e) {
            }
        }
        zzfi("Index out of bounds detected: " + i + " in " + str);
        return null;
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzg {
        if (i < 0 || i >= tArr.length) {
            zzfi("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    static List<zzqp.zza> zza(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, zza[] zzaArr) throws JSONException, zzg {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zza(jSONArray.getJSONObject(i), jSONArray2, jSONArray3, zzaArr, i));
        }
        return arrayList;
    }

    static zzc zzeN(String str) throws JSONException, zzg {
        JSONObject jSONObject = new JSONObject(str);
        Object obj = jSONObject.get("resource");
        if (obj instanceof JSONObject) {
            JSONObject jSONObject2 = (JSONObject) obj;
            zzd zzBF = zzc.zzBF();
            zza[] zzj = zzj(jSONObject2);
            JSONArray jSONArray = jSONObject2.getJSONArray("properties");
            JSONArray jSONArray2 = jSONObject2.getJSONArray("key");
            List zza = zza(jSONObject2.getJSONArray("tags"), jSONArray, jSONArray2, zzj);
            List zza2 = zza(jSONObject2.getJSONArray("predicates"), jSONArray, jSONArray2, zzj);
            List<zzqp.zza> zza3 = zza(jSONObject2.getJSONArray("macros"), jSONArray, jSONArray2, zzj);
            for (zzqp.zza zzc : zza3) {
                zzBF.zzc(zzc);
            }
            JSONArray jSONArray3 = jSONObject2.getJSONArray("rules");
            for (int i = 0; i < jSONArray3.length(); i++) {
                zzBF.zzb(zza(jSONArray3.getJSONObject(i), zza, zza3, zza2, zzj));
            }
            zzBF.zzfk("1");
            zzBF.zzjm(1);
            if (jSONObject.optJSONArray("runtime") != null) {
            }
            return zzBF.zzBI();
        }
        throw new zzg("Resource map not found");
    }

    private static void zzfi(String str) throws zzg {
        zzbg.m28e(str);
        throw new zzg(str);
    }

    static zza[] zzj(JSONObject jSONObject) throws JSONException, zzg {
        Object opt = jSONObject.opt("values");
        if (opt instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) opt;
            zza[] zzaArr = new zza[jSONArray.length()];
            for (int i = 0; i < zzaArr.length; i++) {
                zza(i, jSONArray, zzaArr, (Set<Integer>) new HashSet<Integer>(0));
            }
            return zzaArr;
        }
        throw new zzg("Missing Values list");
    }
}
