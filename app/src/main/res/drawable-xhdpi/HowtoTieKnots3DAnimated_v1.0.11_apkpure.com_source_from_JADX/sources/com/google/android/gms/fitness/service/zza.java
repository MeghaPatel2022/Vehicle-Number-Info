package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zza implements Creator<FitnessSensorServiceRequest> {
    static void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) fitnessSensorServiceRequest.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, fitnessSensorServiceRequest.getVersionCode());
        zzb.zza(parcel, 2, fitnessSensorServiceRequest.zzst(), false);
        zzb.zza(parcel, 3, fitnessSensorServiceRequest.zzrP());
        zzb.zza(parcel, 4, fitnessSensorServiceRequest.zzsJ());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdB */
    public FitnessSensorServiceRequest createFromParcel(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        long j2 = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, DataSource.CREATOR);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzai);
                    break;
                case 3:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case 4:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FitnessSensorServiceRequest(i, dataSource, iBinder, j2, j);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfv */
    public FitnessSensorServiceRequest[] newArray(int i) {
        return new FitnessSensorServiceRequest[i];
    }
}
