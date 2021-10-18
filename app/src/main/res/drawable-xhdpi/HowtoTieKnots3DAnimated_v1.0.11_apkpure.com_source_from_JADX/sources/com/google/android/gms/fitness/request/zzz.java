package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz implements Creator<SessionUnregistrationRequest> {
    static void zza(SessionUnregistrationRequest sessionUnregistrationRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionUnregistrationRequest.zzso(), i, false);
        zzb.zzc(parcel, 1000, sessionUnregistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionUnregistrationRequest.zzsc(), false);
        zzb.zza(parcel, 3, sessionUnregistrationRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdj */
    public SessionUnregistrationRequest createFromParcel(Parcel parcel) {
        String zzo;
        IBinder iBinder;
        PendingIntent pendingIntent;
        int i;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    IBinder iBinder3 = iBinder2;
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    zzo = str;
                    iBinder = iBinder3;
                    break;
                case 2:
                    pendingIntent = pendingIntent2;
                    i = i2;
                    String str2 = str;
                    iBinder = zza.zzp(parcel, zzai);
                    zzo = str2;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzai);
                    iBinder = iBinder2;
                    pendingIntent = pendingIntent2;
                    i = i2;
                    break;
                case 1000:
                    String str3 = str;
                    iBinder = iBinder2;
                    pendingIntent = pendingIntent2;
                    i = zza.zzg(parcel, zzai);
                    zzo = str3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzo = str;
                    iBinder = iBinder2;
                    pendingIntent = pendingIntent2;
                    i = i2;
                    break;
            }
            i2 = i;
            pendingIntent2 = pendingIntent;
            iBinder2 = iBinder;
            str = zzo;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SessionUnregistrationRequest(i2, pendingIntent2, iBinder2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfd */
    public SessionUnregistrationRequest[] newArray(int i) {
        return new SessionUnregistrationRequest[i];
    }
}
