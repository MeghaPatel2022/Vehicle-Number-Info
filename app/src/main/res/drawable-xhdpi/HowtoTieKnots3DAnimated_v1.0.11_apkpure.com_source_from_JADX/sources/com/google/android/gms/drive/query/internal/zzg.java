package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public class zzg implements zzf<Boolean> {
    private Boolean zzalI = Boolean.valueOf(false);

    private zzg() {
    }

    public static boolean zza(Filter filter) {
        if (filter == null) {
            return false;
        }
        return ((Boolean) filter.zza(new zzg())).booleanValue();
    }

    /* renamed from: zzc */
    public <T> Boolean zzb(zzb<T> zzb, T t) {
        return this.zzalI;
    }

    /* renamed from: zzc */
    public <T> Boolean zzb(Operator operator, MetadataField<T> metadataField, T t) {
        return this.zzalI;
    }

    /* renamed from: zzc */
    public Boolean zzb(Operator operator, List<Boolean> list) {
        return this.zzalI;
    }

    /* renamed from: zzcN */
    public Boolean zzcM(String str) {
        if (!str.isEmpty()) {
            this.zzalI = Boolean.valueOf(true);
        }
        return this.zzalI;
    }

    /* renamed from: zzd */
    public Boolean zzw(Boolean bool) {
        return this.zzalI;
    }

    /* renamed from: zze */
    public <T> Boolean zzd(MetadataField<T> metadataField, T t) {
        return this.zzalI;
    }

    /* renamed from: zzf */
    public Boolean zze(MetadataField<?> metadataField) {
        return this.zzalI;
    }

    /* renamed from: zzrk */
    public Boolean zzrj() {
        return this.zzalI;
    }

    /* renamed from: zzrl */
    public Boolean zzri() {
        return this.zzalI;
    }
}
