package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class zzn implements Creator<OfferWalletObject> {
    static void zza(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, offerWalletObject.getVersionCode());
        zzb.zza(parcel, 2, offerWalletObject.zzhL, false);
        zzb.zza(parcel, 3, offerWalletObject.zzaXu, false);
        zzb.zza(parcel, 4, (Parcelable) offerWalletObject.zzaWv, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgR */
    public OfferWalletObject createFromParcel(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
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
                    commonWalletObject = (CommonWalletObject) zza.zza(parcel, zzai, CommonWalletObject.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OfferWalletObject(i, str2, str, commonWalletObject);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjW */
    public OfferWalletObject[] newArray(int i) {
        return new OfferWalletObject[i];
    }
}
