package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<GetBuyFlowInitializationTokenResponse> {
    static void zza(GetBuyFlowInitializationTokenResponse getBuyFlowInitializationTokenResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getBuyFlowInitializationTokenResponse.getVersionCode());
        zzb.zza(parcel, 2, getBuyFlowInitializationTokenResponse.zzaXI, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgW */
    public GetBuyFlowInitializationTokenResponse createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetBuyFlowInitializationTokenResponse(i, bArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkb */
    public GetBuyFlowInitializationTokenResponse[] newArray(int i) {
        return new GetBuyFlowInitializationTokenResponse[i];
    }
}
