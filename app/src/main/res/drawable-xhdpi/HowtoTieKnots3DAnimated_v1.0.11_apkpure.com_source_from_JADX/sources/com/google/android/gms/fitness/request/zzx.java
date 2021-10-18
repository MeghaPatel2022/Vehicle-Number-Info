package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;

public class zzx implements Creator<SessionStartRequest> {
    static void zza(SessionStartRequest sessionStartRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionStartRequest.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionStartRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionStartRequest.zzsc(), false);
        zzb.zza(parcel, 3, sessionStartRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdh */
    public SessionStartRequest createFromParcel(Parcel parcel) {
        String zzo;
        IBinder iBinder;
        Session session;
        int i;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        IBinder iBinder2 = null;
        Session session2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    IBinder iBinder3 = iBinder2;
                    session = (Session) zza.zza(parcel, zzai, Session.CREATOR);
                    zzo = str;
                    iBinder = iBinder3;
                    break;
                case 2:
                    session = session2;
                    i = i2;
                    String str2 = str;
                    iBinder = zza.zzp(parcel, zzai);
                    zzo = str2;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzai);
                    iBinder = iBinder2;
                    session = session2;
                    i = i2;
                    break;
                case 1000:
                    String str3 = str;
                    iBinder = iBinder2;
                    session = session2;
                    i = zza.zzg(parcel, zzai);
                    zzo = str3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzo = str;
                    iBinder = iBinder2;
                    session = session2;
                    i = i2;
                    break;
            }
            i2 = i;
            session2 = session;
            iBinder2 = iBinder;
            str = zzo;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SessionStartRequest(i2, session2, iBinder2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfb */
    public SessionStartRequest[] newArray(int i) {
        return new SessionStartRequest[i];
    }
}
