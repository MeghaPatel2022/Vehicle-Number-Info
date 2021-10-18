package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzav.zza;

public class RemoveListenerRequest implements SafeParcelable {
    public static final Creator<RemoveListenerRequest> CREATOR = new zzbf();
    final int mVersionCode;
    public final zzav zzaZq;

    RemoveListenerRequest(int versionCode, IBinder listener) {
        this.mVersionCode = versionCode;
        if (listener != null) {
            this.zzaZq = zza.zzdZ(listener);
        } else {
            this.zzaZq = null;
        }
    }

    public RemoveListenerRequest(zzav listener) {
        this.mVersionCode = 1;
        this.zzaZq = listener;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbf.zza(this, dest, flags);
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzCt() {
        if (this.zzaZq == null) {
            return null;
        }
        return this.zzaZq.asBinder();
    }
}
