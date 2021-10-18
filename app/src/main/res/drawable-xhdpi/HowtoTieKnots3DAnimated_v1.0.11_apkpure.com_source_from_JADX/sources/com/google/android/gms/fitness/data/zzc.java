package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Creator<Bucket> {
    static void zza(Bucket bucket, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, bucket.zzkH());
        zzb.zzc(parcel, 1000, bucket.getVersionCode());
        zzb.zza(parcel, 2, bucket.zzrw());
        zzb.zza(parcel, 3, (Parcelable) bucket.getSession(), i, false);
        zzb.zzc(parcel, 4, bucket.zzru());
        zzb.zzc(parcel, 5, bucket.getDataSets(), false);
        zzb.zzc(parcel, 6, bucket.getBucketType());
        zzb.zza(parcel, 7, bucket.zzrv());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcv */
    public Bucket createFromParcel(Parcel parcel) {
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
                    arrayList = zza.zzc(parcel, zzai, DataSet.CREATOR);
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
            return new Bucket(i3, j2, j, session, i2, arrayList, i, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzem */
    public Bucket[] newArray(int i) {
        return new Bucket[i];
    }
}
