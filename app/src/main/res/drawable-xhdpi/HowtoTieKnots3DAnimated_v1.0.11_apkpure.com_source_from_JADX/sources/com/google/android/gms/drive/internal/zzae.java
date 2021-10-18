package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzae implements Creator<FetchThumbnailRequest> {
    static void zza(FetchThumbnailRequest fetchThumbnailRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, fetchThumbnailRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) fetchThumbnailRequest.zzahP, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaZ */
    public FetchThumbnailRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FetchThumbnailRequest(i, driveId);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcL */
    public FetchThumbnailRequest[] newArray(int i) {
        return new FetchThumbnailRequest[i];
    }
}
