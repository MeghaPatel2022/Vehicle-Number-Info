package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoy.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class DisconnectRequest implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int versionCode;
    private final Device zzaJb;
    private final zzoy zzaJe;

    DisconnectRequest(int versionCode2, Device device, IBinder callback) {
        this.versionCode = versionCode2;
        this.zzaJb = (Device) zzx.zzv(device);
        zzx.zzv(callback);
        this.zzaJe = zza.zzdb(callback);
    }

    public int describeContents() {
        zzd zzd = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd zzd = CREATOR;
        zzd.zza(this, out, flags);
    }

    public IBinder zzsc() {
        return this.zzaJe.asBinder();
    }

    public Device zzye() {
        return this.zzaJb;
    }
}
