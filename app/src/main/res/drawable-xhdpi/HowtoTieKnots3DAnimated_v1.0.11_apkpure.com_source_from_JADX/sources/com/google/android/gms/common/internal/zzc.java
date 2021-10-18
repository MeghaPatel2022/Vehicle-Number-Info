package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<AuthAccountRequest> {
    static void zza(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, authAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, authAccountRequest.zzacC, false);
        zzb.zza(parcel, 3, (T[]) authAccountRequest.zzacD, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzac */
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        Scope[] scopeArr = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 3:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzai, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AuthAccountRequest(i, iBinder, scopeArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzbw */
    public AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
