package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<StartScanRequest> {
    static void zza(StartScanRequest startScanRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, startScanRequest.zzyj(), false);
        zzb.zzc(parcel, 1000, startScanRequest.versionCode);
        zzb.zza(parcel, 2, startScanRequest.zzsc(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzft */
    public StartScanRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new StartScanRequest(i, iBinder2, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzib */
    public StartScanRequest[] newArray(int i) {
        return new StartScanRequest[i];
    }
}
