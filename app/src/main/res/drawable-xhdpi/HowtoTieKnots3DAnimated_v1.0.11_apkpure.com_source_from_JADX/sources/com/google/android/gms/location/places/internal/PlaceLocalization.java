package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

@Deprecated
public final class PlaceLocalization implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    public final String address;
    public final String name;
    public final int versionCode;
    public final String zzaEK;
    public final String zzaEL;
    public final List<String> zzaEM;

    public PlaceLocalization(int versionCode2, String name2, String address2, String internationalPhoneNumber, String regularOpenHours, List<String> attributions) {
        this.versionCode = versionCode2;
        this.name = name2;
        this.address = address2;
        this.zzaEK = internationalPhoneNumber;
        this.zzaEL = regularOpenHours;
        this.zzaEM = attributions;
    }

    public static PlaceLocalization zza(String str, String str2, String str3, String str4, List<String> list) {
        return new PlaceLocalization(0, str, str2, str3, str4, list);
    }

    public int describeContents() {
        zzn zzn = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceLocalization)) {
            return false;
        }
        PlaceLocalization placeLocalization = (PlaceLocalization) object;
        return zzw.equal(this.name, placeLocalization.name) && zzw.equal(this.address, placeLocalization.address) && zzw.equal(this.zzaEK, placeLocalization.zzaEK) && zzw.equal(this.zzaEL, placeLocalization.zzaEL) && zzw.equal(this.zzaEM, placeLocalization.zzaEM);
    }

    public int hashCode() {
        return zzw.hashCode(this.name, this.address, this.zzaEK, this.zzaEL);
    }

    public String toString() {
        return zzw.zzu(this).zzg("name", this.name).zzg("address", this.address).zzg("internationalPhoneNumber", this.zzaEK).zzg("regularOpenHours", this.zzaEL).zzg("attributions", this.zzaEM).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzn zzn = CREATOR;
        zzn.zza(this, parcel, flags);
    }
}
