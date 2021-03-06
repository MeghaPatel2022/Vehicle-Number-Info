package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter extends zza implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int mVersionCode;
    final List<Integer> zzaDm;
    private final Set<Integer> zzaDn;
    final List<String> zzaDo;
    final List<UserDataType> zzaDp;
    private final Set<String> zzaDq;
    private final Set<UserDataType> zzaDr;
    final boolean zzaDz;

    @Deprecated
    public static final class zza {
        private Collection<Integer> zzaDA;
        private Collection<UserDataType> zzaDB;
        private String[] zzaDC;
        private boolean zzaDz;

        private zza() {
            this.zzaDA = null;
            this.zzaDz = false;
            this.zzaDB = null;
            this.zzaDC = null;
        }

        public PlaceFilter zzwf() {
            List list = null;
            ArrayList arrayList = this.zzaDA != null ? new ArrayList(this.zzaDA) : null;
            ArrayList arrayList2 = this.zzaDB != null ? new ArrayList(this.zzaDB) : null;
            if (this.zzaDC != null) {
                list = Arrays.asList(this.zzaDC);
            }
            return new PlaceFilter(arrayList, this.zzaDz, list, arrayList2);
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int versionCode, List<Integer> placeTypesList, boolean requireOpenNow, List<String> placeIdsList, List<UserDataType> requestedUserDataTypesList) {
        this.mVersionCode = versionCode;
        this.zzaDm = placeTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(placeTypesList);
        this.zzaDz = requireOpenNow;
        this.zzaDp = requestedUserDataTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(requestedUserDataTypesList);
        this.zzaDo = placeIdsList == null ? Collections.emptyList() : Collections.unmodifiableList(placeIdsList);
        this.zzaDn = zzl(this.zzaDm);
        this.zzaDr = zzl(this.zzaDp);
        this.zzaDq = zzl(this.zzaDo);
    }

    public PlaceFilter(Collection<Integer> restrictToPlaceTypes, boolean requireOpenNow, Collection<String> restrictToPlaceIds, Collection<UserDataType> requestedUserDataTypes) {
        this(0, zzf(restrictToPlaceTypes), requireOpenNow, zzf(restrictToPlaceIds), zzf(requestedUserDataTypes));
    }

    public PlaceFilter(boolean requireOpenNow, Collection<String> restrictToPlaceIds) {
        this(null, requireOpenNow, restrictToPlaceIds, null);
    }

    @Deprecated
    public static PlaceFilter zzwe() {
        return new zza().zzwf();
    }

    public int describeContents() {
        zzg zzg = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) object;
        return this.zzaDn.equals(placeFilter.zzaDn) && this.zzaDz == placeFilter.zzaDz && this.zzaDr.equals(placeFilter.zzaDr) && this.zzaDq.equals(placeFilter.zzaDq);
    }

    public Set<String> getPlaceIds() {
        return this.zzaDq;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzaDn;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaDn, Boolean.valueOf(this.zzaDz), this.zzaDr, this.zzaDq);
    }

    public boolean isRestrictedToPlacesOpenNow() {
        return this.zzaDz;
    }

    public String toString() {
        com.google.android.gms.common.internal.zzw.zza zzu = zzw.zzu(this);
        if (!this.zzaDn.isEmpty()) {
            zzu.zzg("types", this.zzaDn);
        }
        zzu.zzg("requireOpenNow", Boolean.valueOf(this.zzaDz));
        if (!this.zzaDq.isEmpty()) {
            zzu.zzg("placeIds", this.zzaDq);
        }
        if (!this.zzaDr.isEmpty()) {
            zzu.zzg("requestedUserDataTypes", this.zzaDr);
        }
        return zzu.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzg zzg = CREATOR;
        zzg.zza(this, parcel, flags);
    }

    public Set<UserDataType> zzwd() {
        return this.zzaDr;
    }
}
