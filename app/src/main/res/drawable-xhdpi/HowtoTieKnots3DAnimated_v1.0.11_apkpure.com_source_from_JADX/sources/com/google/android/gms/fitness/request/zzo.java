package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Creator<ListClaimedBleDevicesRequest> {
    static void zza(ListClaimedBleDevicesRequest listClaimedBleDevicesRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, listClaimedBleDevicesRequest.zzsc(), false);
        zzb.zzc(parcel, 1000, listClaimedBleDevicesRequest.getVersionCode());
        zzb.zza(parcel, 2, listClaimedBleDevicesRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcY */
    public ListClaimedBleDevicesRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
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
            return new ListClaimedBleDevicesRequest(i, iBinder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeR */
    public ListClaimedBleDevicesRequest[] newArray(int i) {
        return new ListClaimedBleDevicesRequest[i];
    }
}
