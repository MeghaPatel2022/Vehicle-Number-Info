package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class PlaceAlias implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final PlaceAlias zzaFg = new PlaceAlias(0, "Home");
    public static final PlaceAlias zzaFh = new PlaceAlias(0, "Work");
    final int mVersionCode;
    private final String zzaFi;

    PlaceAlias(int versionCode, String alias) {
        this.mVersionCode = versionCode;
        this.zzaFi = alias;
    }

    public int describeContents() {
        zzc zzc = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceAlias)) {
            return false;
        }
        return zzw.equal(this.zzaFi, ((PlaceAlias) object).zzaFi);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaFi);
    }

    public String toString() {
        return zzw.zzu(this).zzg("alias", this.zzaFi).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc zzc = CREATOR;
        zzc.zza(this, parcel, flags);
    }

    public String zzwv() {
        return this.zzaFi;
    }
}
