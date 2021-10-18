package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import java.util.ArrayList;

public class zzc implements Creator<FieldMappingDictionary> {
    static void zza(FieldMappingDictionary fieldMappingDictionary, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, fieldMappingDictionary.getVersionCode());
        zzb.zzc(parcel, 2, fieldMappingDictionary.zzpq(), false);
        zzb.zza(parcel, 3, fieldMappingDictionary.zzpr(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzar */
    public FieldMappingDictionary createFromParcel(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzai, Entry.CREATOR);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzbQ */
    public FieldMappingDictionary[] newArray(int i) {
        return new FieldMappingDictionary[i];
    }
}
