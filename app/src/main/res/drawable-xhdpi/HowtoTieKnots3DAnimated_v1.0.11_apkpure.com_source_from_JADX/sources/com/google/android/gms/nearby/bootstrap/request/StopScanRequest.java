package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoy.zza;

public class StopScanRequest implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    final int versionCode;
    private final zzoy zzaJe;

    StopScanRequest(int versionCode2, IBinder callback) {
        this.versionCode = versionCode2;
        zzx.zzv(callback);
        this.zzaJe = zza.zzdb(callback);
    }

    public int describeContents() {
        zzh zzh = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh zzh = CREATOR;
        zzh.zza(this, out, flags);
    }

    public IBinder zzsc() {
        if (this.zzaJe == null) {
            return null;
        }
        return this.zzaJe.asBinder();
    }
}
