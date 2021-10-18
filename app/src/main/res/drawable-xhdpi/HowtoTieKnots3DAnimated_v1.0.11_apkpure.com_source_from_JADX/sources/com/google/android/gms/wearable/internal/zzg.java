package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<AncsNotificationParcelable> {
    static void zza(AncsNotificationParcelable ancsNotificationParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, ancsNotificationParcelable.mVersionCode);
        zzb.zzc(parcel, 2, ancsNotificationParcelable.getId());
        zzb.zza(parcel, 3, ancsNotificationParcelable.zztW(), false);
        zzb.zza(parcel, 4, ancsNotificationParcelable.zzCw(), false);
        zzb.zza(parcel, 5, ancsNotificationParcelable.zzCx(), false);
        zzb.zza(parcel, 6, ancsNotificationParcelable.getTitle(), false);
        zzb.zza(parcel, 7, ancsNotificationParcelable.zztn(), false);
        zzb.zza(parcel, 8, ancsNotificationParcelable.getDisplayName(), false);
        zzb.zza(parcel, 9, ancsNotificationParcelable.zzCy());
        zzb.zza(parcel, 10, ancsNotificationParcelable.zzCz());
        zzb.zza(parcel, 11, ancsNotificationParcelable.zzCA());
        zzb.zza(parcel, 12, ancsNotificationParcelable.zzCB());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhr */
    public AncsNotificationParcelable createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        byte b = 0;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case 9:
                    b = zza.zze(parcel, zzai);
                    break;
                case 10:
                    b2 = zza.zze(parcel, zzai);
                    break;
                case 11:
                    b3 = zza.zze(parcel, zzai);
                    break;
                case 12:
                    b4 = zza.zze(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AncsNotificationParcelable(i, i2, str, str2, str3, str4, str5, str6, b, b2, b3, b4);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkz */
    public AncsNotificationParcelable[] newArray(int i) {
        return new AncsNotificationParcelable[i];
    }
}
