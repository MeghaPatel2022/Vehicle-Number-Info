package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzl implements Creator<CreateFileIntentSenderRequest> {
    static void zza(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, createFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) createFileIntentSenderRequest.zzaib, i, false);
        zzb.zzc(parcel, 3, createFileIntentSenderRequest.zzagq);
        zzb.zza(parcel, 4, createFileIntentSenderRequest.zzagU, false);
        zzb.zza(parcel, 5, (Parcelable) createFileIntentSenderRequest.zzagX, i, false);
        zzb.zza(parcel, 6, createFileIntentSenderRequest.zzaic, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaT */
    public CreateFileIntentSenderRequest createFromParcel(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case 6:
                    num = zza.zzh(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcD */
    public CreateFileIntentSenderRequest[] newArray(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
