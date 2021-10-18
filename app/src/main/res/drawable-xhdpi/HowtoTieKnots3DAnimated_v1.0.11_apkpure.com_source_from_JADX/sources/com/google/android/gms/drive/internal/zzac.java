package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzac implements Creator<DriveServiceResponse> {
    static void zza(DriveServiceResponse driveServiceResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, driveServiceResponse.mVersionCode);
        zzb.zza(parcel, 2, driveServiceResponse.zzaje, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaY */
    public DriveServiceResponse createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DriveServiceResponse(i, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcI */
    public DriveServiceResponse[] newArray(int i) {
        return new DriveServiceResponse[i];
    }
}
