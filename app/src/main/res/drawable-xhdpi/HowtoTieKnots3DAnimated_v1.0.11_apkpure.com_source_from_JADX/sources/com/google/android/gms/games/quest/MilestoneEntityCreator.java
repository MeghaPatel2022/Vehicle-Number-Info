package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
    static void zza(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, milestoneEntity.getMilestoneId(), false);
        zzb.zzc(parcel, 1000, milestoneEntity.getVersionCode());
        zzb.zza(parcel, 2, milestoneEntity.getCurrentProgress());
        zzb.zza(parcel, 3, milestoneEntity.getTargetProgress());
        zzb.zza(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        zzb.zzc(parcel, 5, milestoneEntity.getState());
        zzb.zza(parcel, 6, milestoneEntity.getEventId(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdZ */
    public MilestoneEntity createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzai);
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
            return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgh */
    public MilestoneEntity[] newArray(int i) {
        return new MilestoneEntity[i];
    }
}
