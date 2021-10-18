package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<FilterHolder> {
    static void zza(FilterHolder filterHolder, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) filterHolder.zzalz, i, false);
        zzb.zzc(parcel, 1000, filterHolder.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) filterHolder.zzalA, i, false);
        zzb.zza(parcel, 3, (Parcelable) filterHolder.zzalB, i, false);
        zzb.zza(parcel, 4, (Parcelable) filterHolder.zzalC, i, false);
        zzb.zza(parcel, 5, (Parcelable) filterHolder.zzalD, i, false);
        zzb.zza(parcel, 6, (Parcelable) filterHolder.zzalE, i, false);
        zzb.zza(parcel, 7, (Parcelable) filterHolder.zzalF, i, false);
        zzb.zza(parcel, 8, (Parcelable) filterHolder.zzalG, i, false);
        zzb.zza(parcel, 9, (Parcelable) filterHolder.zzalH, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbU */
    public FilterHolder createFromParcel(Parcel parcel) {
        OwnedByMeFilter ownedByMeFilter = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        FullTextSearchFilter fullTextSearchFilter = null;
        HasFilter hasFilter = null;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) zza.zza(parcel, zzai, (Creator<T>) ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) zza.zza(parcel, zzai, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) zza.zza(parcel, zzai, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) zza.zza(parcel, zzai, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) zza.zza(parcel, zzai, (Creator<T>) InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) zza.zza(parcel, zzai, (Creator<T>) MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) zza.zza(parcel, zzai, (Creator<T>) HasFilter.CREATOR);
                    break;
                case 8:
                    fullTextSearchFilter = (FullTextSearchFilter) zza.zza(parcel, zzai, (Creator<T>) FullTextSearchFilter.CREATOR);
                    break;
                case 9:
                    ownedByMeFilter = (OwnedByMeFilter) zza.zza(parcel, zzai, (Creator<T>) OwnedByMeFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter, fullTextSearchFilter, ownedByMeFilter);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdI */
    public FilterHolder[] newArray(int i) {
        return new FilterHolder[i];
    }
}
