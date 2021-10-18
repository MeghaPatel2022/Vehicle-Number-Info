package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;

public class zzb implements Creator<UserAddress> {
    static void zza(UserAddress userAddress, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, userAddress.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, userAddress.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, userAddress.zzaAC, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, userAddress.zzaAD, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, userAddress.zzaAE, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, userAddress.zzaAF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, userAddress.zzaAG, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, userAddress.zzaAH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, userAddress.zzaAI, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, userAddress.zzFF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, userAddress.zzaAJ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, userAddress.zzaAK, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, userAddress.phoneNumber, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, userAddress.zzaAL);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, userAddress.zzaAM, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, userAddress.zzaAN, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzem */
    public UserAddress createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
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
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    str7 = zza.zzo(parcel, zzai);
                    break;
                case 9:
                    str8 = zza.zzo(parcel, zzai);
                    break;
                case 10:
                    str9 = zza.zzo(parcel, zzai);
                    break;
                case 11:
                    str10 = zza.zzo(parcel, zzai);
                    break;
                case 12:
                    str11 = zza.zzo(parcel, zzai);
                    break;
                case 13:
                    str12 = zza.zzo(parcel, zzai);
                    break;
                case 14:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 15:
                    str13 = zza.zzo(parcel, zzai);
                    break;
                case 16:
                    str14 = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgy */
    public UserAddress[] newArray(int i) {
        return new UserAddress[i];
    }
}
