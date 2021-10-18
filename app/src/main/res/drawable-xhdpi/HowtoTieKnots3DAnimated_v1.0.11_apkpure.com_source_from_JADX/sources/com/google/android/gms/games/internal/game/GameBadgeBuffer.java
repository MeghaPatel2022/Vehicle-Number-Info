package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameBadgeBuffer extends AbstractDataBuffer<GameBadge> {
    /* renamed from: zzfS */
    public GameBadge get(int i) {
        return new GameBadgeRef(this.zzYX, i);
    }
}
