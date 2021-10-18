package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OpenChannelResponse implements SafeParcelable {
    public static final Creator<OpenChannelResponse> CREATOR = new zzbc();
    public final int statusCode;
    public final int versionCode;
    public final ChannelImpl zzaZR;

    OpenChannelResponse(int versionCode2, int statusCode2, ChannelImpl channel) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaZR = channel;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbc.zza(this, dest, flags);
    }
}
