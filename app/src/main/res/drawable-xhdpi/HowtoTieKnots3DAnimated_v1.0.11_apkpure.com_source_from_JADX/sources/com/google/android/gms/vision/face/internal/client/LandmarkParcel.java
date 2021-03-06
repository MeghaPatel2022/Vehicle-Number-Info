package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LandmarkParcel implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int type;
    public final int versionCode;

    /* renamed from: x */
    public final float f61x;

    /* renamed from: y */
    public final float f62y;

    public LandmarkParcel(int versionCode2, float x, float y, int type2) {
        this.versionCode = versionCode2;
        this.f61x = x;
        this.f62y = y;
        this.type = type2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }
}
