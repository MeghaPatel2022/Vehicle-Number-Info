package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCapabilityResponse implements SafeParcelable {
    public static final Creator<GetCapabilityResponse> CREATOR = new zzah();
    public final int statusCode;
    public final int versionCode;
    public final CapabilityInfoParcelable zzbas;

    GetCapabilityResponse(int versionCode2, int statusCode2, CapabilityInfoParcelable capability) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzbas = capability;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzah.zza(this, dest, flags);
    }
}
