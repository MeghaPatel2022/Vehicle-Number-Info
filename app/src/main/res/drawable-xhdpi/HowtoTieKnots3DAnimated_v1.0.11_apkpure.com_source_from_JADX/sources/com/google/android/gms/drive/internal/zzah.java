package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzah implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getDriveIdFromUniqueIdentifierRequest.mVersionCode);
        zzb.zza(parcel, 2, getDriveIdFromUniqueIdentifierRequest.zzajo, false);
        zzb.zza(parcel, 3, getDriveIdFromUniqueIdentifierRequest.zzajp);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbc */
    public GetDriveIdFromUniqueIdentifierRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i = 0;
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
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcQ */
    public GetDriveIdFromUniqueIdentifierRequest[] newArray(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}
