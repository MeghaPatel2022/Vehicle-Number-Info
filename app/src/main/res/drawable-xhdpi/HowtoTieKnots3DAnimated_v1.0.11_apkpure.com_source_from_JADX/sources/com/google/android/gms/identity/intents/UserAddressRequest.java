package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator<UserAddressRequest> CREATOR = new zza();
    private final int mVersionCode;
    List<CountrySpecification> zzaAz;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (UserAddressRequest.this.zzaAz == null) {
                UserAddressRequest.this.zzaAz = new ArrayList();
            }
            UserAddressRequest.this.zzaAz.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> countrySpecifications) {
            if (UserAddressRequest.this.zzaAz == null) {
                UserAddressRequest.this.zzaAz = new ArrayList();
            }
            UserAddressRequest.this.zzaAz.addAll(countrySpecifications);
            return this;
        }

        public UserAddressRequest build() {
            if (UserAddressRequest.this.zzaAz != null) {
                UserAddressRequest.this.zzaAz = Collections.unmodifiableList(UserAddressRequest.this.zzaAz);
            }
            return UserAddressRequest.this;
        }
    }

    UserAddressRequest() {
        this.mVersionCode = 1;
    }

    UserAddressRequest(int versionCode, List<CountrySpecification> allowedCountrySpecifications) {
        this.mVersionCode = versionCode;
        this.zzaAz = allowedCountrySpecifications;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
