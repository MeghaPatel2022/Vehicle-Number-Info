package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveFile;

public class zzj implements Creator<CreateContentsRequest> {
    static void zza(CreateContentsRequest createContentsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, createContentsRequest.mVersionCode);
        zzb.zzc(parcel, 2, createContentsRequest.zzagr);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaS */
    public CreateContentsRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = DriveFile.MODE_WRITE_ONLY;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CreateContentsRequest(i, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcB */
    public CreateContentsRequest[] newArray(int i) {
        return new CreateContentsRequest[i];
    }
}
