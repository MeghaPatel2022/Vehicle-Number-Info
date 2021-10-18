package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public class zzl implements Creator<SubscribeRequest> {
    static void zza(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, subscribeRequest.mVersionCode);
        zzb.zza(parcel, 2, subscribeRequest.zzyq(), false);
        zzb.zza(parcel, 3, (Parcelable) subscribeRequest.zzaKd, i, false);
        zzb.zza(parcel, 4, subscribeRequest.zzyp(), false);
        zzb.zza(parcel, 5, (Parcelable) subscribeRequest.zzaKg, i, false);
        zzb.zza(parcel, 6, (Parcelable) subscribeRequest.zzaKh, i, false);
        zzb.zzc(parcel, 7, subscribeRequest.zzaKi);
        zzb.zza(parcel, 8, subscribeRequest.zzaCr, false);
        zzb.zza(parcel, 9, subscribeRequest.zzaKe, false);
        zzb.zza(parcel, 10, subscribeRequest.zzaKj, false);
        zzb.zza(parcel, 11, subscribeRequest.zzaJJ);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfE */
    public SubscribeRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        byte[] bArr = null;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        String str2 = null;
        int i = 0;
        PendingIntent pendingIntent = null;
        MessageFilter messageFilter = null;
        IBinder iBinder = null;
        Strategy strategy = null;
        IBinder iBinder2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case 3:
                    strategy = (Strategy) zza.zza(parcel, zzai, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 5:
                    messageFilter = (MessageFilter) zza.zza(parcel, zzai, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 8:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 10:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case 11:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new SubscribeRequest(i2, iBinder2, strategy, iBinder, messageFilter, pendingIntent, i, str2, str, bArr, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzis */
    public SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
