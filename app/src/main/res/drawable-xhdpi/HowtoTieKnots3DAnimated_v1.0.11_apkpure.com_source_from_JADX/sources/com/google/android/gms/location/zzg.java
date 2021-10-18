package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<LocationSettingsResult> {
    static void zza(LocationSettingsResult locationSettingsResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) locationSettingsResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, locationSettingsResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) locationSettingsResult.getLocationSettingsStates(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzes */
    public LocationSettingsResult createFromParcel(Parcel parcel) {
        LocationSettingsStates locationSettingsStates;
        Status status;
        int i;
        LocationSettingsStates locationSettingsStates2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    locationSettingsStates = locationSettingsStates2;
                    status = status3;
                    break;
                case 2:
                    locationSettingsStates = (LocationSettingsStates) zza.zza(parcel, zzai, LocationSettingsStates.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    LocationSettingsStates locationSettingsStates3 = locationSettingsStates2;
                    status = status2;
                    i = zza.zzg(parcel, zzai);
                    locationSettingsStates = locationSettingsStates3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    locationSettingsStates = locationSettingsStates2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            locationSettingsStates2 = locationSettingsStates;
        }
        if (parcel.dataPosition() == zzaj) {
            return new LocationSettingsResult(i2, status2, locationSettingsStates2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgK */
    public LocationSettingsResult[] newArray(int i) {
        return new LocationSettingsResult[i];
    }
}
