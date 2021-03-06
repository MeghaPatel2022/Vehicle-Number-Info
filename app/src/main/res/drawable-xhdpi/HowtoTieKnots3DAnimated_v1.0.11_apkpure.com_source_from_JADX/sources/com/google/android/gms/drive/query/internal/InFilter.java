package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    private final zzb<T> zzalJ;
    final MetadataBundle zzalw;

    InFilter(int versionCode, MetadataBundle value) {
        this.mVersionCode = versionCode;
        this.zzalw = value;
        this.zzalJ = (zzb) zze.zzb(value);
    }

    public InFilter(SearchableCollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.zza(field, Collections.singleton(value)));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return ((Collection) this.zzalw.zza((MetadataField<T>) this.zzalJ)).iterator().next();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zzb(this.zzalJ, getValue());
    }
}
