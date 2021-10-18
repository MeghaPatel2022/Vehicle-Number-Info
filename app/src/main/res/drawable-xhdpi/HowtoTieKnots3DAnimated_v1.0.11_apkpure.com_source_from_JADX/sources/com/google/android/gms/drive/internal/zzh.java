package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzh implements Creator<CloseContentsRequest> {
    static void zza(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, closeContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) closeContentsRequest.zzahR, i, false);
        zzb.zza(parcel, 3, closeContentsRequest.zzahV, false);
        zzb.zzc(parcel, 4, closeContentsRequest.zzahT);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaQ */
    public CloseContentsRequest createFromParcel(Parcel parcel) {
        int zzg;
        Boolean bool;
        Contents contents;
        int i;
        Boolean bool2 = null;
        int i2 = 0;
        int zzaj = zza.zzaj(parcel);
        Contents contents2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    int i4 = i2;
                    bool = bool2;
                    contents = contents2;
                    i = zza.zzg(parcel, zzai);
                    zzg = i4;
                    break;
                case 2:
                    i = i3;
                    Boolean bool3 = bool2;
                    contents = (Contents) zza.zza(parcel, zzai, Contents.CREATOR);
                    zzg = i2;
                    bool = bool3;
                    break;
                case 3:
                    contents = contents2;
                    i = i3;
                    int i5 = i2;
                    bool = zza.zzd(parcel, zzai);
                    zzg = i5;
                    break;
                case 4:
                    zzg = zza.zzg(parcel, zzai);
                    bool = bool2;
                    contents = contents2;
                    i = i3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzg = i2;
                    bool = bool2;
                    contents = contents2;
                    i = i3;
                    break;
            }
            i3 = i;
            contents2 = contents;
            bool2 = bool;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzaj) {
            return new CloseContentsRequest(i3, contents2, bool2, i2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcz */
    public CloseContentsRequest[] newArray(int i) {
        return new CloseContentsRequest[i];
    }
}
