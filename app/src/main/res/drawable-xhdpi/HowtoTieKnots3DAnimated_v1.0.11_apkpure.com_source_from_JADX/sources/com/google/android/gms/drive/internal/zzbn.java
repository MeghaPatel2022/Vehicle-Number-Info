package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbn implements Creator<RemovePermissionRequest> {
    static void zza(RemovePermissionRequest removePermissionRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, removePermissionRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) removePermissionRequest.zzags, i, false);
        zzb.zza(parcel, 3, removePermissionRequest.zzagY, false);
        zzb.zza(parcel, 4, removePermissionRequest.zzahM);
        zzb.zza(parcel, 5, removePermissionRequest.zzagM, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbA */
    public RemovePermissionRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
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
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new RemovePermissionRequest(i, driveId, str2, z, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdo */
    public RemovePermissionRequest[] newArray(int i) {
        return new RemovePermissionRequest[i];
    }
}
