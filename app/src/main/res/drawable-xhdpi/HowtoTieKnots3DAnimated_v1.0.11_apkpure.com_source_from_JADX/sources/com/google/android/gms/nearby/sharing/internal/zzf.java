package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.List;

public class zzf implements Creator<ProvideContentRequest> {
    static void zza(ProvideContentRequest provideContentRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, provideContentRequest.versionCode);
        zzb.zza(parcel, 2, provideContentRequest.zzaKq, false);
        zzb.zza(parcel, 3, provideContentRequest.zzyx(), false);
        zzb.zzc(parcel, 4, provideContentRequest.zzaKs, false);
        zzb.zza(parcel, 5, provideContentRequest.zzaKt);
        zzb.zza(parcel, 6, provideContentRequest.zzyp(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfL */
    public ProvideContentRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        List list = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    iBinder3 = zza.zzp(parcel, zzai);
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzai, SharedContent.CREATOR);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 6:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ProvideContentRequest(i, iBinder3, iBinder2, list, j, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziz */
    public ProvideContentRequest[] newArray(int i) {
        return new ProvideContentRequest[i];
    }
}
