package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

public class zzu implements Creator<SessionInsertRequest> {
    static void zza(SessionInsertRequest sessionInsertRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionInsertRequest.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionInsertRequest.getVersionCode());
        zzb.zzc(parcel, 2, sessionInsertRequest.getDataSets(), false);
        zzb.zzc(parcel, 3, sessionInsertRequest.getAggregateDataPoints(), false);
        zzb.zza(parcel, 4, sessionInsertRequest.zzsc(), false);
        zzb.zza(parcel, 5, sessionInsertRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzde */
    public SessionInsertRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        List list = null;
        List list2 = null;
        Session session = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    session = (Session) zza.zza(parcel, zzai, Session.CREATOR);
                    break;
                case 2:
                    list2 = zza.zzc(parcel, zzai, DataSet.CREATOR);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzai, DataPoint.CREATOR);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzai);
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
            return new SessionInsertRequest(i, session, list2, list, iBinder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeY */
    public SessionInsertRequest[] newArray(int i) {
        return new SessionInsertRequest[i];
    }
}
