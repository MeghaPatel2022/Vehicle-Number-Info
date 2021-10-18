package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzao implements Creator<GetConfigsResponse> {
    static void zza(GetConfigsResponse getConfigsResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getConfigsResponse.versionCode);
        zzb.zzc(parcel, 2, getConfigsResponse.statusCode);
        zzb.zza(parcel, 3, (T[]) getConfigsResponse.zzbay, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhJ */
    public GetConfigsResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ConnectionConfiguration[] connectionConfigurationArr = null;
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
                case 3:
                    connectionConfigurationArr = (ConnectionConfiguration[]) zza.zzb(parcel, zzai, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetConfigsResponse(i2, i, connectionConfigurationArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkU */
    public GetConfigsResponse[] newArray(int i) {
        return new GetConfigsResponse[i];
    }
}
