package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CopresenceApiOptions implements SafeParcelable {
    public static final Creator<CopresenceApiOptions> CREATOR = new zza();
    public static final CopresenceApiOptions zzaCp = new CopresenceApiOptions(true, null);
    final int mVersionCode;
    public final boolean zzaCq;
    public final String zzaCr;

    CopresenceApiOptions(int versionCode, boolean isAuthenticated, String zeroPartyPackageName) {
        this.mVersionCode = versionCode;
        this.zzaCq = isAuthenticated;
        this.zzaCr = zeroPartyPackageName;
    }

    public CopresenceApiOptions(boolean isAuthenticated, String zeroPartyPackageName) {
        this(1, isAuthenticated, zeroPartyPackageName);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
