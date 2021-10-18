package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzbv implements Creator<UpdateMetadataRequest> {
    static void zza(UpdateMetadataRequest updateMetadataRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, updateMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) updateMetadataRequest.zzahP, i, false);
        zzb.zza(parcel, 3, (Parcelable) updateMetadataRequest.zzahQ, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbH */
    public UpdateMetadataRequest createFromParcel(Parcel parcel) {
        MetadataBundle metadataBundle;
        DriveId driveId;
        int i;
        MetadataBundle metadataBundle2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        DriveId driveId2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle2;
                    driveId = driveId2;
                    i = zza.zzg(parcel, zzai);
                    metadataBundle = metadataBundle3;
                    break;
                case 2:
                    i = i2;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    metadataBundle = metadataBundle2;
                    driveId = driveId3;
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    metadataBundle = metadataBundle2;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            metadataBundle2 = metadataBundle;
        }
        if (parcel.dataPosition() == zzaj) {
            return new UpdateMetadataRequest(i2, driveId2, metadataBundle2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdv */
    public UpdateMetadataRequest[] newArray(int i) {
        return new UpdateMetadataRequest[i];
    }
}
