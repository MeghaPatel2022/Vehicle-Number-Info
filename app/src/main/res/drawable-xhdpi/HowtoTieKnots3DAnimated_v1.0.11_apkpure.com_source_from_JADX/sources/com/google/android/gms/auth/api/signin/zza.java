package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<EmailSignInConfig> {
    static void zza(EmailSignInConfig emailSignInConfig, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, emailSignInConfig.versionCode);
        zzb.zza(parcel, 2, (Parcelable) emailSignInConfig.zzlA(), i, false);
        zzb.zza(parcel, 3, emailSignInConfig.zzlC(), false);
        zzb.zza(parcel, 4, (Parcelable) emailSignInConfig.zzlB(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzN */
    public EmailSignInConfig createFromParcel(Parcel parcel) {
        Uri uri;
        String str;
        Uri uri2;
        int i;
        Uri uri3 = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i2 = 0;
        String str2 = null;
        Uri uri4 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    Uri uri5 = uri3;
                    str = str2;
                    uri2 = uri4;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    uri = uri5;
                    break;
                case 2:
                    i = i2;
                    String str3 = str2;
                    uri2 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Uri.CREATOR);
                    uri = uri3;
                    str = str3;
                    break;
                case 3:
                    uri2 = uri4;
                    i = i2;
                    Uri uri6 = uri3;
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    uri = uri6;
                    break;
                case 4:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Uri.CREATOR);
                    str = str2;
                    uri2 = uri4;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    uri = uri3;
                    str = str2;
                    uri2 = uri4;
                    i = i2;
                    break;
            }
            i2 = i;
            uri4 = uri2;
            str2 = str;
            uri3 = uri;
        }
        if (parcel.dataPosition() == zzaj) {
            return new EmailSignInConfig(i2, uri4, str2, uri3);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzaD */
    public EmailSignInConfig[] newArray(int i) {
        return new EmailSignInConfig[i];
    }
}
