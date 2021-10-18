package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbc implements Creator<OnListEntriesResponse> {
    static void zza(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onListEntriesResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onListEntriesResponse.zzajT, i, false);
        zzb.zza(parcel, 3, onListEntriesResponse.zzaio);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbq */
    public OnListEntriesResponse createFromParcel(Parcel parcel) {
        boolean zzc;
        DataHolder dataHolder;
        int i;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        DataHolder dataHolder2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    boolean z2 = z;
                    dataHolder = dataHolder2;
                    i = zza.zzg(parcel, zzai);
                    zzc = z2;
                    break;
                case 2:
                    i = i2;
                    DataHolder dataHolder3 = (DataHolder) zza.zza(parcel, zzai, (Creator<T>) DataHolder.CREATOR);
                    zzc = z;
                    dataHolder = dataHolder3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzai);
                    dataHolder = dataHolder2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = z;
                    dataHolder = dataHolder2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataHolder2 = dataHolder;
            z = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnListEntriesResponse(i2, dataHolder2, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzde */
    public OnListEntriesResponse[] newArray(int i) {
        return new OnListEntriesResponse[i];
    }
}
