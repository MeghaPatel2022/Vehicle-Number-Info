package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.vision.barcode.Barcode.CalendarEvent;
import com.google.android.gms.vision.barcode.Barcode.ContactInfo;
import com.google.android.gms.vision.barcode.Barcode.DriverLicense;
import com.google.android.gms.vision.barcode.Barcode.Email;
import com.google.android.gms.vision.barcode.Barcode.GeoPoint;
import com.google.android.gms.vision.barcode.Barcode.Phone;
import com.google.android.gms.vision.barcode.Barcode.Sms;
import com.google.android.gms.vision.barcode.Barcode.UrlBookmark;
import com.google.android.gms.vision.barcode.Barcode.WiFi;

public class zzb implements Creator<Barcode> {
    static void zza(Barcode barcode, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, barcode.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, barcode.format);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, barcode.rawValue, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, barcode.displayValue, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, barcode.valueFormat);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (T[]) barcode.cornerPoints, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) barcode.email, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) barcode.phone, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable) barcode.sms, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, (Parcelable) barcode.wifi, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, (Parcelable) barcode.url, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, (Parcelable) barcode.geoPoint, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, (Parcelable) barcode.calendarEvent, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, (Parcelable) barcode.contactInfo, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, (Parcelable) barcode.driverLicense, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzgn */
    public Barcode createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        int i3 = 0;
        Point[] pointArr = null;
        Email email = null;
        Phone phone = null;
        Sms sms = null;
        WiFi wiFi = null;
        UrlBookmark urlBookmark = null;
        GeoPoint geoPoint = null;
        CalendarEvent calendarEvent = null;
        ContactInfo contactInfo = null;
        DriverLicense driverLicense = null;
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
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case 6:
                    pointArr = (Point[]) zza.zzb(parcel, zzai, Point.CREATOR);
                    break;
                case 7:
                    email = (Email) zza.zza(parcel, zzai, (Creator<T>) Email.CREATOR);
                    break;
                case 8:
                    phone = (Phone) zza.zza(parcel, zzai, (Creator<T>) Phone.CREATOR);
                    break;
                case 9:
                    sms = (Sms) zza.zza(parcel, zzai, (Creator<T>) Sms.CREATOR);
                    break;
                case 10:
                    wiFi = (WiFi) zza.zza(parcel, zzai, (Creator<T>) WiFi.CREATOR);
                    break;
                case 11:
                    urlBookmark = (UrlBookmark) zza.zza(parcel, zzai, (Creator<T>) UrlBookmark.CREATOR);
                    break;
                case 12:
                    geoPoint = (GeoPoint) zza.zza(parcel, zzai, (Creator<T>) GeoPoint.CREATOR);
                    break;
                case 13:
                    calendarEvent = (CalendarEvent) zza.zza(parcel, zzai, (Creator<T>) CalendarEvent.CREATOR);
                    break;
                case 14:
                    contactInfo = (ContactInfo) zza.zza(parcel, zzai, (Creator<T>) ContactInfo.CREATOR);
                    break;
                case 15:
                    driverLicense = (DriverLicense) zza.zza(parcel, zzai, (Creator<T>) DriverLicense.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Barcode(i, i2, str, str2, i3, pointArr, email, phone, sms, wiFi, urlBookmark, geoPoint, calendarEvent, contactInfo, driverLicense);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzjr */
    public Barcode[] newArray(int i) {
        return new Barcode[i];
    }
}
