package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzm implements Creator<RawBucket> {
    static void zza(RawBucket rawBucket, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, rawBucket.zzMS);
        zzb.zzc(parcel, 1000, rawBucket.mVersionCode);
        zzb.zza(parcel, 2, rawBucket.zzann);
        zzb.zza(parcel, 3, (Parcelable) rawBucket.zzanp, i, false);
        zzb.zzc(parcel, 4, rawBucket.zzaov);
        zzb.zzc(parcel, 5, rawBucket.zzany, false);
        zzb.zzc(parcel, 6, rawBucket.zzanz);
        zzb.zza(parcel, 7, rawBucket.zzanA);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcD */
    public RawBucket createFromParcel(Parcel parcel) {
        long j = 0;
        ArrayList arrayList = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    session = (Session) zza.zza(parcel, zzai, Session.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    arrayList = zza.zzc(parcel, zzai, RawDataSet.CREATOR);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new RawBucket(i3, j2, j, session, i2, arrayList, i, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzev */
    public RawBucket[] newArray(int i) {
        return new RawBucket[i];
    }
}
