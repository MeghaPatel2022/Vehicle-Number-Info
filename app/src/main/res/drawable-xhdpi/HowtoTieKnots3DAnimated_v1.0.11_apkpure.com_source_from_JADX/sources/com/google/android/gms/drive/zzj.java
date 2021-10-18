package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<UserMetadata> {
    static void zza(UserMetadata userMetadata, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, userMetadata.mVersionCode);
        zzb.zza(parcel, 2, userMetadata.zzahg, false);
        zzb.zza(parcel, 3, userMetadata.zzahh, false);
        zzb.zza(parcel, 4, userMetadata.zzahi, false);
        zzb.zza(parcel, 5, userMetadata.zzahj);
        zzb.zza(parcel, 6, userMetadata.zzahk, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaD */
    public UserMetadata createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new UserMetadata(i, str4, str3, str2, z, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcl */
    public UserMetadata[] newArray(int i) {
        return new UserMetadata[i];
    }
}
