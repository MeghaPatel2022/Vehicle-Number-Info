package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<Strategy> {
    static void zza(Strategy strategy, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, strategy.zzaJL);
        zzb.zzc(parcel, 1000, strategy.versionCode);
        zzb.zzc(parcel, 2, strategy.zzaJM);
        zzb.zzc(parcel, 3, strategy.zzaJN);
        zzb.zza(parcel, 4, strategy.zzaJO);
        zzb.zzc(parcel, 5, strategy.zzaJP);
        zzb.zzc(parcel, 6, strategy.zzaJQ);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfz */
    public Strategy createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i5 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 1000:
                    i6 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Strategy(i6, i5, i4, i3, z, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzin */
    public Strategy[] newArray(int i) {
        return new Strategy[i];
    }
}
