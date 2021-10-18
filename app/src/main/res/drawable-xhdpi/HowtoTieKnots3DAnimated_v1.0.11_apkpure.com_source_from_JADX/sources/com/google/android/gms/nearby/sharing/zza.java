package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<AppContentReceivedResult> {
    static void zza(AppContentReceivedResult appContentReceivedResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, appContentReceivedResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) appContentReceivedResult.zzyr(), i, false);
        zzb.zzc(parcel, 3, appContentReceivedResult.getStatusCode());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfH */
    public AppContentReceivedResult createFromParcel(Parcel parcel) {
        int zzg;
        Uri uri;
        int i;
        int i2 = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        Uri uri2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    int i4 = i2;
                    uri = uri2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    zzg = i4;
                    break;
                case 2:
                    i = i3;
                    Uri uri3 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Uri.CREATOR);
                    zzg = i2;
                    uri = uri3;
                    break;
                case 3:
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    uri = uri2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    zzg = i2;
                    uri = uri2;
                    i = i3;
                    break;
            }
            i3 = i;
            uri2 = uri;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzaj) {
            return new AppContentReceivedResult(i3, uri2, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziv */
    public AppContentReceivedResult[] newArray(int i) {
        return new AppContentReceivedResult[i];
    }
}
