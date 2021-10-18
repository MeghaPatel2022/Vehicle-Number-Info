package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import java.util.ArrayList;

public class zzb implements Creator<FacebookSignInConfig> {
    static void zza(FacebookSignInConfig facebookSignInConfig, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, facebookSignInConfig.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) facebookSignInConfig.zzlD(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 3, facebookSignInConfig.zzlE(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzO */
    public FacebookSignInConfig createFromParcel(Parcel parcel) {
        ArrayList zzC;
        Intent intent;
        int i;
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Intent intent2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    ArrayList arrayList2 = arrayList;
                    intent = intent2;
                    i = zza.zzg(parcel, zzai);
                    zzC = arrayList2;
                    break;
                case 2:
                    i = i2;
                    Intent intent3 = (Intent) zza.zza(parcel, zzai, Intent.CREATOR);
                    zzC = arrayList;
                    intent = intent3;
                    break;
                case 3:
                    zzC = zza.zzC(parcel, zzai);
                    intent = intent2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzC = arrayList;
                    intent = intent2;
                    i = i2;
                    break;
            }
            i2 = i;
            intent2 = intent;
            arrayList = zzC;
        }
        if (parcel.dataPosition() == zzaj) {
            return new FacebookSignInConfig(i2, intent2, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzaE */
    public FacebookSignInConfig[] newArray(int i) {
        return new FacebookSignInConfig[i];
    }
}
