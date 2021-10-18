package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt implements Creator<SensorUnregistrationRequest> {
    static void zza(SensorUnregistrationRequest sensorUnregistrationRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, sensorUnregistrationRequest.zzst(), false);
        zzb.zzc(parcel, 1000, sensorUnregistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) sensorUnregistrationRequest.zzso(), i, false);
        zzb.zza(parcel, 3, sensorUnregistrationRequest.zzsc(), false);
        zzb.zza(parcel, 4, sensorUnregistrationRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdd */
    public SensorUnregistrationRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 4:
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
            return new SensorUnregistrationRequest(i, iBinder2, pendingIntent, iBinder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeX */
    public SensorUnregistrationRequest[] newArray(int i) {
        return new SensorUnregistrationRequest[i];
    }
}
