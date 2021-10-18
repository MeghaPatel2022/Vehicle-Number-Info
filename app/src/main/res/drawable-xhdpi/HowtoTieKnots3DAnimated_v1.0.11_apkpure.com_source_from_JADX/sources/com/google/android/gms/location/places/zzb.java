package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class zzb implements Creator<AddPlaceRequest> {
    static void zza(AddPlaceRequest addPlaceRequest, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, addPlaceRequest.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, addPlaceRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) addPlaceRequest.getLatLng(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, addPlaceRequest.getAddress(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addPlaceRequest.getPlaceTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addPlaceRequest.getPhoneNumber(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) addPlaceRequest.getWebsiteUri(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzez */
    public AddPlaceRequest createFromParcel(Parcel parcel) {
        Uri uri = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        List list = null;
        String str2 = null;
        LatLng latLng = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    latLng = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    list = zza.zzB(parcel, zzai);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
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
            return new AddPlaceRequest(i, str3, latLng, str2, list, str, uri);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgW */
    public AddPlaceRequest[] newArray(int i) {
        return new AddPlaceRequest[i];
    }
}
