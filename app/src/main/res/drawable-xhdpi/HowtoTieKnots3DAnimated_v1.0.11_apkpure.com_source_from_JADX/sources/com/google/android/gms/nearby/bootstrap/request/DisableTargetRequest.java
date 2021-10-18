package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoy.zza;

public class DisableTargetRequest implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int versionCode;
    private final zzoy zzaJe;

    DisableTargetRequest(int versionCode2, IBinder callback) {
        this.versionCode = versionCode2;
        zzx.zzv(callback);
        this.zzaJe = zza.zzdb(callback);
    }

    public int describeContents() {
        zzc zzc = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc zzc = CREATOR;
        zzc.zza(this, out, flags);
    }

    public IBinder zzsc() {
        if (this.zzaJe == null) {
            return null;
        }
        return this.zzaJe.asBinder();
    }
}
