package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<PlaceRequest> {
    static void zza(PlaceRequest placeRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, placeRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) placeRequest.zzwa(), i, false);
        zzb.zza(parcel, 3, placeRequest.getInterval());
        zzb.zzc(parcel, 4, placeRequest.getPriority());
        zzb.zza(parcel, 5, placeRequest.getExpirationTime());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeH */
    public PlaceRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        PlaceFilter placeFilter = null;
        long j = PlaceRequest.zzaDJ;
        int i2 = 102;
        long j2 = Long.MAX_VALUE;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 2:
                    placeFilter = (PlaceFilter) zza.zza(parcel, zzai, (Creator<T>) PlaceFilter.CREATOR);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    j2 = zza.zzi(parcel, zzai);
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
            return new PlaceRequest(i, placeFilter, j, i2, j2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhf */
    public PlaceRequest[] newArray(int i) {
        return new PlaceRequest[i];
    }
}
