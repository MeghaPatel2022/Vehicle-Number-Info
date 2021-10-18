package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zze implements Creator<PasswordSpecification> {
    static void zza(PasswordSpecification passwordSpecification, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, passwordSpecification.zzRq, false);
        zzb.zzc(parcel, 1000, passwordSpecification.mVersionCode);
        zzb.zzb(parcel, 2, passwordSpecification.zzRr, false);
        zzb.zza(parcel, 3, passwordSpecification.zzRs, false);
        zzb.zzc(parcel, 4, passwordSpecification.zzRt);
        zzb.zzc(parcel, 5, passwordSpecification.zzRu);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzH */
    public PasswordSpecification createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        List list = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    list = zza.zzC(parcel, zzai);
                    break;
                case 3:
                    arrayList = zza.zzB(parcel, zzai);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PasswordSpecification(i3, str, list, arrayList, i2, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzax */
    public PasswordSpecification[] newArray(int i) {
        return new PasswordSpecification[i];
    }
}
