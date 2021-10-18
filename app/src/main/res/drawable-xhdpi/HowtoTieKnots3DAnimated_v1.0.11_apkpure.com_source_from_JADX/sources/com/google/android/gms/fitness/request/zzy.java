package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy implements Creator<SessionStopRequest> {
    static void zza(SessionStopRequest sessionStopRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, sessionStopRequest.getName(), false);
        zzb.zzc(parcel, 1000, sessionStopRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionStopRequest.getIdentifier(), false);
        zzb.zza(parcel, 3, sessionStopRequest.zzsc(), false);
        zzb.zza(parcel, 4, sessionStopRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdi */
    public SessionStopRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
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
            return new SessionStopRequest(i, str3, str2, iBinder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfc */
    public SessionStopRequest[] newArray(int i) {
        return new SessionStopRequest[i];
    }
}
