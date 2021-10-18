package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AppContentConditionEntityCreator implements Creator<AppContentConditionEntity> {
    static void zza(AppContentConditionEntity appContentConditionEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, appContentConditionEntity.zztq(), false);
        zzb.zzc(parcel, 1000, appContentConditionEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentConditionEntity.zztr(), false);
        zzb.zza(parcel, 3, appContentConditionEntity.zzts(), false);
        zzb.zza(parcel, 4, appContentConditionEntity.zztt(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdK */
    public AppContentConditionEntity createFromParcel(Parcel parcel) {
        Bundle bundle = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    bundle = zza.zzq(parcel, zzai);
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
            return new AppContentConditionEntity(i, str3, str2, str, bundle);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfF */
    public AppContentConditionEntity[] newArray(int i) {
        return new AppContentConditionEntity[i];
    }
}
