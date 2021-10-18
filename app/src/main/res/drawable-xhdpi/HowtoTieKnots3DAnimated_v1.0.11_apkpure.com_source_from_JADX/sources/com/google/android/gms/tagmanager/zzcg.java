package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzcg extends zzak {

    /* renamed from: ID */
    private static final String f40ID = zzad.RESOLUTION.toString();
    private final Context mContext;

    public zzcg(Context context) {
        super(f40ID, new String[0]);
        this.mContext = context;
    }

    public zza zzG(Map<String, zza> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return zzdf.zzK(i + "x" + displayMetrics.heightPixels);
    }

    public boolean zzzx() {
        return true;
    }
}
