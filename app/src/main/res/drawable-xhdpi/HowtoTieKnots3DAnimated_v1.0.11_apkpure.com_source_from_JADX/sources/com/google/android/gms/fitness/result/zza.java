package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.List;

public class zza implements Creator<BleDevicesResult> {
    static void zza(BleDevicesResult bleDevicesResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, bleDevicesResult.getClaimedBleDevices(), false);
        zzb.zzc(parcel, 1000, bleDevicesResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) bleDevicesResult.getStatus(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdp */
    public BleDevicesResult createFromParcel(Parcel parcel) {
        Status status = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, BleDevice.CREATOR);
                    break;
                case 2:
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Status.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new BleDevicesResult(i, list, status);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfj */
    public BleDevicesResult[] newArray(int i) {
        return new BleDevicesResult[i];
    }
}
