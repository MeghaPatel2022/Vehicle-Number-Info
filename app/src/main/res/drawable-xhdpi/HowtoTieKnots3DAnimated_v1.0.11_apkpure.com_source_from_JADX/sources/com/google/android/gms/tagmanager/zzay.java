package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzay extends zzak {

    /* renamed from: ID */
    private static final String f27ID = zzad.JOINER.toString();
    private static final String zzaPY = zzae.ARG0.toString();
    private static final String zzaQq = zzae.ITEM_SEPARATOR.toString();
    private static final String zzaQr = zzae.KEY_VALUE_SEPARATOR.toString();
    private static final String zzaQs = zzae.ESCAPE.toString();

    private enum zza {
        NONE,
        URL,
        BACKSLASH
    }

    public zzay() {
        super(f27ID, zzaPY);
    }

    private String zza(String str, zza zza2, Set<Character> set) {
        switch (zza2) {
            case URL:
                try {
                    return zzdj.zzff(str);
                } catch (UnsupportedEncodingException e) {
                    zzbg.zzb("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                Iterator it = set.iterator();
                while (true) {
                    String str2 = replace;
                    if (!it.hasNext()) {
                        return str2;
                    }
                    String ch = ((Character) it.next()).toString();
                    replace = str2.replace(ch, "\\" + ch);
                }
            default:
                return str;
        }
    }

    private void zza(StringBuilder sb, String str, zza zza2, Set<Character> set) {
        sb.append(zza(str, zza2, set));
    }

    private void zza(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public com.google.android.gms.internal.zzag.zza zzG(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        HashSet hashSet;
        zza zza2;
        com.google.android.gms.internal.zzag.zza zza3 = (com.google.android.gms.internal.zzag.zza) map.get(zzaPY);
        if (zza3 == null) {
            return zzdf.zzBg();
        }
        com.google.android.gms.internal.zzag.zza zza4 = (com.google.android.gms.internal.zzag.zza) map.get(zzaQq);
        String str = zza4 != null ? zzdf.zzg(zza4) : "";
        com.google.android.gms.internal.zzag.zza zza5 = (com.google.android.gms.internal.zzag.zza) map.get(zzaQr);
        String str2 = zza5 != null ? zzdf.zzg(zza5) : "=";
        zza zza6 = zza.NONE;
        com.google.android.gms.internal.zzag.zza zza7 = (com.google.android.gms.internal.zzag.zza) map.get(zzaQs);
        if (zza7 != null) {
            String zzg = zzdf.zzg(zza7);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(zzg)) {
                zza2 = zza.URL;
                hashSet = null;
            } else if ("backslash".equals(zzg)) {
                zza2 = zza.BACKSLASH;
                hashSet = new HashSet();
                zza(hashSet, str);
                zza(hashSet, str2);
                hashSet.remove(Character.valueOf('\\'));
            } else {
                zzbg.m28e("Joiner: unsupported escape type: " + zzg);
                return zzdf.zzBg();
            }
        } else {
            hashSet = null;
            zza2 = zza6;
        }
        StringBuilder sb = new StringBuilder();
        switch (zza3.type) {
            case 2:
                boolean z = true;
                com.google.android.gms.internal.zzag.zza[] zzaArr = zza3.zziV;
                int length = zzaArr.length;
                int i = 0;
                while (i < length) {
                    com.google.android.gms.internal.zzag.zza zza8 = zzaArr[i];
                    if (!z) {
                        sb.append(str);
                    }
                    zza(sb, zzdf.zzg(zza8), zza2, hashSet);
                    i++;
                    z = false;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < zza3.zziW.length; i2++) {
                    if (i2 > 0) {
                        sb.append(str);
                    }
                    String zzg2 = zzdf.zzg(zza3.zziW[i2]);
                    String zzg3 = zzdf.zzg(zza3.zziX[i2]);
                    zza(sb, zzg2, zza2, hashSet);
                    sb.append(str2);
                    zza(sb, zzg3, zza2, hashSet);
                }
                break;
            default:
                zza(sb, zzdf.zzg(zza3), zza2, hashSet);
                break;
        }
        return zzdf.zzK(sb.toString());
    }

    public boolean zzzx() {
        return true;
    }
}
