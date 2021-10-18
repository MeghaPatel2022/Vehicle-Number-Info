package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzlj;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zzlt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public static class Field<I, O> implements SafeParcelable {
        public static final zza CREATOR = new zza();
        private final int mVersionCode;
        protected final int zzaeQ;
        protected final boolean zzaeR;
        protected final int zzaeS;
        protected final boolean zzaeT;
        protected final String zzaeU;
        protected final int zzaeV;
        protected final Class<? extends FastJsonResponse> zzaeW;
        protected final String zzaeX;
        private FieldMappingDictionary zzaeY;
        /* access modifiers changed from: private */
        public zza<I, O> zzaeZ;

        Field(int versionCode, int typeIn, boolean typeInArray, int typeOut, boolean typeOutArray, String outputFieldName, int safeParcelableFieldId, String concreteTypeName, ConverterWrapper wrappedConverter) {
            this.mVersionCode = versionCode;
            this.zzaeQ = typeIn;
            this.zzaeR = typeInArray;
            this.zzaeS = typeOut;
            this.zzaeT = typeOutArray;
            this.zzaeU = outputFieldName;
            this.zzaeV = safeParcelableFieldId;
            if (concreteTypeName == null) {
                this.zzaeW = null;
                this.zzaeX = null;
            } else {
                this.zzaeW = SafeParcelResponse.class;
                this.zzaeX = concreteTypeName;
            }
            if (wrappedConverter == null) {
                this.zzaeZ = null;
            } else {
                this.zzaeZ = wrappedConverter.zzoX();
            }
        }

        protected Field(int typeIn, boolean typeInArray, int typeOut, boolean typeOutArray, String outputFieldName, int safeParcelableFieldId, Class<? extends FastJsonResponse> concreteType, zza<I, O> converter) {
            this.mVersionCode = 1;
            this.zzaeQ = typeIn;
            this.zzaeR = typeInArray;
            this.zzaeS = typeOut;
            this.zzaeT = typeOutArray;
            this.zzaeU = outputFieldName;
            this.zzaeV = safeParcelableFieldId;
            this.zzaeW = concreteType;
            if (concreteType == null) {
                this.zzaeX = null;
            } else {
                this.zzaeX = concreteType.getCanonicalName();
            }
            this.zzaeZ = converter;
        }

        public static Field zza(String str, int i, zza<?, ?> zza, boolean z) {
            return new Field(zza.zzoZ(), z, zza.zzpa(), false, str, i, null, zza);
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        public static Field<Integer, Integer> zzj(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        public static Field<Double, Double> zzk(String str, int i) {
            return new Field<>(4, false, 4, false, str, i, null, null);
        }

        public static Field<Boolean, Boolean> zzl(String str, int i) {
            return new Field<>(6, false, 6, false, str, i, null, null);
        }

        public static Field<String, String> zzm(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> zzn(String str, int i) {
            return new Field<>(7, true, 7, true, str, i, null, null);
        }

        public I convertBack(O output) {
            return this.zzaeZ.convertBack(output);
        }

        public int describeContents() {
            zza zza = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.mVersionCode).append(10);
            sb.append("                 typeIn=").append(this.zzaeQ).append(10);
            sb.append("            typeInArray=").append(this.zzaeR).append(10);
            sb.append("                typeOut=").append(this.zzaeS).append(10);
            sb.append("           typeOutArray=").append(this.zzaeT).append(10);
            sb.append("        outputFieldName=").append(this.zzaeU).append(10);
            sb.append("      safeParcelFieldId=").append(this.zzaeV).append(10);
            sb.append("       concreteTypeName=").append(zzpk()).append(10);
            if (zzpj() != null) {
                sb.append("     concreteType.class=").append(zzpj().getCanonicalName()).append(10);
            }
            sb.append("          converterName=").append(this.zzaeZ == null ? "null" : this.zzaeZ.getClass().getCanonicalName()).append(10);
            return sb.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            zza zza = CREATOR;
            zza.zza(this, out, flags);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.zzaeY = fieldMappingDictionary;
        }

        public int zzoZ() {
            return this.zzaeQ;
        }

        public int zzpa() {
            return this.zzaeS;
        }

        public Field<I, O> zzpe() {
            return new Field<>(this.mVersionCode, this.zzaeQ, this.zzaeR, this.zzaeS, this.zzaeT, this.zzaeU, this.zzaeV, this.zzaeX, zzpm());
        }

        public boolean zzpf() {
            return this.zzaeR;
        }

        public boolean zzpg() {
            return this.zzaeT;
        }

        public String zzph() {
            return this.zzaeU;
        }

        public int zzpi() {
            return this.zzaeV;
        }

        public Class<? extends FastJsonResponse> zzpj() {
            return this.zzaeW;
        }

        /* access modifiers changed from: 0000 */
        public String zzpk() {
            if (this.zzaeX == null) {
                return null;
            }
            return this.zzaeX;
        }

        public boolean zzpl() {
            return this.zzaeZ != null;
        }

        /* access modifiers changed from: 0000 */
        public ConverterWrapper zzpm() {
            if (this.zzaeZ == null) {
                return null;
            }
            return ConverterWrapper.zza(this.zzaeZ);
        }

        public Map<String, Field<?, ?>> zzpn() {
            zzx.zzv(this.zzaeX);
            zzx.zzv(this.zzaeY);
            return this.zzaeY.zzcx(this.zzaeX);
        }
    }

    public interface zza<I, O> {
        I convertBack(O o);

        int zzoZ();

        int zzpa();
    }

    private void zza(StringBuilder sb, Field field, Object obj) {
        if (field.zzoZ() == 11) {
            sb.append(((FastJsonResponse) field.zzpj().cast(obj)).toString());
        } else if (field.zzoZ() == 7) {
            sb.append("\"");
            sb.append(zzls.zzcA((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }

    private void zza(StringBuilder sb, Field field, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(sb, field, obj);
            }
        }
        sb.append("]");
    }

    public String toString() {
        Map zzpb = zzpb();
        StringBuilder sb = new StringBuilder(100);
        for (String str : zzpb.keySet()) {
            Field field = (Field) zzpb.get(str);
            if (zza(field)) {
                Object zza2 = zza(field, zzb(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (zza2 != null) {
                    switch (field.zzpa()) {
                        case 8:
                            sb.append("\"").append(zzlj.zzi((byte[]) zza2)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(zzlj.zzj((byte[]) zza2)).append("\"");
                            break;
                        case 10:
                            zzlt.zza(sb, (HashMap) zza2);
                            break;
                        default:
                            if (!field.zzpf()) {
                                zza(sb, field, zza2);
                                break;
                            } else {
                                zza(sb, field, (ArrayList) zza2);
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public <O, I> I zza(Field<I, O> field, Object obj) {
        return field.zzaeZ != null ? field.convertBack(obj) : obj;
    }

    /* access modifiers changed from: protected */
    public boolean zza(Field field) {
        return field.zzpa() == 11 ? field.zzpg() ? zzcw(field.zzph()) : zzcv(field.zzph()) : zzcu(field.zzph());
    }

    /* access modifiers changed from: protected */
    public Object zzb(Field field) {
        String zzph = field.zzph();
        if (field.zzpj() == null) {
            return zzct(field.zzph());
        }
        zzx.zza(zzct(field.zzph()) == null, "Concrete field shouldn't be value object: %s", field.zzph());
        HashMap zzpc = field.zzpg() ? zzpd() : zzpc();
        if (zzpc != null) {
            return zzpc.get(zzph);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(zzph.charAt(0)) + zzph.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zzct(String str);

    /* access modifiers changed from: protected */
    public abstract boolean zzcu(String str);

    /* access modifiers changed from: protected */
    public boolean zzcv(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    public boolean zzcw(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract Map<String, Field<?, ?>> zzpb();

    public HashMap<String, Object> zzpc() {
        return null;
    }

    public HashMap<String, Object> zzpd() {
        return null;
    }
}
