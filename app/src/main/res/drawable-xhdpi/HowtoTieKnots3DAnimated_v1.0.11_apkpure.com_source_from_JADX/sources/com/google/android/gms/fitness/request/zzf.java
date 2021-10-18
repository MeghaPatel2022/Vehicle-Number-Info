package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import java.util.ArrayList;

public class zzf implements Creator<DataReadRequest> {
    static void zza(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, dataReadRequest.getDataTypes(), false);
        zzb.zzc(parcel, 2, dataReadRequest.getDataSources(), false);
        zzb.zza(parcel, 3, dataReadRequest.zzkH());
        zzb.zza(parcel, 4, dataReadRequest.zzrw());
        zzb.zzc(parcel, 5, dataReadRequest.getAggregatedDataTypes(), false);
        zzb.zzc(parcel, 6, dataReadRequest.getAggregatedDataSources(), false);
        zzb.zzc(parcel, 7, dataReadRequest.getBucketType());
        zzb.zza(parcel, 8, dataReadRequest.zzsj());
        zzb.zza(parcel, 9, (Parcelable) dataReadRequest.getActivityDataSource(), i, false);
        zzb.zzc(parcel, 10, dataReadRequest.getLimit());
        zzb.zza(parcel, 12, dataReadRequest.zzsi());
        zzb.zza(parcel, 13, dataReadRequest.zzsh());
        zzb.zza(parcel, 14, dataReadRequest.zzsc(), false);
        zzb.zza(parcel, 15, dataReadRequest.getPackageName(), false);
        zzb.zzc(parcel, 16, dataReadRequest.zzsk(), false);
        zzb.zzc(parcel, 1000, dataReadRequest.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcQ */
    public DataReadRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        long j = 0;
        long j2 = 0;
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        int i2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        String str = null;
        ArrayList arrayList5 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzai, DataType.CREATOR);
                    break;
                case 2:
                    arrayList2 = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 5:
                    arrayList3 = zza.zzc(parcel, zzai, DataType.CREATOR);
                    break;
                case 6:
                    arrayList4 = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 8:
                    j3 = zza.zzi(parcel, zzai);
                    break;
                case 9:
                    dataSource = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
                    break;
                case 10:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 12:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 13:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 14:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 15:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 16:
                    arrayList5 = zza.zzc(parcel, zzai, Device.CREATOR);
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
            return new DataReadRequest(i, arrayList, arrayList2, j, j2, arrayList3, arrayList4, i2, j3, dataSource, i3, z, z2, iBinder, str, arrayList5);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeJ */
    public DataReadRequest[] newArray(int i) {
        return new DataReadRequest[i];
    }
}
