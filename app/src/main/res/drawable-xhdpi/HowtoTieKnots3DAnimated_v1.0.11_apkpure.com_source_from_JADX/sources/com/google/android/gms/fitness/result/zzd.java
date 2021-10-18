package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzd implements Creator<DataSourceStatsResult> {
    static void zza(DataSourceStatsResult dataSourceStatsResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataSourceStatsResult.zzanm, i, false);
        zzb.zzc(parcel, 1000, dataSourceStatsResult.mVersionCode);
        zzb.zza(parcel, 2, dataSourceStatsResult.zzQD);
        zzb.zza(parcel, 3, dataSourceStatsResult.zzaqJ);
        zzb.zza(parcel, 4, dataSourceStatsResult.zzaqK);
        zzb.zza(parcel, 5, dataSourceStatsResult.zzaqL);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzds */
    public DataSourceStatsResult createFromParcel(Parcel parcel) {
        boolean z = false;
        long j = 0;
        int zzaj = zza.zzaj(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
                    break;
                case 2:
                    j3 = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzai);
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
            return new DataSourceStatsResult(i, dataSource, j3, z, j2, j);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfm */
    public DataSourceStatsResult[] newArray(int i) {
        return new DataSourceStatsResult[i];
    }
}
