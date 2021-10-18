package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListParentsResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Creator<OnListParentsResponse> CREATOR = new zzbd();
    final int mVersionCode;
    final DataHolder zzajU;

    OnListParentsResponse(int versionCode, DataHolder parents) {
        this.mVersionCode = versionCode;
        this.zzajU = parents;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void zzI(Parcel parcel, int i) {
        zzbd.zza(this, parcel, i);
    }

    public DataHolder zzqV() {
        return this.zzajU;
    }
}
