package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
    static void zza(RoomEntity roomEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, roomEntity.getRoomId(), false);
        zzb.zzc(parcel, 1000, roomEntity.getVersionCode());
        zzb.zza(parcel, 2, roomEntity.getCreatorId(), false);
        zzb.zza(parcel, 3, roomEntity.getCreationTimestamp());
        zzb.zzc(parcel, 4, roomEntity.getStatus());
        zzb.zza(parcel, 5, roomEntity.getDescription(), false);
        zzb.zzc(parcel, 6, roomEntity.getVariant());
        zzb.zza(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        zzb.zzc(parcel, 8, roomEntity.getParticipants(), false);
        zzb.zzc(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdX */
    public RoomEntity createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 7:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 8:
                    arrayList = zza.zzc(parcel, zzai, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 1000:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgf */
    public RoomEntity[] newArray(int i) {
        return new RoomEntity[i];
    }
}
