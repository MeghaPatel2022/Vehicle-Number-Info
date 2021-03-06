package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.sharing.internal.zzc.zza;

public final class TrustedDevicesRequest implements SafeParcelable {
    public static final Creator<TrustedDevicesRequest> CREATOR = new zzk();
    final int versionCode;
    public zzc zzaKu;
    public String zzaKw;
    public byte[] zzaKx;

    TrustedDevicesRequest(int versionCode2, String deviceIdentifier, byte[] message, IBinder callbackAsBinder) {
        this.versionCode = versionCode2;
        this.zzaKw = (String) zzx.zzv(deviceIdentifier);
        this.zzaKx = (byte[]) zzx.zzv(message);
        this.zzaKu = zza.zzdn(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzyp() {
        return this.zzaKu.asBinder();
    }
}
