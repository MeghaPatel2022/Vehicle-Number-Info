package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzg implements Creator<PlaceFilter> {
    static void zza(PlaceFilter placeFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, placeFilter.zzaDm, false);
        zzb.zzc(parcel, 1000, placeFilter.mVersionCode);
        zzb.zza(parcel, 3, placeFilter.zzaDz);
        zzb.zzc(parcel, 4, placeFilter.zzaDp, false);
        zzb.zzb(parcel, 6, placeFilter.zzaDo, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeD */
    public PlaceFilter createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        List list = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    list2 = zza.zzB(parcel, zzai);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzai, UserDataType.CREATOR);
                    break;
                case 6:
                    list = zza.zzC(parcel, zzai);
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
            return new PlaceFilter(i, list2, z, list, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzha */
    public PlaceFilter[] newArray(int i) {
        return new PlaceFilter[i];
    }
}
