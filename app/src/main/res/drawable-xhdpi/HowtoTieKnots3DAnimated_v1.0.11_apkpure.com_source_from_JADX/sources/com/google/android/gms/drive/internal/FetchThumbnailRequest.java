package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class FetchThumbnailRequest implements SafeParcelable {
    public static final Creator<FetchThumbnailRequest> CREATOR = new zzae();
    final int mVersionCode;
    final DriveId zzahP;

    FetchThumbnailRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzahP = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzae.zza(this, dest, flags);
    }
}
