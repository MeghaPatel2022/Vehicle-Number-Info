package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;

public class ClaimBleDeviceRequest implements SafeParcelable {
    public static final Creator<ClaimBleDeviceRequest> CREATOR = new zzb();
    private final int mVersionCode;
    private final String zzOZ;
    private final String zzapC;
    private final BleDevice zzapD;
    private final zznh zzapE;

    ClaimBleDeviceRequest(int versionCode, String deviceAddress, BleDevice bleDevice, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzapC = deviceAddress;
        this.zzapD = bleDevice;
        this.zzapE = callback == null ? null : zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public ClaimBleDeviceRequest(String deviceAddress, BleDevice bleDevice, zznh callback, String packageName) {
        this.mVersionCode = 3;
        this.zzapC = deviceAddress;
        this.zzapD = bleDevice;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.zzapC;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.zzapC, this.zzapD});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }

    public BleDevice zzsb() {
        return this.zzapD;
    }

    public IBinder zzsc() {
        if (this.zzapE == null) {
            return null;
        }
        return this.zzapE.asBinder();
    }
}
