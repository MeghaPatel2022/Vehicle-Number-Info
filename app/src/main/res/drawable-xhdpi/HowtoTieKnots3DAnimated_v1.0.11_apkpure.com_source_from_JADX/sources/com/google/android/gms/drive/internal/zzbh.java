package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbh implements Creator<OnSyncMoreResponse> {
    static void zza(OnSyncMoreResponse onSyncMoreResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onSyncMoreResponse.mVersionCode);
        zzb.zza(parcel, 2, onSyncMoreResponse.zzaio);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbv */
    public OnSyncMoreResponse createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
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
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnSyncMoreResponse(i, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdj */
    public OnSyncMoreResponse[] newArray(int i) {
        return new OnSyncMoreResponse[i];
    }
}
