package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import java.util.List;

public class zze implements Creator<DataSourcesResult> {
    static void zza(DataSourcesResult dataSourcesResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, dataSourcesResult.getDataSources(), false);
        zzb.zzc(parcel, 1000, dataSourcesResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) dataSourcesResult.getStatus(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdt */
    public DataSourcesResult createFromParcel(Parcel parcel) {
        Status status = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    list = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzai, Status.CREATOR);
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
            return new DataSourcesResult(i, list, status);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfn */
    public DataSourcesResult[] newArray(int i) {
        return new DataSourcesResult[i];
    }
}
