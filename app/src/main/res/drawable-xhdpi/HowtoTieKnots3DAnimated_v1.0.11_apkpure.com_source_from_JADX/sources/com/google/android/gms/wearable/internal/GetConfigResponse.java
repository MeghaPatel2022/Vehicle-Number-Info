package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class GetConfigResponse implements SafeParcelable {
    public static final Creator<GetConfigResponse> CREATOR = new zzan();
    public final int statusCode;
    public final int versionCode;
    public final ConnectionConfiguration zzbax;

    GetConfigResponse(int versionCode2, int statusCode2, ConnectionConfiguration config) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzbax = config;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzan.zza(this, dest, flags);
    }
}
