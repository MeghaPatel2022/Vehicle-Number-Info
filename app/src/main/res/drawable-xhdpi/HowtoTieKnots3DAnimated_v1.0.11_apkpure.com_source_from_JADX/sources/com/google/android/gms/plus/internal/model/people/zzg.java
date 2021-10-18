package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.NameEntity;
import java.util.HashSet;
import java.util.Set;

public class zzg implements Creator<NameEntity> {
    static void zza(NameEntity nameEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set<Integer> set = nameEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, nameEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, nameEntity.zzaMr, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, nameEntity.zzaNr, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, nameEntity.zzaMu, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, nameEntity.zzaNs, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, nameEntity.zzaNt, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, nameEntity.zzaNu, true);
        }
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgb */
    public NameEntity createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new NameEntity(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziQ */
    public NameEntity[] newArray(int i) {
        return new NameEntity[i];
    }
}
