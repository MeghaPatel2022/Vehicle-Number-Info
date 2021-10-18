package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.fitness.data.DataSet;

public class zzb implements Creator<DailyTotalResult> {
    static void zza(DailyTotalResult dailyTotalResult, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) dailyTotalResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dailyTotalResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) dailyTotalResult.getTotal(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdq */
    public DailyTotalResult createFromParcel(Parcel parcel) {
        DataSet dataSet;
        Status status;
        int i;
        DataSet dataSet2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    dataSet = dataSet2;
                    status = status3;
                    break;
                case 2:
                    dataSet = (DataSet) zza.zza(parcel, zzai, DataSet.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet2;
                    status = status2;
                    i = zza.zzg(parcel, zzai);
                    dataSet = dataSet3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    dataSet = dataSet2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            dataSet2 = dataSet;
        }
        if (parcel.dataPosition() == zzaj) {
            return new DailyTotalResult(i2, status2, dataSet2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfk */
    public DailyTotalResult[] newArray(int i) {
        return new DailyTotalResult[i];
    }
}
