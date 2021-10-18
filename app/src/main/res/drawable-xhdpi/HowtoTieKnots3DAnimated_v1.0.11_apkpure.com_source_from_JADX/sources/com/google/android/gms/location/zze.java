package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zze implements Creator<LocationResult> {
    static void zza(LocationResult locationResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, locationResult.getLocations(), false);
        zzb.zzc(parcel, 1000, locationResult.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeq */
    public LocationResult createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List<Location> list = LocationResult.zzaCb;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    list = zza.zzc(parcel, zzai, Location.CREATOR);
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
            return new LocationResult(i, list);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgI */
    public LocationResult[] newArray(int i) {
        return new LocationResult[i];
    }
}
