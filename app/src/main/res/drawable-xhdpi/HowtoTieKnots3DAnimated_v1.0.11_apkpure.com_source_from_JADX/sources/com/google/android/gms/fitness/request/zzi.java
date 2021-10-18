package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Field;
import java.util.List;

public class zzi implements Creator<DataTypeCreateRequest> {
    static void zza(DataTypeCreateRequest dataTypeCreateRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataTypeCreateRequest.getName(), false);
        zzb.zzc(parcel, 1000, dataTypeCreateRequest.getVersionCode());
        zzb.zzc(parcel, 2, dataTypeCreateRequest.getFields(), false);
        zzb.zza(parcel, 3, dataTypeCreateRequest.zzsc(), false);
        zzb.zza(parcel, 4, dataTypeCreateRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcT */
    public DataTypeCreateRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        List list = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzai, Field.CREATOR);
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
            return new DataTypeCreateRequest(i, str2, list, iBinder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeM */
    public DataTypeCreateRequest[] newArray(int i) {
        return new DataTypeCreateRequest[i];
    }
}
