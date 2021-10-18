package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class zzb implements Creator<StreetViewPanoramaOptions> {
    static void zza(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) streetViewPanoramaOptions.getPosition(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, streetViewPanoramaOptions.zzwT());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, streetViewPanoramaOptions.zzwJ());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, streetViewPanoramaOptions.zzwU());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, streetViewPanoramaOptions.zzwV());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, streetViewPanoramaOptions.zzwF());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeV */
    public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        Integer num = null;
        byte b = 0;
        int zzaj = zza.zzaj(parcel);
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) zza.zza(parcel, zzai, (Creator<T>) StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    latLng = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    break;
                case 5:
                    num = zza.zzh(parcel, zzai);
                    break;
                case 6:
                    b5 = zza.zze(parcel, zzai);
                    break;
                case 7:
                    b4 = zza.zze(parcel, zzai);
                    break;
                case 8:
                    b3 = zza.zze(parcel, zzai);
                    break;
                case 9:
                    b2 = zza.zze(parcel, zzai);
                    break;
                case 10:
                    b = zza.zze(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhv */
    public StreetViewPanoramaOptions[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
