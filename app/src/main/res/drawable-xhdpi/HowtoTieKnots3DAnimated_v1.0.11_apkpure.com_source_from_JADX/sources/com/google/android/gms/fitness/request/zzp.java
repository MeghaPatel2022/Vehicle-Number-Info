package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzp implements Creator<ListSubscriptionsRequest> {
    static void zza(ListSubscriptionsRequest listSubscriptionsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) listSubscriptionsRequest.getDataType(), i, false);
        zzb.zzc(parcel, 1000, listSubscriptionsRequest.getVersionCode());
        zzb.zza(parcel, 2, listSubscriptionsRequest.zzsc(), false);
        zzb.zza(parcel, 3, listSubscriptionsRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcZ */
    public ListSubscriptionsRequest createFromParcel(Parcel parcel) {
        String zzo;
        IBinder iBinder;
        DataType dataType;
        int i;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        IBinder iBinder2 = null;
        DataType dataType2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    IBinder iBinder3 = iBinder2;
                    dataType = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    zzo = str;
                    iBinder = iBinder3;
                    break;
                case 2:
                    dataType = dataType2;
                    i = i2;
                    String str2 = str;
                    iBinder = zza.zzp(parcel, zzai);
                    zzo = str2;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzai);
                    iBinder = iBinder2;
                    dataType = dataType2;
                    i = i2;
                    break;
                case 1000:
                    String str3 = str;
                    iBinder = iBinder2;
                    dataType = dataType2;
                    i = zza.zzg(parcel, zzai);
                    zzo = str3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzo = str;
                    iBinder = iBinder2;
                    dataType = dataType2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataType2 = dataType;
            iBinder2 = iBinder;
            str = zzo;
        }
        if (parcel.dataPosition() == zzaj) {
            return new ListSubscriptionsRequest(i2, dataType2, iBinder2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeS */
    public ListSubscriptionsRequest[] newArray(int i) {
        return new ListSubscriptionsRequest[i];
    }
}
