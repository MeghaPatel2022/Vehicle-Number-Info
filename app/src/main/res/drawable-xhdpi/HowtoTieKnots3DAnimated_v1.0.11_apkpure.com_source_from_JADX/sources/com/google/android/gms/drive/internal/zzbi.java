package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbi implements Creator<OpenContentsRequest> {
    static void zza(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, openContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) openContentsRequest.zzahP, i, false);
        zzb.zzc(parcel, 3, openContentsRequest.zzagr);
        zzb.zzc(parcel, 4, openContentsRequest.zzajV);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbw */
    public OpenContentsRequest createFromParcel(Parcel parcel) {
        int zzg;
        int i;
        DriveId driveId;
        int i2;
        int i3 = 0;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId2 = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    int i6 = i3;
                    i = i4;
                    driveId = driveId2;
                    i2 = zza.zzg(parcel, zzai);
                    zzg = i6;
                    break;
                case 2:
                    i2 = i5;
                    int i7 = i4;
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    zzg = i3;
                    i = i7;
                    break;
                case 3:
                    driveId = driveId2;
                    i2 = i5;
                    int i8 = i3;
                    i = zza.zzg(parcel, zzai);
                    zzg = i8;
                    break;
                case 4:
                    zzg = zza.zzg(parcel, zzai);
                    i = i4;
                    driveId = driveId2;
                    i2 = i5;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzg = i3;
                    i = i4;
                    driveId = driveId2;
                    i2 = i5;
                    break;
            }
            i5 = i2;
            driveId2 = driveId;
            i4 = i;
            i3 = zzg;
        }
        if (parcel.dataPosition() == zzaj) {
            return new OpenContentsRequest(i5, driveId2, i4, i3);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdk */
    public OpenContentsRequest[] newArray(int i) {
        return new OpenContentsRequest[i];
    }
}
