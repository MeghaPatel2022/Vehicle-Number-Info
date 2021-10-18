package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

public class zzk implements Creator<PlaceImpl> {
    static void zza(PlaceImpl placeImpl, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, placeImpl.getId(), false);
        zzb.zza(parcel, 2, placeImpl.zzwo(), false);
        zzb.zza(parcel, 3, (Parcelable) placeImpl.zzwq(), i, false);
        zzb.zza(parcel, 4, (Parcelable) placeImpl.getLatLng(), i, false);
        zzb.zza(parcel, 5, placeImpl.zzwj());
        zzb.zza(parcel, 6, (Parcelable) placeImpl.getViewport(), i, false);
        zzb.zza(parcel, 7, placeImpl.zzwp(), false);
        zzb.zza(parcel, 8, (Parcelable) placeImpl.getWebsiteUri(), i, false);
        zzb.zza(parcel, 9, placeImpl.zzwm());
        zzb.zza(parcel, 10, placeImpl.getRating());
        zzb.zzc(parcel, 11, placeImpl.getPriceLevel());
        zzb.zza(parcel, 12, placeImpl.zzwn());
        zzb.zza(parcel, 13, placeImpl.zzwi(), false);
        zzb.zza(parcel, 14, placeImpl.getAddress(), false);
        zzb.zza(parcel, 15, placeImpl.getPhoneNumber(), false);
        zzb.zzb(parcel, 17, placeImpl.zzwl(), false);
        zzb.zza(parcel, 16, placeImpl.zzwk(), false);
        zzb.zzc(parcel, 1000, placeImpl.mVersionCode);
        zzb.zza(parcel, 19, placeImpl.getName(), false);
        zzb.zza(parcel, 18, placeImpl.zzaEC);
        zzb.zza(parcel, 20, placeImpl.getPlaceTypes(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeK */
    public PlaceImpl createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        ArrayList arrayList3 = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str6 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i2 = 0;
        long j = 0;
        boolean z2 = false;
        PlaceLocalization placeLocalization = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 3:
                    placeLocalization = (PlaceLocalization) zza.zza(parcel, zzai, (Creator<T>) PlaceLocalization.CREATOR);
                    break;
                case 4:
                    latLng = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    break;
                case 5:
                    f = zza.zzl(parcel, zzai);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzai, (Creator<T>) LatLngBounds.CREATOR);
                    break;
                case 7:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 10:
                    f2 = zza.zzl(parcel, zzai);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 12:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 13:
                    arrayList2 = zza.zzB(parcel, zzai);
                    break;
                case 14:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 15:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 16:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 17:
                    arrayList3 = zza.zzC(parcel, zzai);
                    break;
                case 18:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 19:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 20:
                    arrayList = zza.zzB(parcel, zzai);
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
            return new PlaceImpl(i, str, arrayList, arrayList2, bundle, str2, str3, str4, str5, arrayList3, latLng, f, latLngBounds, str6, uri, z, f2, i2, j, z2, placeLocalization);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhk */
    public PlaceImpl[] newArray(int i) {
        return new PlaceImpl[i];
    }
}
