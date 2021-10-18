package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<PartialDriveId> {
    static void zza(PartialDriveId partialDriveId, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, partialDriveId.mVersionCode);
        zzb.zza(parcel, 2, partialDriveId.zzagC, false);
        zzb.zza(parcel, 3, partialDriveId.zzagD);
        zzb.zzc(parcel, 4, partialDriveId.zzagE);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbO */
    public PartialDriveId createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        long j = 0;
        int i2 = -1;
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
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PartialDriveId(i, str, j, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdC */
    public PartialDriveId[] newArray(int i) {
        return new PartialDriveId[i];
    }
}
