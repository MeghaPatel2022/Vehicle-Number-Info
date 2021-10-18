package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbd implements Creator<PackageStorageInfo> {
    static void zza(PackageStorageInfo packageStorageInfo, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, packageStorageInfo.versionCode);
        zzb.zza(parcel, 2, packageStorageInfo.packageName, false);
        zzb.zza(parcel, 3, packageStorageInfo.label, false);
        zzb.zza(parcel, 4, packageStorageInfo.zzbaQ);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhR */
    public PackageStorageInfo createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PackageStorageInfo(i, str2, str, j);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzlc */
    public PackageStorageInfo[] newArray(int i) {
        return new PackageStorageInfo[i];
    }
}
