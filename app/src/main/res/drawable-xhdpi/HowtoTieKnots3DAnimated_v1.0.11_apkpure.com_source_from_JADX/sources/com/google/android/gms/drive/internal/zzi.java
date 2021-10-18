package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzi implements Creator<ControlProgressRequest> {
    static void zza(ControlProgressRequest controlProgressRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, controlProgressRequest.mVersionCode);
        zzb.zzc(parcel, 2, controlProgressRequest.zzahW);
        zzb.zzc(parcel, 3, controlProgressRequest.zzahX);
        zzb.zza(parcel, 4, (Parcelable) controlProgressRequest.zzags, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaR */
    public ControlProgressRequest createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ControlProgressRequest(i3, i2, i, driveId);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcA */
    public ControlProgressRequest[] newArray(int i) {
        return new ControlProgressRequest[i];
    }
}
