package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzo extends zza<String> {
    public zzo(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    public void zza(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzi */
    public String zzc(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzd(getName(), i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzr */
    public String zzk(Bundle bundle) {
        return bundle.getString(getName());
    }
}
