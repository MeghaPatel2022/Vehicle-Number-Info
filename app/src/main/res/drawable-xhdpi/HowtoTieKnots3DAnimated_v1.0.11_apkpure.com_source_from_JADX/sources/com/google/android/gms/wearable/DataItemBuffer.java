package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzae;

public class DataItemBuffer extends zzf<DataItem> implements Result {
    private final Status zzQA;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzQA = new Status(dataHolder.getStatusCode());
    }

    public Status getStatus() {
        return this.zzQA;
    }

    /* access modifiers changed from: protected */
    public String zznW() {
        return "path";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzw */
    public DataItem zzk(int i, int i2) {
        return new zzae(this.zzYX, i, i2);
    }
}
