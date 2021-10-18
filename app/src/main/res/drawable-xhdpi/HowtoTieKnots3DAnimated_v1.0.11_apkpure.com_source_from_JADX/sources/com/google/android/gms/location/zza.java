package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

public class zza implements Creator<GeofencingRequest> {
    static void zza(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, geofencingRequest.zzvH(), false);
        zzb.zzc(parcel, 1000, geofencingRequest.getVersionCode());
        zzb.zzc(parcel, 2, geofencingRequest.getInitialTrigger());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeo */
    public GeofencingRequest createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        ArrayList arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ParcelableGeofence.CREATOR);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GeofencingRequest(i2, (List<ParcelableGeofence>) arrayList, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgE */
    public GeofencingRequest[] newArray(int i) {
        return new GeofencingRequest[i];
    }
}
