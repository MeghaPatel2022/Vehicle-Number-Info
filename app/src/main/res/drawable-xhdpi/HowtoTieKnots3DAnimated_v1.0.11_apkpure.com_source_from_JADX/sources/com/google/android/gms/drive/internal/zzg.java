package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzg implements Creator<CloseContentsAndUpdateMetadataRequest> {
    static void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, closeContentsAndUpdateMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) closeContentsAndUpdateMetadataRequest.zzahP, i, false);
        zzb.zza(parcel, 3, (Parcelable) closeContentsAndUpdateMetadataRequest.zzahQ, i, false);
        zzb.zza(parcel, 4, (Parcelable) closeContentsAndUpdateMetadataRequest.zzahR, i, false);
        zzb.zza(parcel, 5, closeContentsAndUpdateMetadataRequest.zzagN);
        zzb.zza(parcel, 6, closeContentsAndUpdateMetadataRequest.zzagM, false);
        zzb.zzc(parcel, 7, closeContentsAndUpdateMetadataRequest.zzahS);
        zzb.zzc(parcel, 8, closeContentsAndUpdateMetadataRequest.zzahT);
        zzb.zza(parcel, 9, closeContentsAndUpdateMetadataRequest.zzahU);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaP */
    public CloseContentsAndUpdateMetadataRequest createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) zza.zza(parcel, zzai, Contents.CREATOR);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CloseContentsAndUpdateMetadataRequest(i3, driveId, metadataBundle, contents, z2, str, i2, i, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcy */
    public CloseContentsAndUpdateMetadataRequest[] newArray(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }
}
