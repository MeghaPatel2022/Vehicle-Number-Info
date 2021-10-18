package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbm implements Creator<RemoveEventListenerRequest> {
    static void zza(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, removeEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) removeEventListenerRequest.zzags, i, false);
        zzb.zzc(parcel, 3, removeEventListenerRequest.zzafk);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbz */
    public RemoveEventListenerRequest createFromParcel(Parcel parcel) {
        int zzg;
        DriveId driveId;
        int i;
        int i2 = 0;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    int i4 = i2;
                    driveId = driveId2;
                    i = zza.zzg(parcel, zzai);
                    zzg = i4;
                    break;
                case 2:
                    i = i3;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    zzg = i2;
                    driveId = driveId3;
                    break;
                case 3:
                    zzg = zza.zzg(parcel, zzai);
                    driveId = driveId2;
                    i = i3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzg = i2;
                    driveId = driveId2;
                    i = i3;
                    break;
            }
            i3 = i;
            driveId2 = driveId;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzaj) {
            return new RemoveEventListenerRequest(i3, driveId2, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdn */
    public RemoveEventListenerRequest[] newArray(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
