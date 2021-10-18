package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class LeaderboardBuffer extends zzf<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    public String zznW() {
        return "external_leaderboard_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzo */
    public Leaderboard zzk(int i, int i2) {
        return new LeaderboardRef(this.zzYX, i, i2);
    }
}
