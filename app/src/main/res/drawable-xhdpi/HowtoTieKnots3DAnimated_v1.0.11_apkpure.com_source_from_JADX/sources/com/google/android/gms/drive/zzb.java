package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;

public class zzb implements Creator<Contents> {
    static void zza(Contents contents, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, contents.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) contents.zzabN, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, contents.zzagq);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, contents.zzagr);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) contents.zzags, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, contents.zzagt);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, contents.zzrL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzax */
    public Contents createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        DriveId driveId = null;
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 8:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, z, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcb */
    public Contents[] newArray(int i) {
        return new Contents[i];
    }
}
