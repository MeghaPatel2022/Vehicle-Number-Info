package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<ApplicationStatus> {
    static void zza(ApplicationStatus applicationStatus, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, applicationStatus.getVersionCode());
        zzb.zza(parcel, 2, applicationStatus.zzms(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzU */
    public ApplicationStatus createFromParcel(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ApplicationStatus(i, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzaS */
    public ApplicationStatus[] newArray(int i) {
        return new ApplicationStatus[i];
    }
}
