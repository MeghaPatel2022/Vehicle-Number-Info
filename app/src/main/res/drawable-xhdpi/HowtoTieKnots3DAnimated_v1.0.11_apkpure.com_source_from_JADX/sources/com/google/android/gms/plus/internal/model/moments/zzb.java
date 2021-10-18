package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import java.util.HashSet;
import java.util.Set;

public class zzb implements Creator<MomentEntity> {
    static void zza(MomentEntity momentEntity, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        Set<Integer> set = momentEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, momentEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, momentEntity.zzwj, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) momentEntity.zzaMO, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, momentEntity.zzaMG, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) momentEntity.zzaMP, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, momentEntity.zzFz, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfU */
    public MomentEntity createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ItemScopeEntity itemScopeEntity = null;
        String str2 = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    ItemScopeEntity itemScopeEntity3 = (ItemScopeEntity) zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    itemScopeEntity2 = itemScopeEntity3;
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    ItemScopeEntity itemScopeEntity4 = (ItemScopeEntity) zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    itemScopeEntity = itemScopeEntity4;
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
            return new MomentEntity(hashSet, i, str3, itemScopeEntity2, str2, itemScopeEntity, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziJ */
    public MomentEntity[] newArray(int i) {
        return new MomentEntity[i];
    }
}
