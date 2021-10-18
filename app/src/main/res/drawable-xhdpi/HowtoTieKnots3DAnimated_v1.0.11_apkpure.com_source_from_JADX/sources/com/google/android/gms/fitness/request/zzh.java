package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class zzh implements Creator<DataSourcesRequest> {
    static void zza(DataSourcesRequest dataSourcesRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, dataSourcesRequest.getDataTypes(), false);
        zzb.zzc(parcel, 1000, dataSourcesRequest.getVersionCode());
        zzb.zza(parcel, 2, dataSourcesRequest.zzsl(), false);
        zzb.zza(parcel, 3, dataSourcesRequest.zzsm());
        zzb.zza(parcel, 4, dataSourcesRequest.zzsc(), false);
        zzb.zza(parcel, 5, dataSourcesRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcS */
    public DataSourcesRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        IBinder iBinder = null;
        List list = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    list2 = zza.zzc(parcel, zzai, DataType.CREATOR);
                    break;
                case 2:
                    list = zza.zzB(parcel, zzai);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzai);
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
            return new DataSourcesRequest(i, list2, list, z, iBinder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeL */
    public DataSourcesRequest[] newArray(int i) {
        return new DataSourcesRequest[i];
    }
}
