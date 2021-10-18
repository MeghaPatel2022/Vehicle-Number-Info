package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zzh;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzqp {

    public static class zza {
        private final com.google.android.gms.internal.zzag.zza zzaRQ;
        private final Map<String, com.google.android.gms.internal.zzag.zza> zzaTS;

        private zza(Map<String, com.google.android.gms.internal.zzag.zza> map, com.google.android.gms.internal.zzag.zza zza) {
            this.zzaTS = map;
            this.zzaRQ = zza;
        }

        public static zzb zzBC() {
            return new zzb();
        }

        public String toString() {
            return "Properties: " + zzBD() + " pushAfterEvaluate: " + this.zzaRQ;
        }

        public com.google.android.gms.internal.zzag.zza zzAI() {
            return this.zzaRQ;
        }

        public Map<String, com.google.android.gms.internal.zzag.zza> zzBD() {
            return Collections.unmodifiableMap(this.zzaTS);
        }

        public void zza(String str, com.google.android.gms.internal.zzag.zza zza) {
            this.zzaTS.put(str, zza);
        }
    }

    public static class zzb {
        private com.google.android.gms.internal.zzag.zza zzaRQ;
        private final Map<String, com.google.android.gms.internal.zzag.zza> zzaTS;

        private zzb() {
            this.zzaTS = new HashMap();
        }

        public zza zzBE() {
            return new zza(this.zzaTS, this.zzaRQ);
        }

        public zzb zzb(String str, com.google.android.gms.internal.zzag.zza zza) {
            this.zzaTS.put(str, zza);
            return this;
        }

        public zzb zzq(com.google.android.gms.internal.zzag.zza zza) {
            this.zzaRQ = zza;
            return this;
        }
    }

    public static class zzc {
        private final String zzWs;
        private final List<zze> zzaTT;
        private final Map<String, List<zza>> zzaTU;
        private final int zzaTV;

        private zzc(List<zze> list, Map<String, List<zza>> map, String str, int i) {
            this.zzaTT = Collections.unmodifiableList(list);
            this.zzaTU = Collections.unmodifiableMap(map);
            this.zzWs = str;
            this.zzaTV = i;
        }

        public static zzd zzBF() {
            return new zzd();
        }

        public String getVersion() {
            return this.zzWs;
        }

        public String toString() {
            return "Rules: " + zzBG() + "  Macros: " + this.zzaTU;
        }

        public List<zze> zzBG() {
            return this.zzaTT;
        }

        public Map<String, List<zza>> zzBH() {
            return this.zzaTU;
        }
    }

    public static class zzd {
        private String zzWs;
        private final List<zze> zzaTT;
        private final Map<String, List<zza>> zzaTU;
        private int zzaTV;

        private zzd() {
            this.zzaTT = new ArrayList();
            this.zzaTU = new HashMap();
            this.zzWs = "";
            this.zzaTV = 0;
        }

        public zzc zzBI() {
            return new zzc(this.zzaTT, this.zzaTU, this.zzWs, this.zzaTV);
        }

        public zzd zzb(zze zze) {
            this.zzaTT.add(zze);
            return this;
        }

        public zzd zzc(zza zza) {
            String zzg = zzdf.zzg((com.google.android.gms.internal.zzag.zza) zza.zzBD().get(zzae.INSTANCE_NAME.toString()));
            List list = (List) this.zzaTU.get(zzg);
            if (list == null) {
                list = new ArrayList();
                this.zzaTU.put(zzg, list);
            }
            list.add(zza);
            return this;
        }

        public zzd zzfk(String str) {
            this.zzWs = str;
            return this;
        }

        public zzd zzjm(int i) {
            this.zzaTV = i;
            return this;
        }
    }

    public static class zze {
        private final List<zza> zzaTW;
        private final List<zza> zzaTX;
        private final List<zza> zzaTY;
        private final List<zza> zzaTZ;
        private final List<zza> zzaUa;
        private final List<zza> zzaUb;
        private final List<String> zzaUc;
        private final List<String> zzaUd;
        private final List<String> zzaUe;
        private final List<String> zzaUf;

        private zze(List<zza> list, List<zza> list2, List<zza> list3, List<zza> list4, List<zza> list5, List<zza> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.zzaTW = Collections.unmodifiableList(list);
            this.zzaTX = Collections.unmodifiableList(list2);
            this.zzaTY = Collections.unmodifiableList(list3);
            this.zzaTZ = Collections.unmodifiableList(list4);
            this.zzaUa = Collections.unmodifiableList(list5);
            this.zzaUb = Collections.unmodifiableList(list6);
            this.zzaUc = Collections.unmodifiableList(list7);
            this.zzaUd = Collections.unmodifiableList(list8);
            this.zzaUe = Collections.unmodifiableList(list9);
            this.zzaUf = Collections.unmodifiableList(list10);
        }

        public static zzf zzBJ() {
            return new zzf();
        }

        public String toString() {
            return "Positive predicates: " + zzBK() + "  Negative predicates: " + zzBL() + "  Add tags: " + zzBM() + "  Remove tags: " + zzBN() + "  Add macros: " + zzBO() + "  Remove macros: " + zzBT();
        }

        public List<zza> zzBK() {
            return this.zzaTW;
        }

        public List<zza> zzBL() {
            return this.zzaTX;
        }

        public List<zza> zzBM() {
            return this.zzaTY;
        }

        public List<zza> zzBN() {
            return this.zzaTZ;
        }

        public List<zza> zzBO() {
            return this.zzaUa;
        }

        public List<String> zzBP() {
            return this.zzaUc;
        }

        public List<String> zzBQ() {
            return this.zzaUd;
        }

        public List<String> zzBR() {
            return this.zzaUe;
        }

        public List<String> zzBS() {
            return this.zzaUf;
        }

        public List<zza> zzBT() {
            return this.zzaUb;
        }
    }

    public static class zzf {
        private final List<zza> zzaTW;
        private final List<zza> zzaTX;
        private final List<zza> zzaTY;
        private final List<zza> zzaTZ;
        private final List<zza> zzaUa;
        private final List<zza> zzaUb;
        private final List<String> zzaUc;
        private final List<String> zzaUd;
        private final List<String> zzaUe;
        private final List<String> zzaUf;

        private zzf() {
            this.zzaTW = new ArrayList();
            this.zzaTX = new ArrayList();
            this.zzaTY = new ArrayList();
            this.zzaTZ = new ArrayList();
            this.zzaUa = new ArrayList();
            this.zzaUb = new ArrayList();
            this.zzaUc = new ArrayList();
            this.zzaUd = new ArrayList();
            this.zzaUe = new ArrayList();
            this.zzaUf = new ArrayList();
        }

        public zze zzBU() {
            return new zze(this.zzaTW, this.zzaTX, this.zzaTY, this.zzaTZ, this.zzaUa, this.zzaUb, this.zzaUc, this.zzaUd, this.zzaUe, this.zzaUf);
        }

        public zzf zzd(zza zza) {
            this.zzaTW.add(zza);
            return this;
        }

        public zzf zze(zza zza) {
            this.zzaTX.add(zza);
            return this;
        }

        public zzf zzf(zza zza) {
            this.zzaTY.add(zza);
            return this;
        }

        public zzf zzfl(String str) {
            this.zzaUe.add(str);
            return this;
        }

        public zzf zzfm(String str) {
            this.zzaUf.add(str);
            return this;
        }

        public zzf zzfn(String str) {
            this.zzaUc.add(str);
            return this;
        }

        public zzf zzfo(String str) {
            this.zzaUd.add(str);
            return this;
        }

        public zzf zzg(zza zza) {
            this.zzaTZ.add(zza);
            return this;
        }

        public zzf zzh(zza zza) {
            this.zzaUa.add(zza);
            return this;
        }

        public zzf zzi(zza zza) {
            this.zzaUb.add(zza);
            return this;
        }
    }

    public static class zzg extends Exception {
        public zzg(String str) {
            super(str);
        }
    }

    private static com.google.android.gms.internal.zzag.zza zza(int i, com.google.android.gms.internal.zzaf.zzf zzf2, com.google.android.gms.internal.zzag.zza[] zzaArr, Set<Integer> set) throws zzg {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            zzfi("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        com.google.android.gms.internal.zzag.zza zza2 = (com.google.android.gms.internal.zzag.zza) zza(zzf2.zzif, i, "values");
        if (zzaArr[i] != null) {
            return zzaArr[i];
        }
        com.google.android.gms.internal.zzag.zza zza3 = null;
        set.add(Integer.valueOf(i));
        switch (zza2.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                zza3 = zza2;
                break;
            case 2:
                zzh zzp = zzp(zza2);
                zza3 = zzo(zza2);
                zza3.zziV = new com.google.android.gms.internal.zzag.zza[zzp.zziG.length];
                int[] iArr = zzp.zziG;
                int length = iArr.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i3 + 1;
                    zza3.zziV[i3] = zza(iArr[i2], zzf2, zzaArr, set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                zza3 = zzo(zza2);
                zzh zzp2 = zzp(zza2);
                if (zzp2.zziH.length != zzp2.zziI.length) {
                    zzfi("Uneven map keys (" + zzp2.zziH.length + ") and map values (" + zzp2.zziI.length + ")");
                }
                zza3.zziW = new com.google.android.gms.internal.zzag.zza[zzp2.zziH.length];
                zza3.zziX = new com.google.android.gms.internal.zzag.zza[zzp2.zziH.length];
                int[] iArr2 = zzp2.zziH;
                int length2 = iArr2.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length2) {
                    int i7 = i6 + 1;
                    zza3.zziW[i6] = zza(iArr2[i5], zzf2, zzaArr, set);
                    i5++;
                    i6 = i7;
                }
                int[] iArr3 = zzp2.zziI;
                int length3 = iArr3.length;
                int i8 = 0;
                while (i2 < length3) {
                    int i9 = i8 + 1;
                    zza3.zziX[i8] = zza(iArr3[i2], zzf2, zzaArr, set);
                    i2++;
                    i8 = i9;
                }
                break;
            case 4:
                zza3 = zzo(zza2);
                zza3.zziY = zzdf.zzg(zza(zzp(zza2).zziL, zzf2, zzaArr, set));
                break;
            case 7:
                zza3 = zzo(zza2);
                zzh zzp3 = zzp(zza2);
                zza3.zzjc = new com.google.android.gms.internal.zzag.zza[zzp3.zziK.length];
                int[] iArr4 = zzp3.zziK;
                int length4 = iArr4.length;
                int i10 = 0;
                while (i2 < length4) {
                    int i11 = i10 + 1;
                    zza3.zzjc[i10] = zza(iArr4[i2], zzf2, zzaArr, set);
                    i2++;
                    i10 = i11;
                }
                break;
        }
        if (zza3 == null) {
            zzfi("Invalid value: " + zza2);
        }
        zzaArr[i] = zza3;
        set.remove(Integer.valueOf(i));
        return zza3;
    }

    private static zza zza(com.google.android.gms.internal.zzaf.zzb zzb2, com.google.android.gms.internal.zzaf.zzf zzf2, com.google.android.gms.internal.zzag.zza[] zzaArr, int i) throws zzg {
        zzb zzBC = zza.zzBC();
        for (int valueOf : zzb2.zzhQ) {
            com.google.android.gms.internal.zzaf.zze zze2 = (com.google.android.gms.internal.zzaf.zze) zza(zzf2.zzig, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) zza(zzf2.zzie, zze2.key, "keys");
            com.google.android.gms.internal.zzag.zza zza2 = (com.google.android.gms.internal.zzag.zza) zza(zzaArr, zze2.value, "values");
            if (zzae.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzBC.zzq(zza2);
            } else {
                zzBC.zzb(str, zza2);
            }
        }
        return zzBC.zzBE();
    }

    private static zze zza(com.google.android.gms.internal.zzaf.zzg zzg2, List<zza> list, List<zza> list2, List<zza> list3, com.google.android.gms.internal.zzaf.zzf zzf2) {
        zzf zzBJ = zze.zzBJ();
        for (int valueOf : zzg2.zziu) {
            zzBJ.zzd((zza) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : zzg2.zziv) {
            zzBJ.zze((zza) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf3 : zzg2.zziw) {
            zzBJ.zzf((zza) list.get(Integer.valueOf(valueOf3).intValue()));
        }
        for (int valueOf4 : zzg2.zziy) {
            zzBJ.zzfl(zzf2.zzif[Integer.valueOf(valueOf4).intValue()].zziU);
        }
        for (int valueOf5 : zzg2.zzix) {
            zzBJ.zzg((zza) list.get(Integer.valueOf(valueOf5).intValue()));
        }
        for (int valueOf6 : zzg2.zziz) {
            zzBJ.zzfm(zzf2.zzif[Integer.valueOf(valueOf6).intValue()].zziU);
        }
        for (int valueOf7 : zzg2.zziA) {
            zzBJ.zzh((zza) list2.get(Integer.valueOf(valueOf7).intValue()));
        }
        for (int valueOf8 : zzg2.zziC) {
            zzBJ.zzfn(zzf2.zzif[Integer.valueOf(valueOf8).intValue()].zziU);
        }
        for (int valueOf9 : zzg2.zziB) {
            zzBJ.zzi((zza) list2.get(Integer.valueOf(valueOf9).intValue()));
        }
        for (int valueOf10 : zzg2.zziD) {
            zzBJ.zzfo(zzf2.zzif[Integer.valueOf(valueOf10).intValue()].zziU);
        }
        return zzBJ.zzBU();
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzg {
        if (i < 0 || i >= tArr.length) {
            zzfi("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static zzc zzb(com.google.android.gms.internal.zzaf.zzf zzf2) throws zzg {
        com.google.android.gms.internal.zzag.zza[] zzaArr = new com.google.android.gms.internal.zzag.zza[zzf2.zzif.length];
        for (int i = 0; i < zzf2.zzif.length; i++) {
            zza(i, zzf2, zzaArr, (Set<Integer>) new HashSet<Integer>(0));
        }
        zzd zzBF = zzc.zzBF();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < zzf2.zzii.length; i2++) {
            arrayList.add(zza(zzf2.zzii[i2], zzf2, zzaArr, i2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < zzf2.zzij.length; i3++) {
            arrayList2.add(zza(zzf2.zzij[i3], zzf2, zzaArr, i3));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < zzf2.zzih.length; i4++) {
            zza zza2 = zza(zzf2.zzih[i4], zzf2, zzaArr, i4);
            zzBF.zzc(zza2);
            arrayList3.add(zza2);
        }
        for (com.google.android.gms.internal.zzaf.zzg zza3 : zzf2.zzik) {
            zzBF.zzb(zza(zza3, arrayList, arrayList3, arrayList2, zzf2));
        }
        zzBF.zzfk(zzf2.version);
        zzBF.zzjm(zzf2.zzis);
        return zzBF.zzBI();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void zzfi(String str) throws zzg {
        zzbg.m28e(str);
        throw new zzg(str);
    }

    public static com.google.android.gms.internal.zzag.zza zzo(com.google.android.gms.internal.zzag.zza zza2) {
        com.google.android.gms.internal.zzag.zza zza3 = new com.google.android.gms.internal.zzag.zza();
        zza3.type = zza2.type;
        zza3.zzjd = (int[]) zza2.zzjd.clone();
        if (zza2.zzje) {
            zza3.zzje = zza2.zzje;
        }
        return zza3;
    }

    private static zzh zzp(com.google.android.gms.internal.zzag.zza zza2) throws zzg {
        if (((zzh) zza2.zza(zzh.zziE)) == null) {
            zzfi("Expected a ServingValue and didn't get one. Value is: " + zza2);
        }
        return (zzh) zza2.zza(zzh.zziE);
    }
}
