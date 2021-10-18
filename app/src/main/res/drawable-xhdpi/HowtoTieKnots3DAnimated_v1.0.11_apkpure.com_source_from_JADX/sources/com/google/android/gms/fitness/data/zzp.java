package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Creator<Session> {
    static void zza(Session session, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, session.zzkH());
        zzb.zzc(parcel, 1000, session.getVersionCode());
        zzb.zza(parcel, 2, session.zzrw());
        zzb.zza(parcel, 3, session.getName(), false);
        zzb.zza(parcel, 4, session.getIdentifier(), false);
        zzb.zza(parcel, 5, session.getDescription(), false);
        zzb.zzc(parcel, 7, session.zzru());
        zzb.zza(parcel, 8, (Parcelable) session.zzrF(), i, false);
        zzb.zza(parcel, 9, session.zzrN(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcG */
    public Session createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        Long l = null;
        int zzaj = zza.zzaj(parcel);
        Application application = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 8:
                    application = (Application) zza.zza(parcel, zzai, Application.CREATOR);
                    break;
                case 9:
                    l = zza.zzj(parcel, zzai);
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
            return new Session(i2, j2, j, str3, str2, str, i, application, l);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzez */
    public Session[] newArray(int i) {
        return new Session[i];
    }
}
