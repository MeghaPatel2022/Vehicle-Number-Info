package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LabelValue implements SafeParcelable {
    public static final Creator<LabelValue> CREATOR = new zzb();
    String label;
    private final int mVersionCode;
    String value;

    LabelValue() {
        this.mVersionCode = 1;
    }

    LabelValue(int versionCode, String label2, String value2) {
        this.mVersionCode = versionCode;
        this.label = label2;
        this.value = value2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
