package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.ImageEntity;
import java.util.HashSet;
import java.util.Set;

public class zzf implements Creator<ImageEntity> {
    static void zza(ImageEntity imageEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set<Integer> set = imageEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, imageEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, imageEntity.zzF, true);
        }
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzga */
    public ImageEntity createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ImageEntity(hashSet, i, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziP */
    public ImageEntity[] newArray(int i) {
        return new ImageEntity[i];
    }
}
