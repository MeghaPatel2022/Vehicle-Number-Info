package com.google.android.gms.appstate;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class zzb extends zzc implements AppState {
    zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return zza.zza(this, obj);
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !zzcf("conflict_version");
    }

    public int hashCode() {
        return zza.zza(this);
    }

    public String toString() {
        return zza.zzb(this);
    }

    /* renamed from: zzlk */
    public AppState freeze() {
        return new zza(this);
    }
}
