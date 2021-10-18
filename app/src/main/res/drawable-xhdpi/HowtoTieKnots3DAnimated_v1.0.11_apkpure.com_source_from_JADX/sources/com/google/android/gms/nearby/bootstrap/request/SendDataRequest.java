package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoy.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class SendDataRequest implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final byte[] data;
    final int versionCode;
    private final Device zzaJb;
    private final zzoy zzaJe;

    SendDataRequest(int versionCode2, Device device, byte[] data2, IBinder callback) {
        this.versionCode = versionCode2;
        this.zzaJb = (Device) zzx.zzv(device);
        this.data = (byte[]) zzx.zzv(data2);
        zzx.zzv(callback);
        this.zzaJe = zza.zzdb(callback);
    }

    public int describeContents() {
        zzf zzf = CREATOR;
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf zzf = CREATOR;
        zzf.zza(this, out, flags);
    }

    public IBinder zzsc() {
        if (this.zzaJe == null) {
            return null;
        }
        return this.zzaJe.asBinder();
    }

    public Device zzye() {
        return this.zzaJb;
    }
}
