package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class StorageInfoResponse implements SafeParcelable {
    public static final Creator<StorageInfoResponse> CREATOR = new zzbk();
    public final int statusCode;
    public final int versionCode;
    public final long zzbaQ;
    public final List<PackageStorageInfo> zzbaS;

    StorageInfoResponse(int versionCode2, int statusCode2, long totalSizeBytes, List<PackageStorageInfo> packageStorageInfo) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzbaQ = totalSizeBytes;
        this.zzbaS = packageStorageInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzbk.zza(this, out, flags);
    }
}
