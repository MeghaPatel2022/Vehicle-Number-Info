package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzbk implements Creator<StorageInfoResponse> {
    static void zza(StorageInfoResponse storageInfoResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, storageInfoResponse.versionCode);
        zzb.zzc(parcel, 2, storageInfoResponse.statusCode);
        zzb.zza(parcel, 3, storageInfoResponse.zzbaQ);
        zzb.zzc(parcel, 4, storageInfoResponse.zzbaS, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhW */
    public StorageInfoResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        long j = 0;
        ArrayList arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzai, PackageStorageInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new StorageInfoResponse(i2, i, j, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzlh */
    public StorageInfoResponse[] newArray(int i) {
        return new StorageInfoResponse[i];
    }
}
