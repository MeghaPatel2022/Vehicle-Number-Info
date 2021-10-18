package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzy;

public class DataEventBuffer extends zzf<DataEvent> implements Result {
    private final Status zzQA;

    public DataEventBuffer(DataHolder dataHolder) {
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
    /* renamed from: zzv */
    public DataEvent zzk(int i, int i2) {
        return new zzy(this.zzYX, i, i2);
    }
}
