package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzbg implements Creator<OnResourceIdSetResponse> {
    static void zza(OnResourceIdSetResponse onResourceIdSetResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onResourceIdSetResponse.getVersionCode());
        zzb.zzb(parcel, 2, onResourceIdSetResponse.zzqD(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbu */
    public OnResourceIdSetResponse createFromParcel(Parcel parcel) {
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
                    arrayList = zza.zzC(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnResourceIdSetResponse(i, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdi */
    public OnResourceIdSetResponse[] newArray(int i) {
        return new OnResourceIdSetResponse[i];
    }
}
