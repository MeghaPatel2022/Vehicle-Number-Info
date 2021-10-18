package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<PlacePhotoResult> {
    static void zza(PlacePhotoResult placePhotoResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) placePhotoResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placePhotoResult.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) placePhotoResult.zzaDG, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeF */
    public PlacePhotoResult createFromParcel(Parcel parcel) {
        BitmapTeleporter bitmapTeleporter;
        Status status;
        int i;
        BitmapTeleporter bitmapTeleporter2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    bitmapTeleporter = bitmapTeleporter2;
                    status = status3;
                    break;
                case 2:
                    bitmapTeleporter = (BitmapTeleporter) zza.zza(parcel, zzai, BitmapTeleporter.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    BitmapTeleporter bitmapTeleporter3 = bitmapTeleporter2;
                    status = status2;
                    i = zza.zzg(parcel, zzai);
                    bitmapTeleporter = bitmapTeleporter3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    bitmapTeleporter = bitmapTeleporter2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            bitmapTeleporter2 = bitmapTeleporter;
        }
        if (parcel.dataPosition() == zzaj) {
            return new PlacePhotoResult(i2, status2, bitmapTeleporter2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhd */
    public PlacePhotoResult[] newArray(int i) {
        return new PlacePhotoResult[i];
    }
}
