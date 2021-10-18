package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<DocumentSection> {
    static void zza(DocumentSection documentSection, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, documentSection.zzPe, false);
        zzb.zzc(parcel, 1000, documentSection.mVersionCode);
        zzb.zza(parcel, 3, (Parcelable) documentSection.zzPf, i, false);
        zzb.zzc(parcel, 4, documentSection.zzPg);
        zzb.zza(parcel, 5, documentSection.zzPh, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaf */
    public DocumentSection[] newArray(int i) {
        return new DocumentSection[i];
    }

    /* renamed from: zzu */
    public DocumentSection createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = -1;
        RegisterSectionInfo registerSectionInfo = null;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    registerSectionInfo = (RegisterSectionInfo) zza.zza(parcel, zzai, (Creator<T>) RegisterSectionInfo.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DocumentSection(i, str, registerSectionInfo, i2, bArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }
}
