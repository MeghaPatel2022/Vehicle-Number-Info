package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zza implements Creator<ConnectRequest> {
    static void zza(ConnectRequest connectRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) connectRequest.zzye(), i, false);
        zzb.zzc(parcel, 1000, connectRequest.versionCode);
        zzb.zza(parcel, 2, connectRequest.getName(), false);
        zzb.zza(parcel, 3, connectRequest.getDescription(), false);
        zzb.zza(parcel, 4, connectRequest.zzyh(), false);
        zzb.zza(parcel, 5, connectRequest.zzyi(), false);
        zzb.zza(parcel, 6, connectRequest.zzsc(), false);
        zzb.zza(parcel, 7, connectRequest.zzyc());
        zzb.zza(parcel, 8, connectRequest.zzyf());
        zzb.zza(parcel, 9, connectRequest.getToken(), false);
        zzb.zza(parcel, 10, connectRequest.zzyg());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfn */
    public ConnectRequest createFromParcel(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        Device device = null;
        String str = null;
        String str2 = null;
        byte b = 0;
        long j = 0;
        String str3 = null;
        byte b2 = 0;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Device.CREATOR);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 4:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzai);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzai);
                    break;
                case 6:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzai);
                    break;
                case 7:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case 9:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 10:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
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
            return new ConnectRequest(i, device, str, str2, b, j, str3, b2, iBinder, iBinder2, iBinder3);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhV */
    public ConnectRequest[] newArray(int i) {
        return new ConnectRequest[i];
    }
}
