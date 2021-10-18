package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Creator<ParcelableIndexReference> {
    static void zza(ParcelableIndexReference parcelableIndexReference, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, parcelableIndexReference.mVersionCode);
        zzb.zza(parcel, 2, parcelableIndexReference.zzamb, false);
        zzb.zzc(parcel, 3, parcelableIndexReference.mIndex);
        zzb.zza(parcel, 4, parcelableIndexReference.zzamc);
        zzb.zzc(parcel, 5, parcelableIndexReference.zzamd);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzch */
    public ParcelableIndexReference createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ParcelableIndexReference(i3, str, i2, z, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdW */
    public ParcelableIndexReference[] newArray(int i) {
        return new ParcelableIndexReference[i];
    }
}
