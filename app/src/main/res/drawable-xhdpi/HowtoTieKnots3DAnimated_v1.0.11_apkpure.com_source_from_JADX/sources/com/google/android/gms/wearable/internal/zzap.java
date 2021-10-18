package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzap implements Creator<GetConnectedNodesResponse> {
    static void zza(GetConnectedNodesResponse getConnectedNodesResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getConnectedNodesResponse.versionCode);
        zzb.zzc(parcel, 2, getConnectedNodesResponse.statusCode);
        zzb.zzc(parcel, 3, getConnectedNodesResponse.zzbaz, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhK */
    public GetConnectedNodesResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList = null;
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
                    arrayList = zza.zzc(parcel, zzai, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetConnectedNodesResponse(i2, i, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkV */
    public GetConnectedNodesResponse[] newArray(int i) {
        return new GetConnectedNodesResponse[i];
    }
}
