package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzas implements Creator<GetLocalNodeResponse> {
    static void zza(GetLocalNodeResponse getLocalNodeResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getLocalNodeResponse.versionCode);
        zzb.zzc(parcel, 2, getLocalNodeResponse.statusCode);
        zzb.zza(parcel, 3, (Parcelable) getLocalNodeResponse.zzbaC, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhN */
    public GetLocalNodeResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        NodeParcelable nodeParcelable = null;
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
                    nodeParcelable = (NodeParcelable) zza.zza(parcel, zzai, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetLocalNodeResponse(i2, i, nodeParcelable);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkY */
    public GetLocalNodeResponse[] newArray(int i) {
        return new GetLocalNodeResponse[i];
    }
}
