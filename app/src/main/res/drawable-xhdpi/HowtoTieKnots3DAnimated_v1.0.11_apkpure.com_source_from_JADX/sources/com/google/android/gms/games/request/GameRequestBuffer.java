package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class GameRequestBuffer extends zzf<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    public String zznW() {
        return "external_request_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzt */
    public GameRequest zzk(int i, int i2) {
        return new GameRequestRef(this.zzYX, i, i2);
    }
}
