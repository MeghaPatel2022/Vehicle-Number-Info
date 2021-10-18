package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class AppContentReceivedResult implements SafeParcelable {
    public static final Creator<AppContentReceivedResult> CREATOR = new zza();
    private int statusCode;
    private final int versionCode;
    private Uri zzaKk;

    private AppContentReceivedResult() {
        this.versionCode = 1;
    }

    AppContentReceivedResult(int versionCode2, Uri destinationUri, int statusCode2) {
        this.versionCode = versionCode2;
        this.zzaKk = destinationUri;
        this.statusCode = statusCode2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AppContentReceivedResult)) {
            return false;
        }
        AppContentReceivedResult appContentReceivedResult = (AppContentReceivedResult) o;
        return zzw.equal(this.zzaKk, appContentReceivedResult.zzaKk) && zzw.equal(Integer.valueOf(this.statusCode), Integer.valueOf(appContentReceivedResult.statusCode));
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaKk, Integer.valueOf(this.statusCode));
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public Uri zzyr() {
        return this.zzaKk;
    }
}
