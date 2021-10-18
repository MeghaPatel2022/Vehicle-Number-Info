package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<LoyaltyPoints> {
    static void zza(LoyaltyPoints loyaltyPoints, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, loyaltyPoints.getVersionCode());
        zzb.zza(parcel, 2, loyaltyPoints.label, false);
        zzb.zza(parcel, 3, (Parcelable) loyaltyPoints.zzaYy, i, false);
        zzb.zza(parcel, 4, loyaltyPoints.type, false);
        zzb.zza(parcel, 5, (Parcelable) loyaltyPoints.zzaWR, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhg */
    public LoyaltyPoints createFromParcel(Parcel parcel) {
        TimeInterval timeInterval = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        LoyaltyPointsBalance loyaltyPointsBalance = null;
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
                    loyaltyPointsBalance = (LoyaltyPointsBalance) zza.zza(parcel, zzai, LoyaltyPointsBalance.CREATOR);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    timeInterval = (TimeInterval) zza.zza(parcel, zzai, TimeInterval.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LoyaltyPoints(i, str2, loyaltyPointsBalance, str, timeInterval);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzko */
    public LoyaltyPoints[] newArray(int i) {
        return new LoyaltyPoints[i];
    }
}
