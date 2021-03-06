package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzmc extends zzj<AppVisibleCustomProperties> {
    public zzmc(int i) {
        super("customProperties", Arrays.asList(new String[]{"hasCustomProperties", "sqlId"}), Arrays.asList(new String[]{"customPropertiesExtra"}), i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzl */
    public AppVisibleCustomProperties zzc(DataHolder dataHolder, int i, int i2) {
        return (AppVisibleCustomProperties) dataHolder.zznP().getSparseParcelableArray("customPropertiesExtra").get(i, AppVisibleCustomProperties.zzakh);
    }
}
