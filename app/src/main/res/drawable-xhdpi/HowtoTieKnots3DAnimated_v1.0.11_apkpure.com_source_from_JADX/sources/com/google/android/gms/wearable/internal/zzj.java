package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzj implements Creator<CapabilityInfoParcelable> {
    static void zza(CapabilityInfoParcelable capabilityInfoParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, capabilityInfoParcelable.mVersionCode);
        zzb.zza(parcel, 2, capabilityInfoParcelable.getName(), false);
        zzb.zzc(parcel, 3, capabilityInfoParcelable.zzCC(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhs */
    public CapabilityInfoParcelable createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzai, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CapabilityInfoParcelable(i, str, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkA */
    public CapabilityInfoParcelable[] newArray(int i) {
        return new CapabilityInfoParcelable[i];
    }
}
