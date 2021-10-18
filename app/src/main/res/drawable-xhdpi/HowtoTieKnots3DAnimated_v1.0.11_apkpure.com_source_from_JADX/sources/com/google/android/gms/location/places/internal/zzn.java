package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzn implements Creator<PlaceLocalization> {
    static void zza(PlaceLocalization placeLocalization, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, placeLocalization.name, false);
        zzb.zzc(parcel, 1000, placeLocalization.versionCode);
        zzb.zza(parcel, 2, placeLocalization.address, false);
        zzb.zza(parcel, 3, placeLocalization.zzaEK, false);
        zzb.zza(parcel, 4, placeLocalization.zzaEL, false);
        zzb.zzb(parcel, 5, placeLocalization.zzaEM, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeM */
    public PlaceLocalization createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    arrayList = zza.zzC(parcel, zzai);
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
            return new PlaceLocalization(i, str4, str3, str2, str, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhm */
    public PlaceLocalization[] newArray(int i) {
        return new PlaceLocalization[i];
    }
}
