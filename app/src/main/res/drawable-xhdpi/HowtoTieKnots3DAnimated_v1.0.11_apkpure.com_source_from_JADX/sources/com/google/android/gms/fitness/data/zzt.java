package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt implements Creator<Value> {
    static void zza(Value value, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, value.getFormat());
        zzb.zzc(parcel, 1000, value.getVersionCode());
        zzb.zza(parcel, 2, value.isSet());
        zzb.zza(parcel, 3, value.zzrM());
        zzb.zza(parcel, 4, value.zzrU(), false);
        zzb.zza(parcel, 5, value.zzrV(), false);
        zzb.zza(parcel, 6, value.zzrW(), false);
        zzb.zza(parcel, 7, value.zzrX(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcJ */
    public Value createFromParcel(Parcel parcel) {
        boolean z = false;
        float[] fArr = null;
        int zzaj = zza.zzaj(parcel);
        float f = 0.0f;
        int[] iArr = null;
        Bundle bundle = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 3:
                    f = zza.zzl(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case 6:
                    iArr = zza.zzu(parcel, zzai);
                    break;
                case 7:
                    fArr = zza.zzx(parcel, zzai);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Value(i2, i, z, f, str, bundle, iArr, fArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzeC */
    public Value[] newArray(int i) {
        return new Value[i];
    }
}
