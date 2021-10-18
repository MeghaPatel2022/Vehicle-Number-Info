package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<StreetViewPanoramaOrientation> {
    static void zza(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaOrientation.getVersionCode());
        zzb.zza(parcel, 2, streetViewPanoramaOrientation.tilt);
        zzb.zza(parcel, 3, streetViewPanoramaOrientation.bearing);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfi */
    public StreetViewPanoramaOrientation createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    f2 = zza.zzl(parcel, zzai);
                    break;
                case 3:
                    f = zza.zzl(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhI */
    public StreetViewPanoramaOrientation[] newArray(int i) {
        return new StreetViewPanoramaOrientation[i];
    }
}
