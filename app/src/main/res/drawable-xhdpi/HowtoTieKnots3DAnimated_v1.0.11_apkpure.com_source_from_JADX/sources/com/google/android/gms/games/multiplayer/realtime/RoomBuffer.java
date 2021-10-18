package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class RoomBuffer extends zzf<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    public String zznW() {
        return "external_match_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzq */
    public Room zzk(int i, int i2) {
        return new RoomRef(this.zzYX, i, i2);
    }
}
