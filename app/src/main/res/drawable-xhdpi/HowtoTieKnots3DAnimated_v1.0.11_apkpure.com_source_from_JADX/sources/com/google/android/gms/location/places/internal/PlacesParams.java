package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class PlacesParams implements SafeParcelable {
    public static final zzs CREATOR = new zzs();
    public static final PlacesParams zzaEY = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
    public final int versionCode;
    public final String zzaDU;
    public final String zzaEZ;
    public final String zzaFa;
    public final String zzaFb;
    public final String zzaFc;
    public final int zzaFd;

    public PlacesParams(int versionCode2, String clientPackageName, String localeString, String accountName, String gCoreClientName, String chargedPackageName, int gCoreClientJarVersion) {
        this.versionCode = versionCode2;
        this.zzaEZ = clientPackageName;
        this.zzaFa = localeString;
        this.zzaFb = accountName;
        this.zzaDU = gCoreClientName;
        this.zzaFc = chargedPackageName;
        this.zzaFd = gCoreClientJarVersion;
    }

    public PlacesParams(String clientPackageName, Locale locale, String accountName) {
        this(1, clientPackageName, locale.toString(), accountName, null, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public PlacesParams(String clientPackageName, Locale locale, String accountName, String gCoreClientName, String chargedPackageName) {
        this(1, clientPackageName, locale.toString(), accountName, gCoreClientName, chargedPackageName, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public int describeContents() {
        zzs zzs = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof PlacesParams)) {
            return false;
        }
        PlacesParams placesParams = (PlacesParams) object;
        return this.zzaFa.equals(placesParams.zzaFa) && this.zzaEZ.equals(placesParams.zzaEZ) && zzw.equal(this.zzaFb, placesParams.zzaFb) && zzw.equal(this.zzaDU, placesParams.zzaDU) && zzw.equal(this.zzaFc, placesParams.zzaFc);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaEZ, this.zzaFa, this.zzaFb, this.zzaDU, this.zzaFc);
    }

    public String toString() {
        return zzw.zzu(this).zzg("clientPackageName", this.zzaEZ).zzg("locale", this.zzaFa).zzg("accountName", this.zzaFb).zzg("gCoreClientName", this.zzaDU).zzg("chargedPackageName", this.zzaFc).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzs zzs = CREATOR;
        zzs.zza(this, out, flags);
    }
}
