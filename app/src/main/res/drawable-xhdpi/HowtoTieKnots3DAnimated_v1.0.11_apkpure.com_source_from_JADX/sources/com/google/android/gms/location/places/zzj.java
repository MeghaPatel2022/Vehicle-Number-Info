package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<PlaceReport> {
    static void zza(PlaceReport placeReport, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, placeReport.mVersionCode);
        zzb.zza(parcel, 2, placeReport.getPlaceId(), false);
        zzb.zza(parcel, 3, placeReport.getTag(), false);
        zzb.zza(parcel, 4, placeReport.getSource(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeG */
    public PlaceReport createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PlaceReport(i, str3, str2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhe */
    public PlaceReport[] newArray(int i) {
        return new PlaceReport[i];
    }
}
