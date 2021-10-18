package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PointOfInterest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    private final int mVersionCode;
    public final String name;
    public final LatLng zzaHy;
    public final String zzaHz;

    PointOfInterest(int versionCode, LatLng latLng, String placeId, String name2) {
        this.mVersionCode = versionCode;
        this.zzaHy = latLng;
        this.zzaHz = placeId;
        this.name = name2;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
