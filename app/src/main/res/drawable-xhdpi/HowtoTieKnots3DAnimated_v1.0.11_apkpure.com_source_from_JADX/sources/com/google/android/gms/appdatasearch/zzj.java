package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<UsageInfo> {
    static void zza(UsageInfo usageInfo, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) usageInfo.zzPP, i, false);
        zzb.zzc(parcel, 1000, usageInfo.mVersionCode);
        zzb.zza(parcel, 2, usageInfo.zzPQ);
        zzb.zzc(parcel, 3, usageInfo.zzPR);
        zzb.zza(parcel, 4, usageInfo.zztM, false);
        zzb.zza(parcel, 5, (Parcelable) usageInfo.zzPS, i, false);
        zzb.zza(parcel, 6, usageInfo.zzPT);
        zzb.zzc(parcel, 7, usageInfo.zzPU);
        zzb.zzc(parcel, 8, usageInfo.zzPV);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzao */
    public UsageInfo[] newArray(int i) {
        return new UsageInfo[i];
    }

    /* renamed from: zzz */
    public UsageInfo createFromParcel(Parcel parcel) {
        DocumentContents documentContents = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        long j = 0;
        int i2 = -1;
        boolean z = false;
        String str = null;
        int i3 = 0;
        DocumentId documentId = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    documentId = (DocumentId) zza.zza(parcel, zzai, (Creator<T>) DocumentId.CREATOR);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    documentContents = (DocumentContents) zza.zza(parcel, zzai, (Creator<T>) DocumentContents.CREATOR);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 1000:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new UsageInfo(i4, documentId, j, i3, str, documentContents, z, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }
}
