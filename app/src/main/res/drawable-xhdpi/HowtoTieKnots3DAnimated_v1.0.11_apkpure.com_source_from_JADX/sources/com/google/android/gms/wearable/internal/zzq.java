package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<ChannelReceiveFileResponse> {
    static void zza(ChannelReceiveFileResponse channelReceiveFileResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, channelReceiveFileResponse.versionCode);
        zzb.zzc(parcel, 2, channelReceiveFileResponse.statusCode);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhv */
    public ChannelReceiveFileResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
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
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ChannelReceiveFileResponse(i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkG */
    public ChannelReceiveFileResponse[] newArray(int i) {
        return new ChannelReceiveFileResponse[i];
    }
}
