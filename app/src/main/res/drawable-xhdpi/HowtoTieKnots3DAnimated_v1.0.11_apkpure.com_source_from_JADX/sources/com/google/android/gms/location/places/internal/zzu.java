package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity.SubstringEntity;

public class zzu implements Creator<SubstringEntity> {
    static void zza(SubstringEntity substringEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, substringEntity.mOffset);
        zzb.zzc(parcel, 1000, substringEntity.mVersionCode);
        zzb.zzc(parcel, 2, substringEntity.mLength);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeO */
    public SubstringEntity createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzai);
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
            return new SubstringEntity(i3, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzho */
    public SubstringEntity[] newArray(int i) {
        return new SubstringEntity[i];
    }
}
