package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
    static void zza(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, gameRequestCluster.zzuN(), false);
        zzb.zzc(parcel, 1000, gameRequestCluster.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdS */
    public GameRequestCluster createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzai, GameRequestEntity.CREATOR);
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
            return new GameRequestCluster(i, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfZ */
    public GameRequestCluster[] newArray(int i) {
        return new GameRequestCluster[i];
    }
}
