package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetChannelOutputStreamResponse implements SafeParcelable {
    public static final Creator<GetChannelOutputStreamResponse> CREATOR = new zzaj();
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzbat;

    GetChannelOutputStreamResponse(int versionCode2, int statusCode2, ParcelFileDescriptor fileDescriptor) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzbat = fileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaj.zza(this, dest, flags);
    }
}
