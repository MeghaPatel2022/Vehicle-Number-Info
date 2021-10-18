package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Creator<GoogleSignInConfig> {
    static void zza(GoogleSignInConfig googleSignInConfig, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, googleSignInConfig.versionCode);
        zzb.zzc(parcel, 2, googleSignInConfig.zzlE(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzP */
    public GoogleSignInConfig createFromParcel(Parcel parcel) {
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
                    arrayList = zza.zzc(parcel, zzai, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GoogleSignInConfig(i, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzaF */
    public GoogleSignInConfig[] newArray(int i) {
        return new GoogleSignInConfig[i];
    }
}
