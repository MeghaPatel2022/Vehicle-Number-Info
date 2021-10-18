package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<LatLngBounds> {
    static void zza(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, latLngBounds.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) latLngBounds.southwest, i, false);
        zzb.zza(parcel, 3, (Parcelable) latLngBounds.northeast, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeZ */
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        int i;
        LatLng latLng3 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    LatLng latLng5 = latLng3;
                    latLng2 = latLng4;
                    i = zza.zzg(parcel, zzai);
                    latLng = latLng5;
                    break;
                case 2:
                    i = i2;
                    LatLng latLng6 = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    latLng = latLng3;
                    latLng2 = latLng6;
                    break;
                case 3:
                    latLng = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    latLng2 = latLng4;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    latLng = latLng3;
                    latLng2 = latLng4;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng4 = latLng2;
            latLng3 = latLng;
        }
        if (parcel.dataPosition() == zzaj) {
            return new LatLngBounds(i2, latLng4, latLng3);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhz */
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
