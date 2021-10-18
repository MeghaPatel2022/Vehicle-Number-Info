package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Permission;
import java.util.ArrayList;

public class zzak implements Creator<GetPermissionsResponse> {
    static void zza(GetPermissionsResponse getPermissionsResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getPermissionsResponse.mVersionCode);
        zzb.zzc(parcel, 2, getPermissionsResponse.zzajr, false);
        zzb.zzc(parcel, 3, getPermissionsResponse.zzxf);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbf */
    public GetPermissionsResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzai, Permission.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetPermissionsResponse(i2, arrayList, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcT */
    public GetPermissionsResponse[] newArray(int i) {
        return new GetPermissionsResponse[i];
    }
}
