package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<DataSource> {
    static void zza(DataSource dataSource, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataSource.getDataType(), i, false);
        zzb.zzc(parcel, 1000, dataSource.getVersionCode());
        zzb.zza(parcel, 2, dataSource.getName(), false);
        zzb.zzc(parcel, 3, dataSource.getType());
        zzb.zza(parcel, 4, (Parcelable) dataSource.getDevice(), i, false);
        zzb.zza(parcel, 5, (Parcelable) dataSource.zzrF(), i, false);
        zzb.zza(parcel, 6, dataSource.getStreamName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcy */
    public DataSource createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        Application application = null;
        Device device = null;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    dataType = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    device = (Device) zza.zza(parcel, zzai, Device.CREATOR);
                    break;
                case 5:
                    application = (Application) zza.zza(parcel, zzai, Application.CREATOR);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DataSource(i2, dataType, str2, i, device, application, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeq */
    public DataSource[] newArray(int i) {
        return new DataSource[i];
    }
}
