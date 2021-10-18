package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<TrustedDevicesRequest> {
    static void zza(TrustedDevicesRequest trustedDevicesRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, trustedDevicesRequest.versionCode);
        zzb.zza(parcel, 2, trustedDevicesRequest.zzaKw, false);
        zzb.zza(parcel, 3, trustedDevicesRequest.zzaKx, false);
        zzb.zza(parcel, 4, trustedDevicesRequest.zzyp(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfO */
    public TrustedDevicesRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new TrustedDevicesRequest(i, str, bArr, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziC */
    public TrustedDevicesRequest[] newArray(int i) {
        return new TrustedDevicesRequest[i];
    }
}
