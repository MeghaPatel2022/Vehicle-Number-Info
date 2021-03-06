package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.UrlsEntity;
import java.util.HashSet;
import java.util.Set;

public class zzj implements Creator<UrlsEntity> {
    static void zza(UrlsEntity urlsEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set<Integer> set = urlsEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, urlsEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzc(parcel, 3, urlsEntity.zzzg());
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, urlsEntity.mValue, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, urlsEntity.zzaID, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zzc(parcel, 6, urlsEntity.zzUS);
        }
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzge */
    public UrlsEntity createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i3 = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new UrlsEntity(hashSet, i3, str2, i2, str, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziT */
    public UrlsEntity[] newArray(int i) {
        return new UrlsEntity[i];
    }
}
