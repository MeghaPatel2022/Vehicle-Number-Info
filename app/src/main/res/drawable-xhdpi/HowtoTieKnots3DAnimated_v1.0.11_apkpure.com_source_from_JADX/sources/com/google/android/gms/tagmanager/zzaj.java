package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf.zzc;
import com.google.android.gms.internal.zzaf.zzd;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzaj {
    private static void zza(DataLayer dataLayer, zzd zzd) {
        for (zza zzg : zzd.zzia) {
            dataLayer.zzeC(zzdf.zzg(zzg));
        }
    }

    public static void zza(DataLayer dataLayer, zzi zzi) {
        if (zzi.zziP == null) {
            zzbg.zzaE("supplemental missing experimentSupplemental");
            return;
        }
        zza(dataLayer, zzi.zziP);
        zzb(dataLayer, zzi.zziP);
        zzc(dataLayer, zzi.zziP);
    }

    private static void zzb(DataLayer dataLayer, zzd zzd) {
        for (zza zzc : zzd.zzhZ) {
            Map zzc2 = zzc(zzc);
            if (zzc2 != null) {
                dataLayer.push(zzc2);
            }
        }
    }

    private static Map<String, Object> zzc(zza zza) {
        Object zzl = zzdf.zzl(zza);
        if (zzl instanceof Map) {
            return (Map) zzl;
        }
        zzbg.zzaE("value: " + zzl + " is not a map value, ignored.");
        return null;
    }

    private static void zzc(DataLayer dataLayer, zzd zzd) {
        zzc[] zzcArr;
        for (zzc zzc : zzd.zzib) {
            if (zzc.key == null) {
                zzbg.zzaE("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(zzc.key);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = zzc.zzhV;
                long j2 = zzc.zzhW;
                if (!zzc.zzhX || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        zzbg.zzaE("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.zzeC(zzc.key);
                Map zzj = dataLayer.zzj(zzc.key, obj);
                if (zzc.zzhY > 0) {
                    if (!zzj.containsKey("gtm")) {
                        zzj.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(zzc.zzhY)));
                    } else {
                        Object obj2 = zzj.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(zzc.zzhY));
                        } else {
                            zzbg.zzaE("GaExperimentRandom: gtm not a map");
                        }
                    }
                }
                dataLayer.push(zzj);
            }
        }
    }
}
