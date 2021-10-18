package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Subscription;
import java.util.List;

public class zzh implements Creator<ListSubscriptionsResult> {
    static void zza(ListSubscriptionsResult listSubscriptionsResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, listSubscriptionsResult.getSubscriptions(), false);
        zzb.zzc(parcel, 1000, listSubscriptionsResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) listSubscriptionsResult.getStatus(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdw */
    public ListSubscriptionsResult createFromParcel(Parcel parcel) {
        Status status = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    list = zza.zzc(parcel, zzai, Subscription.CREATOR);
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzai, Status.CREATOR);
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
            return new ListSubscriptionsResult(i, list, status);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfq */
    public ListSubscriptionsResult[] newArray(int i) {
        return new ListSubscriptionsResult[i];
    }
}
