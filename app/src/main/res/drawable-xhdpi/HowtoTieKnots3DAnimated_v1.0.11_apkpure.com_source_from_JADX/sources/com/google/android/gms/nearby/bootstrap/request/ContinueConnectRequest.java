package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoy.zza;

public class ContinueConnectRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int versionCode;
    private final zzoy zzaJe;
    private final String zzaJf;

    ContinueConnectRequest(int versionCode2, String token, IBinder callback) {
        this.versionCode = versionCode2;
        this.zzaJf = (String) zzx.zzv(token);
        this.zzaJe = zza.zzdb(callback);
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    public String getToken() {
        return this.zzaJf;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    public IBinder zzsc() {
        if (this.zzaJe == null) {
            return null;
        }
        return this.zzaJe.asBinder();
    }
}
