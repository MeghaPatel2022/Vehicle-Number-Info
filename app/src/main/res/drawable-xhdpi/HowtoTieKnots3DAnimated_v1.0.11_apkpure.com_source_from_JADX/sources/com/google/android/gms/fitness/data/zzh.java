package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<Device> {
    static void zza(Device device, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, device.getManufacturer(), false);
        zzb.zzc(parcel, 1000, device.getVersionCode());
        zzb.zza(parcel, 2, device.getModel(), false);
        zzb.zza(parcel, 3, device.getVersion(), false);
        zzb.zza(parcel, 4, device.zzrK(), false);
        zzb.zzc(parcel, 5, device.getType());
        zzb.zzc(parcel, 6, device.zzrI());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcA */
    public Device createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Device(i3, str4, str3, str2, str, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzes */
    public Device[] newArray(int i) {
        return new Device[i];
    }
}
