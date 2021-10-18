package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<DriveId> {
    static void zza(DriveId driveId, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, driveId.mVersionCode);
        zzb.zza(parcel, 2, driveId.zzagC, false);
        zzb.zza(parcel, 3, driveId.zzagD);
        zzb.zza(parcel, 4, driveId.zzagn);
        zzb.zzc(parcel, 5, driveId.zzagE);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzay */
    public DriveId createFromParcel(Parcel parcel) {
        long j = 0;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        int i2 = -1;
        long j2 = 0;
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
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DriveId(i, str, j2, j, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcc */
    public DriveId[] newArray(int i) {
        return new DriveId[i];
    }
}
