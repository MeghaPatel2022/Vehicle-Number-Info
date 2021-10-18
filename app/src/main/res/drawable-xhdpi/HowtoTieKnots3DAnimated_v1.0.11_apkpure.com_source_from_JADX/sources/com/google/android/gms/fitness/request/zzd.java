package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

public class zzd implements Creator<DataDeleteRequest> {
    static void zza(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataDeleteRequest.zzkH());
        zzb.zzc(parcel, 1000, dataDeleteRequest.getVersionCode());
        zzb.zza(parcel, 2, dataDeleteRequest.zzrw());
        zzb.zzc(parcel, 3, dataDeleteRequest.getDataSources(), false);
        zzb.zzc(parcel, 4, dataDeleteRequest.getDataTypes(), false);
        zzb.zzc(parcel, 5, dataDeleteRequest.getSessions(), false);
        zzb.zza(parcel, 6, dataDeleteRequest.zzsd());
        zzb.zza(parcel, 7, dataDeleteRequest.zzse());
        zzb.zza(parcel, 8, dataDeleteRequest.zzsc(), false);
        zzb.zza(parcel, 9, dataDeleteRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcO */
    public DataDeleteRequest createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case 4:
                    arrayList2 = zza.zzc(parcel, zzai, DataType.CREATOR);
                    break;
                case 5:
                    arrayList3 = zza.zzc(parcel, zzai, Session.CREATOR);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 7:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 8:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 9:
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
            return new DataDeleteRequest(i, j, j2, arrayList, arrayList2, arrayList3, z, z2, iBinder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeH */
    public DataDeleteRequest[] newArray(int i) {
        return new DataDeleteRequest[i];
    }
}
