package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<Request> {
    static void zza(Request request, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) request.zzPl, i, false);
        zzb.zzc(parcel, 1000, request.mVersionCode);
        zzb.zza(parcel, 2, request.zzPm);
        zzb.zza(parcel, 3, request.zzPn);
        zzb.zza(parcel, 4, request.zzPo);
        zzb.zza(parcel, 5, request.zzPp, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzah */
    public Request[] newArray(int i) {
        return new Request[i];
    }

    /* renamed from: zzw */
    public Request createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    account = (Account) zza.zza(parcel, zzai, Account.CREATOR);
                    break;
                case 2:
                    z3 = zza.zzc(parcel, zzai);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Request(i, account, z3, z2, z, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }
}
