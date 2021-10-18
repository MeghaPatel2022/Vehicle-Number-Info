package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<SessionDataSet> {
    static void zza(SessionDataSet sessionDataSet, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionDataSet.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionDataSet.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) sessionDataSet.zzrO(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcH */
    public SessionDataSet createFromParcel(Parcel parcel) {
        DataSet dataSet;
        Session session;
        int i;
        DataSet dataSet2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Session session2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    Session session3 = (Session) zza.zza(parcel, zzai, Session.CREATOR);
                    dataSet = dataSet2;
                    session = session3;
                    break;
                case 2:
                    dataSet = (DataSet) zza.zza(parcel, zzai, DataSet.CREATOR);
                    session = session2;
                    i = i2;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet2;
                    session = session2;
                    i = zza.zzg(parcel, zzai);
                    dataSet = dataSet3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    dataSet = dataSet2;
                    session = session2;
                    i = i2;
                    break;
            }
            i2 = i;
            session2 = session;
            dataSet2 = dataSet;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SessionDataSet(i2, session2, dataSet2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeA */
    public SessionDataSet[] newArray(int i) {
        return new SessionDataSet[i];
    }
}
