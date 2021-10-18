package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PopupLocationInfoParcelableCreator implements Creator<PopupLocationInfoParcelable> {
    static void zza(PopupLocationInfoParcelable popupLocationInfoParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, popupLocationInfoParcelable.zzuo(), false);
        zzb.zzc(parcel, 1000, popupLocationInfoParcelable.getVersionCode());
        zzb.zza(parcel, 2, popupLocationInfoParcelable.getWindowToken(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdO */
    public PopupLocationInfoParcelable createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzai);
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
            return new PopupLocationInfoParcelable(i, bundle, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfO */
    public PopupLocationInfoParcelable[] newArray(int i) {
        return new PopupLocationInfoParcelable[i];
    }
}
