package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DataItemParcelable implements SafeParcelable, DataItem {
    public static final Creator<DataItemParcelable> CREATOR = new zzad();
    private final Uri mUri;
    final int mVersionCode;
    private byte[] zzayG;
    private final Map<String, DataItemAsset> zzbap;

    DataItemParcelable(int versionCode, Uri uri, Bundle assetBundle, byte[] data) {
        this.mVersionCode = versionCode;
        this.mUri = uri;
        HashMap hashMap = new HashMap();
        assetBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : assetBundle.keySet()) {
            hashMap.put(str, (DataItemAssetParcelable) assetBundle.getParcelable(str));
        }
        this.zzbap = hashMap;
        this.zzayG = data;
    }

    public int describeContents() {
        return 0;
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.zzbap;
    }

    public byte[] getData() {
        return this.zzayG;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder sb = new StringBuilder("DataItemParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(",dataSz=" + (this.zzayG == null ? "null" : Integer.valueOf(this.zzayG.length)));
        sb.append(", numAssets=" + this.zzbap.size());
        sb.append(", uri=" + this.mUri);
        if (!verbose) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.zzbap.keySet()) {
            sb.append("\n    " + str + ": " + this.zzbap.get(str));
        }
        sb.append("\n  ]");
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzad.zza(this, dest, flags);
    }

    /* renamed from: zzCH */
    public DataItemParcelable freeze() {
        return this;
    }

    public Bundle zzCr() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Entry entry : this.zzbap.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((DataItemAsset) entry.getValue()));
        }
        return bundle;
    }

    /* renamed from: zzv */
    public DataItemParcelable setData(byte[] bArr) {
        this.zzayG = bArr;
        return this;
    }
}
