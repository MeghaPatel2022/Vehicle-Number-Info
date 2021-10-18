package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<Asset> {
    static void zza(Asset asset, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, asset.mVersionCode);
        zzb.zza(parcel, 2, asset.getData(), false);
        zzb.zza(parcel, 3, asset.getDigest(), false);
        zzb.zza(parcel, 4, (Parcelable) asset.zzaYL, i, false);
        zzb.zza(parcel, 5, (Parcelable) asset.uri, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhl */
    public Asset createFromParcel(Parcel parcel) {
        Uri uri = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkt */
    public Asset[] newArray(int i) {
        return new Asset[i];
    }
}
