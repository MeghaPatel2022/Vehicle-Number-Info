package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR = new zzaa();
    final int mVersionCode;
    private final String zztP;
    private final String zzwj;

    DataItemAssetParcelable(int versionCode, String id, String key) {
        this.mVersionCode = versionCode;
        this.zzwj = id;
        this.zztP = key;
    }

    public DataItemAssetParcelable(DataItemAsset value) {
        this.mVersionCode = 1;
        this.zzwj = (String) zzx.zzv(value.getId());
        this.zztP = (String) zzx.zzv(value.getDataItemKey());
    }

    public int describeContents() {
        return 0;
    }

    public String getDataItemKey() {
        return this.zztP;
    }

    public String getId() {
        return this.zzwj;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zzwj == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.zzwj);
        }
        sb.append(", key=");
        sb.append(this.zztP);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaa.zza(this, dest, flags);
    }

    /* renamed from: zzCF */
    public DataItemAsset freeze() {
        return this;
    }
}
