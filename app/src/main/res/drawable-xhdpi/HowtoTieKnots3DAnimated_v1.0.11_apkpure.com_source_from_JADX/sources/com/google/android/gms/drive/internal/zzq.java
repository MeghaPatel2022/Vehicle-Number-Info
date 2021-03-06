package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<DisconnectRequest> {
    static void zza(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, disconnectRequest.mVersionCode);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaX */
    public DisconnectRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DisconnectRequest(i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcH */
    public DisconnectRequest[] newArray(int i) {
        return new DisconnectRequest[i];
    }
}
