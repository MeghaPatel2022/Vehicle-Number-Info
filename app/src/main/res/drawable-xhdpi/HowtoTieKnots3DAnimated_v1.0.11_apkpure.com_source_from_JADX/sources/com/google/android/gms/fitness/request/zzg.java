package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzg implements Creator<DataSourceQueryParams> {
    static void zza(DataSourceQueryParams dataSourceQueryParams, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataSourceQueryParams.zzanm, i, false);
        zzb.zzc(parcel, 1000, dataSourceQueryParams.mVersionCode);
        zzb.zza(parcel, 2, dataSourceQueryParams.zzQD);
        zzb.zza(parcel, 3, dataSourceQueryParams.zzanC);
        zzb.zza(parcel, 4, dataSourceQueryParams.zzapU);
        zzb.zzc(parcel, 5, dataSourceQueryParams.zzapP);
        zzb.zzc(parcel, 6, dataSourceQueryParams.zzapV);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcR */
    public DataSourceQueryParams createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        DataSource dataSource = null;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        int i3 = 0;
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
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DataSourceQueryParams(i3, dataSource, j3, j2, j, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeK */
    public DataSourceQueryParams[] newArray(int i) {
        return new DataSourceQueryParams[i];
    }
}
