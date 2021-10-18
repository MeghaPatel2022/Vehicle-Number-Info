package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzc;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzoh;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzom;
import com.google.android.gms.internal.zzon;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzop;
import com.google.android.gms.internal.zzoq;
import com.google.android.gms.internal.zzor;
import com.google.android.gms.internal.zzos;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzb extends zzc implements zzoh {
    private static DecimalFormat zzKk;
    private final zzf zzKa;
    private final Uri zzKl;
    private final boolean zzKm;
    private final boolean zzKn;
    private final String zztw;

    public zzb(zzf zzf, String str) {
        this(zzf, str, true, false);
    }

    public zzb(zzf zzf, String str, boolean z, boolean z2) {
        super(zzf);
        zzx.zzcs(str);
        this.zzKa = zzf;
        this.zztw = str;
        this.zzKm = z;
        this.zzKn = z2;
        this.zzKl = zzaP(this.zztw);
    }

    private static void zza(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, zzb(d));
        }
    }

    private static void zza(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void zza(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static void zza(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    static Uri zzaP(String str) {
        zzx.zzcs(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String zzb(double d) {
        if (zzKk == null) {
            zzKk = new DecimalFormat("0.######");
        }
        return zzKk.format(d);
    }

    public static Map<String, String> zzc(zzob zzob) {
        HashMap hashMap = new HashMap();
        zzja zzja = (zzja) zzob.zzd(zzja.class);
        if (zzja != null) {
            for (Entry entry : zzja.zzhJ().entrySet()) {
                String zzh = zzh(entry.getValue());
                if (zzh != null) {
                    hashMap.put(entry.getKey(), zzh);
                }
            }
        }
        zzjb zzjb = (zzjb) zzob.zzd(zzjb.class);
        if (zzjb != null) {
            zza((Map<String, String>) hashMap, "t", zzjb.zzhK());
            zza((Map<String, String>) hashMap, "cid", zzjb.getClientId());
            zza((Map<String, String>) hashMap, "uid", zzjb.getUserId());
            zza((Map<String, String>) hashMap, "sc", zzjb.zzhN());
            zza((Map<String, String>) hashMap, "sf", zzjb.zzhP());
            zza((Map<String, String>) hashMap, "ni", zzjb.zzhO());
            zza((Map<String, String>) hashMap, "adid", zzjb.zzhL());
            zza((Map<String, String>) hashMap, "ate", zzjb.zzhM());
        }
        zzoq zzoq = (zzoq) zzob.zzd(zzoq.class);
        if (zzoq != null) {
            zza((Map<String, String>) hashMap, "cd", zzoq.zzxT());
            zza((Map<String, String>) hashMap, "a", (double) zzoq.zzbp());
            zza((Map<String, String>) hashMap, "dr", zzoq.zzxW());
        }
        zzoo zzoo = (zzoo) zzob.zzd(zzoo.class);
        if (zzoo != null) {
            zza((Map<String, String>) hashMap, "ec", zzoo.zzxQ());
            zza((Map<String, String>) hashMap, "ea", zzoo.getAction());
            zza((Map<String, String>) hashMap, "el", zzoo.getLabel());
            zza((Map<String, String>) hashMap, "ev", (double) zzoo.getValue());
        }
        zzol zzol = (zzol) zzob.zzd(zzol.class);
        if (zzol != null) {
            zza((Map<String, String>) hashMap, "cn", zzol.getName());
            zza((Map<String, String>) hashMap, "cs", zzol.getSource());
            zza((Map<String, String>) hashMap, "cm", zzol.zzxB());
            zza((Map<String, String>) hashMap, "ck", zzol.zzxC());
            zza((Map<String, String>) hashMap, "cc", zzol.getContent());
            zza((Map<String, String>) hashMap, "ci", zzol.getId());
            zza((Map<String, String>) hashMap, "anid", zzol.zzxD());
            zza((Map<String, String>) hashMap, "gclid", zzol.zzxE());
            zza((Map<String, String>) hashMap, "dclid", zzol.zzxF());
            zza((Map<String, String>) hashMap, "aclid", zzol.zzxG());
        }
        zzop zzop = (zzop) zzob.zzd(zzop.class);
        if (zzop != null) {
            zza((Map<String, String>) hashMap, "exd", zzop.getDescription());
            zza((Map<String, String>) hashMap, "exf", zzop.zzxR());
        }
        zzor zzor = (zzor) zzob.zzd(zzor.class);
        if (zzor != null) {
            zza((Map<String, String>) hashMap, "sn", zzor.zzya());
            zza((Map<String, String>) hashMap, "sa", zzor.getAction());
            zza((Map<String, String>) hashMap, "st", zzor.getTarget());
        }
        zzos zzos = (zzos) zzob.zzd(zzos.class);
        if (zzos != null) {
            zza((Map<String, String>) hashMap, "utv", zzos.zzyb());
            zza((Map<String, String>) hashMap, "utt", (double) zzos.getTimeInMillis());
            zza((Map<String, String>) hashMap, "utc", zzos.zzxQ());
            zza((Map<String, String>) hashMap, "utl", zzos.getLabel());
        }
        zziy zziy = (zziy) zzob.zzd(zziy.class);
        if (zziy != null) {
            for (Entry entry2 : zziy.zzhH().entrySet()) {
                String zzP = zzc.zzP(((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(zzP)) {
                    hashMap.put(zzP, entry2.getValue());
                }
            }
        }
        zziz zziz = (zziz) zzob.zzd(zziz.class);
        if (zziz != null) {
            for (Entry entry3 : zziz.zzhI().entrySet()) {
                String zzR = zzc.zzR(((Integer) entry3.getKey()).intValue());
                if (!TextUtils.isEmpty(zzR)) {
                    hashMap.put(zzR, zzb(((Double) entry3.getValue()).doubleValue()));
                }
            }
        }
        zzon zzon = (zzon) zzob.zzd(zzon.class);
        if (zzon != null) {
            ProductAction zzxM = zzon.zzxM();
            if (zzxM != null) {
                for (Entry entry4 : zzxM.build().entrySet()) {
                    if (((String) entry4.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry4.getKey()).substring(1), entry4.getValue());
                    } else {
                        hashMap.put(entry4.getKey(), entry4.getValue());
                    }
                }
            }
            int i = 1;
            for (Promotion zzaV : zzon.zzxP()) {
                hashMap.putAll(zzaV.zzaV(zzc.zzV(i)));
                i++;
            }
            int i2 = 1;
            for (Product zzaV2 : zzon.zzxN()) {
                hashMap.putAll(zzaV2.zzaV(zzc.zzT(i2)));
                i2++;
            }
            int i3 = 1;
            for (Entry entry5 : zzon.zzxO().entrySet()) {
                List<Product> list = (List) entry5.getValue();
                String zzY = zzc.zzY(i3);
                int i4 = 1;
                for (Product zzaV3 : list) {
                    hashMap.putAll(zzaV3.zzaV(zzY + zzc.zzW(i4)));
                    i4++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry5.getKey())) {
                    hashMap.put(zzY + "nm", entry5.getKey());
                }
                i3++;
            }
        }
        zzom zzom = (zzom) zzob.zzd(zzom.class);
        if (zzom != null) {
            zza((Map<String, String>) hashMap, "ul", zzom.getLanguage());
            zza((Map<String, String>) hashMap, "sd", (double) zzom.zzxH());
            zza(hashMap, "sr", zzom.zzxI(), zzom.zzxJ());
            zza(hashMap, "vp", zzom.zzxK(), zzom.zzxL());
        }
        zzok zzok = (zzok) zzob.zzd(zzok.class);
        if (zzok != null) {
            zza((Map<String, String>) hashMap, "an", zzok.zzjZ());
            zza((Map<String, String>) hashMap, "aid", zzok.zztW());
            zza((Map<String, String>) hashMap, "aiid", zzok.zzxA());
            zza((Map<String, String>) hashMap, "av", zzok.zzkb());
        }
        return hashMap;
    }

    private static String zzh(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.doubleValue() != 0.0d) {
                return zzb(d.doubleValue());
            }
            return null;
        } else if (!(obj instanceof Boolean)) {
            return String.valueOf(obj);
        } else {
            if (obj != Boolean.FALSE) {
                return "1";
            }
            return null;
        }
    }

    private static String zzy(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append((String) entry.getValue());
        }
        return sb.toString();
    }

    public void zzb(zzob zzob) {
        zzx.zzv(zzob);
        zzx.zzb(zzob.zzxm(), (Object) "Can't deliver not submitted measurement");
        zzx.zzci("deliver should be called on worker thread");
        zzob zzxh = zzob.zzxh();
        zzjb zzjb = (zzjb) zzxh.zze(zzjb.class);
        if (TextUtils.isEmpty(zzjb.zzhK())) {
            zzie().zzh(zzc(zzxh), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(zzjb.getClientId())) {
            zzie().zzh(zzc(zzxh), "Ignoring measurement without client id");
        } else if (!this.zzKa.zzis().getAppOptOut()) {
            double zzhP = zzjb.zzhP();
            if (zzam.zza(zzhP, zzjb.getClientId())) {
                zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zzhP));
                return;
            }
            Map zzc = zzc(zzxh);
            zzc.put("v", "1");
            zzc.put("_v", zze.zzLB);
            zzc.put("tid", this.zztw);
            if (this.zzKa.zzis().isDryRunEnabled()) {
                zzc("Dry run is enabled. GoogleAnalytics would have sent", zzy(zzc));
                return;
            }
            HashMap hashMap = new HashMap();
            zzam.zzb((Map<String, String>) hashMap, "uid", zzjb.getUserId());
            zzok zzok = (zzok) zzob.zzd(zzok.class);
            if (zzok != null) {
                zzam.zzb((Map<String, String>) hashMap, "an", zzok.zzjZ());
                zzam.zzb((Map<String, String>) hashMap, "aid", zzok.zztW());
                zzam.zzb((Map<String, String>) hashMap, "av", zzok.zzkb());
                zzam.zzb((Map<String, String>) hashMap, "aiid", zzok.zzxA());
            }
            zzc.put("_s", String.valueOf(zzhz().zza(new zzh(0, zzjb.getClientId(), this.zztw, !TextUtils.isEmpty(zzjb.zzhL()), 0, hashMap))));
            zzhz().zza(new zzab(zzie(), zzc, zzob.zzxk(), true));
        }
    }

    public Uri zzhs() {
        return this.zzKl;
    }
}
