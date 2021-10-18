package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode.DriverLicense;

public class zzf implements Creator<DriverLicense> {
    static void zza(DriverLicense driverLicense, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, driverLicense.versionCode);
        zzb.zza(parcel, 2, driverLicense.documentType, false);
        zzb.zza(parcel, 3, driverLicense.firstName, false);
        zzb.zza(parcel, 4, driverLicense.middleName, false);
        zzb.zza(parcel, 5, driverLicense.lastName, false);
        zzb.zza(parcel, 6, driverLicense.gender, false);
        zzb.zza(parcel, 7, driverLicense.addressStreet, false);
        zzb.zza(parcel, 8, driverLicense.addressCity, false);
        zzb.zza(parcel, 9, driverLicense.addressState, false);
        zzb.zza(parcel, 10, driverLicense.addressZip, false);
        zzb.zza(parcel, 11, driverLicense.licenseNumber, false);
        zzb.zza(parcel, 12, driverLicense.issueDate, false);
        zzb.zza(parcel, 13, driverLicense.expiryDate, false);
        zzb.zza(parcel, 14, driverLicense.birthDate, false);
        zzb.zza(parcel, 15, driverLicense.issuingCountry, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgr */
    public DriverLicense createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    str7 = zza.zzo(parcel, zzai);
                    break;
                case 9:
                    str8 = zza.zzo(parcel, zzai);
                    break;
                case 10:
                    str9 = zza.zzo(parcel, zzai);
                    break;
                case 11:
                    str10 = zza.zzo(parcel, zzai);
                    break;
                case 12:
                    str11 = zza.zzo(parcel, zzai);
                    break;
                case 13:
                    str12 = zza.zzo(parcel, zzai);
                    break;
                case 14:
                    str13 = zza.zzo(parcel, zzai);
                    break;
                case 15:
                    str14 = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DriverLicense(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjv */
    public DriverLicense[] newArray(int i) {
        return new DriverLicense[i];
    }
}
