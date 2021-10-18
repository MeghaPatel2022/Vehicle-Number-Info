package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetChannelInputStreamResponse implements SafeParcelable {
    public static final Creator<GetChannelInputStreamResponse> CREATOR = new zzai();
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzbat;

    GetChannelInputStreamResponse(int versionCode2, int statusCode2, ParcelFileDescriptor fileDescriptor) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzbat = fileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzai.zza(this, dest, flags);
    }
}
