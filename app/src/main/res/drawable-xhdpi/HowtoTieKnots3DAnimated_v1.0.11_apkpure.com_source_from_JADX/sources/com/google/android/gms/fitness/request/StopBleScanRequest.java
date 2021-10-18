package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zza.C1380zza;
import com.google.android.gms.fitness.request.zzn.zza;
import com.google.android.gms.internal.zznh;

public class StopBleScanRequest implements SafeParcelable {
    public static final Creator<StopBleScanRequest> CREATOR = new zzab();
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;
    private final zzn zzaqB;

    StopBleScanRequest(int versionCode, IBinder bleScanCallback, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzaqB = zza.zzbM(bleScanCallback);
        this.zzapE = callback == null ? null : zznh.zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public StopBleScanRequest(BleScanCallback bleScanCallback, zznh callback, String packageName) {
        this((zzn) C1380zza.zzsa().zzb(bleScanCallback), callback, packageName);
    }

    public StopBleScanRequest(zzn bleScanCallback, zznh callback, String packageName) {
        this.mVersionCode = 2;
        this.zzaqB = bleScanCallback;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzab.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        if (this.zzapE == null) {
            return null;
        }
        return this.zzapE.asBinder();
    }

    public IBinder zzsy() {
        return this.zzaqB.asBinder();
    }
}
