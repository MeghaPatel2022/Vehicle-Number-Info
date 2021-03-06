package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<CredentialRequest> {
    static void zza(CredentialRequest credentialRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, credentialRequest.getSupportsPasswordLogin());
        zzb.zzc(parcel, 1000, credentialRequest.mVersionCode);
        zzb.zza(parcel, 2, credentialRequest.getAccountTypes(), false);
        zzb.zza(parcel, 3, (Parcelable) credentialRequest.getCredentialPickerConfig(), i, false);
        zzb.zza(parcel, 4, (Parcelable) credentialRequest.getCredentialHintPickerConfig(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzF */
    public CredentialRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int zzaj = zza.zzaj(parcel);
        CredentialPickerConfig credentialPickerConfig2 = null;
        String[] strArr = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 2:
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case 3:
                    credentialPickerConfig2 = (CredentialPickerConfig) zza.zza(parcel, zzai, CredentialPickerConfig.CREATOR);
                    break;
                case 4:
                    credentialPickerConfig = (CredentialPickerConfig) zza.zza(parcel, zzai, CredentialPickerConfig.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CredentialRequest(i, z, strArr, credentialPickerConfig2, credentialPickerConfig);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzav */
    public CredentialRequest[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
