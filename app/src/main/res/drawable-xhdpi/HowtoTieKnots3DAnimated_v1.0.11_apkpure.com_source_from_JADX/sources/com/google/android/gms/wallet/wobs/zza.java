package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class zza implements Creator<CommonWalletObject> {
    static void zza(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, commonWalletObject.getVersionCode());
        zzb.zza(parcel, 2, commonWalletObject.zzhL, false);
        zzb.zza(parcel, 3, commonWalletObject.zzaWP, false);
        zzb.zza(parcel, 4, commonWalletObject.name, false);
        zzb.zza(parcel, 5, commonWalletObject.zzaWJ, false);
        zzb.zza(parcel, 6, commonWalletObject.zzaWL, false);
        zzb.zza(parcel, 7, commonWalletObject.zzaWM, false);
        zzb.zza(parcel, 8, commonWalletObject.zzaWN, false);
        zzb.zza(parcel, 9, commonWalletObject.zzaWO, false);
        zzb.zzc(parcel, 10, commonWalletObject.state);
        zzb.zzc(parcel, 11, commonWalletObject.zzaWQ, false);
        zzb.zza(parcel, 12, (Parcelable) commonWalletObject.zzaWR, i, false);
        zzb.zzc(parcel, 13, commonWalletObject.zzaWS, false);
        zzb.zza(parcel, 14, commonWalletObject.zzaWT, false);
        zzb.zza(parcel, 15, commonWalletObject.zzaWU, false);
        zzb.zza(parcel, 17, commonWalletObject.zzaWW);
        zzb.zzc(parcel, 16, commonWalletObject.zzaWV, false);
        zzb.zzc(parcel, 19, commonWalletObject.zzaWY, false);
        zzb.zzc(parcel, 18, commonWalletObject.zzaWX, false);
        zzb.zzc(parcel, 20, commonWalletObject.zzaWZ, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzhc */
    public CommonWalletObject createFromParcel(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        ArrayList zzpM = zzli.zzpM();
        TimeInterval timeInterval = null;
        ArrayList zzpM2 = zzli.zzpM();
        String str9 = null;
        String str10 = null;
        ArrayList zzpM3 = zzli.zzpM();
        boolean z = false;
        ArrayList zzpM4 = zzli.zzpM();
        ArrayList zzpM5 = zzli.zzpM();
        ArrayList zzpM6 = zzli.zzpM();
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 10:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case 11:
                    zzpM = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, WalletObjectMessage.CREATOR);
                    break;
                case 12:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, TimeInterval.CREATOR);
                    break;
                case 13:
                    zzpM2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 15:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case 16:
                    zzpM3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, LabelValueRow.CREATOR);
                    break;
                case 17:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                case 18:
                    zzpM4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, UriData.CREATOR);
                    break;
                case 19:
                    zzpM5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, TextModuleData.CREATOR);
                    break;
                case 20:
                    zzpM6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, UriData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, zzpM, timeInterval, zzpM2, str9, str10, zzpM3, z, zzpM4, zzpM5, zzpM6);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzkk */
    public CommonWalletObject[] newArray(int i) {
        return new CommonWalletObject[i];
    }
}
