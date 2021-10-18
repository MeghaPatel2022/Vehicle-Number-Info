package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.Iterator;
import java.util.List;

public class zzc implements zzf<String> {
    /* renamed from: zza */
    public <T> String zzb(zzb<T> zzb, T t) {
        return String.format("contains(%s,%s)", new Object[]{zzb.getName(), t});
    }

    /* renamed from: zza */
    public <T> String zzb(Operator operator, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", new Object[]{operator.getTag(), metadataField.getName(), t});
    }

    /* renamed from: zza */
    public String zzb(Operator operator, List<String> list) {
        StringBuilder sb = new StringBuilder(operator.getTag() + "(");
        String str = "";
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return sb.append(")").toString();
            }
            String str3 = (String) it.next();
            sb.append(str2);
            sb.append(str3);
            str = ",";
        }
    }

    /* renamed from: zzc */
    public <T> String zzd(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", new Object[]{metadataField.getName(), t});
    }

    /* renamed from: zzcK */
    public String zzw(String str) {
        return String.format("not(%s)", new Object[]{str});
    }

    /* renamed from: zzcL */
    public String zzcM(String str) {
        return String.format("fullTextSearch(%s)", new Object[]{str});
    }

    /* renamed from: zzd */
    public String zze(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", new Object[]{metadataField.getName()});
    }

    /* renamed from: zzrg */
    public String zzrj() {
        return "all()";
    }

    /* renamed from: zzrh */
    public String zzri() {
        return "ownedByMe()";
    }
}
