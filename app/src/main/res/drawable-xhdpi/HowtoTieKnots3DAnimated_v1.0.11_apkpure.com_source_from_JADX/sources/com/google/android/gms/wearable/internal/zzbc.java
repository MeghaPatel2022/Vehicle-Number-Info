package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbc implements Creator<OpenChannelResponse> {
    static void zza(OpenChannelResponse openChannelResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, openChannelResponse.versionCode);
        zzb.zzc(parcel, 2, openChannelResponse.statusCode);
        zzb.zza(parcel, 3, (Parcelable) openChannelResponse.zzaZR, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhQ */
    public OpenChannelResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ChannelImpl channelImpl = null;
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
                    channelImpl = (ChannelImpl) zza.zza(parcel, zzai, ChannelImpl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OpenChannelResponse(i2, i, channelImpl);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzlb */
    public OpenChannelResponse[] newArray(int i) {
        return new OpenChannelResponse[i];
    }
}
