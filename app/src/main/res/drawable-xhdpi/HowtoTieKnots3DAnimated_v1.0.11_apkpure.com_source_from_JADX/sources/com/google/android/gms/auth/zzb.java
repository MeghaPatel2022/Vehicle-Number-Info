package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;

public class zzb implements Creator<AccountChangeEventsRequest> {
    static void zza(AccountChangeEventsRequest accountChangeEventsRequest, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, accountChangeEventsRequest.mVersion);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, accountChangeEventsRequest.zzQG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, accountChangeEventsRequest.zzQE, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) accountChangeEventsRequest.zzOY, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzB */
    public AccountChangeEventsRequest createFromParcel(Parcel parcel) {
        Account account = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    account = (Account) zza.zza(parcel, zzai, Account.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AccountChangeEventsRequest(i2, i, str, account);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzar */
    public AccountChangeEventsRequest[] newArray(int i) {
        return new AccountChangeEventsRequest[i];
    }
}
