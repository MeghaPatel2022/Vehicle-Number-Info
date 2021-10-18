package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzf implements Creator<LocationSettingsRequest> {
    static void zza(LocationSettingsRequest locationSettingsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, locationSettingsRequest.zzsr(), false);
        zzb.zzc(parcel, 1000, locationSettingsRequest.getVersionCode());
        zzb.zza(parcel, 2, locationSettingsRequest.zzvJ());
        zzb.zza(parcel, 3, locationSettingsRequest.zzvK());
        zzb.zza(parcel, 4, locationSettingsRequest.zzvL());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzer */
    public LocationSettingsRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzai, LocationRequest.CREATOR);
                    break;
                case 2:
                    z3 = zza.zzc(parcel, zzai);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzai);
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
            return new LocationSettingsRequest(i, (List<LocationRequest>) arrayList, z3, z2, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgJ */
    public LocationSettingsRequest[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
