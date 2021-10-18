package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

public class zzd implements Creator<ParcelableEventList> {
    static void zza(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, parcelableEventList.mVersionCode);
        zzb.zzc(parcel, 2, parcelableEventList.zzoP, false);
        zzb.zza(parcel, 3, (Parcelable) parcelableEventList.zzamv, i, false);
        zzb.zza(parcel, 4, parcelableEventList.zzamw);
        zzb.zzb(parcel, 5, parcelableEventList.zzamx, false);
        zzb.zza(parcel, 6, (Parcelable) parcelableEventList.zzamy, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcl */
    public ParcelableEventList createFromParcel(Parcel parcel) {
        boolean z = false;
        ParcelableChangeInfo parcelableChangeInfo = null;
        int zzaj = zza.zzaj(parcel);
        List list = null;
        DataHolder dataHolder = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    list2 = zza.zzc(parcel, zzai, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, (Creator<T>) DataHolder.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 5:
                    list = zza.zzC(parcel, zzai);
                    break;
                case 6:
                    parcelableChangeInfo = (ParcelableChangeInfo) zza.zza(parcel, zzai, ParcelableChangeInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ParcelableEventList(i, list2, dataHolder, z, list, parcelableChangeInfo);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzea */
    public ParcelableEventList[] newArray(int i) {
        return new ParcelableEventList[i];
    }
}
