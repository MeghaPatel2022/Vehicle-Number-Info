package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
    static void zza(PlayerLevel playerLevel, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, playerLevel.getLevelNumber());
        zzb.zzc(parcel, 1000, playerLevel.getVersionCode());
        zzb.zza(parcel, 2, playerLevel.getMinXp());
        zzb.zza(parcel, 3, playerLevel.getMaxXp());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdE */
    public PlayerLevel createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PlayerLevel(i2, i, j2, j);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfz */
    public PlayerLevel[] newArray(int i) {
        return new PlayerLevel[i];
    }
}
