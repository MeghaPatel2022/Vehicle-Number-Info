package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class zzg implements Creator<GiftCardWalletObject> {
    static void zza(GiftCardWalletObject giftCardWalletObject, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, giftCardWalletObject.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) giftCardWalletObject.zzaWv, i, false);
        zzb.zza(parcel, 3, giftCardWalletObject.zzaWw, false);
        zzb.zza(parcel, 4, giftCardWalletObject.pin, false);
        zzb.zza(parcel, 5, giftCardWalletObject.zzaWx, false);
        zzb.zza(parcel, 6, giftCardWalletObject.zzaWy);
        zzb.zza(parcel, 7, giftCardWalletObject.zzaWz, false);
        zzb.zza(parcel, 8, giftCardWalletObject.zzaWA);
        zzb.zza(parcel, 9, giftCardWalletObject.zzaWB, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgK */
    public GiftCardWalletObject createFromParcel(Parcel parcel) {
        long j = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        CommonWalletObject commonWalletObject = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    commonWalletObject = (CommonWalletObject) zza.zza(parcel, zzai, CommonWalletObject.CREATOR);
                    break;
                case 3:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 7:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GiftCardWalletObject(i, commonWalletObject, str5, str4, str3, j2, str2, j, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjP */
    public GiftCardWalletObject[] newArray(int i) {
        return new GiftCardWalletObject[i];
    }
}
