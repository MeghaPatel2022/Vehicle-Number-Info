package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<AmsEntityUpdateParcelable> {
    static void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, amsEntityUpdateParcelable.mVersionCode);
        zzb.zza(parcel, 2, amsEntityUpdateParcelable.zzCu());
        zzb.zza(parcel, 3, amsEntityUpdateParcelable.zzCv());
        zzb.zza(parcel, 4, amsEntityUpdateParcelable.getValue(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhq */
    public AmsEntityUpdateParcelable createFromParcel(Parcel parcel) {
        byte b = 0;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        byte b2 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    b2 = zza.zze(parcel, zzai);
                    break;
                case 3:
                    b = zza.zze(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AmsEntityUpdateParcelable(i, b2, b, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzky */
    public AmsEntityUpdateParcelable[] newArray(int i) {
        return new AmsEntityUpdateParcelable[i];
    }
}
