package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class QuestBuffer extends zzf<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    public String zznW() {
        return "external_quest_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzs */
    public Quest zzk(int i, int i2) {
        return new QuestRef(this.zzYX, i, i2);
    }
}
