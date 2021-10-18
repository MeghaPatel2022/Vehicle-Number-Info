package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Creator<FileUploadPreferencesImpl> CREATOR = new zzaf();
    final int mVersionCode;
    int zzajj;
    int zzajk;
    boolean zzajl;

    FileUploadPreferencesImpl(int versionCode, int networkTypePreference, int batteryUsagePreference, boolean allowRoaming) {
        this.mVersionCode = versionCode;
        this.zzajj = networkTypePreference;
        this.zzajk = batteryUsagePreference;
        this.zzajl = allowRoaming;
    }

    public static boolean zzcM(int i) {
        switch (i) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzcN(int i) {
        switch (i) {
            case 256:
            case 257:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getBatteryUsagePreference() {
        if (!zzcN(this.zzajk)) {
            return 0;
        }
        return this.zzajk;
    }

    public int getNetworkTypePreference() {
        if (!zzcM(this.zzajj)) {
            return 0;
        }
        return this.zzajj;
    }

    public boolean isRoamingAllowed() {
        return this.zzajl;
    }

    public void setBatteryUsagePreference(int batteryUsagePreference) {
        if (!zzcN(batteryUsagePreference)) {
            throw new IllegalArgumentException("Invalid battery usage preference value.");
        }
        this.zzajk = batteryUsagePreference;
    }

    public void setNetworkTypePreference(int networkTypePreference) {
        if (!zzcM(networkTypePreference)) {
            throw new IllegalArgumentException("Invalid data connection preference value.");
        }
        this.zzajj = networkTypePreference;
    }

    public void setRoamingAllowed(boolean allowRoaming) {
        this.zzajl = allowRoaming;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzaf.zza(this, parcel, flags);
    }
}
