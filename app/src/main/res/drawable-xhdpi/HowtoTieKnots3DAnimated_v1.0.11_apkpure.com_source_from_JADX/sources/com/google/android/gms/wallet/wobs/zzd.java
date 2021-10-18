package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<LoyaltyPointsBalance> {
    static void zza(LoyaltyPointsBalance loyaltyPointsBalance, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, loyaltyPointsBalance.getVersionCode());
        zzb.zzc(parcel, 2, loyaltyPointsBalance.zzaYz);
        zzb.zza(parcel, 3, loyaltyPointsBalance.zzaYA, false);
        zzb.zza(parcel, 4, loyaltyPointsBalance.zzaYB);
        zzb.zza(parcel, 5, loyaltyPointsBalance.zzaWz, false);
        zzb.zza(parcel, 6, loyaltyPointsBalance.zzaYC);
        zzb.zzc(parcel, 7, loyaltyPointsBalance.zzaYD);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhf */
    public LoyaltyPointsBalance createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    d = zza.zzm(parcel, zzai);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LoyaltyPointsBalance(i3, i, str2, d, str, j, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkn */
    public LoyaltyPointsBalance[] newArray(int i) {
        return new LoyaltyPointsBalance[i];
    }
}
