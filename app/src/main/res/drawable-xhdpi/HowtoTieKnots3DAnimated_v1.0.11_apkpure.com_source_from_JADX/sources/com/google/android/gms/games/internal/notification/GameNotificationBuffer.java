package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameNotificationBuffer extends AbstractDataBuffer<GameNotification> {
    /* renamed from: zzfX */
    public GameNotification get(int i) {
        return new GameNotificationRef(this.zzYX, i);
    }
}
