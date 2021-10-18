package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class FitnessUnregistrationRequest implements SafeParcelable {
    public static final Creator<FitnessUnregistrationRequest> CREATOR = new zzb();
    private final int mVersionCode;
    private final DataSource zzanm;

    FitnessUnregistrationRequest(int versionCode, DataSource dataSource) {
        this.mVersionCode = versionCode;
        this.zzanm = dataSource;
    }

    public int describeContents() {
        return 0;
    }

    public DataSource getDataSource() {
        return this.zzanm;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", new Object[]{this.zzanm});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
