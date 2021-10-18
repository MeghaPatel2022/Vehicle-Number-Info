package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<GetInstrumentsResponse> {
    static void zza(GetInstrumentsResponse getInstrumentsResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getInstrumentsResponse.getVersionCode());
        zzb.zza(parcel, 2, getInstrumentsResponse.zzaXK, false);
        zzb.zza(parcel, 3, getInstrumentsResponse.zzaXL, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgY */
    public GetInstrumentsResponse createFromParcel(Parcel parcel) {
        String[] strArr = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        byte[][] bArr = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case 3:
                    bArr = zza.zzs(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetInstrumentsResponse(i, strArr, bArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkd */
    public GetInstrumentsResponse[] newArray(int i) {
        return new GetInstrumentsResponse[i];
    }
}
