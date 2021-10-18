package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class UserDataType implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    public static final UserDataType zzaDW = zzz("test_type", 1);
    public static final UserDataType zzaDX = zzz("labeled_place", 6);
    public static final UserDataType zzaDY = zzz("here_content", 7);
    public static final Set<UserDataType> zzaDZ = Collections.unmodifiableSet(new HashSet(Arrays.asList(new UserDataType[]{zzaDW, zzaDX, zzaDY})));
    final int mVersionCode;
    final String zzFz;
    final int zzaEa;

    UserDataType(int versionCode, String type, int enumValue) {
        zzx.zzcs(type);
        this.mVersionCode = versionCode;
        this.zzFz = type;
        this.zzaEa = enumValue;
    }

    private static UserDataType zzz(String str, int i) {
        return new UserDataType(0, str, i);
    }

    public int describeContents() {
        zzm zzm = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof UserDataType)) {
            return false;
        }
        UserDataType userDataType = (UserDataType) object;
        return this.zzFz.equals(userDataType.zzFz) && this.zzaEa == userDataType.zzaEa;
    }

    public int hashCode() {
        return this.zzFz.hashCode();
    }

    public String toString() {
        return this.zzFz;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzm zzm = CREATOR;
        zzm.zza(this, parcel, flags);
    }
}
