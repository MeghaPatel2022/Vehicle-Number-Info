package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<PlacePhotoMetadataResult> {
    static void zza(PlacePhotoMetadataResult placePhotoMetadataResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) placePhotoMetadataResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placePhotoMetadataResult.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) placePhotoMetadataResult.zzaDE, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeE */
    public PlacePhotoMetadataResult createFromParcel(Parcel parcel) {
        DataHolder dataHolder;
        Status status;
        int i;
        DataHolder dataHolder2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    dataHolder = dataHolder2;
                    status = status3;
                    break;
                case 2:
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, (Creator<T>) DataHolder.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    DataHolder dataHolder3 = dataHolder2;
                    status = status2;
                    i = zza.zzg(parcel, zzai);
                    dataHolder = dataHolder3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    dataHolder = dataHolder2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            dataHolder2 = dataHolder;
        }
        if (parcel.dataPosition() == zzaj) {
            return new PlacePhotoMetadataResult(i2, status2, dataHolder2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhc */
    public PlacePhotoMetadataResult[] newArray(int i) {
        return new PlacePhotoMetadataResult[i];
    }
}
