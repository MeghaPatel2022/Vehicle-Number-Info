package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<ValuesAddedDetails> {
    static void zza(ValuesAddedDetails valuesAddedDetails, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, valuesAddedDetails.mVersionCode);
        zzb.zzc(parcel, 2, valuesAddedDetails.mIndex);
        zzb.zzc(parcel, 3, valuesAddedDetails.zzamf);
        zzb.zzc(parcel, 4, valuesAddedDetails.zzamg);
        zzb.zza(parcel, 5, valuesAddedDetails.zzamE, false);
        zzb.zzc(parcel, 6, valuesAddedDetails.zzamF);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcq */
    public ValuesAddedDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i5 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ValuesAddedDetails(i5, i4, i3, i2, str, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzef */
    public ValuesAddedDetails[] newArray(int i) {
        return new ValuesAddedDetails[i];
    }
}
