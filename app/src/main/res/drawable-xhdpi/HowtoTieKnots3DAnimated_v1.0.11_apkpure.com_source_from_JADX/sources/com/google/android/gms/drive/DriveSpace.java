package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DriveSpace implements SafeParcelable {
    public static final Creator<DriveSpace> CREATOR = new zzg();
    public static final DriveSpace zzagH = new DriveSpace("DRIVE");
    public static final DriveSpace zzagI = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace zzagJ = new DriveSpace("PHOTOS");
    public static final Set<DriveSpace> zzagK = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DriveSpace[]{zzagH, zzagI, zzagJ})));
    public static final String zzagL = TextUtils.join(",", zzagK.toArray());
    private final String mName;
    final int mVersionCode;

    DriveSpace(int versionCode, String name) {
        this.mVersionCode = versionCode;
        this.mName = (String) zzx.zzv(name);
    }

    private DriveSpace(String name) {
        this(1, name);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != DriveSpace.class) {
            return false;
        }
        return this.mName.equals(((DriveSpace) o).mName);
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return 1247068382 ^ this.mName.hashCode();
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
