package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<LandmarkParcel> {
    static void zza(LandmarkParcel landmarkParcel, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, landmarkParcel.versionCode);
        zzb.zza(parcel, 2, landmarkParcel.f61x);
        zzb.zza(parcel, 3, landmarkParcel.f62y);
        zzb.zzc(parcel, 4, landmarkParcel.type);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgC */
    public LandmarkParcel createFromParcel(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int zzaj = zza.zzaj(parcel);
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    f2 = zza.zzl(parcel, zzai);
                    break;
                case 3:
                    f = zza.zzl(parcel, zzai);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LandmarkParcel(i2, f2, f, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjH */
    public LandmarkParcel[] newArray(int i) {
        return new LandmarkParcel[i];
    }
}
