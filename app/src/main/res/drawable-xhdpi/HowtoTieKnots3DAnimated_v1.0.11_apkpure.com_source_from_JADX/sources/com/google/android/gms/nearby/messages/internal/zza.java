package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<GetPermissionStatusRequest> {
    static void zza(GetPermissionStatusRequest getPermissionStatusRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getPermissionStatusRequest.mVersionCode);
        zzb.zza(parcel, 2, getPermissionStatusRequest.zzyp(), false);
        zzb.zza(parcel, 3, getPermissionStatusRequest.zzaCr, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfA */
    public GetPermissionStatusRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzai);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetPermissionStatusRequest(i, iBinder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzio */
    public GetPermissionStatusRequest[] newArray(int i) {
        return new GetPermissionStatusRequest[i];
    }
}
