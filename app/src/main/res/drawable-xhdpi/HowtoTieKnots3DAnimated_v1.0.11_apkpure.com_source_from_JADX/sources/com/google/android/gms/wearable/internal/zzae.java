package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class zzae extends zzc implements DataItem {
    private final int zzasz;

    public zzae(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzasz = i2;
    }

    public Map<String, DataItemAsset> getAssets() {
        HashMap hashMap = new HashMap(this.zzasz);
        for (int i = 0; i < this.zzasz; i++) {
            zzab zzab = new zzab(this.zzYX, this.zzabg + i);
            if (zzab.getDataItemKey() != null) {
                hashMap.put(zzab.getDataItemKey(), zzab);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        byte[] data = getData();
        Map assets = getAssets();
        StringBuilder sb = new StringBuilder("DataItemInternal{ ");
        sb.append("uri=" + getUri());
        sb.append(", dataSz=" + (data == null ? "null" : Integer.valueOf(data.length)));
        sb.append(", numAssets=" + assets.size());
        if (verbose && !assets.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            Iterator it = assets.entrySet().iterator();
            while (true) {
                String str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                sb.append(str2 + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).getId());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }

    /* renamed from: zzCG */
    public DataItem freeze() {
        return new zzac(this);
    }
}
