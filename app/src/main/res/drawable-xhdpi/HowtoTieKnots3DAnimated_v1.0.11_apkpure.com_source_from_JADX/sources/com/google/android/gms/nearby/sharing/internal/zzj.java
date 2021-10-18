package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<StopProvidingContentRequest> {
    static void zza(StopProvidingContentRequest stopProvidingContentRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, stopProvidingContentRequest.versionCode);
        zzb.zza(parcel, 2, stopProvidingContentRequest.zzaKt);
        zzb.zza(parcel, 3, stopProvidingContentRequest.zzyp(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfN */
    public StopProvidingContentRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new StopProvidingContentRequest(i, j, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziB */
    public StopProvidingContentRequest[] newArray(int i) {
        return new StopProvidingContentRequest[i];
    }
}
