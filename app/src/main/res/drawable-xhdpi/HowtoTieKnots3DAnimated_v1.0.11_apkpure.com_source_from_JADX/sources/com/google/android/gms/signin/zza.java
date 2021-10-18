package com.google.android.gms.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<GoogleSignInAccount> {
    static void zza(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, googleSignInAccount.versionCode);
        zzb.zza(parcel, 2, googleSignInAccount.getId(), false);
        zzb.zza(parcel, 3, googleSignInAccount.zzlv(), false);
        zzb.zza(parcel, 4, googleSignInAccount.getEmail(), false);
        zzb.zza(parcel, 5, googleSignInAccount.getDisplayName(), false);
        zzb.zza(parcel, 6, (Parcelable) googleSignInAccount.zzzm(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgi */
    public GoogleSignInAccount createFromParcel(Parcel parcel) {
        Uri uri = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 6:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GoogleSignInAccount(i, str4, str3, str2, str, uri);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziX */
    public GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
