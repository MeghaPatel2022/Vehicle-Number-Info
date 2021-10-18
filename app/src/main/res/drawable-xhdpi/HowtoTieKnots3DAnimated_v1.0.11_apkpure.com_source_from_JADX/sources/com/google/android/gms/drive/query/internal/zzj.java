package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzj implements Creator<InFilter> {
    static void zza(InFilter inFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, inFilter.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) inFilter.zzalw, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbX */
    public InFilter createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
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
            return new InFilter(i, metadataBundle);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdL */
    public InFilter[] newArray(int i) {
        return new InFilter[i];
    }
}
