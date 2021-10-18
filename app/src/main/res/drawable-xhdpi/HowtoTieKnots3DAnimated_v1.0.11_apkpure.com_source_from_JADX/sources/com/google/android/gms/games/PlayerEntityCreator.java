package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void zza(PlayerEntity playerEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, playerEntity.getPlayerId(), false);
        zzb.zza(parcel, 2, playerEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, (Parcelable) playerEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 4, (Parcelable) playerEntity.getHiResImageUri(), i, false);
        zzb.zza(parcel, 5, playerEntity.getRetrievedTimestamp());
        zzb.zzc(parcel, 6, playerEntity.zzsS());
        zzb.zza(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        zzb.zza(parcel, 8, playerEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 9, playerEntity.getHiResImageUrl(), false);
        zzb.zza(parcel, 14, playerEntity.getTitle(), false);
        zzb.zza(parcel, 15, (Parcelable) playerEntity.zzsT(), i, false);
        zzb.zza(parcel, 16, (Parcelable) playerEntity.getLevelInfo(), i, false);
        zzb.zzc(parcel, 1000, playerEntity.getVersionCode());
        zzb.zza(parcel, 19, playerEntity.zzsR());
        zzb.zza(parcel, 18, playerEntity.isProfileVisible());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdD */
    public PlayerEntity createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 7:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 8:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 9:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 14:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) zza.zza(parcel, zzai, (Creator<T>) MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) zza.zza(parcel, zzai, PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 19:
                    z2 = zza.zzc(parcel, zzai);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z, z2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfy */
    public PlayerEntity[] newArray(int i) {
        return new PlayerEntity[i];
    }
}
