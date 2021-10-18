package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzq implements Creator<ReadRawRequest> {
    static void zza(ReadRawRequest readRawRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, readRawRequest.zzsc(), false);
        zzb.zzc(parcel, 1000, readRawRequest.getVersionCode());
        zzb.zza(parcel, 2, readRawRequest.getPackageName(), false);
        zzb.zzc(parcel, 3, readRawRequest.zzsn(), false);
        zzb.zza(parcel, 4, readRawRequest.zzsi());
        zzb.zza(parcel, 5, readRawRequest.zzsh());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzda */
    public ReadRawRequest createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        boolean z2 = false;
        String str = null;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzai, DataSourceQueryParams.CREATOR);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzai);
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
            return new ReadRawRequest(i, iBinder, str, arrayList, z2, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeT */
    public ReadRawRequest[] newArray(int i) {
        return new ReadRawRequest[i];
    }
}
