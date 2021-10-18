package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzo;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zzmb;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzagP;

    private static class zza extends Metadata {
        private final DataHolder zzYX;
        private final int zzabh;
        /* access modifiers changed from: private */
        public final int zzagQ;

        public zza(DataHolder dataHolder, int i) {
            this.zzYX = dataHolder;
            this.zzagQ = i;
            this.zzabh = dataHolder.zzbo(i);
        }

        public boolean isDataValid() {
            return !this.zzYX.isClosed();
        }

        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzYX, this.zzagQ, this.zzabh);
        }

        /* renamed from: zzqo */
        public Metadata freeze() {
            MetadataBundle zzrb = MetadataBundle.zzrb();
            for (MetadataField<BitmapTeleporter> metadataField : zze.zzra()) {
                if (metadataField != zzmb.zzakT) {
                    metadataField.zza(this.zzYX, zzrb, this.zzagQ, this.zzabh);
                }
            }
            return new zzo(zzrb);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zznP().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        zza zza2 = this.zzagP;
        if (zza2 != null && zza2.zzagQ == row) {
            return zza2;
        }
        zza zza3 = new zza(this.zzYX, row);
        this.zzagP = zza3;
        return zza3;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }

    public void release() {
        if (this.zzYX != null) {
            zze.zzb(this.zzYX);
        }
        super.release();
    }
}
