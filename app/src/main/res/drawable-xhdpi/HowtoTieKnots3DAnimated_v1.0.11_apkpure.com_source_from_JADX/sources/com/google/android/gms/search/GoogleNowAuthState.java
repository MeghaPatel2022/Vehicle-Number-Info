package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleNowAuthState implements SafeParcelable {
    public static final Creator<GoogleNowAuthState> CREATOR = new zza();
    final int mVersionCode;
    String zzaNM;
    String zzaNN;
    long zzaNO;

    GoogleNowAuthState(int versionCode, String authCode, String accessToken, long nextAllowedTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzaNM = authCode;
        this.zzaNN = accessToken;
        this.zzaNO = nextAllowedTimeMillis;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccessToken() {
        return this.zzaNN;
    }

    public String getAuthCode() {
        return this.zzaNM;
    }

    public long getNextAllowedTimeMillis() {
        return this.zzaNO;
    }

    public String toString() {
        return "mAuthCode = " + this.zzaNM + "\nmAccessToken = " + this.zzaNN + "\nmNextAllowedTimeMillis = " + this.zzaNO;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
