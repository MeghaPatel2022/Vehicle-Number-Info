package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class SyncInfoResult implements Result, SafeParcelable {
    public static final Creator<SyncInfoResult> CREATOR = new zzl();
    private final int mVersionCode;
    private final Status zzQA;
    private final long zzXR;

    SyncInfoResult(int versionCode, Status status, long timestamp) {
        this.mVersionCode = versionCode;
        this.zzQA = status;
        this.zzXR = timestamp;
    }

    private boolean zzb(SyncInfoResult syncInfoResult) {
        return this.zzQA.equals(syncInfoResult.zzQA) && zzw.equal(Long.valueOf(this.zzXR), Long.valueOf(syncInfoResult.zzXR));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SyncInfoResult) && zzb((SyncInfoResult) that));
    }

    public Status getStatus() {
        return this.zzQA;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzQA, Long.valueOf(this.zzXR));
    }

    public String toString() {
        return zzw.zzu(this).zzg("status", this.zzQA).zzg("timestamp", Long.valueOf(this.zzXR)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }

    public long zzsH() {
        return this.zzXR;
    }
}
