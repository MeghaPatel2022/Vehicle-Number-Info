package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbw implements Creator<UpdatePermissionRequest> {
    static void zza(UpdatePermissionRequest updatePermissionRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, updatePermissionRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) updatePermissionRequest.zzags, i, false);
        zzb.zza(parcel, 3, updatePermissionRequest.zzagY, false);
        zzb.zzc(parcel, 4, updatePermissionRequest.zzakb);
        zzb.zza(parcel, 5, updatePermissionRequest.zzahM);
        zzb.zza(parcel, 6, updatePermissionRequest.zzagM, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbI */
    public UpdatePermissionRequest createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new UpdatePermissionRequest(i2, driveId, str2, i, z, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdw */
    public UpdatePermissionRequest[] newArray(int i) {
        return new UpdatePermissionRequest[i];
    }
}
