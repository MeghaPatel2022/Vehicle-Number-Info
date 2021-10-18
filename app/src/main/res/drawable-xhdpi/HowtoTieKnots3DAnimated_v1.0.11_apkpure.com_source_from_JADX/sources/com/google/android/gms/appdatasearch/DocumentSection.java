package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class DocumentSection implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public static final int zzPc = Integer.parseInt("-1");
    private static final RegisterSectionInfo zzPd = new zza("SsbContext").zzM(true).zzby("blob").zzld();
    final int mVersionCode;
    public final String zzPe;
    final RegisterSectionInfo zzPf;
    public final int zzPg;
    public final byte[] zzPh;

    DocumentSection(int versionCode, String content, RegisterSectionInfo sectionInfo, int globalSearchSectionType, byte[] blobContent) {
        zzx.zzb(globalSearchSectionType == zzPc || zzh.zzaj(globalSearchSectionType) != null, (Object) "Invalid section type " + globalSearchSectionType);
        this.mVersionCode = versionCode;
        this.zzPe = content;
        this.zzPf = sectionInfo;
        this.zzPg = globalSearchSectionType;
        this.zzPh = blobContent;
        String zzla = zzla();
        if (zzla != null) {
            throw new IllegalArgumentException(zzla);
        }
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo) {
        this(1, content, sectionInfo, zzPc, null);
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo, String globalSearchSectionType) {
        this(1, content, sectionInfo, zzh.zzbx(globalSearchSectionType), null);
    }

    public DocumentSection(byte[] blobContent, RegisterSectionInfo sectionInfo) {
        this(1, null, sectionInfo, zzPc, blobContent);
    }

    public static DocumentSection zzh(byte[] bArr) {
        return new DocumentSection(bArr, zzPd);
    }

    public int describeContents() {
        zzd zzd = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd zzd = CREATOR;
        zzd.zza(this, dest, flags);
    }

    public RegisterSectionInfo zzkZ() {
        return this.zzPf;
    }

    public String zzla() {
        if (this.zzPg != zzPc && zzh.zzaj(this.zzPg) == null) {
            return "Invalid section type " + this.zzPg;
        }
        if (this.zzPe == null || this.zzPh == null) {
            return null;
        }
        return "Both content and blobContent set";
    }
}
