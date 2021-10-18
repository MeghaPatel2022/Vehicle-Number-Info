package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzd implements Creator<DisconnectRequest> {
    static void zza(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) disconnectRequest.zzye(), i, false);
        zzb.zzc(parcel, 1000, disconnectRequest.versionCode);
        zzb.zza(parcel, 2, disconnectRequest.zzsc(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfq */
    public DisconnectRequest createFromParcel(Parcel parcel) {
        IBinder zzp;
        Device device;
        int i;
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Device device2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    Device device3 = (Device) zza.zza(parcel, zzai, Device.CREATOR);
                    zzp = iBinder;
                    device = device3;
                    break;
                case 2:
                    zzp = zza.zzp(parcel, zzai);
                    device = device2;
                    i = i2;
                    break;
                case 1000:
                    IBinder iBinder2 = iBinder;
                    device = device2;
                    i = zza.zzg(parcel, zzai);
                    zzp = iBinder2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzp = iBinder;
                    device = device2;
                    i = i2;
                    break;
            }
            i2 = i;
            device2 = device;
            iBinder = zzp;
        }
        if (parcel.dataPosition() == zzaj) {
            return new DisconnectRequest(i2, device2, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhY */
    public DisconnectRequest[] newArray(int i) {
        return new DisconnectRequest[i];
    }
}
