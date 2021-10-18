package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbd implements Creator<OnListParentsResponse> {
    static void zza(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onListParentsResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onListParentsResponse.zzajU, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbr */
    public OnListParentsResponse createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, (Creator<T>) DataHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdf */
    public OnListParentsResponse[] newArray(int i) {
        return new OnListParentsResponse[i];
    }
}
