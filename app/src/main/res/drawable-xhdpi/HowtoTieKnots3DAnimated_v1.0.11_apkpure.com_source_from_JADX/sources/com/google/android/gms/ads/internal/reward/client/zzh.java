package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<RewardedVideoAdRequestParcel> {
    static void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, rewardedVideoAdRequestParcel.versionCode);
        zzb.zza(parcel, 2, (Parcelable) rewardedVideoAdRequestParcel.zzDy, i, false);
        zzb.zza(parcel, 3, rewardedVideoAdRequestParcel.zzpZ, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzI */
    public RewardedVideoAdRequestParcel[] newArray(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }

    /* renamed from: zzo */
    public RewardedVideoAdRequestParcel createFromParcel(Parcel parcel) {
        String zzo;
        AdRequestParcel adRequestParcel;
        int i;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        AdRequestParcel adRequestParcel2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    String str2 = str;
                    adRequestParcel = adRequestParcel2;
                    i = zza.zzg(parcel, zzai);
                    zzo = str2;
                    break;
                case 2:
                    i = i2;
                    AdRequestParcel adRequestParcel3 = (AdRequestParcel) zza.zza(parcel, zzai, (Creator<T>) AdRequestParcel.CREATOR);
                    zzo = str;
                    adRequestParcel = adRequestParcel3;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzai);
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzo = str;
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
            }
            i2 = i;
            adRequestParcel2 = adRequestParcel;
            str = zzo;
        }
        if (parcel.dataPosition() == zzaj) {
            return new RewardedVideoAdRequestParcel(i2, adRequestParcel2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }
}
