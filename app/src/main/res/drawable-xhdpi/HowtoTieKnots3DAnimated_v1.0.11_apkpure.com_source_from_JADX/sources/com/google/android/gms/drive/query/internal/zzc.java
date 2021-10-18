package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<FieldWithSortOrder> {
    static void zza(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1000, fieldWithSortOrder.mVersionCode);
        zzb.zza(parcel, 1, fieldWithSortOrder.zzakc, false);
        zzb.zza(parcel, 2, fieldWithSortOrder.zzaly);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbT */
    public FieldWithSortOrder createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzai);
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
            return new FieldWithSortOrder(i, str, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdH */
    public FieldWithSortOrder[] newArray(int i) {
        return new FieldWithSortOrder[i];
    }
}
