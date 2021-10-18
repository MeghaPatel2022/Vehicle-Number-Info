package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Creator<CheckServerAuthResult> {
    static void zza(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, checkServerAuthResult.mVersionCode);
        zzb.zza(parcel, 2, checkServerAuthResult.zzaOk);
        zzb.zzc(parcel, 3, checkServerAuthResult.zzaOl, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgk */
    public CheckServerAuthResult createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList = null;
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
                    arrayList = zza.zzc(parcel, zzai, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CheckServerAuthResult(i, z, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziZ */
    public CheckServerAuthResult[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }
}
