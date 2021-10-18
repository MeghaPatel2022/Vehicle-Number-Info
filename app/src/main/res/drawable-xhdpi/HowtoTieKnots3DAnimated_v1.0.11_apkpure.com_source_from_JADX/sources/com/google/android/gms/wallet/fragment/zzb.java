package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;

public class zzb implements Creator<WalletFragmentOptions> {
    static void zza(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, walletFragmentOptions.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, walletFragmentOptions.getEnvironment());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, walletFragmentOptions.getTheme());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) walletFragmentOptions.getFragmentStyle(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, walletFragmentOptions.getMode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzha */
    public WalletFragmentOptions createFromParcel(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int zzaj = zza.zzaj(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    walletFragmentStyle = (WalletFragmentStyle) zza.zza(parcel, zzai, WalletFragmentStyle.CREATOR);
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
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkf */
    public WalletFragmentOptions[] newArray(int i) {
        return new WalletFragmentOptions[i];
    }
}
