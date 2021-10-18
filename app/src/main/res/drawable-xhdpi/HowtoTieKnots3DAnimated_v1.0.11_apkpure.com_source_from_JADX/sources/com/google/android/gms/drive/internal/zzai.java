package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzai implements Creator<GetMetadataRequest> {
    static void zza(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) getMetadataRequest.zzahP, i, false);
        zzb.zza(parcel, 3, getMetadataRequest.zzajq);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbd */
    public GetMetadataRequest createFromParcel(Parcel parcel) {
        boolean zzc;
        DriveId driveId;
        int i;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    boolean z2 = z;
                    driveId = driveId2;
                    i = zza.zzg(parcel, zzai);
                    zzc = z2;
                    break;
                case 2:
                    i = i2;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    zzc = z;
                    driveId = driveId3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzai);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = z;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            z = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetMetadataRequest(i2, driveId2, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcR */
    public GetMetadataRequest[] newArray(int i) {
        return new GetMetadataRequest[i];
    }
}
