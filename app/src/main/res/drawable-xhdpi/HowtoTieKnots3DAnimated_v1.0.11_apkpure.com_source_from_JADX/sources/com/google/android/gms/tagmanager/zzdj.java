package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag.zza;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class zzdj {
    private static zzbw<zza> zza(zzbw<zza> zzbw) {
        try {
            return new zzbw(zzdf.zzK(zzff(zzdf.zzg((zza) zzbw.getObject()))), zzbw.zzAq());
        } catch (UnsupportedEncodingException e) {
            zzbg.zzb("Escape URI: unsupported encoding", e);
            return zzbw;
        }
    }

    private static zzbw<zza> zza(zzbw<zza> zzbw, int i) {
        if (!zzn((zza) zzbw.getObject())) {
            zzbg.m28e("Escaping can only be applied to strings.");
            return zzbw;
        }
        switch (i) {
            case 12:
                return zza(zzbw);
            default:
                zzbg.m28e("Unsupported Value Escaping: " + i);
                return zzbw;
        }
    }

    static zzbw<zza> zza(zzbw<zza> zzbw, int... iArr) {
        for (int zza : iArr) {
            zzbw = zza(zzbw, zza);
        }
        return zzbw;
    }

    static String zzff(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean zzn(zza zza) {
        return zzdf.zzl(zza) instanceof String;
    }
}
