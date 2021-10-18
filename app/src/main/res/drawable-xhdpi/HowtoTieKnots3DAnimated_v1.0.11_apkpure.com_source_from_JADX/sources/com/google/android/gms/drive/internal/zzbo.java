package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzbo implements Creator<SetDrivePreferencesRequest> {
    static void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, setDrivePreferencesRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) setDrivePreferencesRequest.zzajM, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbB */
    public SetDrivePreferencesRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    drivePreferences = (DrivePreferences) zza.zza(parcel, zzai, DrivePreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new SetDrivePreferencesRequest(i, drivePreferences);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdp */
    public SetDrivePreferencesRequest[] newArray(int i) {
        return new SetDrivePreferencesRequest[i];
    }
}
