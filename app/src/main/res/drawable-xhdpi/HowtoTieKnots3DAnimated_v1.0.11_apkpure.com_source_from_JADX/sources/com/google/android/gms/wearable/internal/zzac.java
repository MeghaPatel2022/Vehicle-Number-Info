package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class zzac implements DataItem {
    private Uri mUri;
    private byte[] zzayG;
    private Map<String, DataItemAsset> zzbap;

    public zzac(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.zzayG = dataItem.getData();
        HashMap hashMap = new HashMap();
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((DataItemAsset) entry.getValue()).freeze());
            }
        }
        this.zzbap = Collections.unmodifiableMap(hashMap);
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

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder sb = new StringBuilder("DataItemEntity{ ");
        sb.append("uri=" + this.mUri);
        sb.append(", dataSz=" + (this.zzayG == null ? "null" : Integer.valueOf(this.zzayG.length)));
        sb.append(", numAssets=" + this.zzbap.size());
        if (verbose && !this.zzbap.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            Iterator it = this.zzbap.entrySet().iterator();
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
        return this;
    }
}
