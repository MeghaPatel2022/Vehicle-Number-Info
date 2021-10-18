package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
    static void zza(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, participantEntity.getParticipantId(), false);
        zzb.zzc(parcel, 1000, participantEntity.getVersionCode());
        zzb.zza(parcel, 2, participantEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, (Parcelable) participantEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 4, (Parcelable) participantEntity.getHiResImageUri(), i, false);
        zzb.zzc(parcel, 5, participantEntity.getStatus());
        zzb.zza(parcel, 6, participantEntity.zztD(), false);
        zzb.zza(parcel, 7, participantEntity.isConnectedToRoom());
        zzb.zza(parcel, 8, (Parcelable) participantEntity.getPlayer(), i, false);
        zzb.zzc(parcel, 9, participantEntity.getCapabilities());
        zzb.zza(parcel, 10, (Parcelable) participantEntity.getResult(), i, false);
        zzb.zza(parcel, 11, participantEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 12, participantEntity.getHiResImageUrl(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdU */
    public ParticipantEntity createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) zza.zza(parcel, zzai, PlayerEntity.CREATOR);
                    break;
                case 9:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 10:
                    participantResult = (ParticipantResult) zza.zza(parcel, zzai, ParticipantResult.CREATOR);
                    break;
                case 11:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 12:
                    str5 = zza.zzo(parcel, zzai);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgc */
    public ParticipantEntity[] newArray(int i) {
        return new ParticipantEntity[i];
    }
}
