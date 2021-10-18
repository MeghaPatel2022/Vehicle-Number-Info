package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<NotFilter> {
    static void zza(NotFilter notFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, notFilter.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) notFilter.zzalL, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzca */
    public NotFilter createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    filterHolder = (FilterHolder) zza.zza(parcel, zzai, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdO */
    public NotFilter[] newArray(int i) {
        return new NotFilter[i];
    }
}
