package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpa.zza;

public class StartScanRequest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int versionCode;
    private final zzoy zzaJe;
    private final zzpa zzaJh;

    StartScanRequest(int versionCode2, IBinder scanListener, IBinder callback) {
        this.versionCode = versionCode2;
        zzx.zzv(scanListener);
        this.zzaJh = zza.zzdd(scanListener);
        zzx.zzv(callback);
        this.zzaJe = zzoy.zza.zzdb(callback);
    }

    public int describeContents() {
        zzg zzg = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg zzg = CREATOR;
        zzg.zza(this, out, flags);
    }

    public IBinder zzsc() {
        if (this.zzaJe == null) {
            return null;
        }
        return this.zzaJe.asBinder();
    }

    public IBinder zzyj() {
        if (this.zzaJh == null) {
            return null;
        }
        return this.zzaJh.asBinder();
    }
}
