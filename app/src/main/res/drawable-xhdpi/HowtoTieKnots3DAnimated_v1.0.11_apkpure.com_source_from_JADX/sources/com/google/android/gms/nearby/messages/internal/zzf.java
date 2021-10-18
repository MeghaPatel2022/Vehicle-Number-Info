package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.Message;

public class zzf implements Creator<MessageWrapper> {
    static void zza(MessageWrapper messageWrapper, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) messageWrapper.zzaJS, i, false);
        zzb.zzc(parcel, 1000, messageWrapper.versionCode);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfC */
    public MessageWrapper createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Message message = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    message = (Message) zza.zza(parcel, zzai, Message.CREATOR);
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
            return new MessageWrapper(i, message);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziq */
    public MessageWrapper[] newArray(int i) {
        return new MessageWrapper[i];
    }
}
