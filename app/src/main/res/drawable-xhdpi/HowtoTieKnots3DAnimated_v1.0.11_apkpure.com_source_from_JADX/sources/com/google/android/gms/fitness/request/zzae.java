package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class zzae implements Creator<UnsubscribeRequest> {
    static void zza(UnsubscribeRequest unsubscribeRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) unsubscribeRequest.getDataType(), i, false);
        zzb.zzc(parcel, 1000, unsubscribeRequest.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) unsubscribeRequest.getDataSource(), i, false);
        zzb.zza(parcel, 3, unsubscribeRequest.zzsc(), false);
        zzb.zza(parcel, 4, unsubscribeRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdo */
    public UnsubscribeRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        DataSource dataSource = null;
        DataType dataType = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    dataType = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    break;
                case 2:
                    dataSource = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
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
            return new UnsubscribeRequest(i, dataType, dataSource, iBinder, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfi */
    public UnsubscribeRequest[] newArray(int i) {
        return new UnsubscribeRequest[i];
    }
}
