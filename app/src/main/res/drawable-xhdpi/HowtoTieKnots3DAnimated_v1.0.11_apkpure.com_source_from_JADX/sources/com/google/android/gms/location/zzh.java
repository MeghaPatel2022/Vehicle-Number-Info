package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<LocationSettingsStates> {
    static void zza(LocationSettingsStates locationSettingsStates, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, locationSettingsStates.isGpsUsable());
        zzb.zzc(parcel, 1000, locationSettingsStates.getVersionCode());
        zzb.zza(parcel, 2, locationSettingsStates.isNetworkLocationUsable());
        zzb.zza(parcel, 3, locationSettingsStates.isBleUsable());
        zzb.zza(parcel, 4, locationSettingsStates.isGpsPresent());
        zzb.zza(parcel, 5, locationSettingsStates.isNetworkLocationPresent());
        zzb.zza(parcel, 6, locationSettingsStates.isBlePresent());
        zzb.zza(parcel, 7, locationSettingsStates.zzvM());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzet */
    public LocationSettingsStates createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    z7 = zza.zzc(parcel, zzai);
                    break;
                case 2:
                    z6 = zza.zzc(parcel, zzai);
                    break;
                case 3:
                    z5 = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    z4 = zza.zzc(parcel, zzai);
                    break;
                case 5:
                    z3 = zza.zzc(parcel, zzai);
                    break;
                case 6:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 7:
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
            return new LocationSettingsStates(i, z7, z6, z5, z4, z3, z2, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgL */
    public LocationSettingsStates[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
