package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zze implements Creator<CancelPendingActionsRequest> {
    static void zza(CancelPendingActionsRequest cancelPendingActionsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, cancelPendingActionsRequest.mVersionCode);
        zzb.zzb(parcel, 2, cancelPendingActionsRequest.zzahv, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaN */
    public CancelPendingActionsRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    arrayList = zza.zzC(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CancelPendingActionsRequest(i, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcw */
    public CancelPendingActionsRequest[] newArray(int i) {
        return new CancelPendingActionsRequest[i];
    }
}
