package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Creator<VisibleRegion> {
    static void zza(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, visibleRegion.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        zzb.zza(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        zzb.zza(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        zzb.zza(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        zzb.zza(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfl */
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    latLng4 = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzai, (Creator<T>) LatLngBounds.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhL */
    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
