package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;

public class zzb implements Creator<SortOrder> {
    static void zza(SortOrder sortOrder, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sortOrder.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, sortOrder.zzalt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, sortOrder.zzalu);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbQ */
    public SortOrder createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzai, FieldWithSortOrder.CREATOR);
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
            return new SortOrder(i, (List<FieldWithSortOrder>) arrayList, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdE */
    public SortOrder[] newArray(int i) {
        return new SortOrder[i];
    }
}
