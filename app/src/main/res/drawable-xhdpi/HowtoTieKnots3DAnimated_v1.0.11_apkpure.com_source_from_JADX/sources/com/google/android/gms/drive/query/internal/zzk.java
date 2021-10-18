package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzk implements Creator<LogicalFilter> {
    static void zza(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, logicalFilter.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) logicalFilter.zzalv, i, false);
        zzb.zzc(parcel, 2, logicalFilter.zzalK, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbY */
    public LogicalFilter createFromParcel(Parcel parcel) {
        List zzc;
        Operator operator;
        int i;
        List list = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Operator operator2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    Operator operator3 = (Operator) zza.zza(parcel, zzai, Operator.CREATOR);
                    zzc = list;
                    operator = operator3;
                    break;
                case 2:
                    zzc = zza.zzc(parcel, zzai, FilterHolder.CREATOR);
                    operator = operator2;
                    i = i2;
                    break;
                case 1000:
                    List list2 = list;
                    operator = operator2;
                    i = zza.zzg(parcel, zzai);
                    zzc = list2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = list;
                    operator = operator2;
                    i = i2;
                    break;
            }
            i2 = i;
            operator2 = operator;
            list = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new LogicalFilter(i2, operator2, list);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdM */
    public LogicalFilter[] newArray(int i) {
        return new LogicalFilter[i];
    }
}
