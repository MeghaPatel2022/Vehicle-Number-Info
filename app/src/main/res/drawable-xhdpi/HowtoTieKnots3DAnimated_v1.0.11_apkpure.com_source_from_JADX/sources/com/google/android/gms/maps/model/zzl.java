package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<StreetViewPanoramaLocation> {
    static void zza(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        zzb.zza(parcel, 2, (T[]) streetViewPanoramaLocation.links, i, false);
        zzb.zza(parcel, 3, (Parcelable) streetViewPanoramaLocation.position, i, false);
        zzb.zza(parcel, 4, streetViewPanoramaLocation.panoId, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfh */
    public StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        String zzo;
        LatLng latLng;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr;
        int i;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        LatLng latLng2 = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    String str2 = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = zza.zzg(parcel, zzai);
                    zzo = str2;
                    break;
                case 2:
                    i = i2;
                    LatLng latLng3 = latLng2;
                    streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) zza.zzb(parcel, zzai, StreetViewPanoramaLink.CREATOR);
                    zzo = str;
                    latLng = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    String str3 = str;
                    latLng = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    zzo = str3;
                    break;
                case 4:
                    zzo = zza.zzo(parcel, zzai);
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzo = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
            }
            i2 = i;
            streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
            latLng2 = latLng;
            str = zzo;
        }
        if (parcel.dataPosition() == zzaj) {
            return new StreetViewPanoramaLocation(i2, streetViewPanoramaLinkArr2, latLng2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhH */
    public StreetViewPanoramaLocation[] newArray(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
