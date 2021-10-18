package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzal implements Creator<GetCloudSyncOptInStatusResponse> {
    static void zza(GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getCloudSyncOptInStatusResponse.versionCode);
        zzb.zzc(parcel, 2, getCloudSyncOptInStatusResponse.statusCode);
        zzb.zza(parcel, 3, getCloudSyncOptInStatusResponse.zzbav);
        zzb.zza(parcel, 4, getCloudSyncOptInStatusResponse.zzbaw);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhG */
    public GetCloudSyncOptInStatusResponse createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        boolean z2 = false;
        int i = 0;
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
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetCloudSyncOptInStatusResponse(i2, i, z2, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkR */
    public GetCloudSyncOptInStatusResponse[] newArray(int i) {
        return new GetCloudSyncOptInStatusResponse[i];
    }
}
