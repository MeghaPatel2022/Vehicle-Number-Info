package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<ReceiveContentRequest> {
    static void zza(ReceiveContentRequest receiveContentRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, receiveContentRequest.versionCode);
        zzb.zza(parcel, 2, receiveContentRequest.zzaKq, false);
        zzb.zza(parcel, 3, receiveContentRequest.zzyy(), false);
        zzb.zza(parcel, 4, receiveContentRequest.packageName, false);
        zzb.zza(parcel, 5, receiveContentRequest.zzyp(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfM */
    public ReceiveContentRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    iBinder3 = zza.zzp(parcel, zzai);
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ReceiveContentRequest(i, iBinder3, iBinder2, str, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziA */
    public ReceiveContentRequest[] newArray(int i) {
        return new ReceiveContentRequest[i];
    }
}
