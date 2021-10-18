package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverInfoEntity;
import java.util.HashSet;
import java.util.Set;

public class zzd implements Creator<CoverInfoEntity> {
    static void zza(CoverInfoEntity coverInfoEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set<Integer> set = coverInfoEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, coverInfoEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, coverInfoEntity.zzaNp);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzc(parcel, 3, coverInfoEntity.zzaNq);
        }
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfY */
    public CoverInfoEntity createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i3 = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CoverInfoEntity(hashSet, i3, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziN */
    public CoverInfoEntity[] newArray(int i) {
        return new CoverInfoEntity[i];
    }
}
