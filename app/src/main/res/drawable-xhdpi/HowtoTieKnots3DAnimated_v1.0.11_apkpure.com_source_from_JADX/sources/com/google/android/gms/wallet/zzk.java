package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.UserAddress;

public class zzk implements Creator<MaskedWallet> {
    static void zza(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, maskedWallet.getVersionCode());
        zzb.zza(parcel, 2, maskedWallet.zzaWi, false);
        zzb.zza(parcel, 3, maskedWallet.zzaWj, false);
        zzb.zza(parcel, 4, maskedWallet.zzaWo, false);
        zzb.zza(parcel, 5, maskedWallet.zzaWl, false);
        zzb.zza(parcel, 6, (Parcelable) maskedWallet.zzaWm, i, false);
        zzb.zza(parcel, 7, (Parcelable) maskedWallet.zzaWn, i, false);
        zzb.zza(parcel, 8, (T[]) maskedWallet.zzaXb, i, false);
        zzb.zza(parcel, 9, (T[]) maskedWallet.zzaXc, i, false);
        zzb.zza(parcel, 10, (Parcelable) maskedWallet.zzaWp, i, false);
        zzb.zza(parcel, 11, (Parcelable) maskedWallet.zzaWq, i, false);
        zzb.zza(parcel, 12, (T[]) maskedWallet.zzaWr, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgO */
    public MaskedWallet createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    address = (Address) zza.zza(parcel, zzai, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) zza.zza(parcel, zzai, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) zza.zzb(parcel, zzai, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) zza.zzb(parcel, zzai, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) zza.zza(parcel, zzai, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) zza.zza(parcel, zzai, UserAddress.CREATOR);
                    break;
                case 12:
                    instrumentInfoArr = (InstrumentInfo[]) zza.zzb(parcel, zzai, InstrumentInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjT */
    public MaskedWallet[] newArray(int i) {
        return new MaskedWallet[i];
    }
}
