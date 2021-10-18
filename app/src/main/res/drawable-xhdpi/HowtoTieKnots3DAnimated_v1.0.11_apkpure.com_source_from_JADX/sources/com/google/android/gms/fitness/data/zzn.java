package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<RawDataPoint> {
    static void zza(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, rawDataPoint.zzanB);
        zzb.zzc(parcel, 1000, rawDataPoint.mVersionCode);
        zzb.zza(parcel, 2, rawDataPoint.zzanC);
        zzb.zza(parcel, 3, (T[]) rawDataPoint.zzanD, i, false);
        zzb.zzc(parcel, 4, rawDataPoint.zzaow);
        zzb.zzc(parcel, 5, rawDataPoint.zzaox);
        zzb.zza(parcel, 6, rawDataPoint.zzanF);
        zzb.zza(parcel, 7, rawDataPoint.zzanG);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcE */
    public RawDataPoint createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    valueArr = (Value[]) zza.zzb(parcel, zzai, Value.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 6:
                    j3 = zza.zzi(parcel, zzai);
                    break;
                case 7:
                    j4 = zza.zzi(parcel, zzai);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzew */
    public RawDataPoint[] newArray(int i) {
        return new RawDataPoint[i];
    }
}
