package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    static void zza(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, mostRecentGameInfoEntity.zzuG(), false);
        zzb.zzc(parcel, 1000, mostRecentGameInfoEntity.getVersionCode());
        zzb.zza(parcel, 2, mostRecentGameInfoEntity.zzuH(), false);
        zzb.zza(parcel, 3, mostRecentGameInfoEntity.zzuI());
        zzb.zza(parcel, 4, (Parcelable) mostRecentGameInfoEntity.zzuJ(), i, false);
        zzb.zza(parcel, 5, (Parcelable) mostRecentGameInfoEntity.zzuK(), i, false);
        zzb.zza(parcel, 6, (Parcelable) mostRecentGameInfoEntity.zzuL(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdR */
    public MostRecentGameInfoEntity createFromParcel(Parcel parcel) {
        Uri uri = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    uri3 = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfY */
    public MostRecentGameInfoEntity[] newArray(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}
