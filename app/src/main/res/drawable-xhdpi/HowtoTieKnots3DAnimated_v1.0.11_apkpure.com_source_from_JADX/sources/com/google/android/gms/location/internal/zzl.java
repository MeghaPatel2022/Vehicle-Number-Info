package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<LocationRequestUpdateData> {
    static void zza(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, locationRequestUpdateData.zzaCZ);
        zzb.zzc(parcel, 1000, locationRequestUpdateData.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) locationRequestUpdateData.zzaDa, i, false);
        zzb.zza(parcel, 3, locationRequestUpdateData.zzvS(), false);
        zzb.zza(parcel, 4, (Parcelable) locationRequestUpdateData.mPendingIntent, i, false);
        zzb.zza(parcel, 5, locationRequestUpdateData.zzvT(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzex */
    public LocationRequestUpdateData createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 1;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        LocationRequestInternal locationRequestInternal = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    locationRequestInternal = (LocationRequestInternal) zza.zza(parcel, zzai, (Creator<T>) LocationRequestInternal.CREATOR);
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder = zza.zzp(parcel, zzai);
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
            return new LocationRequestUpdateData(i, i2, locationRequestInternal, iBinder2, pendingIntent, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgS */
    public LocationRequestUpdateData[] newArray(int i) {
        return new LocationRequestUpdateData[i];
    }
}
