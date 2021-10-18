package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class zzv implements Creator<SessionReadRequest> {
    static void zza(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, sessionReadRequest.getSessionName(), false);
        zzb.zzc(parcel, 1000, sessionReadRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionReadRequest.getSessionId(), false);
        zzb.zza(parcel, 3, sessionReadRequest.zzkH());
        zzb.zza(parcel, 4, sessionReadRequest.zzrw());
        zzb.zzc(parcel, 5, sessionReadRequest.getDataTypes(), false);
        zzb.zzc(parcel, 6, sessionReadRequest.getDataSources(), false);
        zzb.zza(parcel, 7, sessionReadRequest.zzsw());
        zzb.zza(parcel, 8, sessionReadRequest.zzsh());
        zzb.zzb(parcel, 9, sessionReadRequest.getExcludedPackages(), false);
        zzb.zza(parcel, 10, sessionReadRequest.zzsc(), false);
        zzb.zza(parcel, 11, sessionReadRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdf */
    public SessionReadRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        boolean z = false;
        boolean z2 = false;
        ArrayList arrayList3 = null;
        IBinder iBinder = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 5:
                    arrayList = zza.zzc(parcel, zzai, DataType.CREATOR);
                    break;
                case 6:
                    arrayList2 = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 9:
                    arrayList3 = zza.zzC(parcel, zzai);
                    break;
                case 10:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 11:
                    str3 = zza.zzo(parcel, zzai);
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
            return new SessionReadRequest(i, str, str2, j, j2, arrayList, arrayList2, z, z2, arrayList3, iBinder, str3);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeZ */
    public SessionReadRequest[] newArray(int i) {
        return new SessionReadRequest[i];
    }
}
