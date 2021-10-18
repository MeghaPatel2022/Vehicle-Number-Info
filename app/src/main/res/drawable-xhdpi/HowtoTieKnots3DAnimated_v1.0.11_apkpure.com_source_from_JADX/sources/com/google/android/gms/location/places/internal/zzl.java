package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<PlaceLikelihoodEntity> {
    static void zza(PlaceLikelihoodEntity placeLikelihoodEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) placeLikelihoodEntity.zzaEI, i, false);
        zzb.zzc(parcel, 1000, placeLikelihoodEntity.mVersionCode);
        zzb.zza(parcel, 2, placeLikelihoodEntity.zzaEJ);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeL */
    public PlaceLikelihoodEntity createFromParcel(Parcel parcel) {
        float zzl;
        PlaceImpl placeImpl;
        int i;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        PlaceImpl placeImpl2 = null;
        float f = 0.0f;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    PlaceImpl placeImpl3 = (PlaceImpl) zza.zza(parcel, zzai, (Creator<T>) PlaceImpl.CREATOR);
                    zzl = f;
                    placeImpl = placeImpl3;
                    break;
                case 2:
                    zzl = zza.zzl(parcel, zzai);
                    placeImpl = placeImpl2;
                    i = i2;
                    break;
                case 1000:
                    float f2 = f;
                    placeImpl = placeImpl2;
                    i = zza.zzg(parcel, zzai);
                    zzl = f2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzl = f;
                    placeImpl = placeImpl2;
                    i = i2;
                    break;
            }
            i2 = i;
            placeImpl2 = placeImpl;
            f = zzl;
        }
        if (parcel.dataPosition() == zzaj) {
            return new PlaceLikelihoodEntity(i2, placeImpl2, f);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhl */
    public PlaceLikelihoodEntity[] newArray(int i) {
        return new PlaceLikelihoodEntity[i];
    }
}
