package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<LaunchOptions> {
    static void zza(LaunchOptions launchOptions, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, launchOptions.getVersionCode());
        zzb.zza(parcel, 2, launchOptions.getRelaunchIfRunning());
        zzb.zza(parcel, 3, launchOptions.getLanguage(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzT */
    public LaunchOptions createFromParcel(Parcel parcel) {
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
                    z = zza.zzc(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LaunchOptions(i, z, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzaJ */
    public LaunchOptions[] newArray(int i) {
        return new LaunchOptions[i];
    }
}
