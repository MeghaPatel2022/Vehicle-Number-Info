package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class PlacesOptions implements Optional {
    public final String zzaDU;

    public static class Builder {
        /* access modifiers changed from: private */
        public String zzaDV;

        public PlacesOptions build() {
            return new PlacesOptions(this);
        }
    }

    private PlacesOptions(Builder builder) {
        this.zzaDU = builder.zzaDV;
    }
}
