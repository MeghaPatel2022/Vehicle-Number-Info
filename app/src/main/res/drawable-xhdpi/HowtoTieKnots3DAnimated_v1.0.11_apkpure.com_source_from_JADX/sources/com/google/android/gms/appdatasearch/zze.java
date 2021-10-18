package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<Feature> {
    static void zza(Feature feature, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, feature.f15id);
        zzb.zzc(parcel, 1000, feature.mVersionCode);
        zzb.zza(parcel, 2, feature.zzPi, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzag */
    public Feature[] newArray(int i) {
        return new Feature[i];
    }

    /* renamed from: zzv */
    public Feature createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzai);
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
            return new Feature(i2, i, bundle);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }
}
