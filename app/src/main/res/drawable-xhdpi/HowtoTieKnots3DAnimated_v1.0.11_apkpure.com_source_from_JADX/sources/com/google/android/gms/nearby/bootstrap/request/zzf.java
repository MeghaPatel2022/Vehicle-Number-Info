package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzf implements Creator<SendDataRequest> {
    static void zza(SendDataRequest sendDataRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) sendDataRequest.zzye(), i, false);
        zzb.zzc(parcel, 1000, sendDataRequest.versionCode);
        zzb.zza(parcel, 2, sendDataRequest.getData(), false);
        zzb.zza(parcel, 3, sendDataRequest.zzsc(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfs */
    public SendDataRequest createFromParcel(Parcel parcel) {
        IBinder zzp;
        byte[] bArr;
        Device device;
        int i;
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        byte[] bArr2 = null;
        Device device2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    byte[] bArr3 = bArr2;
                    device = (Device) zza.zza(parcel, zzai, Device.CREATOR);
                    zzp = iBinder;
                    bArr = bArr3;
                    break;
                case 2:
                    device = device2;
                    i = i2;
                    IBinder iBinder2 = iBinder;
                    bArr = zza.zzr(parcel, zzai);
                    zzp = iBinder2;
                    break;
                case 3:
                    zzp = zza.zzp(parcel, zzai);
                    bArr = bArr2;
                    device = device2;
                    i = i2;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    bArr = bArr2;
                    device = device2;
                    i = zza.zzg(parcel, zzai);
                    zzp = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzp = iBinder;
                    bArr = bArr2;
                    device = device2;
                    i = i2;
                    break;
            }
            i2 = i;
            device2 = device;
            bArr2 = bArr;
            iBinder = zzp;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SendDataRequest(i2, device2, bArr2, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzia */
    public SendDataRequest[] newArray(int i) {
        return new SendDataRequest[i];
    }
}
