package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbb implements Creator<OnFetchThumbnailResponse> {
    static void zza(OnFetchThumbnailResponse onFetchThumbnailResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onFetchThumbnailResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onFetchThumbnailResponse.zzajS, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbp */
    public OnFetchThumbnailResponse createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnFetchThumbnailResponse(i, parcelFileDescriptor);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdd */
    public OnFetchThumbnailResponse[] newArray(int i) {
        return new OnFetchThumbnailResponse[i];
    }
}
