package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzbe implements Creator<OnMetadataResponse> {
    static void zza(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onMetadataResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onMetadataResponse.zzaib, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbs */
    public OnMetadataResponse createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdg */
    public OnMetadataResponse[] newArray(int i) {
        return new OnMetadataResponse[i];
    }
}
