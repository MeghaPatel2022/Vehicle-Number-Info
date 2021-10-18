package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class zzaq implements Creator<LoadRealtimeRequest> {
    static void zza(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, loadRealtimeRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) loadRealtimeRequest.zzags, i, false);
        zzb.zza(parcel, 3, loadRealtimeRequest.zzajt);
        zzb.zzb(parcel, 4, loadRealtimeRequest.zzaju, false);
        zzb.zza(parcel, 5, loadRealtimeRequest.zzajv);
        zzb.zza(parcel, 6, (Parcelable) loadRealtimeRequest.zzajw, i, false);
        zzb.zza(parcel, 7, loadRealtimeRequest.zzajx, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbh */
    public LoadRealtimeRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        DataHolder dataHolder = null;
        List list = null;
        boolean z2 = false;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    list = zza.zzC(parcel, zzai);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 6:
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, (Creator<T>) DataHolder.CREATOR);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LoadRealtimeRequest(i, driveId, z2, list, z, dataHolder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcV */
    public LoadRealtimeRequest[] newArray(int i) {
        return new LoadRealtimeRequest[i];
    }
}
