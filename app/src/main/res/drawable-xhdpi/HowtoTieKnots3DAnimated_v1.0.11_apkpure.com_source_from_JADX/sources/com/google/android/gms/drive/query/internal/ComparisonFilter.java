package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final zza CREATOR = new zza();
    final int mVersionCode;
    final Operator zzalv;
    final MetadataBundle zzalw;
    final MetadataField<T> zzalx;

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.mVersionCode = versionCode;
        this.zzalv = operator;
        this.zzalw = value;
        this.zzalx = zze.zzb(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.zza(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.zzalw.zza(this.zzalx);
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zzb(this.zzalv, this.zzalx, getValue());
    }
}
