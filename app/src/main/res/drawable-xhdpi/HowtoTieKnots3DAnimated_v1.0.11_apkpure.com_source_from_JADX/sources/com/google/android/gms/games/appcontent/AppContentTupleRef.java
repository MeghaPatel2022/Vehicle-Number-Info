package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class AppContentTupleRef extends zzc implements AppContentTuple {
    AppContentTupleRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentTupleEntity.zza(this, obj);
    }

    public String getName() {
        return getString("tuple_name");
    }

    public String getValue() {
        return getString("tuple_value");
    }

    public int hashCode() {
        return AppContentTupleEntity.zza(this);
    }

    public String toString() {
        return AppContentTupleEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentTupleEntity) freeze()).writeToParcel(dest, flags);
    }

    /* renamed from: zztB */
    public AppContentTuple freeze() {
        return new AppContentTupleEntity(this);
    }
}
