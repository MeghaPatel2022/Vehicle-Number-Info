package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.PlacesLivedEntity;
import java.util.HashSet;
import java.util.Set;

public class zzi implements Creator<PlacesLivedEntity> {
    static void zza(PlacesLivedEntity placesLivedEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set<Integer> set = placesLivedEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, placesLivedEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, placesLivedEntity.zzaNx);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, placesLivedEntity.mValue, true);
        }
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgd */
    public PlacesLivedEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = zza.zzc(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PlacesLivedEntity(hashSet, i, z, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziS */
    public PlacesLivedEntity[] newArray(int i) {
        return new PlacesLivedEntity[i];
    }
}
