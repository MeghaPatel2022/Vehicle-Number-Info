package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<CustomPropertyKey> {
    static void zza(CustomPropertyKey customPropertyKey, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, customPropertyKey.mVersionCode);
        zzb.zza(parcel, 2, customPropertyKey.zztP, false);
        zzb.zzc(parcel, 3, customPropertyKey.mVisibility);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbJ */
    public CustomPropertyKey createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CustomPropertyKey(i2, str, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdx */
    public CustomPropertyKey[] newArray(int i) {
        return new CustomPropertyKey[i];
    }
}
