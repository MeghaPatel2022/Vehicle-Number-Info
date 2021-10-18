package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.UserAddress;

public class zze implements Creator<FullWallet> {
    static void zza(FullWallet fullWallet, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, fullWallet.getVersionCode());
        zzb.zza(parcel, 2, fullWallet.zzaWi, false);
        zzb.zza(parcel, 3, fullWallet.zzaWj, false);
        zzb.zza(parcel, 4, (Parcelable) fullWallet.zzaWk, i, false);
        zzb.zza(parcel, 5, fullWallet.zzaWl, false);
        zzb.zza(parcel, 6, (Parcelable) fullWallet.zzaWm, i, false);
        zzb.zza(parcel, 7, (Parcelable) fullWallet.zzaWn, i, false);
        zzb.zza(parcel, 8, fullWallet.zzaWo, false);
        zzb.zza(parcel, 9, (Parcelable) fullWallet.zzaWp, i, false);
        zzb.zza(parcel, 10, (Parcelable) fullWallet.zzaWq, i, false);
        zzb.zza(parcel, 11, (T[]) fullWallet.zzaWr, i, false);
        zzb.zza(parcel, 12, (Parcelable) fullWallet.zzaWs, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgI */
    public FullWallet createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ProxyCard proxyCard = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        String[] strArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
        PaymentMethodToken paymentMethodToken = null;
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
                    proxyCard = (ProxyCard) zza.zza(parcel, zzai, ProxyCard.CREATOR);
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
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case 9:
                    userAddress = (UserAddress) zza.zza(parcel, zzai, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress2 = (UserAddress) zza.zza(parcel, zzai, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) zza.zzb(parcel, zzai, InstrumentInfo.CREATOR);
                    break;
                case 12:
                    paymentMethodToken = (PaymentMethodToken) zza.zza(parcel, zzai, PaymentMethodToken.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FullWallet(i, str, str2, proxyCard, str3, address, address2, strArr, userAddress, userAddress2, instrumentInfoArr, paymentMethodToken);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjN */
    public FullWallet[] newArray(int i) {
        return new FullWallet[i];
    }
}
