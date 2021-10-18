package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<ProxyCard> {
    static void zza(ProxyCard proxyCard, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, proxyCard.getVersionCode());
        zzb.zza(parcel, 2, proxyCard.zzaXy, false);
        zzb.zza(parcel, 3, proxyCard.zzaXz, false);
        zzb.zzc(parcel, 4, proxyCard.zzaXA);
        zzb.zzc(parcel, 5, proxyCard.zzaXB);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgU */
    public ProxyCard createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjZ */
    public ProxyCard[] newArray(int i) {
        return new ProxyCard[i];
    }
}
