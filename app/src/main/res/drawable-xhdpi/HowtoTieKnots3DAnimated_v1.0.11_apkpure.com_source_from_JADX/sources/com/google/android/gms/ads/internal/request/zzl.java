package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<LargeParcelTeleporter> {
    static void zza(LargeParcelTeleporter largeParcelTeleporter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, largeParcelTeleporter.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) largeParcelTeleporter.zzEo, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzF */
    public LargeParcelTeleporter[] newArray(int i) {
        return new LargeParcelTeleporter[i];
    }

    /* renamed from: zzm */
    public LargeParcelTeleporter createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LargeParcelTeleporter(i, parcelFileDescriptor);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }
}
