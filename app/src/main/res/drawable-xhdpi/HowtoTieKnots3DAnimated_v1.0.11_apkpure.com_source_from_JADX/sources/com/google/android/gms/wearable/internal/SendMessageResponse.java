package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SendMessageResponse implements SafeParcelable {
    public static final Creator<SendMessageResponse> CREATOR = new zzbh();
    public final int statusCode;
    public final int versionCode;
    public final int zzaBi;

    SendMessageResponse(int versionCode2, int statusCode2, int requestId) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaBi = requestId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbh.zza(this, dest, flags);
    }
}
