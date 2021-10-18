package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncSettingResponse implements SafeParcelable {
    public static final Creator<GetCloudSyncSettingResponse> CREATOR = new zzam();
    public final boolean enabled;
    public final int statusCode;
    public final int versionCode;

    GetCloudSyncSettingResponse(int versionCode2, int statusCode2, boolean enabled2) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.enabled = enabled2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzam.zza(this, dest, flags);
    }
}
