package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.List;

public class zzj implements Creator<SessionReadResult> {
    static void zza(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, sessionReadResult.getSessions(), false);
        zzb.zzc(parcel, 1000, sessionReadResult.getVersionCode());
        zzb.zzc(parcel, 2, sessionReadResult.zzsG(), false);
        zzb.zza(parcel, 3, (Parcelable) sessionReadResult.getStatus(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdy */
    public SessionReadResult createFromParcel(Parcel parcel) {
        Status status = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    list2 = zza.zzc(parcel, zzai, Session.CREATOR);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzai, SessionDataSet.CREATOR);
                    break;
                case 3:
                    status = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new SessionReadResult(i, list2, list, status);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfs */
    public SessionReadResult[] newArray(int i) {
        return new SessionReadResult[i];
    }
}
