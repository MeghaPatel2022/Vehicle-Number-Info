package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class zzbq implements Creator<SetResourceParentsRequest> {
    static void zza(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, setResourceParentsRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) setResourceParentsRequest.zzajZ, i, false);
        zzb.zzc(parcel, 3, setResourceParentsRequest.zzaka, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbD */
    public SetResourceParentsRequest createFromParcel(Parcel parcel) {
        List zzc;
        DriveId driveId;
        int i;
        List list = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        DriveId driveId2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    List list2 = list;
                    driveId = driveId2;
                    i = zza.zzg(parcel, zzai);
                    zzc = list2;
                    break;
                case 2:
                    i = i2;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    zzc = list;
                    driveId = driveId3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzai, DriveId.CREATOR);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = list;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            list = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SetResourceParentsRequest(i2, driveId2, list);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdr */
    public SetResourceParentsRequest[] newArray(int i) {
        return new SetResourceParentsRequest[i];
    }
}
