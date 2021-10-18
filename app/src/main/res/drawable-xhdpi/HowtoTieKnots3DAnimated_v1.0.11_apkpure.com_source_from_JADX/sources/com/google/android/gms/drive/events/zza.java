package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zza implements Creator<ChangeEvent> {
    static void zza(ChangeEvent changeEvent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, changeEvent.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) changeEvent.zzags, i, false);
        zzb.zzc(parcel, 3, changeEvent.zzahm);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaE */
    public ChangeEvent createFromParcel(Parcel parcel) {
        int zzg;
        DriveId driveId;
        int i;
        int i2 = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        DriveId driveId2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    int i4 = i2;
                    driveId = driveId2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    zzg = i4;
                    break;
                case 2:
                    i = i3;
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, DriveId.CREATOR);
                    zzg = i2;
                    driveId = driveId3;
                    break;
                case 3:
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    driveId = driveId2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
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
            return new ChangeEvent(i3, driveId2, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcm */
    public ChangeEvent[] newArray(int i) {
        return new ChangeEvent[i];
    }
}
