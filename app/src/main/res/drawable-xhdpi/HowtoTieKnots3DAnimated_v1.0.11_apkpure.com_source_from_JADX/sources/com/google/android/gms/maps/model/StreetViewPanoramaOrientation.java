package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class StreetViewPanoramaOrientation implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    public final float bearing;
    private final int mVersionCode;
    public final float tilt;

    public static final class Builder {
        public float bearing;
        public float tilt;

        public Builder() {
        }

        public Builder(StreetViewPanoramaOrientation previous) {
            this.bearing = previous.bearing;
            this.tilt = previous.tilt;
        }

        public Builder bearing(float bearing2) {
            this.bearing = bearing2;
            return this;
        }

        public StreetViewPanoramaOrientation build() {
            return new StreetViewPanoramaOrientation(this.tilt, this.bearing);
        }

        public Builder tilt(float tilt2) {
            this.tilt = tilt2;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float tilt2, float bearing2) {
        this(1, tilt2, bearing2);
    }

    StreetViewPanoramaOrientation(int versionCode, float tilt2, float bearing2) {
        zzx.zzb(-90.0f <= tilt2 && tilt2 <= 90.0f, (Object) "Tilt needs to be between -90 and 90 inclusive");
        this.mVersionCode = versionCode;
        this.tilt = 0.0f + tilt2;
        if (((double) bearing2) <= 0.0d) {
            bearing2 = (bearing2 % 360.0f) + 360.0f;
        }
        this.bearing = bearing2 % 360.0f;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(StreetViewPanoramaOrientation orientation) {
        return new Builder(orientation);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) o;
        return Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaOrientation.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaOrientation.bearing);
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public String toString() {
        return zzw.zzu(this).zzg("tilt", Float.valueOf(this.tilt)).zzg("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzm.zza(this, out, flags);
    }
}
