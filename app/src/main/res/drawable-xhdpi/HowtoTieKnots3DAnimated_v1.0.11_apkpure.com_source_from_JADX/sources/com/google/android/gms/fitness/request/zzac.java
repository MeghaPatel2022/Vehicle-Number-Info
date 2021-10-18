package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Subscription;

public class zzac implements Creator<SubscribeRequest> {
    static void zza(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) subscribeRequest.zzsz(), i, false);
        zzb.zzc(parcel, 1000, subscribeRequest.getVersionCode());
        zzb.zza(parcel, 2, subscribeRequest.zzsA());
        zzb.zza(parcel, 3, subscribeRequest.zzsc(), false);
        zzb.zza(parcel, 4, subscribeRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdm */
    public SubscribeRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        IBinder iBinder = null;
        Subscription subscription = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    subscription = (Subscription) zza.zza(parcel, zzai, Subscription.CREATOR);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
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
            return new SubscribeRequest(i, subscription, z, iBinder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfg */
    public SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
