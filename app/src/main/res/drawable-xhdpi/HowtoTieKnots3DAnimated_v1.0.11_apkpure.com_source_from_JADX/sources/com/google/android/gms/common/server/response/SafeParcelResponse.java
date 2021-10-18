package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.internal.zzlj;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zzlt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String mClassName;
    private final int mVersionCode;
    private final FieldMappingDictionary zzaeY;
    private final Parcel zzaff;
    private final int zzafg;
    private int zzafh;
    private int zzafi;

    SafeParcelResponse(int versionCode, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = versionCode;
        this.zzaff = (Parcel) zzx.zzv(parcel);
        this.zzafg = 2;
        this.zzaeY = fieldMappingDictionary;
        if (this.zzaeY == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzaeY.zzpr();
        }
        this.zzafh = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary dictionary, String className) {
        this.mVersionCode = 1;
        this.zzaff = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzaff, 0);
        this.zzafg = 1;
        this.zzaeY = (FieldMappingDictionary) zzx.zzv(dictionary);
        this.mClassName = (String) zzx.zzv(className);
        this.zzafh = 2;
    }

    private static HashMap<Integer, Entry<String, Field<?, ?>>> zzE(Map<String, Field<?, ?>> map) {
        HashMap<Integer, Entry<String, Field<?, ?>>> hashMap = new HashMap<>();
        for (Entry entry : map.entrySet()) {
            hashMap.put(Integer.valueOf(((Field) entry.getValue()).zzpi()), entry);
        }
        return hashMap;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse zza(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse((SafeParcelable) t, zzb(t), canonicalName);
    }

    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class cls = fastJsonResponse.getClass();
        if (!fieldMappingDictionary.zzb(cls)) {
            Map zzpb = fastJsonResponse.zzpb();
            fieldMappingDictionary.zza(cls, zzpb);
            for (String str : zzpb.keySet()) {
                Field field = (Field) zzpb.get(str);
                Class zzpj = field.zzpj();
                if (zzpj != null) {
                    try {
                        zza(fieldMappingDictionary, (FastJsonResponse) zzpj.newInstance());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + field.zzpj().getCanonicalName(), e);
                    } catch (IllegalAccessException e2) {
                        throw new IllegalStateException("Could not access object of type " + field.zzpj().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void zza(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"").append(zzls.zzcA(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzlj.zzi((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzlj.zzj((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                zzlt.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void zza(StringBuilder sb, Field<?, ?> field, Parcel parcel, int i) {
        switch (field.zzpa()) {
            case 0:
                zzb(sb, field, zza(field, Integer.valueOf(zza.zzg(parcel, i))));
                return;
            case 1:
                zzb(sb, field, zza(field, zza.zzk(parcel, i)));
                return;
            case 2:
                zzb(sb, field, zza(field, Long.valueOf(zza.zzi(parcel, i))));
                return;
            case 3:
                zzb(sb, field, zza(field, Float.valueOf(zza.zzl(parcel, i))));
                return;
            case 4:
                zzb(sb, field, zza(field, Double.valueOf(zza.zzm(parcel, i))));
                return;
            case 5:
                zzb(sb, field, zza(field, zza.zzn(parcel, i)));
                return;
            case 6:
                zzb(sb, field, zza(field, Boolean.valueOf(zza.zzc(parcel, i))));
                return;
            case 7:
                zzb(sb, field, zza(field, zza.zzo(parcel, i)));
                return;
            case 8:
            case 9:
                zzb(sb, field, zza(field, zza.zzr(parcel, i)));
                return;
            case 10:
                zzb(sb, field, zza(field, zzi(zza.zzq(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.zzpa());
        }
    }

    private void zza(StringBuilder sb, String str, Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (field.zzpl()) {
            zza(sb, field, parcel, i);
        } else {
            zzb(sb, field, parcel, i);
        }
    }

    private void zza(StringBuilder sb, Map<String, Field<?, ?>> map, Parcel parcel) {
        HashMap zzE = zzE(map);
        sb.append('{');
        int zzaj = zza.zzaj(parcel);
        boolean z = false;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            Entry entry = (Entry) zzE.get(Integer.valueOf(zza.zzbH(zzai)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                zza(sb, (String) entry.getKey(), (Field) entry.getValue(), parcel, zzai);
                z = true;
            }
        }
        if (parcel.dataPosition() != zzaj) {
            throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
        }
        sb.append('}');
    }

    private static FieldMappingDictionary zzb(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.zzpp();
        fieldMappingDictionary.zzpo();
        return fieldMappingDictionary;
    }

    private void zzb(StringBuilder sb, Field<?, ?> field, Parcel parcel, int i) {
        if (field.zzpg()) {
            sb.append("[");
            switch (field.zzpa()) {
                case 0:
                    zzli.zza(sb, zza.zzu(parcel, i));
                    break;
                case 1:
                    zzli.zza(sb, (T[]) zza.zzw(parcel, i));
                    break;
                case 2:
                    zzli.zza(sb, zza.zzv(parcel, i));
                    break;
                case 3:
                    zzli.zza(sb, zza.zzx(parcel, i));
                    break;
                case 4:
                    zzli.zza(sb, zza.zzy(parcel, i));
                    break;
                case 5:
                    zzli.zza(sb, (T[]) zza.zzz(parcel, i));
                    break;
                case 6:
                    zzli.zza(sb, zza.zzt(parcel, i));
                    break;
                case 7:
                    zzli.zza(sb, zza.zzA(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzE = zza.zzE(parcel, i);
                    int length = zzE.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        zzE[i2].setDataPosition(0);
                        zza(sb, field.zzpn(), zzE[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (field.zzpa()) {
            case 0:
                sb.append(zza.zzg(parcel, i));
                return;
            case 1:
                sb.append(zza.zzk(parcel, i));
                return;
            case 2:
                sb.append(zza.zzi(parcel, i));
                return;
            case 3:
                sb.append(zza.zzl(parcel, i));
                return;
            case 4:
                sb.append(zza.zzm(parcel, i));
                return;
            case 5:
                sb.append(zza.zzn(parcel, i));
                return;
            case 6:
                sb.append(zza.zzc(parcel, i));
                return;
            case 7:
                sb.append("\"").append(zzls.zzcA(zza.zzo(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzlj.zzi(zza.zzr(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzlj.zzj(zza.zzr(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle zzq = zza.zzq(parcel, i);
                Set<String> keySet = zzq.keySet();
                keySet.size();
                sb.append("{");
                boolean z = true;
                for (String str : keySet) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(zzls.zzcA(zzq.getString(str))).append("\"");
                    z = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel zzD = zza.zzD(parcel, i);
                zzD.setDataPosition(0);
                zza(sb, field.zzpn(), zzD);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder sb, Field<?, ?> field, Object obj) {
        if (field.zzpf()) {
            zzb(sb, field, (ArrayList) obj);
        } else {
            zza(sb, field.zzoZ(), obj);
        }
    }

    private void zzb(StringBuilder sb, Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            zza(sb, field.zzoZ(), arrayList.get(i));
        }
        sb.append("]");
    }

    public static HashMap<String, String> zzi(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int describeContents() {
        zze zze = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzx.zzb(this.zzaeY, (Object) "Cannot convert to JSON on client side.");
        Parcel zzpt = zzpt();
        zzpt.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.zzaeY.zzcx(this.mClassName), zzpt);
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zze zze = CREATOR;
        zze.zza(this, out, flags);
    }

    /* access modifiers changed from: protected */
    public Object zzct(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    public boolean zzcu(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Map<String, Field<?, ?>> zzpb() {
        if (this.zzaeY == null) {
            return null;
        }
        return this.zzaeY.zzcx(this.mClassName);
    }

    public Parcel zzpt() {
        switch (this.zzafh) {
            case 0:
                this.zzafi = zzb.zzak(this.zzaff);
                zzb.zzH(this.zzaff, this.zzafi);
                this.zzafh = 2;
                break;
            case 1:
                zzb.zzH(this.zzaff, this.zzafi);
                this.zzafh = 2;
                break;
        }
        return this.zzaff;
    }

    /* access modifiers changed from: 0000 */
    public FieldMappingDictionary zzpu() {
        switch (this.zzafg) {
            case 0:
                return null;
            case 1:
                return this.zzaeY;
            case 2:
                return this.zzaeY;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zzafg);
        }
    }
}
