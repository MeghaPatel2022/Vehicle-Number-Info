package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbp implements Creator<SetFileUploadPreferencesRequest> {
    static void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, setFileUploadPreferencesRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) setFileUploadPreferencesRequest.zzajJ, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbC */
    public SetFileUploadPreferencesRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileUploadPreferencesImpl = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    fileUploadPreferencesImpl = (FileUploadPreferencesImpl) zza.zza(parcel, zzai, FileUploadPreferencesImpl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new SetFileUploadPreferencesRequest(i, fileUploadPreferencesImpl);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdq */
    public SetFileUploadPreferencesRequest[] newArray(int i) {
        return new SetFileUploadPreferencesRequest[i];
    }
}
