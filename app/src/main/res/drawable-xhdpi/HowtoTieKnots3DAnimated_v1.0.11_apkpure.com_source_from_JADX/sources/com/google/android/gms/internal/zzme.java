package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzme extends zzj<DriveId> {
    public static final zzme zzali = new zzme();

    private zzme() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId", "mimeType"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzm */
    public DriveId zzc(DataHolder dataHolder, int i, int i2) {
        return new DriveId(dataHolder.zzd("resourceId", i, i2), Long.valueOf(dataHolder.zzb("sqlId", i, i2)).longValue(), dataHolder.zznP().getLong("dbInstanceId"), DriveFolder.MIME_TYPE.equals(dataHolder.zzd(zzmb.zzakL.getName(), i, i2)) ? 1 : 0);
    }
}
