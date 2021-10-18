package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbf implements Creator<RemoveListenerRequest> {
    static void zza(RemoveListenerRequest removeListenerRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, removeListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, removeListenerRequest.zzCt(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhT */
    public RemoveListenerRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new RemoveListenerRequest(i, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzle */
    public RemoveListenerRequest[] newArray(int i) {
        return new RemoveListenerRequest[i];
    }
}
