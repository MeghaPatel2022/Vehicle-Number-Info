package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zza.C1530zza;
import com.google.android.gms.nearby.sharing.internal.zzc.zza;

public final class ReceiveContentRequest implements SafeParcelable {
    public static final Creator<ReceiveContentRequest> CREATOR = new zzg();
    public String packageName;
    final int versionCode;
    public IBinder zzaKq;
    public zzc zzaKu;
    public zza zzaKv;

    ReceiveContentRequest() {
        this.versionCode = 1;
    }

    ReceiveContentRequest(int versionCode2, IBinder clientBinder, IBinder contentReceiverAsBinder, String packageName2, IBinder callbackAsBinder) {
        this.versionCode = versionCode2;
        this.zzaKq = clientBinder;
        this.zzaKv = C1530zza.zzdl(contentReceiverAsBinder);
        this.packageName = packageName2;
        this.zzaKu = zza.zzdn(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzyp() {
        return this.zzaKu.asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzyy() {
        if (this.zzaKv == null) {
            return null;
        }
        return this.zzaKv.asBinder();
    }
}
