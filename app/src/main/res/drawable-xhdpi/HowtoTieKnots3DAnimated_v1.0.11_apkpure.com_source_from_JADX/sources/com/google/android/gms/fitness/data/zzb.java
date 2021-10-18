package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import java.util.ArrayList;
import java.util.List;

public class zzb implements Creator<BleDevice> {
    static void zza(BleDevice bleDevice, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, bleDevice.getAddress(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, bleDevice.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, bleDevice.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 3, bleDevice.getSupportedProfiles(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, bleDevice.getDataTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcu */
    public BleDevice createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    list = zza.zzC(parcel, zzai);
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzai, DataType.CREATOR);
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
            return new BleDevice(i, str2, str, list, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzek */
    public BleDevice[] newArray(int i) {
        return new BleDevice[i];
    }
}
