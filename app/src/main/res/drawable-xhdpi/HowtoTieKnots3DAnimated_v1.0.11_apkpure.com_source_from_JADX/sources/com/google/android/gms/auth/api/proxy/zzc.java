package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<ProxyResponse> {
    static void zza(ProxyResponse proxyResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, proxyResponse.googlePlayServicesStatusCode);
        zzb.zzc(parcel, 1000, proxyResponse.versionCode);
        zzb.zza(parcel, 2, (Parcelable) proxyResponse.recoveryAction, i, false);
        zzb.zzc(parcel, 3, proxyResponse.statusCode);
        zzb.zza(parcel, 4, proxyResponse.zzRE, false);
        zzb.zza(parcel, 5, proxyResponse.body, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzM */
    public ProxyResponse createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        Bundle bundle = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 5:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ProxyResponse(i3, i2, pendingIntent, i, bundle, bArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzaC */
    public ProxyResponse[] newArray(int i) {
        return new ProxyResponse[i];
    }
}
