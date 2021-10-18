package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.CameraPosition;

public class zza implements Creator<GoogleMapOptions> {
    static void zza(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, googleMapOptions.getVersionCode());
        zzb.zza(parcel, 2, googleMapOptions.zzwE());
        zzb.zza(parcel, 3, googleMapOptions.zzwF());
        zzb.zzc(parcel, 4, googleMapOptions.getMapType());
        zzb.zza(parcel, 5, (Parcelable) googleMapOptions.getCamera(), i, false);
        zzb.zza(parcel, 6, googleMapOptions.zzwG());
        zzb.zza(parcel, 7, googleMapOptions.zzwH());
        zzb.zza(parcel, 8, googleMapOptions.zzwI());
        zzb.zza(parcel, 9, googleMapOptions.zzwJ());
        zzb.zza(parcel, 10, googleMapOptions.zzwK());
        zzb.zza(parcel, 11, googleMapOptions.zzwL());
        zzb.zza(parcel, 12, googleMapOptions.zzwM());
        zzb.zza(parcel, 14, googleMapOptions.zzwN());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeU */
    public GoogleMapOptions createFromParcel(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        byte b = -1;
        byte b2 = -1;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b3 = -1;
        byte b4 = -1;
        byte b5 = -1;
        byte b6 = -1;
        byte b7 = -1;
        byte b8 = -1;
        byte b9 = -1;
        byte b10 = -1;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case 3:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case 7:
                    b4 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case 8:
                    b5 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case 9:
                    b6 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case 10:
                    b7 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case 11:
                    b8 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case 12:
                    b9 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case 14:
                    b10 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GoogleMapOptions(i, b, b2, i2, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhu */
    public GoogleMapOptions[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
