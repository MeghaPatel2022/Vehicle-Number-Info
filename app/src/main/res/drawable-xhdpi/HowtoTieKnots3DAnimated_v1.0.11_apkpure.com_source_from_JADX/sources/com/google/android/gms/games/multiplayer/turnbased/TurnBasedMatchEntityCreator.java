package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    static void zza(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) turnBasedMatchEntity.getGame(), i, false);
        zzb.zza(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        zzb.zza(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        zzb.zza(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        zzb.zza(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        zzb.zza(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        zzb.zzc(parcel, 8, turnBasedMatchEntity.getStatus());
        zzb.zzc(parcel, 10, turnBasedMatchEntity.getVariant());
        zzb.zzc(parcel, 11, turnBasedMatchEntity.getVersion());
        zzb.zza(parcel, 12, turnBasedMatchEntity.getData(), false);
        zzb.zzc(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        zzb.zza(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        zzb.zza(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        zzb.zza(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        zzb.zzc(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        zzb.zzc(parcel, 1000, turnBasedMatchEntity.getVersionCode());
        zzb.zza(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        zzb.zzc(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        zzb.zza(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        zzb.zza(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdY */
    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    gameEntity = (GameEntity) zza.zza(parcel, zzai, GameEntity.CREATOR);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 7:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 10:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 11:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case 12:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case 13:
                    arrayList = zza.zzc(parcel, zzai, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 15:
                    bArr2 = zza.zzr(parcel, zzai);
                    break;
                case 16:
                    i5 = zza.zzg(parcel, zzai);
                    break;
                case 17:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 18:
                    i6 = zza.zzg(parcel, zzai);
                    break;
                case 19:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 20:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case 21:
                    str7 = zza.zzo(parcel, zzai);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgg */
    public TurnBasedMatchEntity[] newArray(int i) {
        return new TurnBasedMatchEntity[i];
    }
}
