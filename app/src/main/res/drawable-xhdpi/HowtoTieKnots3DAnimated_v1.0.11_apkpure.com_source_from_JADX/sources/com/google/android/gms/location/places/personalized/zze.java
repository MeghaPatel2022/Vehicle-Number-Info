package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.ArrayList;
import java.util.List;

public class zze implements Creator<PlaceUserData> {
    static void zza(PlaceUserData placeUserData, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, placeUserData.zzww(), false);
        zzb.zzc(parcel, 1000, placeUserData.mVersionCode);
        zzb.zza(parcel, 2, placeUserData.getPlaceId(), false);
        zzb.zzc(parcel, 5, placeUserData.zzwz(), false);
        zzb.zzc(parcel, 6, placeUserData.zzwx(), false);
        zzb.zzc(parcel, 7, placeUserData.zzwy(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeS */
    public PlaceUserData createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    list2 = zza.zzc(parcel, zzai, TestDataImpl.CREATOR);
                    break;
                case 6:
                    list = zza.zzc(parcel, zzai, PlaceAlias.CREATOR);
                    break;
                case 7:
                    arrayList = zza.zzc(parcel, zzai, HereContent.CREATOR);
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
            return new PlaceUserData(i, str2, str, list2, list, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhs */
    public PlaceUserData[] newArray(int i) {
        return new PlaceUserData[i];
    }
}
