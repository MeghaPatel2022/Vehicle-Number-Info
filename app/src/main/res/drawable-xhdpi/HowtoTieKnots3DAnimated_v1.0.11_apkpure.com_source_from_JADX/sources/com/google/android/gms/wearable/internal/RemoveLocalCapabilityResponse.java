package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RemoveLocalCapabilityResponse implements SafeParcelable {
    public static final Creator<RemoveLocalCapabilityResponse> CREATOR = new zzbg();
    public final int statusCode;
    public final int versionCode;

    RemoveLocalCapabilityResponse(int versionCode2, int statusCode2) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbg.zza(this, dest, flags);
    }
}
