package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy implements Creator<ResolveAccountRequest> {
    static void zza(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, resolveAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) resolveAccountRequest.getAccount(), i, false);
        zzb.zzc(parcel, 3, resolveAccountRequest.getSessionId());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaf */
    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        int zzg;
        Account account;
        int i;
        int i2 = 0;
        int zzaj = zza.zzaj(parcel);
        Account account2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    int i4 = i2;
                    account = account2;
                    i = zza.zzg(parcel, zzai);
                    zzg = i4;
                    break;
                case 2:
                    i = i3;
                    Account account3 = (Account) zza.zza(parcel, zzai, Account.CREATOR);
                    zzg = i2;
                    account = account3;
                    break;
                case 3:
                    zzg = zza.zzg(parcel, zzai);
                    account = account2;
                    i = i3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzg = i2;
                    account = account2;
                    i = i3;
                    break;
            }
            i3 = i;
            account2 = account;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzaj) {
            return new ResolveAccountRequest(i3, account2, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzbE */
    public ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
