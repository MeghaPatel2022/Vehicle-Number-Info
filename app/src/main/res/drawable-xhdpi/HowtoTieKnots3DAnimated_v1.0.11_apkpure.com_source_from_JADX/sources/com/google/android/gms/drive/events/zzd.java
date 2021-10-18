package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

public class zzd implements Creator<ChangesAvailableOptions> {
    static void zza(ChangesAvailableOptions changesAvailableOptions, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, changesAvailableOptions.mVersionCode);
        zzb.zzc(parcel, 2, changesAvailableOptions.zzaho);
        zzb.zza(parcel, 3, changesAvailableOptions.zzahp);
        zzb.zzc(parcel, 4, changesAvailableOptions.zzahq, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaG */
    public ChangesAvailableOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzai, DriveSpace.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ChangesAvailableOptions(i2, i, z, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzco */
    public ChangesAvailableOptions[] newArray(int i) {
        return new ChangesAvailableOptions[i];
    }
}
