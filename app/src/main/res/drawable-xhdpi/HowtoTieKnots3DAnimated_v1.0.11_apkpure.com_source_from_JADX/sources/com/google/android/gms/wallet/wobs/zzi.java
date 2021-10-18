package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<WalletObjectMessage> {
    static void zza(WalletObjectMessage walletObjectMessage, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, walletObjectMessage.getVersionCode());
        zzb.zza(parcel, 2, walletObjectMessage.zzaYE, false);
        zzb.zza(parcel, 3, walletObjectMessage.body, false);
        zzb.zza(parcel, 4, (Parcelable) walletObjectMessage.zzaYH, i, false);
        zzb.zza(parcel, 5, (Parcelable) walletObjectMessage.zzaYI, i, false);
        zzb.zza(parcel, 6, (Parcelable) walletObjectMessage.zzaYJ, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhk */
    public WalletObjectMessage createFromParcel(Parcel parcel) {
        UriData uriData = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        UriData uriData2 = null;
        TimeInterval timeInterval = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    timeInterval = (TimeInterval) zza.zza(parcel, zzai, TimeInterval.CREATOR);
                    break;
                case 5:
                    uriData2 = (UriData) zza.zza(parcel, zzai, UriData.CREATOR);
                    break;
                case 6:
                    uriData = (UriData) zza.zza(parcel, zzai, UriData.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new WalletObjectMessage(i, str2, str, timeInterval, uriData2, uriData);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzks */
    public WalletObjectMessage[] newArray(int i) {
        return new WalletObjectMessage[i];
    }
}
