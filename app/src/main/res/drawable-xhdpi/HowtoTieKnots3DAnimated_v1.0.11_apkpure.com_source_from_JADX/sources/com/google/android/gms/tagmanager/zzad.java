package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzad extends zzak {

    /* renamed from: ID */
    private static final String f18ID = com.google.android.gms.internal.zzad.ENCODE.toString();
    private static final String zzaPY = zzae.ARG0.toString();
    private static final String zzaPZ = zzae.NO_PADDING.toString();
    private static final String zzaQa = zzae.INPUT_FORMAT.toString();
    private static final String zzaQb = zzae.OUTPUT_FORMAT.toString();

    public zzad() {
        super(f18ID, zzaPY);
    }

    public zza zzG(Map<String, zza> map) {
        byte[] decode;
        String encodeToString;
        zza zza = (zza) map.get(zzaPY);
        if (zza == null || zza == zzdf.zzBg()) {
            return zzdf.zzBg();
        }
        String zzg = zzdf.zzg(zza);
        zza zza2 = (zza) map.get(zzaQa);
        String zzg2 = zza2 == null ? "text" : zzdf.zzg(zza2);
        zza zza3 = (zza) map.get(zzaQb);
        String zzg3 = zza3 == null ? "base16" : zzdf.zzg(zza3);
        zza zza4 = (zza) map.get(zzaPZ);
        int i = (zza4 == null || !zzdf.zzk(zza4).booleanValue()) ? 2 : 3;
        try {
            if ("text".equals(zzg2)) {
                decode = zzg.getBytes();
            } else if ("base16".equals(zzg2)) {
                decode = zzk.zzet(zzg);
            } else if ("base64".equals(zzg2)) {
                decode = Base64.decode(zzg, i);
            } else if ("base64url".equals(zzg2)) {
                decode = Base64.decode(zzg, i | 8);
            } else {
                zzbg.m28e("Encode: unknown input format: " + zzg2);
                return zzdf.zzBg();
            }
            if ("base16".equals(zzg3)) {
                encodeToString = zzk.zzi(decode);
            } else if ("base64".equals(zzg3)) {
                encodeToString = Base64.encodeToString(decode, i);
            } else if ("base64url".equals(zzg3)) {
                encodeToString = Base64.encodeToString(decode, i | 8);
            } else {
                zzbg.m28e("Encode: unknown output format: " + zzg3);
                return zzdf.zzBg();
            }
            return zzdf.zzK(encodeToString);
        } catch (IllegalArgumentException e) {
            zzbg.m28e("Encode: invalid input:");
            return zzdf.zzBg();
        }
    }

    public boolean zzzx() {
        return true;
    }
}
