package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<LatLng> {
    static void zza(LatLng latLng, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, latLng.getVersionCode());
        zzb.zza(parcel, 2, latLng.latitude);
        zzb.zza(parcel, 3, latLng.longitude);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfa */
    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    d2 = zza.zzm(parcel, zzai);
                    break;
                case 3:
                    d = zza.zzm(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LatLng(i, d2, d);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhA */
    public LatLng[] newArray(int i) {
        return new LatLng[i];
    }
}
