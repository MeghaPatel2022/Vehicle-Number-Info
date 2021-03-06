package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;

public class DisableFitRequest implements SafeParcelable {
    public static final Creator<DisableFitRequest> CREATOR = new zzl();
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;

    DisableFitRequest(int versionCode, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzapE = zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public DisableFitRequest(zznh callback, String packageName) {
        this.mVersionCode = 1;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DisableFitRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzl.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzapE.asBinder();
    }
}
