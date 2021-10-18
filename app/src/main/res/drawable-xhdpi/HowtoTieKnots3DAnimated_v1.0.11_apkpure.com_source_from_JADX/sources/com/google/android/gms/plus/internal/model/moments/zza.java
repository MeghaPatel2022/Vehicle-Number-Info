package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class zza implements Creator<ItemScopeEntity> {
    static void zza(ItemScopeEntity itemScopeEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set<Integer> set = itemScopeEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, itemScopeEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, (Parcelable) itemScopeEntity.zzaLU, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzb(parcel, 3, itemScopeEntity.zzaLV, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, (Parcelable) itemScopeEntity.zzaLW, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, itemScopeEntity.zzaLX, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, itemScopeEntity.zzaLY, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, itemScopeEntity.zzaLZ, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zzc(parcel, 8, itemScopeEntity.zzaMa, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zzc(parcel, 9, itemScopeEntity.zzaMb);
        }
        if (set.contains(Integer.valueOf(10))) {
            zzb.zzc(parcel, 10, itemScopeEntity.zzaMc, true);
        }
        if (set.contains(Integer.valueOf(11))) {
            zzb.zza(parcel, 11, (Parcelable) itemScopeEntity.zzaMd, i, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zzc(parcel, 12, itemScopeEntity.zzaMe, true);
        }
        if (set.contains(Integer.valueOf(13))) {
            zzb.zza(parcel, 13, itemScopeEntity.zzaMf, true);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zza(parcel, 14, itemScopeEntity.zzaMg, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzb.zza(parcel, 15, (Parcelable) itemScopeEntity.zzaMh, i, true);
        }
        if (set.contains(Integer.valueOf(17))) {
            zzb.zza(parcel, 17, itemScopeEntity.zzaMj, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzb.zza(parcel, 16, itemScopeEntity.zzaMi, true);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzb.zzc(parcel, 19, itemScopeEntity.zzaMk, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzb.zza(parcel, 18, itemScopeEntity.zzsV, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzb.zza(parcel, 21, itemScopeEntity.zzaMm, true);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzb.zza(parcel, 20, itemScopeEntity.zzaMl, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzb.zza(parcel, 23, itemScopeEntity.zzaoB, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzb.zza(parcel, 22, itemScopeEntity.zzaMn, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzb.zza(parcel, 25, itemScopeEntity.zzaMp, true);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzb.zza(parcel, 24, itemScopeEntity.zzaMo, true);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzb.zza(parcel, 27, itemScopeEntity.zzaMr, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzb.zza(parcel, 26, itemScopeEntity.zzaMq, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzb.zza(parcel, 29, (Parcelable) itemScopeEntity.zzaMt, i, true);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzb.zza(parcel, 28, itemScopeEntity.zzaMs, true);
        }
        if (set.contains(Integer.valueOf(31))) {
            zzb.zza(parcel, 31, itemScopeEntity.zzaMv, true);
        }
        if (set.contains(Integer.valueOf(30))) {
            zzb.zza(parcel, 30, itemScopeEntity.zzaMu, true);
        }
        if (set.contains(Integer.valueOf(34))) {
            zzb.zza(parcel, 34, (Parcelable) itemScopeEntity.zzaMx, i, true);
        }
        if (set.contains(Integer.valueOf(32))) {
            zzb.zza(parcel, 32, itemScopeEntity.zzwj, true);
        }
        if (set.contains(Integer.valueOf(33))) {
            zzb.zza(parcel, 33, itemScopeEntity.zzaMw, true);
        }
        if (set.contains(Integer.valueOf(38))) {
            zzb.zza(parcel, 38, itemScopeEntity.zzaBE);
        }
        if (set.contains(Integer.valueOf(39))) {
            zzb.zza(parcel, 39, itemScopeEntity.mName, true);
        }
        if (set.contains(Integer.valueOf(36))) {
            zzb.zza(parcel, 36, itemScopeEntity.zzaBD);
        }
        if (set.contains(Integer.valueOf(37))) {
            zzb.zza(parcel, 37, (Parcelable) itemScopeEntity.zzaMy, i, true);
        }
        if (set.contains(Integer.valueOf(42))) {
            zzb.zza(parcel, 42, itemScopeEntity.zzaMB, true);
        }
        if (set.contains(Integer.valueOf(43))) {
            zzb.zza(parcel, 43, itemScopeEntity.zzaMC, true);
        }
        if (set.contains(Integer.valueOf(40))) {
            zzb.zza(parcel, 40, (Parcelable) itemScopeEntity.zzaMz, i, true);
        }
        if (set.contains(Integer.valueOf(41))) {
            zzb.zzc(parcel, 41, itemScopeEntity.zzaMA, true);
        }
        if (set.contains(Integer.valueOf(46))) {
            zzb.zza(parcel, 46, (Parcelable) itemScopeEntity.zzaMF, i, true);
        }
        if (set.contains(Integer.valueOf(47))) {
            zzb.zza(parcel, 47, itemScopeEntity.zzaMG, true);
        }
        if (set.contains(Integer.valueOf(44))) {
            zzb.zza(parcel, 44, itemScopeEntity.zzaMD, true);
        }
        if (set.contains(Integer.valueOf(45))) {
            zzb.zza(parcel, 45, itemScopeEntity.zzaME, true);
        }
        if (set.contains(Integer.valueOf(51))) {
            zzb.zza(parcel, 51, itemScopeEntity.zzaMK, true);
        }
        if (set.contains(Integer.valueOf(50))) {
            zzb.zza(parcel, 50, (Parcelable) itemScopeEntity.zzaMJ, i, true);
        }
        if (set.contains(Integer.valueOf(49))) {
            zzb.zza(parcel, 49, itemScopeEntity.zzaMI, true);
        }
        if (set.contains(Integer.valueOf(48))) {
            zzb.zza(parcel, 48, itemScopeEntity.zzaMH, true);
        }
        if (set.contains(Integer.valueOf(55))) {
            zzb.zza(parcel, 55, itemScopeEntity.zzaMM, true);
        }
        if (set.contains(Integer.valueOf(54))) {
            zzb.zza(parcel, 54, itemScopeEntity.zzF, true);
        }
        if (set.contains(Integer.valueOf(53))) {
            zzb.zza(parcel, 53, itemScopeEntity.zzFz, true);
        }
        if (set.contains(Integer.valueOf(52))) {
            zzb.zza(parcel, 52, itemScopeEntity.zzaML, true);
        }
        if (set.contains(Integer.valueOf(56))) {
            zzb.zza(parcel, 56, itemScopeEntity.zzaMN, true);
        }
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfT */
    public ItemScopeEntity createFromParcel(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ItemScopeEntity itemScopeEntity = null;
        ArrayList arrayList = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        ArrayList arrayList3 = null;
        ItemScopeEntity itemScopeEntity3 = null;
        ArrayList arrayList4 = null;
        String str4 = null;
        String str5 = null;
        ItemScopeEntity itemScopeEntity4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        ArrayList arrayList5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        ItemScopeEntity itemScopeEntity5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        ItemScopeEntity itemScopeEntity6 = null;
        double d = 0.0d;
        ItemScopeEntity itemScopeEntity7 = null;
        double d2 = 0.0d;
        String str22 = null;
        ItemScopeEntity itemScopeEntity8 = null;
        ArrayList arrayList6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        ItemScopeEntity itemScopeEntity9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        ItemScopeEntity itemScopeEntity10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    ItemScopeEntity itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    itemScopeEntity = itemScopeEntity11;
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzai);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    ItemScopeEntity itemScopeEntity12 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    itemScopeEntity2 = itemScopeEntity12;
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    ItemScopeEntity itemScopeEntity13 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    itemScopeEntity3 = itemScopeEntity13;
                    break;
                case 12:
                    arrayList4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    ItemScopeEntity itemScopeEntity14 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    itemScopeEntity4 = itemScopeEntity14;
                    break;
                case 16:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 17:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case 18:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case 19:
                    arrayList5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case 20:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    str11 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    str12 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    str13 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    str14 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str15 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str16 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    str17 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    ItemScopeEntity itemScopeEntity15 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    itemScopeEntity5 = itemScopeEntity15;
                    break;
                case 30:
                    str18 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case 31:
                    str19 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case 32:
                    str20 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    str21 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case 34:
                    ItemScopeEntity itemScopeEntity16 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    itemScopeEntity6 = itemScopeEntity16;
                    break;
                case 36:
                    d = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzai);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case 37:
                    ItemScopeEntity itemScopeEntity17 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    itemScopeEntity7 = itemScopeEntity17;
                    break;
                case 38:
                    d2 = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzai);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case 39:
                    str22 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case 40:
                    ItemScopeEntity itemScopeEntity18 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    itemScopeEntity8 = itemScopeEntity18;
                    break;
                case 41:
                    arrayList6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case 42:
                    str23 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case 43:
                    str24 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case 44:
                    str25 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case 45:
                    str26 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case 46:
                    ItemScopeEntity itemScopeEntity19 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    itemScopeEntity9 = itemScopeEntity19;
                    break;
                case 47:
                    str27 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case 48:
                    str28 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case 49:
                    str29 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case 50:
                    ItemScopeEntity itemScopeEntity20 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    itemScopeEntity10 = itemScopeEntity20;
                    break;
                case 51:
                    str30 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case 52:
                    str31 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case 53:
                    str32 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case 54:
                    str33 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case 55:
                    str34 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case 56:
                    str35 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ItemScopeEntity(hashSet, i, itemScopeEntity, arrayList, itemScopeEntity2, str, str2, str3, arrayList2, i2, arrayList3, itemScopeEntity3, arrayList4, str4, str5, itemScopeEntity4, str6, str7, str8, arrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, itemScopeEntity5, str18, str19, str20, str21, itemScopeEntity6, d, itemScopeEntity7, d2, str22, itemScopeEntity8, arrayList6, str23, str24, str25, str26, itemScopeEntity9, str27, str28, str29, itemScopeEntity10, str30, str31, str32, str33, str34, str35);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziI */
    public ItemScopeEntity[] newArray(int i) {
        return new ItemScopeEntity[i];
    }
}
