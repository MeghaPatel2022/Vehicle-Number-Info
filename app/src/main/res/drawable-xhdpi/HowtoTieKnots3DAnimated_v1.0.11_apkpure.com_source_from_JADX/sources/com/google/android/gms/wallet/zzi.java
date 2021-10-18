package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<LineItem> {
    static void zza(LineItem lineItem, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, lineItem.getVersionCode());
        zzb.zza(parcel, 2, lineItem.description, false);
        zzb.zza(parcel, 3, lineItem.zzaWE, false);
        zzb.zza(parcel, 4, lineItem.zzaWF, false);
        zzb.zza(parcel, 5, lineItem.zzaWb, false);
        zzb.zzc(parcel, 6, lineItem.zzaWG);
        zzb.zza(parcel, 7, lineItem.zzaWc, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgM */
    public LineItem createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjR */
    public LineItem[] newArray(int i) {
        return new LineItem[i];
    }
}
