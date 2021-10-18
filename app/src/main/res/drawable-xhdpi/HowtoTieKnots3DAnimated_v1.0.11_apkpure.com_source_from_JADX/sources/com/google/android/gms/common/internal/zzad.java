package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Creator<ValidateAccountRequest> {
    static void zza(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, validateAccountRequest.mVersionCode);
        zzb.zzc(parcel, 2, validateAccountRequest.zzoS());
        zzb.zza(parcel, 3, validateAccountRequest.zzacC, false);
        zzb.zza(parcel, 4, (T[]) validateAccountRequest.zzoT(), i, false);
        zzb.zza(parcel, 5, validateAccountRequest.zzoU(), false);
        zzb.zza(parcel, 6, validateAccountRequest.getCallingPackage(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzah */
    public ValidateAccountRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 4:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzai, Scope.CREATOR);
                    break;
                case 5:
                    bundle = zza.zzq(parcel, zzai);
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
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzbG */
    public ValidateAccountRequest[] newArray(int i) {
        return new ValidateAccountRequest[i];
    }
}
