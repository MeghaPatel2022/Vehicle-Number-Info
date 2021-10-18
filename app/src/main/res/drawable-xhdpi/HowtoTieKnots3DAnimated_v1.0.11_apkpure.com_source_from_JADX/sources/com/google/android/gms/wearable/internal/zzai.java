package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzai implements Creator<GetChannelInputStreamResponse> {
    static void zza(GetChannelInputStreamResponse getChannelInputStreamResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getChannelInputStreamResponse.versionCode);
        zzb.zzc(parcel, 2, getChannelInputStreamResponse.statusCode);
        zzb.zza(parcel, 3, (Parcelable) getChannelInputStreamResponse.zzbat, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhD */
    public GetChannelInputStreamResponse createFromParcel(Parcel parcel) {
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
            return new GetChannelInputStreamResponse(i2, i, parcelFileDescriptor);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkO */
    public GetChannelInputStreamResponse[] newArray(int i) {
        return new GetChannelInputStreamResponse[i];
    }
}
