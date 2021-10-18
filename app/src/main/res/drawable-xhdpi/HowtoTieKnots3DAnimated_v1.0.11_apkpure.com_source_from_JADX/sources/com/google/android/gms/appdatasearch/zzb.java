package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;

public class zzb implements Creator<DocumentContents> {
    static void zza(DocumentContents documentContents, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (T[]) documentContents.zzOS, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, documentContents.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, documentContents.zzOT, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, documentContents.zzOU);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) documentContents.account, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzad */
    public DocumentContents[] newArray(int i) {
        return new DocumentContents[i];
    }

    /* renamed from: zzs */
    public DocumentContents createFromParcel(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        DocumentSection[] documentSectionArr = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    documentSectionArr = (DocumentSection[]) zza.zzb(parcel, zzai, DocumentSection.CREATOR);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    account = (Account) zza.zza(parcel, zzai, Account.CREATOR);
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
            return new DocumentContents(i, documentSectionArr, str, z, account);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }
}
