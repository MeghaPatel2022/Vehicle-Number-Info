package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ObjectChangedDetails implements SafeParcelable {
    public static final Creator<ObjectChangedDetails> CREATOR = new zzb();
    final int mVersionCode;
    final int zzamf;
    final int zzamg;

    ObjectChangedDetails(int versionCode, int valueIndex, int valueCount) {
        this.mVersionCode = versionCode;
        this.zzamf = valueIndex;
        this.zzamg = valueCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
