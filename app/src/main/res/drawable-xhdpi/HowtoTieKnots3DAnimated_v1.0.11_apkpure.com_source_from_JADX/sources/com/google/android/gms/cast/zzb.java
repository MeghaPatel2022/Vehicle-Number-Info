package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import java.util.ArrayList;

public class zzb implements Creator<CastDevice> {
    static void zza(CastDevice castDevice, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, castDevice.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, castDevice.getDeviceId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, castDevice.zzTo, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, castDevice.getFriendlyName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, castDevice.getModelName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, castDevice.getDeviceVersion(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, castDevice.getServicePort());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, castDevice.getIcons(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, castDevice.getCapabilities());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, castDevice.getStatus());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzS */
    public CastDevice createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        int i3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 8:
                    arrayList = zza.zzc(parcel, zzai, WebImage.CREATOR);
                    break;
                case 9:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 10:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CastDevice(i4, str5, str4, str3, str2, str, i3, arrayList, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzaI */
    public CastDevice[] newArray(int i) {
        return new CastDevice[i];
    }
}
