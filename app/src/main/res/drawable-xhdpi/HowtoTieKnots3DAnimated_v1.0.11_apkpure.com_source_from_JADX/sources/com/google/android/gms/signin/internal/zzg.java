package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<RecordConsentRequest> {
    static void zza(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, recordConsentRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) recordConsentRequest.getAccount(), i, false);
        zzb.zza(parcel, 3, (T[]) recordConsentRequest.zzzs(), i, false);
        zzb.zza(parcel, 4, recordConsentRequest.zzlG(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgl */
    public RecordConsentRequest createFromParcel(Parcel parcel) {
        String zzo;
        Scope[] scopeArr;
        Account account;
        int i;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Scope[] scopeArr2 = null;
        Account account2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    String str2 = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = zza.zzg(parcel, zzai);
                    zzo = str2;
                    break;
                case 2:
                    i = i2;
                    Scope[] scopeArr3 = scopeArr2;
                    account = (Account) zza.zza(parcel, zzai, Account.CREATOR);
                    zzo = str;
                    scopeArr = scopeArr3;
                    break;
                case 3:
                    account = account2;
                    i = i2;
                    String str3 = str;
                    scopeArr = (Scope[]) zza.zzb(parcel, zzai, Scope.CREATOR);
                    zzo = str3;
                    break;
                case 4:
                    zzo = zza.zzo(parcel, zzai);
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzo = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
            }
            i2 = i;
            account2 = account;
            scopeArr2 = scopeArr;
            str = zzo;
        }
        if (parcel.dataPosition() == zzaj) {
            return new RecordConsentRequest(i2, account2, scopeArr2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjb */
    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
