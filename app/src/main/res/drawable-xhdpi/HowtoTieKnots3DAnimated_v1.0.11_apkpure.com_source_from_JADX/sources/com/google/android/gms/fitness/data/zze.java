package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zze implements Creator<DataSet> {
    static void zza(DataSet dataSet, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataSet.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, dataSet.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) dataSet.getDataType(), i, false);
        zzb.zzd(parcel, 3, dataSet.zzrD(), false);
        zzb.zzc(parcel, 4, dataSet.zzrE(), false);
        zzb.zza(parcel, 5, dataSet.zzrv());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcx */
    public DataSet createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList2 = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzai, (List) arrayList2, getClass().getClassLoader());
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzai);
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
            return new DataSet(i, dataSource, dataType, arrayList2, arrayList, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzep */
    public DataSet[] newArray(int i) {
        return new DataSet[i];
    }
}
