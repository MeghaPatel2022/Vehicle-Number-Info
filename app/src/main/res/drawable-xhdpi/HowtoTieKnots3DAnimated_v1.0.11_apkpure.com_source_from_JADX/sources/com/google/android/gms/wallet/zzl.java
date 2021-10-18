package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.List;

public class zzl implements Creator<MaskedWalletRequest> {
    static void zza(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, maskedWalletRequest.getVersionCode());
        zzb.zza(parcel, 2, maskedWalletRequest.zzaWj, false);
        zzb.zza(parcel, 3, maskedWalletRequest.zzaXe);
        zzb.zza(parcel, 4, maskedWalletRequest.zzaXf);
        zzb.zza(parcel, 5, maskedWalletRequest.zzaXg);
        zzb.zza(parcel, 6, maskedWalletRequest.zzaXh, false);
        zzb.zza(parcel, 7, maskedWalletRequest.zzaWc, false);
        zzb.zza(parcel, 8, maskedWalletRequest.zzaXi, false);
        zzb.zza(parcel, 9, (Parcelable) maskedWalletRequest.zzaWt, i, false);
        zzb.zza(parcel, 10, maskedWalletRequest.zzaXj);
        zzb.zza(parcel, 11, maskedWalletRequest.zzaXk);
        zzb.zza(parcel, 12, (T[]) maskedWalletRequest.zzaXl, i, false);
        zzb.zza(parcel, 13, maskedWalletRequest.zzaXm);
        zzb.zza(parcel, 14, maskedWalletRequest.zzaXn);
        zzb.zzc(parcel, 15, maskedWalletRequest.zzaXo, false);
        zzb.zza(parcel, 17, (List<Integer>) maskedWalletRequest.zzaXq, false);
        zzb.zza(parcel, 16, (Parcelable) maskedWalletRequest.zzaXp, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgP */
    public MaskedWalletRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = null;
        ArrayList arrayList2 = null;
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
                    z = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 5:
                    z3 = zza.zzc(parcel, zzai);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 9:
                    cart = (Cart) zza.zza(parcel, zzai, Cart.CREATOR);
                    break;
                case 10:
                    z4 = zza.zzc(parcel, zzai);
                    break;
                case 11:
                    z5 = zza.zzc(parcel, zzai);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) zza.zzb(parcel, zzai, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = zza.zzc(parcel, zzai);
                    break;
                case 14:
                    z7 = zza.zzc(parcel, zzai);
                    break;
                case 15:
                    arrayList = zza.zzc(parcel, zzai, CountrySpecification.CREATOR);
                    break;
                case 16:
                    paymentMethodTokenizationParameters = (PaymentMethodTokenizationParameters) zza.zza(parcel, zzai, PaymentMethodTokenizationParameters.CREATOR);
                    break;
                case 17:
                    arrayList2 = zza.zzB(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList, paymentMethodTokenizationParameters, arrayList2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjU */
    public MaskedWalletRequest[] newArray(int i) {
        return new MaskedWalletRequest[i];
    }
}
