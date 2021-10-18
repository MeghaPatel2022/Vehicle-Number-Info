package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzo implements Creator<RawDataSet> {
    static void zza(RawDataSet rawDataSet, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, rawDataSet.zzaow);
        zzb.zzc(parcel, 1000, rawDataSet.mVersionCode);
        zzb.zzc(parcel, 2, rawDataSet.zzaoy);
        zzb.zzc(parcel, 3, rawDataSet.zzaoz, false);
        zzb.zza(parcel, 4, rawDataSet.zzanA);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcF */
    public RawDataSet createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzai, RawDataPoint.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new RawDataSet(i3, i2, i, arrayList, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzex */
    public RawDataSet[] newArray(int i) {
        return new RawDataSet[i];
    }
}
