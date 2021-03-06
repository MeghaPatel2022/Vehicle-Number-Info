package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class GetConfigsResponse implements SafeParcelable {
    public static final Creator<GetConfigsResponse> CREATOR = new zzao();
    public final int statusCode;
    public final int versionCode;
    public final ConnectionConfiguration[] zzbay;

    GetConfigsResponse(int versionCode2, int statusCode2, ConnectionConfiguration[] configs) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzbay = configs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzao.zza(this, dest, flags);
    }
}
