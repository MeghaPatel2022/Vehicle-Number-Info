package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzc implements Creator<DailyTotalRequest> {
    static void zza(DailyTotalRequest dailyTotalRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dailyTotalRequest.zzsc(), false);
        zzb.zzc(parcel, 1000, dailyTotalRequest.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) dailyTotalRequest.getDataType(), i, false);
        zzb.zza(parcel, 3, dailyTotalRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcN */
    public DailyTotalRequest createFromParcel(Parcel parcel) {
        String zzo;
        DataType dataType;
        IBinder iBinder;
        int i;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        DataType dataType2 = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    DataType dataType3 = dataType2;
                    iBinder = zza.zzp(parcel, zzai);
                    zzo = str;
                    dataType = dataType3;
                    break;
                case 2:
                    iBinder = iBinder2;
                    i = i2;
                    String str2 = str;
                    dataType = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    zzo = str2;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzai);
                    dataType = dataType2;
                    iBinder = iBinder2;
                    i = i2;
                    break;
                case 1000:
                    String str3 = str;
                    dataType = dataType2;
                    iBinder = iBinder2;
                    i = zza.zzg(parcel, zzai);
                    zzo = str3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzo = str;
                    dataType = dataType2;
                    iBinder = iBinder2;
                    i = i2;
                    break;
            }
            i2 = i;
            iBinder2 = iBinder;
            dataType2 = dataType;
            str = zzo;
        }
        if (parcel.dataPosition() == zzaj) {
            return new DailyTotalRequest(i2, iBinder2, dataType2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeG */
    public DailyTotalRequest[] newArray(int i) {
        return new DailyTotalRequest[i];
    }
}
