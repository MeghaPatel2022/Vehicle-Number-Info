package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<FullTextSearchFilter> {
    static void zza(FullTextSearchFilter fullTextSearchFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, fullTextSearchFilter.mVersionCode);
        zzb.zza(parcel, 1, fullTextSearchFilter.mValue, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbV */
    public FullTextSearchFilter createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str = zza.zzo(parcel, zzai);
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
            return new FullTextSearchFilter(i, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdJ */
    public FullTextSearchFilter[] newArray(int i) {
        return new FullTextSearchFilter[i];
    }
}
