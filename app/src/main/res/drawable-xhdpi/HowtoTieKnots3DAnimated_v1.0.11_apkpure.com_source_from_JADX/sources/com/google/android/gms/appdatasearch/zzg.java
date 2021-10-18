package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<Response> {
    static void zza(Response response, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, response.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) response.zzPv, i, false);
        zzb.zzc(parcel, 2, response.zzPw, false);
        zzb.zza(parcel, 3, response.zzPx, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzai */
    public Response[] newArray(int i) {
        return new Response[i];
    }

    /* renamed from: zzx */
    public Response createFromParcel(Parcel parcel) {
        String[] zzA;
        List list;
        Status status;
        int i;
        String[] strArr = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        List list2 = null;
        Status status2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    List list3 = list2;
                    status = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    zzA = strArr;
                    list = list3;
                    break;
                case 2:
                    status = status2;
                    i = i2;
                    String[] strArr2 = strArr;
                    list = zza.zzc(parcel, zzai, UsageInfo.CREATOR);
                    zzA = strArr2;
                    break;
                case 3:
                    zzA = zza.zzA(parcel, zzai);
                    list = list2;
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    String[] strArr3 = strArr;
                    list = list2;
                    status = status2;
                    i = zza.zzg(parcel, zzai);
                    zzA = strArr3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzA = strArr;
                    list = list2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            list2 = list;
            strArr = zzA;
        }
        if (parcel.dataPosition() == zzaj) {
            return new Response(i2, status2, list2, strArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }
}
