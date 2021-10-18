package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<CameraPosition> {
    static void zza(CameraPosition cameraPosition, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, cameraPosition.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) cameraPosition.target, i, false);
        zzb.zza(parcel, 3, cameraPosition.zoom);
        zzb.zza(parcel, 4, cameraPosition.tilt);
        zzb.zza(parcel, 5, cameraPosition.bearing);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeW */
    public CameraPosition createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    break;
                case 3:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case 4:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case 5:
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhw */
    public CameraPosition[] newArray(int i) {
        return new CameraPosition[i];
    }
}
