package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<DataHolder> {
    static void zza(DataHolder dataHolder, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataHolder.zznU(), false);
        zzb.zzc(parcel, 1000, dataHolder.getVersionCode());
        zzb.zza(parcel, 2, (T[]) dataHolder.zznV(), i, false);
        zzb.zzc(parcel, 3, dataHolder.getStatusCode());
        zzb.zza(parcel, 4, dataHolder.zznP(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaa */
    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzaj = zza.zzaj(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) zza.zzb(parcel, zzai, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() != zzaj) {
            throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.zznT();
        return dataHolder;
    }

    /* renamed from: zzbq */
    public DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
