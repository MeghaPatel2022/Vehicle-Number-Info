package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzbk extends zzak {

    /* renamed from: ID */
    private static final String f33ID = zzad.MOBILE_ADWORDS_UNIQUE_ID.toString();
    private final Context mContext;

    public zzbk(Context context) {
        super(f33ID, new String[0]);
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
