package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
    static void zza(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        zzb.zzc(parcel, 1000, playerLevelInfo.getVersionCode());
        zzb.zza(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        zzb.zza(parcel, 3, (Parcelable) playerLevelInfo.getCurrentLevel(), i, false);
        zzb.zza(parcel, 4, (Parcelable) playerLevelInfo.getNextLevel(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdF */
    public PlayerLevelInfo createFromParcel(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    playerLevel2 = (PlayerLevel) zza.zza(parcel, zzai, PlayerLevel.CREATOR);
                    break;
                case 4:
                    playerLevel = (PlayerLevel) zza.zza(parcel, zzai, PlayerLevel.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfA */
    public PlayerLevelInfo[] newArray(int i) {
        return new PlayerLevelInfo[i];
    }
}
