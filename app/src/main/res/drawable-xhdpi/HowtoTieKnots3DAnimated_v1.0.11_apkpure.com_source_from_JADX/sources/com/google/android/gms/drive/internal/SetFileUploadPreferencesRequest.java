package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SetFileUploadPreferencesRequest implements SafeParcelable {
    public static final Creator<SetFileUploadPreferencesRequest> CREATOR = new zzbp();
    final int mVersionCode;
    final FileUploadPreferencesImpl zzajJ;

    SetFileUploadPreferencesRequest(int versionCode, FileUploadPreferencesImpl preferences) {
        this.mVersionCode = versionCode;
        this.zzajJ = preferences;
    }

    public SetFileUploadPreferencesRequest(FileUploadPreferencesImpl preferences) {
        this(1, preferences);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbp.zza(this, dest, flags);
    }
}
