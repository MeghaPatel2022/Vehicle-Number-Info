package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzg implements Creator<DataTypeResult> {
    static void zza(DataTypeResult dataTypeResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataTypeResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, dataTypeResult.getVersionCode());
        zzb.zza(parcel, 3, (Parcelable) dataTypeResult.getDataType(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdv */
    public DataTypeResult createFromParcel(Parcel parcel) {
        DataType dataType;
        Status status;
        int i;
        DataType dataType2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    dataType = dataType2;
                    status = status3;
                    break;
                case 3:
                    dataType = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    DataType dataType3 = dataType2;
                    status = status2;
                    i = zza.zzg(parcel, zzai);
                    dataType = dataType3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    dataType = dataType2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            dataType2 = dataType;
        }
        if (parcel.dataPosition() == zzaj) {
            return new DataTypeResult(i2, status2, dataType2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfp */
    public DataTypeResult[] newArray(int i) {
        return new DataTypeResult[i];
    }
}
