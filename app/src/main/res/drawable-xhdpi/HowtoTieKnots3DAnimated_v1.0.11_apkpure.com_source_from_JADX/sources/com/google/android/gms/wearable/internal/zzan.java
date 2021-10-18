package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzan implements Creator<GetConfigResponse> {
    static void zza(GetConfigResponse getConfigResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getConfigResponse.versionCode);
        zzb.zzc(parcel, 2, getConfigResponse.statusCode);
        zzb.zza(parcel, 3, (Parcelable) getConfigResponse.zzbax, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhI */
    public GetConfigResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ConnectionConfiguration connectionConfiguration = null;
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
                    connectionConfiguration = (ConnectionConfiguration) zza.zza(parcel, zzai, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetConfigResponse(i2, i, connectionConfiguration);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkT */
    public GetConfigResponse[] newArray(int i) {
        return new GetConfigResponse[i];
    }
}
