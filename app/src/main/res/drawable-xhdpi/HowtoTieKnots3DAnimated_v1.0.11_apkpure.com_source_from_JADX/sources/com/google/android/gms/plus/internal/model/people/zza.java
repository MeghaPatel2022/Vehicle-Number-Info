package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.AgeRangeEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.ImageEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.NameEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.OrganizationsEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.PlacesLivedEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.UrlsEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class zza implements Creator<PersonEntity> {
    static void zza(PersonEntity personEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set<Integer> set = personEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, personEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, personEntity.zzaMR, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, (Parcelable) personEntity.zzaMS, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, personEntity.zzaMT, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, personEntity.zzaMU, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zzc(parcel, 6, personEntity.zzaMV);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, (Parcelable) personEntity.zzaMW, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            zzb.zza(parcel, 8, personEntity.zzaMX, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            zzb.zza(parcel, 9, personEntity.zzahh, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            zzb.zzc(parcel, 12, personEntity.zzsW);
        }
        if (set.contains(Integer.valueOf(14))) {
            zzb.zza(parcel, 14, personEntity.zzwj, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            zzb.zza(parcel, 15, (Parcelable) personEntity.zzaMY, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            zzb.zza(parcel, 16, personEntity.zzaMZ);
        }
        if (set.contains(Integer.valueOf(19))) {
            zzb.zza(parcel, 19, (Parcelable) personEntity.zzaNa, i, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            zzb.zza(parcel, 18, personEntity.zzUc, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            zzb.zzc(parcel, 21, personEntity.zzaNc);
        }
        if (set.contains(Integer.valueOf(20))) {
            zzb.zza(parcel, 20, personEntity.zzaNb, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            zzb.zzc(parcel, 23, personEntity.zzaNe, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            zzb.zzc(parcel, 22, personEntity.zzaNd, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            zzb.zzc(parcel, 25, personEntity.zzaNg);
        }
        if (set.contains(Integer.valueOf(24))) {
            zzb.zzc(parcel, 24, personEntity.zzaNf);
        }
        if (set.contains(Integer.valueOf(27))) {
            zzb.zza(parcel, 27, personEntity.zzF, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            zzb.zza(parcel, 26, personEntity.zzaNh, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            zzb.zza(parcel, 29, personEntity.zzaNj);
        }
        if (set.contains(Integer.valueOf(28))) {
            zzb.zzc(parcel, 28, personEntity.zzaNi, true);
        }
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfV */
    public PersonEntity createFromParcel(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        AgeRangeEntity ageRangeEntity = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        CoverEntity coverEntity = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        ImageEntity imageEntity = null;
        boolean z = false;
        String str7 = null;
        NameEntity nameEntity = null;
        String str8 = null;
        int i4 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        ArrayList arrayList3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    AgeRangeEntity ageRangeEntity2 = (AgeRangeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) AgeRangeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    ageRangeEntity = ageRangeEntity2;
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    CoverEntity coverEntity2 = (CoverEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) CoverEntity.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    coverEntity = coverEntity2;
                    break;
                case 8:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    ImageEntity imageEntity2 = (ImageEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) ImageEntity.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    imageEntity = imageEntity2;
                    break;
                case 16:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case 19:
                    NameEntity nameEntity2 = (NameEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, (Creator<T>) NameEntity.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    nameEntity = nameEntity2;
                    break;
                case 20:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, OrganizationsEntity.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, PlacesLivedEntity.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, UrlsEntity.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PersonEntity(hashSet, i, str, ageRangeEntity, str2, str3, i2, coverEntity, str4, str5, i3, str6, imageEntity, z, str7, nameEntity, str8, i4, arrayList, arrayList2, i5, i6, str9, str10, arrayList3, z2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zziK */
    public PersonEntity[] newArray(int i) {
        return new PersonEntity[i];
    }
}
