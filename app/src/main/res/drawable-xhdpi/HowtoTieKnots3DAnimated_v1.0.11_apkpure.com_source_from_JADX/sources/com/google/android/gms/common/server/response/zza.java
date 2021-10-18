package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public class zza implements Creator<Field> {
    static void zza(Field field, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, field.getVersionCode());
        zzb.zzc(parcel, 2, field.zzoZ());
        zzb.zza(parcel, 3, field.zzpf());
        zzb.zzc(parcel, 4, field.zzpa());
        zzb.zza(parcel, 5, field.zzpg());
        zzb.zza(parcel, 6, field.zzph(), false);
        zzb.zzc(parcel, 7, field.zzpi());
        zzb.zza(parcel, 8, field.zzpk(), false);
        zzb.zza(parcel, 9, (Parcelable) field.zzpm(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzap */
    public Field createFromParcel(Parcel parcel) {
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ConverterWrapper.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzbO */
    public Field[] newArray(int i) {
        return new Field[i];
    }
}
