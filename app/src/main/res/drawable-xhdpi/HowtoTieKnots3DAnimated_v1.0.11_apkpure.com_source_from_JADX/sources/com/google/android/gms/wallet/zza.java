package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<Address> {
    static void zza(Address address, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, address.getVersionCode());
        zzb.zza(parcel, 2, address.name, false);
        zzb.zza(parcel, 3, address.zzaAC, false);
        zzb.zza(parcel, 4, address.zzaAD, false);
        zzb.zza(parcel, 5, address.zzaAE, false);
        zzb.zza(parcel, 6, address.zzFF, false);
        zzb.zza(parcel, 7, address.zzaVZ, false);
        zzb.zza(parcel, 8, address.zzaWa, false);
        zzb.zza(parcel, 9, address.zzaAJ, false);
        zzb.zza(parcel, 10, address.phoneNumber, false);
        zzb.zza(parcel, 11, address.zzaAL);
        zzb.zza(parcel, 12, address.zzaAM, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgE */
    public Address createFromParcel(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
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
        boolean z = false;
        String str10 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 10:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 11:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                case 12:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjJ */
    public Address[] newArray(int i) {
        return new Address[i];
    }
}
