package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<AppIdentifier> {
    static void zza(AppIdentifier appIdentifier, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, appIdentifier.getIdentifier(), false);
        zzb.zzc(parcel, 1000, appIdentifier.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfv */
    public AppIdentifier createFromParcel(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AppIdentifier(i, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzid */
    public AppIdentifier[] newArray(int i) {
        return new AppIdentifier[i];
    }
}
