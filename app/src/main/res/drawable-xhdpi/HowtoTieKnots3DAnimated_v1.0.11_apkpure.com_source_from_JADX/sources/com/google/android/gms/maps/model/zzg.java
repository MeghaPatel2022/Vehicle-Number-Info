package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<PointOfInterest> {
    static void zza(PointOfInterest pointOfInterest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, pointOfInterest.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) pointOfInterest.zzaHy, i, false);
        zzb.zza(parcel, 3, pointOfInterest.zzaHz, false);
        zzb.zza(parcel, 4, pointOfInterest.name, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfc */
    public PointOfInterest createFromParcel(Parcel parcel) {
        String zzo;
        String str;
        LatLng latLng;
        int i;
        String str2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        String str3 = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    String str4 = str2;
                    str = str3;
                    latLng = latLng2;
                    i = zza.zzg(parcel, zzai);
                    zzo = str4;
                    break;
                case 2:
                    i = i2;
                    String str5 = str3;
                    latLng = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    zzo = str2;
                    str = str5;
                    break;
                case 3:
                    latLng = latLng2;
                    i = i2;
                    String str6 = str2;
                    str = zza.zzo(parcel, zzai);
                    zzo = str6;
                    break;
                case 4:
                    zzo = zza.zzo(parcel, zzai);
                    str = str3;
                    latLng = latLng2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzo = str2;
                    str = str3;
                    latLng = latLng2;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng2 = latLng;
            str3 = str;
            str2 = zzo;
        }
        if (parcel.dataPosition() == zzaj) {
            return new PointOfInterest(i2, latLng2, str3, str2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhC */
    public PointOfInterest[] newArray(int i) {
        return new PointOfInterest[i];
    }
}
