package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class AppContentActionEntityCreator implements Creator<AppContentActionEntity> {
    static void zza(AppContentActionEntity appContentActionEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, appContentActionEntity.zzta(), false);
        zzb.zzc(parcel, 1000, appContentActionEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentActionEntity.zztb(), false);
        zzb.zza(parcel, 3, appContentActionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentActionEntity.getType(), false);
        zzb.zza(parcel, 7, appContentActionEntity.getId(), false);
        zzb.zza(parcel, 8, (Parcelable) appContentActionEntity.zzsZ(), i, false);
        zzb.zza(parcel, 9, appContentActionEntity.zztc(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdH */
    public AppContentActionEntity createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        AppContentAnnotationEntity appContentAnnotationEntity = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzai, AppContentConditionEntity.CREATOR);
                    break;
                case 2:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    appContentAnnotationEntity = (AppContentAnnotationEntity) zza.zza(parcel, zzai, (Creator<T>) AppContentAnnotationEntity.CREATOR);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzai);
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
            return new AppContentActionEntity(i, arrayList, str4, bundle, str3, str2, appContentAnnotationEntity, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfC */
    public AppContentActionEntity[] newArray(int i) {
        return new AppContentActionEntity[i];
    }
}
