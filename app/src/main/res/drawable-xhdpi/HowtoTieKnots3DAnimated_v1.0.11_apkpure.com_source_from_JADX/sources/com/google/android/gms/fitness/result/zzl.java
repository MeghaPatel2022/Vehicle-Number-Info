package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<SyncInfoResult> {
    static void zza(SyncInfoResult syncInfoResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) syncInfoResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, syncInfoResult.getVersionCode());
        zzb.zza(parcel, 2, syncInfoResult.zzsH());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdA */
    public SyncInfoResult createFromParcel(Parcel parcel) {
        long zzi;
        Status status;
        int i;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Status status2 = null;
        long j = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    long j2 = j;
                    status = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    i = i2;
                    zzi = j2;
                    break;
                case 2:
                    zzi = zza.zzi(parcel, zzai);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    long j3 = j;
                    status = status2;
                    i = zza.zzg(parcel, zzai);
                    zzi = j3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzi = j;
                    status = status2;
                    i = i2;
                    break;
            }
            status2 = status;
            i2 = i;
            j = zzi;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SyncInfoResult(i2, status2, j);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfu */
    public SyncInfoResult[] newArray(int i) {
        return new SyncInfoResult[i];
    }
}
