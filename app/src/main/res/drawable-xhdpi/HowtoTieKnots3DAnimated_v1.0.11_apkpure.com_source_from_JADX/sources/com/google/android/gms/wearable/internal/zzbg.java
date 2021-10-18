package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbg implements Creator<RemoveLocalCapabilityResponse> {
    static void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, removeLocalCapabilityResponse.versionCode);
        zzb.zzc(parcel, 2, removeLocalCapabilityResponse.statusCode);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhU */
    public RemoveLocalCapabilityResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new RemoveLocalCapabilityResponse(i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzlf */
    public RemoveLocalCapabilityResponse[] newArray(int i) {
        return new RemoveLocalCapabilityResponse[i];
    }
}
