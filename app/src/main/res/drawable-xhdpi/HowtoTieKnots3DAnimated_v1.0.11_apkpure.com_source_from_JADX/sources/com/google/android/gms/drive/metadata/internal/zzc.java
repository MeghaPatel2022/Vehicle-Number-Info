package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc implements Creator<CustomProperty> {
    static void zza(CustomProperty customProperty, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, customProperty.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) customProperty.zzakk, i, false);
        zzb.zza(parcel, 3, customProperty.mValue, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbL */
    public CustomProperty createFromParcel(Parcel parcel) {
        String zzo;
        CustomPropertyKey customPropertyKey;
        int i;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        CustomPropertyKey customPropertyKey2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    String str2 = str;
                    customPropertyKey = customPropertyKey2;
                    i = zza.zzg(parcel, zzai);
                    zzo = str2;
                    break;
                case 2:
                    i = i2;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) zza.zza(parcel, zzai, CustomPropertyKey.CREATOR);
                    zzo = str;
                    customPropertyKey = customPropertyKey3;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzai);
                    customPropertyKey = customPropertyKey2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzo = str;
                    customPropertyKey = customPropertyKey2;
                    i = i2;
                    break;
            }
            i2 = i;
            customPropertyKey2 = customPropertyKey;
            str = zzo;
        }
        if (parcel.dataPosition() == zzaj) {
            return new CustomProperty(i2, customPropertyKey2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdz */
    public CustomProperty[] newArray(int i) {
        return new CustomProperty[i];
    }
}
