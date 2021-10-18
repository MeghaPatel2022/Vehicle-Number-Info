package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDataItemResponse implements SafeParcelable {
    public static final Creator<GetDataItemResponse> CREATOR = new zzaq();
    public final int statusCode;
    public final int versionCode;
    public final DataItemParcelable zzbaA;

    GetDataItemResponse(int versionCode2, int statusCode2, DataItemParcelable dataItem) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzbaA = dataItem;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaq.zza(this, dest, flags);
    }
}
