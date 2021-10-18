package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzc implements Creator<AuthorizeAccessRequest> {
    static void zza(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, authorizeAccessRequest.mVersionCode);
        zzb.zza(parcel, 2, authorizeAccessRequest.zzahN);
        zzb.zza(parcel, 3, (Parcelable) authorizeAccessRequest.zzags, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaM */
    public AuthorizeAccessRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcv */
    public AuthorizeAccessRequest[] newArray(int i) {
        return new AuthorizeAccessRequest[i];
    }
}
