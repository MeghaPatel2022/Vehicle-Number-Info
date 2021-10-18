package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Creator<Subscription> {
    static void zza(Subscription subscription, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) subscription.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, subscription.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) subscription.getDataType(), i, false);
        zzb.zza(parcel, 3, subscription.zzrP());
        zzb.zzc(parcel, 4, subscription.getAccuracyMode());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcI */
    public Subscription createFromParcel(Parcel parcel) {
        DataType dataType = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        long j = 0;
        DataSource dataSource = null;
        int i2 = 0;
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
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzai);
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
            return new Subscription(i2, dataSource, dataType, j, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeB */
    public Subscription[] newArray(int i) {
        return new Subscription[i];
    }
}
