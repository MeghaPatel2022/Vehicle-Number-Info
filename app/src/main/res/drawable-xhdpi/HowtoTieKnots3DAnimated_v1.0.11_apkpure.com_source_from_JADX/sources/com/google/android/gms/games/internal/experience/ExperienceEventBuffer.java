package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventBuffer extends AbstractDataBuffer<ExperienceEvent> {
    public ExperienceEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: zzfR */
    public ExperienceEvent get(int i) {
        return new ExperienceEventRef(this.zzYX, i);
    }
}
