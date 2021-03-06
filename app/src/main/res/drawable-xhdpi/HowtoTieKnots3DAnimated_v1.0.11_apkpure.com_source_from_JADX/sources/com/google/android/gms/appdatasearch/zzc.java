package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<DocumentId> {
    static void zza(DocumentId documentId, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, documentId.zzOZ, false);
        zzb.zzc(parcel, 1000, documentId.mVersionCode);
        zzb.zza(parcel, 2, documentId.zzPa, false);
        zzb.zza(parcel, 3, documentId.zzPb, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzae */
    public DocumentId[] newArray(int i) {
        return new DocumentId[i];
    }

    /* renamed from: zzt */
    public DocumentId createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
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
            return new DocumentId(i, str3, str2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }
}
