package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf implements Creator<CheckResourceIdsExistRequest> {
    static void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, checkResourceIdsExistRequest.getVersionCode());
        zzb.zzb(parcel, 2, checkResourceIdsExistRequest.zzqD(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaO */
    public CheckResourceIdsExistRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    arrayList = zza.zzC(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CheckResourceIdsExistRequest(i, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcx */
    public CheckResourceIdsExistRequest[] newArray(int i) {
        return new CheckResourceIdsExistRequest[i];
    }
}
