package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<DataPoint> {
    static void zza(DataPoint dataPoint, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataPoint.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, dataPoint.getVersionCode());
        zzb.zza(parcel, 3, dataPoint.getTimestampNanos());
        zzb.zza(parcel, 4, dataPoint.zzrC());
        zzb.zza(parcel, 5, (T[]) dataPoint.zzry(), i, false);
        zzb.zza(parcel, 6, (Parcelable) dataPoint.getOriginalDataSource(), i, false);
        zzb.zza(parcel, 7, dataPoint.zzrz());
        zzb.zza(parcel, 8, dataPoint.zzrA());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcw */
    public DataPoint createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DataSource dataSource = null;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 5:
                    valueArr = (Value[]) zza.zzb(parcel, zzai, Value.CREATOR);
                    break;
                case 6:
                    dataSource2 = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
                    break;
                case 7:
                    j3 = zza.zzi(parcel, zzai);
                    break;
                case 8:
                    j4 = zza.zzi(parcel, zzai);
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
            return new DataPoint(i, dataSource, j, j2, valueArr, dataSource2, j3, j4);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeo */
    public DataPoint[] newArray(int i) {
        return new DataPoint[i];
    }
}
