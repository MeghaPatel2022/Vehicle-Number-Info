package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetFdForAssetResponse implements SafeParcelable {
    public static final Creator<GetFdForAssetResponse> CREATOR = new zzar();
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzbaB;

    GetFdForAssetResponse(int versionCode2, int statusCode2, ParcelFileDescriptor pfd) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzbaB = pfd;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzar.zza(this, dest, flags | 1);
    }
}
