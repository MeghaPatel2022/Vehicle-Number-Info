package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.OrganizationsEntity;
import java.util.HashSet;
import java.util.Set;

public class zzh implements Creator<OrganizationsEntity> {
    static void zza(OrganizationsEntity organizationsEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set<Integer> set = organizationsEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, organizationsEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, organizationsEntity.zzaNv, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, organizationsEntity.zzaoB, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, organizationsEntity.zzaMq, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, organizationsEntity.zzaNw, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, organizationsEntity.mName, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, organizationsEntity.zzaNx);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, organizationsEntity.zzaMG, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, organizationsEntity.zzagU, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zzc(parcel, 10, organizationsEntity.zzUS);
        }
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgc */
    public OrganizationsEntity createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        HashSet hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str7 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str6 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str5 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z = zza.zzc(parcel, zzai);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str2 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OrganizationsEntity(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziR */
    public OrganizationsEntity[] newArray(int i) {
        return new OrganizationsEntity[i];
    }
}
