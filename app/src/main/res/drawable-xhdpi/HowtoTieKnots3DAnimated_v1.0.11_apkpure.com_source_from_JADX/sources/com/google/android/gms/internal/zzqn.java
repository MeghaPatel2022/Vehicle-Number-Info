package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;

public class zzqn {
    private final List<zzqi> zzaTH = new ArrayList();

    public String getId() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (zzqi zzqi : this.zzaTH) {
            if (z) {
                z = false;
            } else {
                sb.append("#");
            }
            sb.append(zzqi.getContainerId());
        }
        return sb.toString();
    }

    public List<zzqi> zzBv() {
        return this.zzaTH;
    }

    public zzqn zzb(zzqi zzqi) throws IllegalArgumentException {
        zzx.zzv(zzqi);
        for (zzqi containerId : this.zzaTH) {
            if (containerId.getContainerId().equals(zzqi.getContainerId())) {
                throw new IllegalArgumentException("The container is already being requested. " + zzqi.getContainerId());
            }
        }
        this.zzaTH.add(zzqi);
        return this;
    }
}
