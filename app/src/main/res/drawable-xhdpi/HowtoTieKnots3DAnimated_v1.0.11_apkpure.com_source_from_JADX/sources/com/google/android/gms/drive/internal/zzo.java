package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzo extends Metadata {
    private final MetadataBundle zzaig;

    public zzo(MetadataBundle metadataBundle) {
        this.zzaig = metadataBundle;
    }

    public boolean isDataValid() {
        return this.zzaig != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.zzaig + "]";
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return this.zzaig.zza(metadataField);
    }

    /* renamed from: zzqo */
    public Metadata freeze() {
        return new zzo(MetadataBundle.zza(this.zzaig));
    }
}
