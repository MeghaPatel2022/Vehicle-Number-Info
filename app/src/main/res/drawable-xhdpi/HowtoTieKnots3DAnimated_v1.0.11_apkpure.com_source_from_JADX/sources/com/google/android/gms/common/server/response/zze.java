package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<SafeParcelResponse> {
    static void zza(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, safeParcelResponse.getVersionCode());
        zzb.zza(parcel, 2, safeParcelResponse.zzpt(), false);
        zzb.zza(parcel, 3, (Parcelable) safeParcelResponse.zzpu(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzat */
    public SafeParcelResponse createFromParcel(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    parcel2 = zza.zzD(parcel, zzai);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) zza.zza(parcel, zzai, (Creator<T>) FieldMappingDictionary.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzbS */
    public SafeParcelResponse[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
