package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;
import java.util.List;

public class zza implements Creator<Query> {
    static void zza(Query query, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, query.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) query.zzall, i, false);
        zzb.zza(parcel, 3, query.zzalm, false);
        zzb.zza(parcel, 4, (Parcelable) query.zzaln, i, false);
        zzb.zzb(parcel, 5, query.zzalo, false);
        zzb.zza(parcel, 6, query.zzalp);
        zzb.zzc(parcel, 7, query.zzahq, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbP */
    public Query createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        List list = null;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, LogicalFilter.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 4:
                    sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, SortOrder.CREATOR);
                    break;
                case 5:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzai);
                    break;
                case 6:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                case 7:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, DriveSpace.CREATOR);
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
            return new Query(i, logicalFilter, str, sortOrder, list, z, (List<DriveSpace>) arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdD */
    public Query[] newArray(int i) {
        return new Query[i];
    }
}
