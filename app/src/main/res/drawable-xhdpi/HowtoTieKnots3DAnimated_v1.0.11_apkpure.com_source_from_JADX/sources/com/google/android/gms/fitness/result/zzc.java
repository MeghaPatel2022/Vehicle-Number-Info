package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;

public class zzc implements Creator<DataReadResult> {
    static void zza(DataReadResult dataReadResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzd(parcel, 1, dataReadResult.zzsD(), false);
        zzb.zzc(parcel, 1000, dataReadResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) dataReadResult.getStatus(), i, false);
        zzb.zzd(parcel, 3, dataReadResult.zzsC(), false);
        zzb.zzc(parcel, 5, dataReadResult.zzsB());
        zzb.zzc(parcel, 6, dataReadResult.zzrE(), false);
        zzb.zzc(parcel, 7, dataReadResult.zzsE(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdr */
    public DataReadResult createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        List list = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    zza.zza(parcel, zzai, (List) arrayList2, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzai, (List) arrayList3, getClass().getClassLoader());
                    break;
                case 5:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 6:
                    list = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case 7:
                    arrayList = zza.zzc(parcel, zzai, DataType.CREATOR);
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
            return new DataReadResult(i2, arrayList2, status, arrayList3, i, list, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfl */
    public DataReadResult[] newArray(int i) {
        return new DataReadResult[i];
    }
}
