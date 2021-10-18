package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncOptInOutDoneResponse implements SafeParcelable {
    public static final Creator<GetCloudSyncOptInOutDoneResponse> CREATOR = new zzak();
    public final int statusCode;
    public final int versionCode;
    public final boolean zzbau;

    GetCloudSyncOptInOutDoneResponse(int versionCode2, int statusCode2, boolean optInOutDone) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzbau = optInOutDone;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzak.zza(this, dest, flags);
    }
}
