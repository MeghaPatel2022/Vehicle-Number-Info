package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Creator<AutocompleteFilter> {
    static void zza(AutocompleteFilter autocompleteFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, autocompleteFilter.zzvY());
        zzb.zzc(parcel, 1000, autocompleteFilter.mVersionCode);
        zzb.zza(parcel, 2, autocompleteFilter.zzaDm, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeA */
    public AutocompleteFilter createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 2:
                    arrayList = zza.zzB(parcel, zzai);
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
            return new AutocompleteFilter(i, z, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgX */
    public AutocompleteFilter[] newArray(int i) {
        return new AutocompleteFilter[i];
    }
}
