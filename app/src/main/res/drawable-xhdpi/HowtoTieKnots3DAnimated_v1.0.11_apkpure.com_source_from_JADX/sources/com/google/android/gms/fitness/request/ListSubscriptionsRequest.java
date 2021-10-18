package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznc;
import com.google.android.gms.internal.zznc.zza;

public class ListSubscriptionsRequest implements SafeParcelable {
    public static final Creator<ListSubscriptionsRequest> CREATOR = new zzp();
    private final int mVersionCode;
    private final String zzOZ;
    private final DataType zzanl;
    private final zznc zzaqe;

    ListSubscriptionsRequest(int versionCode, DataType dataType, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzanl = dataType;
        this.zzaqe = callback == null ? null : zza.zzbE(callback);
        this.zzOZ = packageName;
    }

    public ListSubscriptionsRequest(DataType dataType, zznc callback, String packageName) {
        this.mVersionCode = 2;
        this.zzanl = dataType;
        this.zzaqe = callback;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public DataType getDataType() {
        return this.zzanl;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzp.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        if (this.zzaqe == null) {
            return null;
        }
        return this.zzaqe.asBinder();
    }
}
