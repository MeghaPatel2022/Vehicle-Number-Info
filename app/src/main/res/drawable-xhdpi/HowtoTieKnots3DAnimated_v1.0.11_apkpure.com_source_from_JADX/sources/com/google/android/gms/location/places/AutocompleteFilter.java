package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutocompleteFilter implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final boolean zzaDl;
    final List<Integer> zzaDm;
    private final Set<Integer> zzaDn;

    AutocompleteFilter(int versionCode, boolean restrictToPlaces, Collection<Integer> placeTypes) {
        this.mVersionCode = versionCode;
        this.zzaDl = restrictToPlaces;
        this.zzaDm = placeTypes == null ? Collections.emptyList() : new ArrayList<>(placeTypes);
        if (this.zzaDm.isEmpty()) {
            this.zzaDn = Collections.emptySet();
        } else {
            this.zzaDn = Collections.unmodifiableSet(new HashSet(this.zzaDm));
        }
    }

    public static AutocompleteFilter create(Collection<Integer> placeTypes) {
        return zza(true, placeTypes);
    }

    public static AutocompleteFilter zza(boolean z, Collection<Integer> collection) {
        return new AutocompleteFilter(0, z, collection);
    }

    public int describeContents() {
        zzc zzc = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) object;
        return this.zzaDn.equals(autocompleteFilter.zzaDn) && this.zzaDl == autocompleteFilter.zzaDl;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzaDn;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzaDl), this.zzaDn);
    }

    public String toString() {
        zza zzu = zzw.zzu(this);
        if (!this.zzaDl) {
            zzu.zzg("restrictedToPlaces", Boolean.valueOf(this.zzaDl));
        }
        zzu.zzg("placeTypes", this.zzaDn);
        return zzu.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc zzc = CREATOR;
        zzc.zza(this, parcel, flags);
    }

    public boolean zzvY() {
        return this.zzaDl;
    }
}
