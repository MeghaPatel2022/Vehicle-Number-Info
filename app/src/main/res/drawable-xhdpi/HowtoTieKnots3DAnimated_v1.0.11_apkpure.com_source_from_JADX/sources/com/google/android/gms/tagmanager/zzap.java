package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzap extends zzak {

    /* renamed from: ID */
    private static final String f25ID = zzad.HASH.toString();
    private static final String zzaPY = zzae.ARG0.toString();
    private static final String zzaQa = zzae.INPUT_FORMAT.toString();
    private static final String zzaQe = zzae.ALGORITHM.toString();

    public zzap() {
        super(f25ID, zzaPY);
    }

    private byte[] zzd(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public zza zzG(Map<String, zza> map) {
        byte[] zzet;
        zza zza = (zza) map.get(zzaPY);
        if (zza == null || zza == zzdf.zzBg()) {
            return zzdf.zzBg();
        }
        String zzg = zzdf.zzg(zza);
        zza zza2 = (zza) map.get(zzaQe);
        String zzg2 = zza2 == null ? "MD5" : zzdf.zzg(zza2);
        zza zza3 = (zza) map.get(zzaQa);
        String zzg3 = zza3 == null ? "text" : zzdf.zzg(zza3);
        if ("text".equals(zzg3)) {
            zzet = zzg.getBytes();
        } else if ("base16".equals(zzg3)) {
            zzet = zzk.zzet(zzg);
        } else {
            zzbg.m28e("Hash: unknown input format: " + zzg3);
            return zzdf.zzBg();
        }
        try {
            return zzdf.zzK(zzk.zzi(zzd(zzg2, zzet)));
        } catch (NoSuchAlgorithmException e) {
            zzbg.m28e("Hash: unknown algorithm: " + zzg2);
            return zzdf.zzBg();
        }
    }

    public boolean zzzx() {
        return true;
    }
}
