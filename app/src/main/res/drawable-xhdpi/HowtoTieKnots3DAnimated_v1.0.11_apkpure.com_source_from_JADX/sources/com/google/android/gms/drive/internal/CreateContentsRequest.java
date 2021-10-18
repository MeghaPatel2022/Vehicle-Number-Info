package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class CreateContentsRequest implements SafeParcelable {
    public static final Creator<CreateContentsRequest> CREATOR = new zzj();
    final int mVersionCode;
    final int zzagr;

    public CreateContentsRequest(int mode) {
        this(1, mode);
    }

    CreateContentsRequest(int versionCode, int mode) {
        this.mVersionCode = versionCode;
        zzx.zzb(mode == 536870912 || mode == 805306368, (Object) "Cannot create a new read-only contents!");
        this.zzagr = mode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
