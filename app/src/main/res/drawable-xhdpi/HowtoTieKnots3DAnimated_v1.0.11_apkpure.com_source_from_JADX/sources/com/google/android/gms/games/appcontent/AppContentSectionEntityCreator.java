package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
    static void zza(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, appContentSectionEntity.getActions(), false);
        zzb.zzc(parcel, 1000, appContentSectionEntity.getVersionCode());
        zzb.zzc(parcel, 3, appContentSectionEntity.zztv(), false);
        zzb.zza(parcel, 4, appContentSectionEntity.zztb(), false);
        zzb.zza(parcel, 5, appContentSectionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentSectionEntity.zztn(), false);
        zzb.zza(parcel, 7, appContentSectionEntity.getTitle(), false);
        zzb.zza(parcel, 8, appContentSectionEntity.getType(), false);
        zzb.zza(parcel, 9, appContentSectionEntity.getId(), false);
        zzb.zza(parcel, 10, appContentSectionEntity.zztw(), false);
        zzb.zzc(parcel, 14, appContentSectionEntity.zztl(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdL */
    public AppContentSectionEntity createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Bundle bundle = null;
        String str6 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    arrayList3 = zza.zzc(parcel, zzai, AppContentActionEntity.CREATOR);
                    break;
                case 3:
                    arrayList2 = zza.zzc(parcel, zzai, AppContentCardEntity.CREATOR);
                    break;
                case 4:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 6:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 9:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 10:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 14:
                    arrayList = zza.zzc(parcel, zzai, AppContentAnnotationEntity.CREATOR);
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
            return new AppContentSectionEntity(i, arrayList3, arrayList2, str6, bundle, str5, str4, str3, str2, str, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfG */
    public AppContentSectionEntity[] newArray(int i) {
        return new AppContentSectionEntity[i];
    }
}
