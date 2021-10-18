package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzar implements Creator<GetFdForAssetResponse> {
    static void zza(GetFdForAssetResponse getFdForAssetResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getFdForAssetResponse.versionCode);
        zzb.zzc(parcel, 2, getFdForAssetResponse.statusCode);
        zzb.zza(parcel, 3, (Parcelable) getFdForAssetResponse.zzbaB, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhM */
    public GetFdForAssetResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetFdForAssetResponse(i2, i, parcelFileDescriptor);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkX */
    public GetFdForAssetResponse[] newArray(int i) {
        return new GetFdForAssetResponse[i];
    }
}
