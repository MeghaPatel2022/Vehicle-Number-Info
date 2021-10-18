package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<QueryResultEventParcelable> {
    static void zza(QueryResultEventParcelable queryResultEventParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, queryResultEventParcelable.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) queryResultEventParcelable.zzYX, i, false);
        zzb.zza(parcel, 3, queryResultEventParcelable.zzahH);
        zzb.zzc(parcel, 4, queryResultEventParcelable.zzahI);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaJ */
    public QueryResultEventParcelable createFromParcel(Parcel parcel) {
        int zzg;
        boolean z;
        DataHolder dataHolder;
        int i;
        int i2 = 0;
        int zzaj = zza.zzaj(parcel);
        DataHolder dataHolder2 = null;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    int i4 = i2;
                    z = z2;
                    dataHolder = dataHolder2;
                    i = zza.zzg(parcel, zzai);
                    zzg = i4;
                    break;
                case 2:
                    i = i3;
                    boolean z3 = z2;
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, (Creator<T>) DataHolder.CREATOR);
                    zzg = i2;
                    z = z3;
                    break;
                case 3:
                    dataHolder = dataHolder2;
                    i = i3;
                    int i5 = i2;
                    z = zza.zzc(parcel, zzai);
                    zzg = i5;
                    break;
                case 4:
                    zzg = zza.zzg(parcel, zzai);
                    z = z2;
                    dataHolder = dataHolder2;
                    i = i3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzg = i2;
                    z = z2;
                    dataHolder = dataHolder2;
                    i = i3;
                    break;
            }
            i3 = i;
            dataHolder2 = dataHolder;
            z2 = z;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzaj) {
            return new QueryResultEventParcelable(i3, dataHolder2, z2, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcr */
    public QueryResultEventParcelable[] newArray(int i) {
        return new QueryResultEventParcelable[i];
    }
}
