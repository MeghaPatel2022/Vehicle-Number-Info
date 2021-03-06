package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzw implements Creator<SessionRegistrationRequest> {
    static void zza(SessionRegistrationRequest sessionRegistrationRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionRegistrationRequest.zzso(), i, false);
        zzb.zzc(parcel, 1000, sessionRegistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionRegistrationRequest.zzsc(), false);
        zzb.zza(parcel, 3, sessionRegistrationRequest.getPackageName(), false);
        zzb.zzc(parcel, 4, sessionRegistrationRequest.zzsx());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdg */
    public SessionRegistrationRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new SessionRegistrationRequest(i2, pendingIntent, iBinder, str, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfa */
    public SessionRegistrationRequest[] newArray(int i) {
        return new SessionRegistrationRequest[i];
    }
}
