package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.Strategy;

public class zzk implements Creator<PublishRequest> {
    static void zza(PublishRequest publishRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, publishRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) publishRequest.zzaKc, i, false);
        zzb.zza(parcel, 3, (Parcelable) publishRequest.zzaKd, i, false);
        zzb.zza(parcel, 4, publishRequest.zzyp(), false);
        zzb.zza(parcel, 5, publishRequest.zzaCr, false);
        zzb.zza(parcel, 6, publishRequest.zzaKe, false);
        zzb.zza(parcel, 7, publishRequest.zzaJJ);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfD */
    public PublishRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        IBinder iBinder = null;
        Strategy strategy = null;
        MessageWrapper messageWrapper = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    messageWrapper = (MessageWrapper) zza.zza(parcel, zzai, (Creator<T>) MessageWrapper.CREATOR);
                    break;
                case 3:
                    strategy = (Strategy) zza.zza(parcel, zzai, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PublishRequest(i, messageWrapper, strategy, iBinder, str2, str, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzir */
    public PublishRequest[] newArray(int i) {
        return new PublishRequest[i];
    }
}
