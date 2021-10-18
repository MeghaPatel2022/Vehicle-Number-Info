package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<LogEvent> {
    static void zza(LogEvent logEvent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, logEvent.versionCode);
        zzb.zza(parcel, 2, logEvent.zzaKG);
        zzb.zza(parcel, 3, logEvent.tag, false);
        zzb.zza(parcel, 4, logEvent.zzaKI, false);
        zzb.zza(parcel, 5, logEvent.zzaKJ, false);
        zzb.zza(parcel, 6, logEvent.zzaKH);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfP */
    public LogEvent createFromParcel(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case 5:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LogEvent(i, j2, j, str, bArr, bundle);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziD */
    public LogEvent[] newArray(int i) {
        return new LogEvent[i];
    }
}
