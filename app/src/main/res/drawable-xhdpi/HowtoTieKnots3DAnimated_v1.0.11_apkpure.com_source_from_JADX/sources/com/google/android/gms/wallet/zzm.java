package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<NotifyTransactionStatusRequest> {
    static void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, notifyTransactionStatusRequest.mVersionCode);
        zzb.zza(parcel, 2, notifyTransactionStatusRequest.zzaWi, false);
        zzb.zzc(parcel, 3, notifyTransactionStatusRequest.status);
        zzb.zza(parcel, 4, notifyTransactionStatusRequest.zzaXs, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgQ */
    public NotifyTransactionStatusRequest createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjV */
    public NotifyTransactionStatusRequest[] newArray(int i) {
        return new NotifyTransactionStatusRequest[i];
    }
}
