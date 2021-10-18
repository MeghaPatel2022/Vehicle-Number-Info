package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<ValuesSetDetails> {
    static void zza(ValuesSetDetails valuesSetDetails, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, valuesSetDetails.mVersionCode);
        zzb.zzc(parcel, 2, valuesSetDetails.mIndex);
        zzb.zzc(parcel, 3, valuesSetDetails.zzamf);
        zzb.zzc(parcel, 4, valuesSetDetails.zzamg);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcs */
    public ValuesSetDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ValuesSetDetails(i4, i3, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeh */
    public ValuesSetDetails[] newArray(int i) {
        return new ValuesSetDetails[i];
    }
}
