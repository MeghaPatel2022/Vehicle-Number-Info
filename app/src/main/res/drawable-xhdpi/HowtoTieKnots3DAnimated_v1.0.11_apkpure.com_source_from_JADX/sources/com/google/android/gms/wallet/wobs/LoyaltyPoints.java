package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyPoints implements SafeParcelable {
    public static final Creator<LoyaltyPoints> CREATOR = new zze();
    String label;
    private final int mVersionCode;
    String type;
    TimeInterval zzaWR;
    LoyaltyPointsBalance zzaYy;

    LoyaltyPoints() {
        this.mVersionCode = 1;
    }

    LoyaltyPoints(int versionCode, String label2, LoyaltyPointsBalance balance, String type2, TimeInterval validTimeInterval) {
        this.mVersionCode = versionCode;
        this.label = label2;
        this.zzaYy = balance;
        this.type = type2;
        this.zzaWR = validTimeInterval;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
