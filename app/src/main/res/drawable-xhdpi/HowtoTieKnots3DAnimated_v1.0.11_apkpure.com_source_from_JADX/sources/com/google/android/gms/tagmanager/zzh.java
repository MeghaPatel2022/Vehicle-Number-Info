package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzh extends zzak {

    /* renamed from: ID */
    private static final String f51ID = zzad.APP_VERSION.toString();
    private final Context mContext;

    public zzh(Context context) {
        super(f51ID, new String[0]);
        this.mContext = context;
    }

    public zza zzG(Map<String, zza> map) {
        try {
            return zzdf.zzK(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            zzbg.m28e("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return zzdf.zzBg();
        }
    }

    public boolean zzzx() {
        return true;
    }
}
