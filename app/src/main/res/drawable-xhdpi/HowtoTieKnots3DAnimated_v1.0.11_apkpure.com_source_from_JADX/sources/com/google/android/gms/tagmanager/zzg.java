package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzg extends zzak {

    /* renamed from: ID */
    private static final String f50ID = zzad.APP_NAME.toString();
    private final Context mContext;

    public zzg(Context context) {
        super(f50ID, new String[0]);
        this.mContext = context;
    }

    public zza zzG(Map<String, zza> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return zzdf.zzK(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (NameNotFoundException e) {
            zzbg.zzb("App name is not found.", e);
            return zzdf.zzBg();
        }
    }

    public boolean zzzx() {
        return true;
    }
}
