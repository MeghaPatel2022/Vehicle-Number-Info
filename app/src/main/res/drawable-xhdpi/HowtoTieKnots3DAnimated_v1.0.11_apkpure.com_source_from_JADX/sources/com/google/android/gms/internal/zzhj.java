package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzgk
public class zzhj {
    public final int errorCode;
    public final int orientation;
    public final zzip zzAR;
    public final String zzDB;
    public final String zzDO;
    public final long zzDW;
    public final boolean zzDX;
    public final long zzDY;
    public final List<String> zzDZ;
    public final AdRequestParcel zzDy;
    public final String zzEc;
    public final JSONObject zzGF;
    public final zzea zzGG;
    public final AdSizeParcel zzGH;
    public final long zzGI;
    public final long zzGJ;
    public final com.google.android.gms.ads.internal.formats.zzh.zza zzGK;
    public final long zzyA;
    public final zzdz zzyQ;
    public final zzei zzyR;
    public final String zzyS;
    public final zzec zzyT;
    public final List<String> zzyw;
    public final List<String> zzyx;

    @zzgk
    public static final class zza {
        public final int errorCode;
        public final JSONObject zzGF;
        public final zzea zzGG;
        public final long zzGI;
        public final long zzGJ;
        public final AdRequestInfoParcel zzGL;
        public final AdResponseParcel zzGM;
        public final AdSizeParcel zzqf;

        public zza(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, zzea zzea, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.zzGL = adRequestInfoParcel;
            this.zzGM = adResponseParcel;
            this.zzGG = zzea;
            this.zzqf = adSizeParcel;
            this.errorCode = i;
            this.zzGI = j;
            this.zzGJ = j2;
            this.zzGF = jSONObject;
        }
    }

    public zzhj(AdRequestParcel adRequestParcel, zzip zzip, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, zzdz zzdz, zzei zzei, String str2, zzea zzea, zzec zzec, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, com.google.android.gms.ads.internal.formats.zzh.zza zza2, String str4) {
        this.zzDy = adRequestParcel;
        this.zzAR = zzip;
        this.zzyw = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i;
        this.zzyx = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzDZ = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.orientation = i2;
        this.zzyA = j;
        this.zzDB = str;
        this.zzDX = z;
        this.zzyQ = zzdz;
        this.zzyR = zzei;
        this.zzyS = str2;
        this.zzGG = zzea;
        this.zzyT = zzec;
        this.zzDY = j2;
        this.zzGH = adSizeParcel;
        this.zzDW = j3;
        this.zzGI = j4;
        this.zzGJ = j5;
        this.zzEc = str3;
        this.zzGF = jSONObject;
        this.zzGK = zza2;
        this.zzDO = str4;
    }

    public zzhj(zza zza2, zzip zzip, zzdz zzdz, zzei zzei, String str, zzec zzec, com.google.android.gms.ads.internal.formats.zzh.zza zza3) {
        this(zza2.zzGL.zzDy, zzip, zza2.zzGM.zzyw, zza2.errorCode, zza2.zzGM.zzyx, zza2.zzGM.zzDZ, zza2.zzGM.orientation, zza2.zzGM.zzyA, zza2.zzGL.zzDB, zza2.zzGM.zzDX, zzdz, zzei, str, zza2.zzGG, zzec, zza2.zzGM.zzDY, zza2.zzqf, zza2.zzGM.zzDW, zza2.zzGI, zza2.zzGJ, zza2.zzGM.zzEc, zza2.zzGF, zza3, zza2.zzGL.zzDO);
    }

    public boolean zzbY() {
        if (this.zzAR == null || this.zzAR.zzgS() == null) {
            return false;
        }
        return this.zzAR.zzgS().zzbY();
    }
}
