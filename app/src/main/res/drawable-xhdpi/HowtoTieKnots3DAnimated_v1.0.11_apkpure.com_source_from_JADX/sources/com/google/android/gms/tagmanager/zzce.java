package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzce extends zzak {

    /* renamed from: ID */
    private static final String f38ID = zzad.REGEX_GROUP.toString();
    private static final String zzaRi = zzae.ARG0.toString();
    private static final String zzaRj = zzae.ARG1.toString();
    private static final String zzaRk = zzae.IGNORE_CASE.toString();
    private static final String zzaRl = zzae.GROUP.toString();

    public zzce() {
        super(f38ID, zzaRi, zzaRj);
    }

    public zza zzG(Map<String, zza> map) {
        int i;
        zza zza = (zza) map.get(zzaRi);
        zza zza2 = (zza) map.get(zzaRj);
        if (zza == null || zza == zzdf.zzBg() || zza2 == null || zza2 == zzdf.zzBg()) {
            return zzdf.zzBg();
        }
        int i2 = 64;
        if (zzdf.zzk((zza) map.get(zzaRk)).booleanValue()) {
            i2 = 66;
        }
        zza zza3 = (zza) map.get(zzaRl);
        if (zza3 != null) {
            Long zzi = zzdf.zzi(zza3);
            if (zzi == zzdf.zzBb()) {
                return zzdf.zzBg();
            }
            i = zzi.intValue();
            if (i < 0) {
                return zzdf.zzBg();
            }
        } else {
            i = 1;
        }
        try {
            String zzg = zzdf.zzg(zza);
            String str = null;
            Matcher matcher = Pattern.compile(zzdf.zzg(zza2), i2).matcher(zzg);
            if (matcher.find() && matcher.groupCount() >= i) {
                str = matcher.group(i);
            }
            return str == null ? zzdf.zzBg() : zzdf.zzK(str);
        } catch (PatternSyntaxException e) {
            return zzdf.zzBg();
        }
    }

    public boolean zzzx() {
        return true;
    }
}
