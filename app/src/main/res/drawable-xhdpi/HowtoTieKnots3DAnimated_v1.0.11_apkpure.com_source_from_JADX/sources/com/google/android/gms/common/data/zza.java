package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<BitmapTeleporter> {
    static void zza(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, bitmapTeleporter.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) bitmapTeleporter.zzEo, i, false);
        zzb.zzc(parcel, 3, bitmapTeleporter.zzUS);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzZ */
    public BitmapTeleporter createFromParcel(Parcel parcel) {
        int zzg;
        ParcelFileDescriptor parcelFileDescriptor;
        int i;
        int i2 = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    int i4 = i2;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    zzg = i4;
                    break;
                case 2:
                    i = i3;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    zzg = i2;
                    parcelFileDescriptor = parcelFileDescriptor3;
                    break;
                case 3:
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    zzg = i2;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = i3;
                    break;
            }
            i3 = i;
            parcelFileDescriptor2 = parcelFileDescriptor;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzaj) {
            return new BitmapTeleporter(i3, parcelFileDescriptor2, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzbl */
    public BitmapTeleporter[] newArray(int i) {
        return new BitmapTeleporter[i];
    }
}
