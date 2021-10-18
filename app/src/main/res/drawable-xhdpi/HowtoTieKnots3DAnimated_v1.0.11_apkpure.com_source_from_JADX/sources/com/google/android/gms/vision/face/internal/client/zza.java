package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<FaceParcel> {
    static void zza(FaceParcel faceParcel, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, faceParcel.versionCode);
        zzb.zzc(parcel, 2, faceParcel.f60id);
        zzb.zza(parcel, 3, faceParcel.centerX);
        zzb.zza(parcel, 4, faceParcel.centerY);
        zzb.zza(parcel, 5, faceParcel.width);
        zzb.zza(parcel, 6, faceParcel.height);
        zzb.zza(parcel, 7, faceParcel.zzaVK);
        zzb.zza(parcel, 8, faceParcel.zzaVL);
        zzb.zza(parcel, 9, (T[]) faceParcel.zzaVM, i, false);
        zzb.zza(parcel, 10, faceParcel.zzaVN);
        zzb.zza(parcel, 11, faceParcel.zzaVO);
        zzb.zza(parcel, 12, faceParcel.zzaVP);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgA */
    public FaceParcel createFromParcel(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        LandmarkParcel[] landmarkParcelArr = null;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 3:
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case 4:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case 5:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case 6:
                    f4 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case 7:
                    f5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case 8:
                    f6 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case 9:
                    landmarkParcelArr = (LandmarkParcel[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai, LandmarkParcel.CREATOR);
                    break;
                case 10:
                    f7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case 11:
                    f8 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                case 12:
                    f9 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FaceParcel(i, i2, f, f2, f3, f4, f5, f6, landmarkParcelArr, f7, f8, f9);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjE */
    public FaceParcel[] newArray(int i) {
        return new FaceParcel[i];
    }
}
