package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzz implements DataItemAsset {
    private final String zztP;
    private final String zzwj;

    public zzz(DataItemAsset dataItemAsset) {
        this.zzwj = dataItemAsset.getId();
        this.zztP = dataItemAsset.getDataItemKey();
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
        sb.append("DataItemAssetEntity[");
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

    /* renamed from: zzCF */
    public DataItemAsset freeze() {
        return this;
    }
}
