package com.google.android.gms.games.request;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameRequestSummaryBuffer extends AbstractDataBuffer<GameRequestSummary> {
    /* renamed from: zzgk */
    public GameRequestSummary get(int i) {
        return new GameRequestSummaryRef(this.zzYX, i);
    }
}
