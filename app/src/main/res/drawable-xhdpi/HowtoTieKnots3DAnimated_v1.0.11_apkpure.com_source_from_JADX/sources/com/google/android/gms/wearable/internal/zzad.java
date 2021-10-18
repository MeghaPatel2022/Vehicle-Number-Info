package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Creator<DataItemParcelable> {
    static void zza(DataItemParcelable dataItemParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, dataItemParcelable.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) dataItemParcelable.getUri(), i, false);
        zzb.zza(parcel, 4, dataItemParcelable.zzCr(), false);
        zzb.zza(parcel, 5, dataItemParcelable.getData(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhz */
    public DataItemParcelable createFromParcel(Parcel parcel) {
        byte[] zzr;
        Bundle bundle;
        Uri uri;
        int i;
        byte[] bArr = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        Bundle bundle2 = null;
        Uri uri2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    byte[] bArr2 = bArr;
                    bundle = bundle2;
                    uri = uri2;
                    i = zza.zzg(parcel, zzai);
                    zzr = bArr2;
                    break;
                case 2:
                    i = i2;
                    Bundle bundle3 = bundle2;
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    zzr = bArr;
                    bundle = bundle3;
                    break;
                case 4:
                    uri = uri2;
                    i = i2;
                    byte[] bArr3 = bArr;
                    bundle = zza.zzq(parcel, zzai);
                    zzr = bArr3;
                    break;
                case 5:
                    zzr = zza.zzr(parcel, zzai);
                    bundle = bundle2;
                    uri = uri2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzr = bArr;
                    bundle = bundle2;
                    uri = uri2;
                    i = i2;
                    break;
            }
            i2 = i;
            uri2 = uri;
            bundle2 = bundle;
            bArr = zzr;
        }
        if (parcel.dataPosition() == zzaj) {
            return new DataItemParcelable(i2, uri2, bundle2, bArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkK */
    public DataItemParcelable[] newArray(int i) {
        return new DataItemParcelable[i];
    }
}
