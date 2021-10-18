package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zza implements Creator<ComparisonFilter> {
    static void zza(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, comparisonFilter.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) comparisonFilter.zzalv, i, false);
        zzb.zza(parcel, 2, (Parcelable) comparisonFilter.zzalw, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbR */
    public ComparisonFilter createFromParcel(Parcel parcel) {
        MetadataBundle metadataBundle;
        Operator operator;
        int i;
        MetadataBundle metadataBundle2 = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i2 = 0;
        Operator operator2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    Operator operator3 = (Operator) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Operator.CREATOR);
                    metadataBundle = metadataBundle2;
                    operator = operator3;
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, MetadataBundle.CREATOR);
                    operator = operator2;
                    i = i2;
                    break;
                case 1000:
                    MetadataBundle metadataBundle3 = metadataBundle2;
                    operator = operator2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    metadataBundle = metadataBundle3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    metadataBundle = metadataBundle2;
                    operator = operator2;
                    i = i2;
                    break;
            }
            i2 = i;
            operator2 = operator;
            metadataBundle2 = metadataBundle;
        }
        if (parcel.dataPosition() == zzaj) {
            return new ComparisonFilter(i2, operator2, metadataBundle2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdF */
    public ComparisonFilter[] newArray(int i) {
        return new ComparisonFilter[i];
    }
}
