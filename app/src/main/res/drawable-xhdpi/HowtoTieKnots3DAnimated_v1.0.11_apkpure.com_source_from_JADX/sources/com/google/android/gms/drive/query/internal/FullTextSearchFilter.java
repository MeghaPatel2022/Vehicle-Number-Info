package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class FullTextSearchFilter extends AbstractFilter {
    public static final zzh CREATOR = new zzh();
    final String mValue;
    final int mVersionCode;

    FullTextSearchFilter(int versionCode, String value) {
        this.mVersionCode = versionCode;
        this.mValue = value;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> zzf) {
        return zzf.zzcM(this.mValue);
    }
}
