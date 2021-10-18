package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<EnableTargetRequest> {
    static void zza(EnableTargetRequest enableTargetRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, enableTargetRequest.getName(), false);
        zzb.zzc(parcel, 1000, enableTargetRequest.versionCode);
        zzb.zza(parcel, 2, enableTargetRequest.getDescription(), false);
        zzb.zza(parcel, 3, enableTargetRequest.zzyh(), false);
        zzb.zza(parcel, 4, enableTargetRequest.zzyi(), false);
        zzb.zza(parcel, 5, enableTargetRequest.zzsc(), false);
        zzb.zza(parcel, 6, enableTargetRequest.zzyc());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfr */
    public EnableTargetRequest createFromParcel(Parcel parcel) {
        byte b = 0;
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        int i = 0;
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
                    iBinder3 = zza.zzp(parcel, zzai);
                    break;
                case 4:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case 5:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 6:
                    b = zza.zze(parcel, zzai);
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
            return new EnableTargetRequest(i, str2, str, b, iBinder3, iBinder2, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhZ */
    public EnableTargetRequest[] newArray(int i) {
        return new EnableTargetRequest[i];
    }
}
