package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<ChangeSequenceNumber> {
    static void zza(ChangeSequenceNumber changeSequenceNumber, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, changeSequenceNumber.mVersionCode);
        zzb.zza(parcel, 2, changeSequenceNumber.zzagm);
        zzb.zza(parcel, 3, changeSequenceNumber.zzagn);
        zzb.zza(parcel, 4, changeSequenceNumber.zzago);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaw */
    public ChangeSequenceNumber createFromParcel(Parcel parcel) {
        long j = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case 3:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case 4:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ChangeSequenceNumber(i, j3, j2, j);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzca */
    public ChangeSequenceNumber[] newArray(int i) {
        return new ChangeSequenceNumber[i];
    }
}
