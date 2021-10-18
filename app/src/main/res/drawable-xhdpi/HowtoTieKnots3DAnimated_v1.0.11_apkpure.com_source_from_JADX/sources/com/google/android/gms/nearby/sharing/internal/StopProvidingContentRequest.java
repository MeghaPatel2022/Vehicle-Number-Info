package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zzc.zza;

public final class StopProvidingContentRequest implements SafeParcelable {
    public static final Creator<StopProvidingContentRequest> CREATOR = new zzj();
    final int versionCode;
    public long zzaKt;
    public zzc zzaKu;

    StopProvidingContentRequest() {
        this.versionCode = 1;
    }

    StopProvidingContentRequest(int versionCode2, long activityId, IBinder callbackAsBinder) {
        this.versionCode = versionCode2;
        this.zzaKt = activityId;
        this.zzaKu = zza.zzdn(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzyp() {
        return this.zzaKu.asBinder();
    }
}
