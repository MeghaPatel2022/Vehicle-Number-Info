package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaf implements Creator<FileUploadPreferencesImpl> {
    static void zza(FileUploadPreferencesImpl fileUploadPreferencesImpl, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, fileUploadPreferencesImpl.mVersionCode);
        zzb.zzc(parcel, 2, fileUploadPreferencesImpl.zzajj);
        zzb.zzc(parcel, 3, fileUploadPreferencesImpl.zzajk);
        zzb.zza(parcel, 4, fileUploadPreferencesImpl.zzajl);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzba */
    public FileUploadPreferencesImpl createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FileUploadPreferencesImpl(i3, i2, i, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcO */
    public FileUploadPreferencesImpl[] newArray(int i) {
        return new FileUploadPreferencesImpl[i];
    }
}
