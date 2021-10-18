package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<SharedContent> {
    static void zza(SharedContent sharedContent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, sharedContent.getVersionCode());
        zzb.zza(parcel, 3, sharedContent.getUri(), false);
        zzb.zza(parcel, 8, (T[]) sharedContent.zzyt(), i, false);
        zzb.zza(parcel, 9, (T[]) sharedContent.zzyu(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzfJ */
    public SharedContent createFromParcel(Parcel parcel) {
        LocalContent[] localContentArr;
        ViewableItem[] viewableItemArr;
        String str;
        int i;
        LocalContent[] localContentArr2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        ViewableItem[] viewableItemArr2 = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    LocalContent[] localContentArr3 = localContentArr2;
                    viewableItemArr = viewableItemArr2;
                    str = str2;
                    i = zza.zzg(parcel, zzai);
                    localContentArr = localContentArr3;
                    break;
                case 3:
                    i = i2;
                    ViewableItem[] viewableItemArr3 = viewableItemArr2;
                    str = zza.zzo(parcel, zzai);
                    localContentArr = localContentArr2;
                    viewableItemArr = viewableItemArr3;
                    break;
                case 8:
                    str = str2;
                    i = i2;
                    LocalContent[] localContentArr4 = localContentArr2;
                    viewableItemArr = (ViewableItem[]) zza.zzb(parcel, zzai, ViewableItem.CREATOR);
                    localContentArr = localContentArr4;
                    break;
                case 9:
                    localContentArr = (LocalContent[]) zza.zzb(parcel, zzai, LocalContent.CREATOR);
                    viewableItemArr = viewableItemArr2;
                    str = str2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    localContentArr = localContentArr2;
                    viewableItemArr = viewableItemArr2;
                    str = str2;
                    i = i2;
                    break;
            }
            i2 = i;
            str2 = str;
            viewableItemArr2 = viewableItemArr;
            localContentArr2 = localContentArr;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SharedContent(i2, str2, viewableItemArr2, localContentArr2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzix */
    public SharedContent[] newArray(int i) {
        return new SharedContent[i];
    }
}
