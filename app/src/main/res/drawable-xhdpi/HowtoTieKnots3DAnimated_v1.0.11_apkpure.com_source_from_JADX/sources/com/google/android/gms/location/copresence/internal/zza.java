package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<CopresenceApiOptions> {
    static void zza(CopresenceApiOptions copresenceApiOptions, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, copresenceApiOptions.mVersionCode);
        zzb.zza(parcel, 2, copresenceApiOptions.zzaCq);
        zzb.zza(parcel, 3, copresenceApiOptions.zzaCr, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeu */
    public CopresenceApiOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CopresenceApiOptions(i, z, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgO */
    public CopresenceApiOptions[] newArray(int i) {
        return new CopresenceApiOptions[i];
    }
}
