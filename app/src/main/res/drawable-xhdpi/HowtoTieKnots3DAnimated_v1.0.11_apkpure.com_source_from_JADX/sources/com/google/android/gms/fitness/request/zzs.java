package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

public class zzs implements Creator<SensorRegistrationRequest> {
    static void zza(SensorRegistrationRequest sensorRegistrationRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) sensorRegistrationRequest.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, sensorRegistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) sensorRegistrationRequest.getDataType(), i, false);
        zzb.zza(parcel, 3, sensorRegistrationRequest.zzst(), false);
        zzb.zzc(parcel, 4, sensorRegistrationRequest.zzaqj);
        zzb.zzc(parcel, 5, sensorRegistrationRequest.zzaqk);
        zzb.zza(parcel, 6, sensorRegistrationRequest.zzrP());
        zzb.zza(parcel, 7, sensorRegistrationRequest.zzsq());
        zzb.zza(parcel, 8, (Parcelable) sensorRegistrationRequest.zzso(), i, false);
        zzb.zza(parcel, 9, sensorRegistrationRequest.zzsp());
        zzb.zzc(parcel, 10, sensorRegistrationRequest.getAccuracyMode());
        zzb.zzc(parcel, 11, sensorRegistrationRequest.zzsr(), false);
        zzb.zza(parcel, 12, sensorRegistrationRequest.zzss());
        zzb.zza(parcel, 13, sensorRegistrationRequest.zzsc(), false);
        zzb.zza(parcel, 14, sensorRegistrationRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdc */
    public SensorRegistrationRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        ArrayList arrayList = null;
        long j4 = 0;
        IBinder iBinder2 = null;
        String str = null;
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
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 7:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    break;
                case 9:
                    j3 = zza.zzi(parcel, zzai);
                    break;
                case 10:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case 11:
                    arrayList = zza.zzc(parcel, zzai, LocationRequest.CREATOR);
                    break;
                case 12:
                    j4 = zza.zzi(parcel, zzai);
                    break;
                case 13:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case 14:
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
            return new SensorRegistrationRequest(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, arrayList, j4, iBinder2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeV */
    public SensorRegistrationRequest[] newArray(int i) {
        return new SensorRegistrationRequest[i];
    }
}
