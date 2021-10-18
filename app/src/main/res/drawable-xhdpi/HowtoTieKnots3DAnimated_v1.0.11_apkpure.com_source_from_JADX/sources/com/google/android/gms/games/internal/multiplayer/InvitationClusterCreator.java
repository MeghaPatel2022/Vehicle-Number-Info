package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator implements Creator<ZInvitationCluster> {
    static void zza(ZInvitationCluster zInvitationCluster, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, zInvitationCluster.zzuA(), false);
        zzb.zzc(parcel, 1000, zInvitationCluster.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdQ */
    public ZInvitationCluster createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzai, InvitationEntity.CREATOR);
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
            return new ZInvitationCluster(i, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfW */
    public ZInvitationCluster[] newArray(int i) {
        return new ZInvitationCluster[i];
    }
}
