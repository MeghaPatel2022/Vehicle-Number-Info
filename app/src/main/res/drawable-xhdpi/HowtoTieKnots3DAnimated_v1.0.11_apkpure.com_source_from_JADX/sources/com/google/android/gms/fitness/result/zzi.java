package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<ReadRawResult> {
    static void zza(ReadRawResult readRawResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) readRawResult.zzqA(), i, false);
        zzb.zzc(parcel, 1000, readRawResult.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdx */
    public ReadRawResult createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, (Creator<T>) DataHolder.CREATOR);
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
            return new ReadRawResult(i, dataHolder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfr */
    public ReadRawResult[] newArray(int i) {
        return new ReadRawResult[i];
    }
}
