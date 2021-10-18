package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Feature implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: id */
    public final int f15id;
    final int mVersionCode;
    final Bundle zzPi;

    Feature(int versionCode, int id, Bundle parameters) {
        this.mVersionCode = versionCode;
        this.f15id = id;
        this.zzPi = parameters;
    }

    public int describeContents() {
        zze zze = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze zze = CREATOR;
        zze.zza(this, dest, flags);
    }
}
