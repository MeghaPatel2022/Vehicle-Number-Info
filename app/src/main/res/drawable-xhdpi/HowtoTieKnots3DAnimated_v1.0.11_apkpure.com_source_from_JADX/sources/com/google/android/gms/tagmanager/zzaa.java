package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzaa extends zzak {

    /* renamed from: ID */
    private static final String f16ID = zzad.DEVICE_ID.toString();
    private final Context mContext;

    public zzaa(Context context) {
        super(f16ID, new String[0]);
        this.mContext = context;
    }

    public zza zzG(Map<String, zza> map) {
        String zzaN = zzaN(this.mContext);
        return zzaN == null ? zzdf.zzBg() : zzdf.zzK(zzaN);
    }

    /* access modifiers changed from: protected */
    public String zzaN(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean zzzx() {
        return true;
    }
}
