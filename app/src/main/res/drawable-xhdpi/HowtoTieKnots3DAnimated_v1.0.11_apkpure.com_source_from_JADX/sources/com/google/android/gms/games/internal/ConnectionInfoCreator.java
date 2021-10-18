package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ConnectionInfoCreator implements Creator<ConnectionInfo> {
    static void zza(ConnectionInfo connectionInfo, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, connectionInfo.zztD(), false);
        zzb.zzc(parcel, 1000, connectionInfo.getVersionCode());
        zzb.zzc(parcel, 2, connectionInfo.zztE());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzdN */
    public ConnectionInfo createFromParcel(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzai);
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
            return new ConnectionInfo(i2, str, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzfL */
    public ConnectionInfo[] newArray(int i) {
        return new ConnectionInfo[i];
    }
}
