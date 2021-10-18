package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public class zza implements Creator<WalletFragmentInitParams> {
    static void zza(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, walletFragmentInitParams.mVersionCode);
        zzb.zza(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        zzb.zza(parcel, 3, (Parcelable) walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        zzb.zzc(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        zzb.zza(parcel, 5, (Parcelable) walletFragmentInitParams.getMaskedWallet(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgZ */
    public WalletFragmentInitParams createFromParcel(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 3:
                    maskedWalletRequest = (MaskedWalletRequest) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, MaskedWalletRequest.CREATOR);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 5:
                    maskedWallet = (MaskedWallet) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, MaskedWallet.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzke */
    public WalletFragmentInitParams[] newArray(int i) {
        return new WalletFragmentInitParams[i];
    }
}
