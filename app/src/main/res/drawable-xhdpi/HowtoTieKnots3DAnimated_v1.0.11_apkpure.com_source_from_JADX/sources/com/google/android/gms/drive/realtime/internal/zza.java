package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<BeginCompoundOperationRequest> {
    static void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, beginCompoundOperationRequest.mVersionCode);
        zzb.zza(parcel, 2, beginCompoundOperationRequest.zzalV);
        zzb.zza(parcel, 3, beginCompoundOperationRequest.mName, false);
        zzb.zza(parcel, 4, beginCompoundOperationRequest.zzalW);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcd */
    public BeginCompoundOperationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String str = null;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 4:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new BeginCompoundOperationRequest(i, z, str, z2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdR */
    public BeginCompoundOperationRequest[] newArray(int i) {
        return new BeginCompoundOperationRequest[i];
    }
}
