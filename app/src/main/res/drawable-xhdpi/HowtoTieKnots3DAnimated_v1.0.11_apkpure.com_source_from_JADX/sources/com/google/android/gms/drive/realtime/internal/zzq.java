package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<ParcelableCollaborator> {
    static void zza(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, parcelableCollaborator.mVersionCode);
        zzb.zza(parcel, 2, parcelableCollaborator.zzalX);
        zzb.zza(parcel, 3, parcelableCollaborator.zzalY);
        zzb.zza(parcel, 4, parcelableCollaborator.zzGY, false);
        zzb.zza(parcel, 5, parcelableCollaborator.zzGh, false);
        zzb.zza(parcel, 6, parcelableCollaborator.zzahh, false);
        zzb.zza(parcel, 7, parcelableCollaborator.zzalZ, false);
        zzb.zza(parcel, 8, parcelableCollaborator.zzama, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzcg */
    public ParcelableCollaborator createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 4:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdV */
    public ParcelableCollaborator[] newArray(int i) {
        return new ParcelableCollaborator[i];
    }
}
