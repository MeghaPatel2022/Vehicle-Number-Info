package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqp.zze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzcp {
    private static final zzbw<com.google.android.gms.internal.zzag.zza> zzaRy = new zzbw<>(zzdf.zzBg(), true);
    private final DataLayer zzaOT;
    private final zzah zzaRA;
    private final Map<String, zzak> zzaRB;
    private final Map<String, zzak> zzaRC;
    private final Map<String, zzak> zzaRD;
    private final zzl<com.google.android.gms.internal.zzqp.zza, zzbw<com.google.android.gms.internal.zzag.zza>> zzaRE;
    private final zzl<String, zzb> zzaRF;
    private final Set<zze> zzaRG;
    private final Map<String, zzc> zzaRH;
    private volatile String zzaRI;
    private int zzaRJ;
    private final com.google.android.gms.internal.zzqp.zzc zzaRz;

    interface zza {
        void zza(zze zze, Set<com.google.android.gms.internal.zzqp.zza> set, Set<com.google.android.gms.internal.zzqp.zza> set2, zzck zzck);
    }

    private static class zzb {
        private zzbw<com.google.android.gms.internal.zzag.zza> zzaRP;
        private com.google.android.gms.internal.zzag.zza zzaRQ;

        public zzb(zzbw<com.google.android.gms.internal.zzag.zza> zzbw, com.google.android.gms.internal.zzag.zza zza) {
            this.zzaRP = zzbw;
            this.zzaRQ = zza;
        }

        public int getSize() {
            return (this.zzaRQ == null ? 0 : this.zzaRQ.zzDw()) + ((com.google.android.gms.internal.zzag.zza) this.zzaRP.getObject()).zzDw();
        }

        public zzbw<com.google.android.gms.internal.zzag.zza> zzAH() {
            return this.zzaRP;
        }

        public com.google.android.gms.internal.zzag.zza zzAI() {
            return this.zzaRQ;
        }
    }

    private static class zzc {
        private final Set<zze> zzaRG = new HashSet();
        private final Map<zze, List<com.google.android.gms.internal.zzqp.zza>> zzaRR = new HashMap();
        private final Map<zze, List<com.google.android.gms.internal.zzqp.zza>> zzaRS = new HashMap();
        private final Map<zze, List<String>> zzaRT = new HashMap();
        private final Map<zze, List<String>> zzaRU = new HashMap();
        private com.google.android.gms.internal.zzqp.zza zzaRV;

        public Set<zze> zzAJ() {
            return this.zzaRG;
        }

        public Map<zze, List<com.google.android.gms.internal.zzqp.zza>> zzAK() {
            return this.zzaRR;
        }

        public Map<zze, List<String>> zzAL() {
            return this.zzaRT;
        }

        public Map<zze, List<String>> zzAM() {
            return this.zzaRU;
        }

        public Map<zze, List<com.google.android.gms.internal.zzqp.zza>> zzAN() {
            return this.zzaRS;
        }

        public com.google.android.gms.internal.zzqp.zza zzAO() {
            return this.zzaRV;
        }

        public void zza(zze zze) {
            this.zzaRG.add(zze);
        }

        public void zza(zze zze, com.google.android.gms.internal.zzqp.zza zza) {
            List list = (List) this.zzaRR.get(zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaRR.put(zze, list);
            }
            list.add(zza);
        }

        public void zza(zze zze, String str) {
            List list = (List) this.zzaRT.get(zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaRT.put(zze, list);
            }
            list.add(str);
        }

        public void zzb(com.google.android.gms.internal.zzqp.zza zza) {
            this.zzaRV = zza;
        }

        public void zzb(zze zze, com.google.android.gms.internal.zzqp.zza zza) {
            List list = (List) this.zzaRS.get(zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaRS.put(zze, list);
            }
            list.add(zza);
        }

        public void zzb(zze zze, String str) {
            List list = (List) this.zzaRU.get(zze);
            if (list == null) {
                list = new ArrayList();
                this.zzaRU.put(zze, list);
            }
            list.add(str);
        }
    }

    public zzcp(Context context, com.google.android.gms.internal.zzqp.zzc zzc2, DataLayer dataLayer, com.google.android.gms.tagmanager.zzt.zza zza2, com.google.android.gms.tagmanager.zzt.zza zza3, zzah zzah) {
        if (zzc2 == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.zzaRz = zzc2;
        this.zzaRG = new HashSet(zzc2.zzBG());
        this.zzaOT = dataLayer;
        this.zzaRA = zzah;
        this.zzaRE = new zzm().zza(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new com.google.android.gms.tagmanager.zzm.zza<com.google.android.gms.internal.zzqp.zza, zzbw<com.google.android.gms.internal.zzag.zza>>() {
            /* renamed from: zza */
            public int sizeOf(com.google.android.gms.internal.zzqp.zza zza, zzbw<com.google.android.gms.internal.zzag.zza> zzbw) {
                return ((com.google.android.gms.internal.zzag.zza) zzbw.getObject()).zzDw();
            }
        });
        this.zzaRF = new zzm().zza(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new com.google.android.gms.tagmanager.zzm.zza<String, zzb>() {
            /* renamed from: zza */
            public int sizeOf(String str, zzb zzb) {
                return str.length() + zzb.getSize();
            }
        });
        this.zzaRB = new HashMap();
        zzb(new zzj(context));
        zzb(new zzt(zza3));
        zzb(new zzx(dataLayer));
        zzb(new zzdg(context, dataLayer));
        zzb(new zzdb(context, dataLayer));
        this.zzaRC = new HashMap();
        zzc(new zzr());
        zzc(new zzae());
        zzc(new zzaf());
        zzc(new zzam());
        zzc(new zzan());
        zzc(new zzbc());
        zzc(new zzbd());
        zzc(new zzcf());
        zzc(new zzcy());
        this.zzaRD = new HashMap();
        zza((zzak) new zzb(context));
        zza((zzak) new zzc(context));
        zza((zzak) new zze(context));
        zza((zzak) new zzf(context));
        zza((zzak) new zzg(context));
        zza((zzak) new zzh(context));
        zza((zzak) new zzi(context));
        zza((zzak) new zzn());
        zza((zzak) new zzq(this.zzaRz.getVersion()));
        zza((zzak) new zzt(zza2));
        zza((zzak) new zzv(dataLayer));
        zza((zzak) new zzaa(context));
        zza((zzak) new zzab());
        zza((zzak) new zzad());
        zza((zzak) new zzai(this));
        zza((zzak) new zzao());
        zza((zzak) new zzap());
        zza((zzak) new zzaw(context));
        zza((zzak) new zzay());
        zza((zzak) new zzbb());
        zza((zzak) new zzbi());
        zza((zzak) new zzbk(context));
        zza((zzak) new zzbx());
        zza((zzak) new zzbz());
        zza((zzak) new zzcc());
        zza((zzak) new zzce());
        zza((zzak) new zzcg(context));
        zza((zzak) new zzcq());
        zza((zzak) new zzcr());
        zza((zzak) new zzda());
        zza((zzak) new zzdh());
        this.zzaRH = new HashMap();
        for (zze zze : this.zzaRG) {
            if (zzah.zzAb()) {
                zza(zze.zzBO(), zze.zzBP(), "add macro");
                zza(zze.zzBT(), zze.zzBQ(), "remove macro");
                zza(zze.zzBM(), zze.zzBR(), "add tag");
                zza(zze.zzBN(), zze.zzBS(), "remove tag");
            }
            for (int i = 0; i < zze.zzBO().size(); i++) {
                com.google.android.gms.internal.zzqp.zza zza4 = (com.google.android.gms.internal.zzqp.zza) zze.zzBO().get(i);
                String str = "Unknown";
                if (zzah.zzAb() && i < zze.zzBP().size()) {
                    str = (String) zze.zzBP().get(i);
                }
                zzc zzi = zzi(this.zzaRH, zza(zza4));
                zzi.zza(zze);
                zzi.zza(zze, zza4);
                zzi.zza(zze, str);
            }
            for (int i2 = 0; i2 < zze.zzBT().size(); i2++) {
                com.google.android.gms.internal.zzqp.zza zza5 = (com.google.android.gms.internal.zzqp.zza) zze.zzBT().get(i2);
                String str2 = "Unknown";
                if (zzah.zzAb() && i2 < zze.zzBQ().size()) {
                    str2 = (String) zze.zzBQ().get(i2);
                }
                zzc zzi2 = zzi(this.zzaRH, zza(zza5));
                zzi2.zza(zze);
                zzi2.zzb(zze, zza5);
                zzi2.zzb(zze, str2);
            }
        }
        for (Entry entry : this.zzaRz.zzBH().entrySet()) {
            for (com.google.android.gms.internal.zzqp.zza zza6 : (List) entry.getValue()) {
                if (!zzdf.zzk((com.google.android.gms.internal.zzag.zza) zza6.zzBD().get(zzae.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    zzi(this.zzaRH, (String) entry.getKey()).zzb(zza6);
                }
            }
        }
    }

    private String zzAG() {
        if (this.zzaRJ <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.zzaRJ));
        for (int i = 2; i < this.zzaRJ; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    private zzbw<com.google.android.gms.internal.zzag.zza> zza(com.google.android.gms.internal.zzag.zza zza2, Set<String> set, zzdi zzdi) {
        if (!zza2.zzje) {
            return new zzbw<>(zza2, true);
        }
        switch (zza2.type) {
            case 2:
                com.google.android.gms.internal.zzag.zza zzo = zzqp.zzo(zza2);
                zzo.zziV = new com.google.android.gms.internal.zzag.zza[zza2.zziV.length];
                for (int i = 0; i < zza2.zziV.length; i++) {
                    zzbw<com.google.android.gms.internal.zzag.zza> zza3 = zza(zza2.zziV[i], set, zzdi.zzjf(i));
                    if (zza3 == zzaRy) {
                        return zzaRy;
                    }
                    zzo.zziV[i] = (com.google.android.gms.internal.zzag.zza) zza3.getObject();
                }
                return new zzbw<>(zzo, false);
            case 3:
                com.google.android.gms.internal.zzag.zza zzo2 = zzqp.zzo(zza2);
                if (zza2.zziW.length != zza2.zziX.length) {
                    zzbg.m28e("Invalid serving value: " + zza2.toString());
                    return zzaRy;
                }
                zzo2.zziW = new com.google.android.gms.internal.zzag.zza[zza2.zziW.length];
                zzo2.zziX = new com.google.android.gms.internal.zzag.zza[zza2.zziW.length];
                for (int i2 = 0; i2 < zza2.zziW.length; i2++) {
                    zzbw<com.google.android.gms.internal.zzag.zza> zza4 = zza(zza2.zziW[i2], set, zzdi.zzjg(i2));
                    zzbw<com.google.android.gms.internal.zzag.zza> zza5 = zza(zza2.zziX[i2], set, zzdi.zzjh(i2));
                    if (zza4 == zzaRy || zza5 == zzaRy) {
                        return zzaRy;
                    }
                    zzo2.zziW[i2] = (com.google.android.gms.internal.zzag.zza) zza4.getObject();
                    zzo2.zziX[i2] = (com.google.android.gms.internal.zzag.zza) zza5.getObject();
                }
                return new zzbw<>(zzo2, false);
            case 4:
                if (set.contains(zza2.zziY)) {
                    zzbg.m28e("Macro cycle detected.  Current macro reference: " + zza2.zziY + "." + "  Previous macro references: " + set.toString() + ".");
                    return zzaRy;
                }
                set.add(zza2.zziY);
                zzbw<com.google.android.gms.internal.zzag.zza> zza6 = zzdj.zza(zza(zza2.zziY, set, zzdi.zzAp()), zza2.zzjd);
                set.remove(zza2.zziY);
                return zza6;
            case 7:
                com.google.android.gms.internal.zzag.zza zzo3 = zzqp.zzo(zza2);
                zzo3.zzjc = new com.google.android.gms.internal.zzag.zza[zza2.zzjc.length];
                for (int i3 = 0; i3 < zza2.zzjc.length; i3++) {
                    zzbw<com.google.android.gms.internal.zzag.zza> zza7 = zza(zza2.zzjc[i3], set, zzdi.zzji(i3));
                    if (zza7 == zzaRy) {
                        return zzaRy;
                    }
                    zzo3.zzjc[i3] = (com.google.android.gms.internal.zzag.zza) zza7.getObject();
                }
                return new zzbw<>(zzo3, false);
            default:
                zzbg.m28e("Unknown type: " + zza2.type);
                return zzaRy;
        }
    }

    private zzbw<com.google.android.gms.internal.zzag.zza> zza(String str, Set<String> set, zzbj zzbj) {
        com.google.android.gms.internal.zzqp.zza zza2;
        this.zzaRJ++;
        zzb zzb2 = (zzb) this.zzaRF.get(str);
        if (zzb2 == null || this.zzaRA.zzAb()) {
            zzc zzc2 = (zzc) this.zzaRH.get(str);
            if (zzc2 == null) {
                zzbg.m28e(zzAG() + "Invalid macro: " + str);
                this.zzaRJ--;
                return zzaRy;
            }
            zzbw zza3 = zza(str, zzc2.zzAJ(), zzc2.zzAK(), zzc2.zzAL(), zzc2.zzAN(), zzc2.zzAM(), set, zzbj.zzzR());
            if (((Set) zza3.getObject()).isEmpty()) {
                zza2 = zzc2.zzAO();
            } else {
                if (((Set) zza3.getObject()).size() > 1) {
                    zzbg.zzaE(zzAG() + "Multiple macros active for macroName " + str);
                }
                zza2 = (com.google.android.gms.internal.zzqp.zza) ((Set) zza3.getObject()).iterator().next();
            }
            if (zza2 == null) {
                this.zzaRJ--;
                return zzaRy;
            }
            zzbw<com.google.android.gms.internal.zzag.zza> zza4 = zza(this.zzaRD, zza2, set, zzbj.zzAh());
            zzbw zzbw = zza4 == zzaRy ? zzaRy : new zzbw(zza4.getObject(), zza3.zzAq() && zza4.zzAq());
            com.google.android.gms.internal.zzag.zza zzAI = zza2.zzAI();
            if (zzbw.zzAq()) {
                this.zzaRF.zzf(str, new zzb(zzbw, zzAI));
            }
            zza(zzAI, set);
            this.zzaRJ--;
            return zzbw;
        }
        zza(zzb2.zzAI(), set);
        this.zzaRJ--;
        return zzb2.zzAH();
    }

    private zzbw<com.google.android.gms.internal.zzag.zza> zza(Map<String, zzak> map, com.google.android.gms.internal.zzqp.zza zza2, Set<String> set, zzch zzch) {
        boolean z;
        boolean z2 = true;
        com.google.android.gms.internal.zzag.zza zza3 = (com.google.android.gms.internal.zzag.zza) zza2.zzBD().get(zzae.FUNCTION.toString());
        if (zza3 == null) {
            zzbg.m28e("No function id in properties");
            return zzaRy;
        }
        String str = zza3.zziZ;
        zzak zzak = (zzak) map.get(str);
        if (zzak == null) {
            zzbg.m28e(str + " has no backing implementation.");
            return zzaRy;
        }
        zzbw<com.google.android.gms.internal.zzag.zza> zzbw = (zzbw) this.zzaRE.get(zza2);
        if (zzbw != null && !this.zzaRA.zzAb()) {
            return zzbw;
        }
        HashMap hashMap = new HashMap();
        boolean z3 = true;
        for (Entry entry : zza2.zzBD().entrySet()) {
            zzbw<com.google.android.gms.internal.zzag.zza> zza4 = zza((com.google.android.gms.internal.zzag.zza) entry.getValue(), set, zzch.zzeO((String) entry.getKey()).zze((com.google.android.gms.internal.zzag.zza) entry.getValue()));
            if (zza4 == zzaRy) {
                return zzaRy;
            }
            if (zza4.zzAq()) {
                zza2.zza((String) entry.getKey(), (com.google.android.gms.internal.zzag.zza) zza4.getObject());
                z = z3;
            } else {
                z = false;
            }
            hashMap.put(entry.getKey(), zza4.getObject());
            z3 = z;
        }
        if (!zzak.zzf(hashMap.keySet())) {
            zzbg.m28e("Incorrect keys for function " + str + " required " + zzak.zzAd() + " had " + hashMap.keySet());
            return zzaRy;
        }
        if (!z3 || !zzak.zzzx()) {
            z2 = false;
        }
        zzbw<com.google.android.gms.internal.zzag.zza> zzbw2 = new zzbw<>(zzak.zzG(hashMap), z2);
        if (z2) {
            this.zzaRE.zzf(zza2, zzbw2);
        }
        zzch.zzd((com.google.android.gms.internal.zzag.zza) zzbw2.getObject());
        return zzbw2;
    }

    private zzbw<Set<com.google.android.gms.internal.zzqp.zza>> zza(Set<zze> set, Set<String> set2, zza zza2, zzco zzco) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        boolean z = true;
        for (zze zze : set) {
            zzck zzAo = zzco.zzAo();
            zzbw zza3 = zza(zze, set2, zzAo);
            if (((Boolean) zza3.getObject()).booleanValue()) {
                zza2.zza(zze, hashSet, hashSet2, zzAo);
            }
            z = z && zza3.zzAq();
        }
        hashSet.removeAll(hashSet2);
        zzco.zzg(hashSet);
        return new zzbw<>(hashSet, z);
    }

    private static String zza(com.google.android.gms.internal.zzqp.zza zza2) {
        return zzdf.zzg((com.google.android.gms.internal.zzag.zza) zza2.zzBD().get(zzae.INSTANCE_NAME.toString()));
    }

    private void zza(com.google.android.gms.internal.zzag.zza zza2, Set<String> set) {
        if (zza2 != null) {
            zzbw<com.google.android.gms.internal.zzag.zza> zza3 = zza(zza2, set, (zzdi) new zzbu());
            if (zza3 != zzaRy) {
                Object zzl = zzdf.zzl((com.google.android.gms.internal.zzag.zza) zza3.getObject());
                if (zzl instanceof Map) {
                    this.zzaOT.push((Map) zzl);
                } else if (zzl instanceof List) {
                    for (Object next : (List) zzl) {
                        if (next instanceof Map) {
                            this.zzaOT.push((Map) next);
                        } else {
                            zzbg.zzaE("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    zzbg.zzaE("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void zza(List<com.google.android.gms.internal.zzqp.zza> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            zzbg.zzaD("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void zza(Map<String, zzak> map, zzak zzak) {
        if (map.containsKey(zzak.zzAc())) {
            throw new IllegalArgumentException("Duplicate function type name: " + zzak.zzAc());
        }
        map.put(zzak.zzAc(), zzak);
    }

    private static zzc zzi(Map<String, zzc> map, String str) {
        zzc zzc2 = (zzc) map.get(str);
        if (zzc2 != null) {
            return zzc2;
        }
        zzc zzc3 = new zzc();
        map.put(str, zzc3);
        return zzc3;
    }

    /* access modifiers changed from: 0000 */
    public synchronized String zzAF() {
        return this.zzaRI;
    }

    /* access modifiers changed from: 0000 */
    public zzbw<Boolean> zza(com.google.android.gms.internal.zzqp.zza zza2, Set<String> set, zzch zzch) {
        zzbw zza3 = zza(this.zzaRC, zza2, set, zzch);
        Boolean zzk = zzdf.zzk((com.google.android.gms.internal.zzag.zza) zza3.getObject());
        zzch.zzd(zzdf.zzK(zzk));
        return new zzbw<>(zzk, zza3.zzAq());
    }

    /* access modifiers changed from: 0000 */
    public zzbw<Boolean> zza(zze zze, Set<String> set, zzck zzck) {
        boolean z;
        boolean z2 = true;
        for (com.google.android.gms.internal.zzqp.zza zza2 : zze.zzBL()) {
            zzbw zza3 = zza(zza2, set, zzck.zzAi());
            if (((Boolean) zza3.getObject()).booleanValue()) {
                zzck.zzf(zzdf.zzK(Boolean.valueOf(false)));
                return new zzbw<>(Boolean.valueOf(false), zza3.zzAq());
            }
            z2 = z && zza3.zzAq();
        }
        for (com.google.android.gms.internal.zzqp.zza zza4 : zze.zzBK()) {
            zzbw zza5 = zza(zza4, set, zzck.zzAj());
            if (!((Boolean) zza5.getObject()).booleanValue()) {
                zzck.zzf(zzdf.zzK(Boolean.valueOf(false)));
                return new zzbw<>(Boolean.valueOf(false), zza5.zzAq());
            }
            z = z && zza5.zzAq();
        }
        zzck.zzf(zzdf.zzK(Boolean.valueOf(true)));
        return new zzbw<>(Boolean.valueOf(true), z);
    }

    /* access modifiers changed from: 0000 */
    public zzbw<Set<com.google.android.gms.internal.zzqp.zza>> zza(String str, Set<zze> set, Map<zze, List<com.google.android.gms.internal.zzqp.zza>> map, Map<zze, List<String>> map2, Map<zze, List<com.google.android.gms.internal.zzqp.zza>> map3, Map<zze, List<String>> map4, Set<String> set2, zzco zzco) {
        final Map<zze, List<com.google.android.gms.internal.zzqp.zza>> map5 = map;
        final Map<zze, List<String>> map6 = map2;
        final Map<zze, List<com.google.android.gms.internal.zzqp.zza>> map7 = map3;
        final Map<zze, List<String>> map8 = map4;
        return zza(set, set2, (zza) new zza() {
            public void zza(zze zze, Set<com.google.android.gms.internal.zzqp.zza> set, Set<com.google.android.gms.internal.zzqp.zza> set2, zzck zzck) {
                List list = (List) map5.get(zze);
                List list2 = (List) map6.get(zze);
                if (list != null) {
                    set.addAll(list);
                    zzck.zzAk().zzc(list, list2);
                }
                List list3 = (List) map7.get(zze);
                List list4 = (List) map8.get(zze);
                if (list3 != null) {
                    set2.addAll(list3);
                    zzck.zzAl().zzc(list3, list4);
                }
            }
        }, zzco);
    }

    /* access modifiers changed from: 0000 */
    public zzbw<Set<com.google.android.gms.internal.zzqp.zza>> zza(Set<zze> set, zzco zzco) {
        return zza(set, (Set<String>) new HashSet<String>(), (zza) new zza() {
            public void zza(zze zze, Set<com.google.android.gms.internal.zzqp.zza> set, Set<com.google.android.gms.internal.zzqp.zza> set2, zzck zzck) {
                set.addAll(zze.zzBM());
                set2.addAll(zze.zzBN());
                zzck.zzAm().zzc(zze.zzBM(), zze.zzBR());
                zzck.zzAn().zzc(zze.zzBN(), zze.zzBS());
            }
        }, zzco);
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzak zzak) {
        zza(this.zzaRD, zzak);
    }

    /* access modifiers changed from: 0000 */
    public void zzb(zzak zzak) {
        zza(this.zzaRB, zzak);
    }

    /* access modifiers changed from: 0000 */
    public void zzc(zzak zzak) {
        zza(this.zzaRC, zzak);
    }

    public zzbw<com.google.android.gms.internal.zzag.zza> zzeS(String str) {
        this.zzaRJ = 0;
        zzag zzeI = this.zzaRA.zzeI(str);
        zzbw<com.google.android.gms.internal.zzag.zza> zza2 = zza(str, (Set<String>) new HashSet<String>(), zzeI.zzzY());
        zzeI.zzAa();
        return zza2;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzeT(String str) {
        this.zzaRI = str;
    }

    public synchronized void zzew(String str) {
        zzeT(str);
        zzag zzeJ = this.zzaRA.zzeJ(str);
        zzu zzzZ = zzeJ.zzzZ();
        for (com.google.android.gms.internal.zzqp.zza zza2 : (Set) zza(this.zzaRG, zzzZ.zzzR()).getObject()) {
            zza(this.zzaRB, zza2, (Set<String>) new HashSet<String>(), zzzZ.zzzQ());
        }
        zzeJ.zzAa();
        zzeT(null);
    }

    public synchronized void zzs(List<zzi> list) {
        for (zzi zzi : list) {
            if (zzi.name == null || !zzi.name.startsWith("gaExperiment:")) {
                zzbg.m29v("Ignored supplemental: " + zzi);
            } else {
                zzaj.zza(this.zzaOT, zzi);
            }
        }
    }
}
