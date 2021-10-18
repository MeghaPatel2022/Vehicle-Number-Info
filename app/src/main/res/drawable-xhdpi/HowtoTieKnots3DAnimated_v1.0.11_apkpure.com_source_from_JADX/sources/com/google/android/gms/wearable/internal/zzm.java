package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<ChannelEventParcelable> {
    static void zza(ChannelEventParcelable channelEventParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, channelEventParcelable.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) channelEventParcelable.zzaZR, i, false);
        zzb.zzc(parcel, 3, channelEventParcelable.type);
        zzb.zzc(parcel, 4, channelEventParcelable.zzaZP);
        zzb.zzc(parcel, 5, channelEventParcelable.zzaZQ);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzht */
    public ChannelEventParcelable createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ChannelImpl channelImpl = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    channelImpl = (ChannelImpl) zza.zza(parcel, zzai, ChannelImpl.CREATOR);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ChannelEventParcelable(i4, channelImpl, i3, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkD */
    public ChannelEventParcelable[] newArray(int i) {
        return new ChannelEventParcelable[i];
    }
}
