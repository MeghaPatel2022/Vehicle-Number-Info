package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzd implements Creator<NearbyAlertFilter> {
    static void zza(NearbyAlertFilter nearbyAlertFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzb(parcel, 1, nearbyAlertFilter.zzaDo, false);
        zzb.zzc(parcel, 1000, nearbyAlertFilter.mVersionCode);
        zzb.zza(parcel, 2, nearbyAlertFilter.zzaDm, false);
        zzb.zzc(parcel, 3, nearbyAlertFilter.zzaDp, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeB */
    public NearbyAlertFilter createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    list2 = zza.zzC(parcel, zzai);
                    break;
                case 2:
                    list = zza.zzB(parcel, zzai);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzai, UserDataType.CREATOR);
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
            return new NearbyAlertFilter(i, list2, list, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgY */
    public NearbyAlertFilter[] newArray(int i) {
        return new NearbyAlertFilter[i];
    }
}
