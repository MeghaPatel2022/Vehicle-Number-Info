package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<CreateWalletObjectsRequest> {
    static void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, createWalletObjectsRequest.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) createWalletObjectsRequest.zzaWf, i, false);
        zzb.zza(parcel, 3, (Parcelable) createWalletObjectsRequest.zzaWg, i, false);
        zzb.zza(parcel, 4, (Parcelable) createWalletObjectsRequest.zzaWh, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgH */
    public CreateWalletObjectsRequest createFromParcel(Parcel parcel) {
        GiftCardWalletObject giftCardWalletObject;
        OfferWalletObject offerWalletObject;
        LoyaltyWalletObject loyaltyWalletObject;
        int i;
        GiftCardWalletObject giftCardWalletObject2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        OfferWalletObject offerWalletObject2 = null;
        LoyaltyWalletObject loyaltyWalletObject2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    GiftCardWalletObject giftCardWalletObject3 = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = zza.zzg(parcel, zzai);
                    giftCardWalletObject = giftCardWalletObject3;
                    break;
                case 2:
                    i = i2;
                    OfferWalletObject offerWalletObject3 = offerWalletObject2;
                    loyaltyWalletObject = (LoyaltyWalletObject) zza.zza(parcel, zzai, LoyaltyWalletObject.CREATOR);
                    giftCardWalletObject = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject3;
                    break;
                case 3:
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    GiftCardWalletObject giftCardWalletObject4 = giftCardWalletObject2;
                    offerWalletObject = (OfferWalletObject) zza.zza(parcel, zzai, OfferWalletObject.CREATOR);
                    giftCardWalletObject = giftCardWalletObject4;
                    break;
                case 4:
                    giftCardWalletObject = (GiftCardWalletObject) zza.zza(parcel, zzai, GiftCardWalletObject.CREATOR);
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    giftCardWalletObject = giftCardWalletObject2;
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    break;
            }
            i2 = i;
            loyaltyWalletObject2 = loyaltyWalletObject;
            offerWalletObject2 = offerWalletObject;
            giftCardWalletObject2 = giftCardWalletObject;
        }
        if (parcel.dataPosition() == zzaj) {
            return new CreateWalletObjectsRequest(i2, loyaltyWalletObject2, offerWalletObject2, giftCardWalletObject2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjM */
    public CreateWalletObjectsRequest[] newArray(int i) {
        return new CreateWalletObjectsRequest[i];
    }
}
