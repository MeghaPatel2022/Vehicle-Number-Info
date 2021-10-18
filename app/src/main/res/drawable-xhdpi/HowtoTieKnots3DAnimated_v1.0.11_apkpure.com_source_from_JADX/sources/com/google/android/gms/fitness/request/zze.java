package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSet;

public class zze implements Creator<DataInsertRequest> {
    static void zza(DataInsertRequest dataInsertRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataInsertRequest.zzrO(), i, false);
        zzb.zzc(parcel, 1000, dataInsertRequest.getVersionCode());
        zzb.zza(parcel, 2, dataInsertRequest.zzsc(), false);
        zzb.zza(parcel, 3, dataInsertRequest.getPackageName(), false);
        zzb.zza(parcel, 4, dataInsertRequest.zzsg());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcP */
    public DataInsertRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        IBinder iBinder = null;
        DataSet dataSet = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    dataSet = (DataSet) zza.zza(parcel, zzai, DataSet.CREATOR);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
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
            return new DataInsertRequest(i, dataSet, iBinder, str, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeI */
    public DataInsertRequest[] newArray(int i) {
        return new DataInsertRequest[i];
    }
}
