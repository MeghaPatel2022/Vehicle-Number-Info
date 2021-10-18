package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class zzbb extends zzak {

    /* renamed from: ID */
    private static final String f29ID = zzad.LANGUAGE.toString();

    public zzbb() {
        super(f29ID, new String[0]);
    }

    public /* bridge */ /* synthetic */ String zzAc() {
        return super.zzAc();
    }

    public /* bridge */ /* synthetic */ Set zzAd() {
        return super.zzAd();
    }

    public zza zzG(Map<String, zza> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return zzdf.zzBg();
        }
        String language = locale.getLanguage();
        return language == null ? zzdf.zzBg() : zzdf.zzK(language.toLowerCase());
    }

    public boolean zzzx() {
        return false;
    }
}
