package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.ArrayList;

public class zzp implements Creator<ParcelableChangeInfo> {
    static void zza(ParcelableChangeInfo parcelableChangeInfo, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, parcelableChangeInfo.mVersionCode);
        zzb.zza(parcel, 2, parcelableChangeInfo.zzXR);
        zzb.zzc(parcel, 3, parcelableChangeInfo.zzoP, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcf */
    public ParcelableChangeInfo createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzai, ParcelableEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ParcelableChangeInfo(i, j, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdU */
    public ParcelableChangeInfo[] newArray(int i) {
        return new ParcelableChangeInfo[i];
    }
}
