package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest implements SafeParcelable {
    public static final Creator<LocationSettingsRequest> CREATOR = new zzf();
    private final int mVersionCode;
    private final boolean zzaCd;
    private final boolean zzaCe;
    private final boolean zzaCf;
    private final List<LocationRequest> zzaqn;

    public static final class Builder {
        private boolean zzaCd = false;
        private boolean zzaCe = false;
        private boolean zzaCf = false;
        private final ArrayList<LocationRequest> zzaCg = new ArrayList<>();

        public Builder addAllLocationRequests(Collection<LocationRequest> requests) {
            this.zzaCg.addAll(requests);
            return this;
        }

        public Builder addLocationRequest(LocationRequest request) {
            this.zzaCg.add(request);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest((List) this.zzaCg, this.zzaCd, this.zzaCe, this.zzaCf);
        }

        public Builder setAlwaysShow(boolean show) {
            this.zzaCd = show;
            return this;
        }

        public Builder setNeedBle(boolean needBle) {
            this.zzaCe = needBle;
            return this;
        }
    }

    LocationSettingsRequest(int version, List<LocationRequest> locationRequests, boolean alwaysShow, boolean needBle, boolean optInUserLocationReporting) {
        this.mVersionCode = version;
        this.zzaqn = locationRequests;
        this.zzaCd = alwaysShow;
        this.zzaCe = needBle;
        this.zzaCf = optInUserLocationReporting;
    }

    private LocationSettingsRequest(List<LocationRequest> locationRequests, boolean alwaysShow, boolean needBle, boolean optInUserLocationReporting) {
        this(2, locationRequests, alwaysShow, needBle, optInUserLocationReporting);
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

    public List<LocationRequest> zzsr() {
        return Collections.unmodifiableList(this.zzaqn);
    }

    public boolean zzvJ() {
        return this.zzaCd;
    }

    public boolean zzvK() {
        return this.zzaCe;
    }

    public boolean zzvL() {
        return this.zzaCf;
    }
}
