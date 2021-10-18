package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class NearbyAlertFilter extends zza implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    final List<Integer> zzaDm;
    private final Set<Integer> zzaDn;
    final List<String> zzaDo;
    final List<UserDataType> zzaDp;
    private final Set<String> zzaDq;
    private final Set<UserDataType> zzaDr;

    NearbyAlertFilter(int versionCode, List<String> placeIdsList, List<Integer> placeTypesList, List<UserDataType> requestedUserDataTypesList) {
        this.mVersionCode = versionCode;
        this.zzaDm = placeTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(placeTypesList);
        this.zzaDp = requestedUserDataTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(requestedUserDataTypesList);
        this.zzaDo = placeIdsList == null ? Collections.emptyList() : Collections.unmodifiableList(placeIdsList);
        this.zzaDn = zzl(this.zzaDm);
        this.zzaDr = zzl(this.zzaDp);
        this.zzaDq = zzl(this.zzaDo);
    }

    public static NearbyAlertFilter zza(Collection<String> collection, Collection<Integer> collection2, Collection<UserDataType> collection3) {
        if ((collection != null && !collection.isEmpty()) || ((collection2 != null && !collection2.isEmpty()) || (collection3 != null && !collection3.isEmpty()))) {
            return new NearbyAlertFilter(0, zzf(collection), zzf(collection2), zzf(collection3));
        }
        throw new IllegalArgumentException("NearbyAlertFilters must contain at least onePlaceId, PlaceType, or UserDataType to match results with.");
    }

    public int describeContents() {
        zzd zzd = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof NearbyAlertFilter)) {
            return false;
        }
        NearbyAlertFilter nearbyAlertFilter = (NearbyAlertFilter) object;
        return this.zzaDn.equals(nearbyAlertFilter.zzaDn) && this.zzaDr.equals(nearbyAlertFilter.zzaDr) && this.zzaDq.equals(nearbyAlertFilter.zzaDq);
    }

    public Set<String> getPlaceIds() {
        return this.zzaDq;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaDn, this.zzaDr, this.zzaDq);
    }

    public String toString() {
        zza zzu = zzw.zzu(this);
        if (!this.zzaDn.isEmpty()) {
            zzu.zzg("types", this.zzaDn);
        }
        if (!this.zzaDq.isEmpty()) {
            zzu.zzg("placeIds", this.zzaDq);
        }
        if (!this.zzaDr.isEmpty()) {
            zzu.zzg("requestedUserDataTypes", this.zzaDr);
        }
        return zzu.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzd zzd = CREATOR;
        zzd.zza(this, parcel, flags);
    }
}
