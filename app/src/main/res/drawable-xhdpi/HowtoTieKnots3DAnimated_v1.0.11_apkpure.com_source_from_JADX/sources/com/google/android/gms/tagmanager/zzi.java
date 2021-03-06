package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzi extends zzak {

    /* renamed from: ID */
    private static final String f52ID = zzad.APP_VERSION_NAME.toString();
    private final Context mContext;

    public zzi(Context context) {
        super(f52ID, new String[0]);
        this.mContext = context;
    }

    public zza zzG(Map<String, zza> map) {
        try {
            return zzdf.zzK(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
            zzbg.m28e("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return zzdf.zzBg();
        }
    }

    public boolean zzzx() {
        return true;
    }
}
