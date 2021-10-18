package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class TextModuleData implements SafeParcelable {
    public static final Creator<TextModuleData> CREATOR = new zzf();
    String body;
    private final int mVersionCode;
    String zzaYE;

    TextModuleData() {
        this.mVersionCode = 1;
    }

    TextModuleData(int versionCode, String header, String body2) {
        this.mVersionCode = versionCode;
        this.zzaYE = header;
        this.body = body2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }
}
