package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReadRawResult implements Result, SafeParcelable {
    public static final Creator<ReadRawResult> CREATOR = new zzi();
    private final int mVersionCode;
    private final DataHolder zzYX;

    ReadRawResult(int versionCode, DataHolder dataHolder) {
        this.mVersionCode = versionCode;
        this.zzYX = dataHolder;
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return new Status(this.zzYX.getStatusCode());
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    /* access modifiers changed from: 0000 */
    public DataHolder zzqA() {
        return this.zzYX;
    }
}
