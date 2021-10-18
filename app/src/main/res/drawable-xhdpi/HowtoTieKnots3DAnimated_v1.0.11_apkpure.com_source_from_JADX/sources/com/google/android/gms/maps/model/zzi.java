package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzi implements Creator<PolylineOptions> {
    static void zza(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, polylineOptions.getVersionCode());
        zzb.zzc(parcel, 2, polylineOptions.getPoints(), false);
        zzb.zza(parcel, 3, polylineOptions.getWidth());
        zzb.zzc(parcel, 4, polylineOptions.getColor());
        zzb.zza(parcel, 5, polylineOptions.getZIndex());
        zzb.zza(parcel, 6, polylineOptions.isVisible());
        zzb.zza(parcel, 7, polylineOptions.isGeodesic());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfe */
    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzai, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = zza.zzl(parcel, zzai);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    f = zza.zzl(parcel, zzai);
                    break;
                case 6:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PolylineOptions(i2, arrayList, f2, i, f, z2, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhE */
    public PolylineOptions[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
