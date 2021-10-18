package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class zzb implements Creator<AddPermissionRequest> {
    static void zza(AddPermissionRequest addPermissionRequest, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addPermissionRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) addPermissionRequest.zzags, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) addPermissionRequest.zzahJ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addPermissionRequest.zzahK);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addPermissionRequest.zzahL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, addPermissionRequest.zzahM);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, addPermissionRequest.zzagM, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaL */
    public AddPermissionRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        boolean z2 = false;
        Permission permission = null;
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
                    permission = (Permission) zza.zza(parcel, zzai, Permission.CREATOR);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzai);
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
            return new AddPermissionRequest(i, driveId, permission, z2, str2, z, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcu */
    public AddPermissionRequest[] newArray(int i) {
        return new AddPermissionRequest[i];
    }
}
