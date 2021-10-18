package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

public class zzk implements Creator<SessionStopResult> {
    static void zza(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, sessionStopResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) sessionStopResult.getStatus(), i, false);
        zzb.zzc(parcel, 3, sessionStopResult.getSessions(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdz */
    public SessionStopResult createFromParcel(Parcel parcel) {
        List zzc;
        Status status;
        int i;
        List list = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 2:
                    i = i2;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    zzc = list;
                    status = status3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzai, Session.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    List list2 = list;
                    status = status2;
                    i = zza.zzg(parcel, zzai);
                    zzc = list2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = list;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            list = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SessionStopResult(i2, status2, list);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzft */
    public SessionStopResult[] newArray(int i) {
        return new SessionStopResult[i];
    }
}
