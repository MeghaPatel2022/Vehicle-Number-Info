package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<ConverterWrapper> {
    static void zza(ConverterWrapper converterWrapper, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, converterWrapper.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) converterWrapper.zzoW(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzam */
    public ConverterWrapper createFromParcel(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    stringToIntConverter = (StringToIntConverter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) StringToIntConverter.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ConverterWrapper(i, stringToIntConverter);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzbL */
    public ConverterWrapper[] newArray(int i) {
        return new ConverterWrapper[i];
    }
}
