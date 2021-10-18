package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode.Address;
import com.google.android.gms.vision.barcode.Barcode.ContactInfo;
import com.google.android.gms.vision.barcode.Barcode.Email;
import com.google.android.gms.vision.barcode.Barcode.PersonName;
import com.google.android.gms.vision.barcode.Barcode.Phone;

public class zze implements Creator<ContactInfo> {
    static void zza(ContactInfo contactInfo, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, contactInfo.versionCode);
        zzb.zza(parcel, 2, (Parcelable) contactInfo.name, i, false);
        zzb.zza(parcel, 3, contactInfo.organization, false);
        zzb.zza(parcel, 4, contactInfo.title, false);
        zzb.zza(parcel, 5, (T[]) contactInfo.phones, i, false);
        zzb.zza(parcel, 6, (T[]) contactInfo.emails, i, false);
        zzb.zza(parcel, 7, contactInfo.urls, false);
        zzb.zza(parcel, 8, (T[]) contactInfo.addresses, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgq */
    public ContactInfo createFromParcel(Parcel parcel) {
        Address[] addressArr = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String[] strArr = null;
        Email[] emailArr = null;
        Phone[] phoneArr = null;
        String str = null;
        String str2 = null;
        PersonName personName = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    personName = (PersonName) zza.zza(parcel, zzai, (Creator<T>) PersonName.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 5:
                    phoneArr = (Phone[]) zza.zzb(parcel, zzai, Phone.CREATOR);
                    break;
                case 6:
                    emailArr = (Email[]) zza.zzb(parcel, zzai, Email.CREATOR);
                    break;
                case 7:
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case 8:
                    addressArr = (Address[]) zza.zzb(parcel, zzai, Address.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ContactInfo(i, personName, str2, str, phoneArr, emailArr, strArr, addressArr);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzju */
    public ContactInfo[] newArray(int i) {
        return new ContactInfo[i];
    }
}
