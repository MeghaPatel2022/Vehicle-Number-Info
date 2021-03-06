package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode.CalendarDateTime;

public class zzc implements Creator<CalendarDateTime> {
    static void zza(CalendarDateTime calendarDateTime, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, calendarDateTime.versionCode);
        zzb.zzc(parcel, 2, calendarDateTime.year);
        zzb.zzc(parcel, 3, calendarDateTime.month);
        zzb.zzc(parcel, 4, calendarDateTime.day);
        zzb.zzc(parcel, 5, calendarDateTime.hours);
        zzb.zzc(parcel, 6, calendarDateTime.minutes);
        zzb.zzc(parcel, 7, calendarDateTime.seconds);
        zzb.zza(parcel, 8, calendarDateTime.isUtc);
        zzb.zza(parcel, 9, calendarDateTime.rawValue, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgo */
    public CalendarDateTime createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i7 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i6 = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    i5 = zza.zzg(parcel, zzai);
                    break;
                case 4:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CalendarDateTime(i7, i6, i5, i4, i3, i2, i, z, str);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjs */
    public CalendarDateTime[] newArray(int i) {
        return new CalendarDateTime[i];
    }
}
