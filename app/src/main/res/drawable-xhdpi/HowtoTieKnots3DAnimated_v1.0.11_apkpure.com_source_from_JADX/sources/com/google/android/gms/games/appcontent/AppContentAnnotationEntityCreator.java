package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AppContentAnnotationEntityCreator implements Creator<AppContentAnnotationEntity> {
    static void zza(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, appContentAnnotationEntity.getDescription(), false);
        zzb.zzc(parcel, 1000, appContentAnnotationEntity.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) appContentAnnotationEntity.zztg(), i, false);
        zzb.zza(parcel, 3, appContentAnnotationEntity.getTitle(), false);
        zzb.zza(parcel, 5, appContentAnnotationEntity.getId(), false);
        zzb.zza(parcel, 6, appContentAnnotationEntity.zztj(), false);
        zzb.zza(parcel, 7, appContentAnnotationEntity.zzte(), false);
        zzb.zzc(parcel, 8, appContentAnnotationEntity.zztf());
        zzb.zzc(parcel, 9, appContentAnnotationEntity.zzti());
        zzb.zza(parcel, 10, appContentAnnotationEntity.zzth(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdI */
    public AppContentAnnotationEntity createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case 3:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 9:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 10:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AppContentAnnotationEntity(i3, str5, uri, str4, str3, str2, str, i2, i, bundle);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfD */
    public AppContentAnnotationEntity[] newArray(int i) {
        return new AppContentAnnotationEntity[i];
    }
}
