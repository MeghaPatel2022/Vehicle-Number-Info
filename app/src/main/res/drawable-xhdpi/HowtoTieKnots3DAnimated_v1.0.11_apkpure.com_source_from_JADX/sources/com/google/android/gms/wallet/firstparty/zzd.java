package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<GetInstrumentsRequest> {
    static void zza(GetInstrumentsRequest getInstrumentsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getInstrumentsRequest.getVersionCode());
        zzb.zza(parcel, 2, getInstrumentsRequest.zzaXJ, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgX */
    public GetInstrumentsRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    iArr = zza.zzu(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetInstrumentsRequest(i, iArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkc */
    public GetInstrumentsRequest[] newArray(int i) {
        return new GetInstrumentsRequest[i];
    }
}
