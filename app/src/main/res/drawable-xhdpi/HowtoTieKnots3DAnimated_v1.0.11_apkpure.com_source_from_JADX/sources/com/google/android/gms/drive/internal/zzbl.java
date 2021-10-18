package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.query.Query;

public class zzbl implements Creator<QueryRequest> {
    static void zza(QueryRequest queryRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, queryRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) queryRequest.zzajY, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzby */
    public QueryRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    query = (Query) zza.zza(parcel, zzai, Query.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new QueryRequest(i, query);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdm */
    public QueryRequest[] newArray(int i) {
        return new QueryRequest[i];
    }
}
