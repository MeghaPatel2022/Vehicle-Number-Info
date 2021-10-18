package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzav implements Creator<OnContentsResponse> {
    static void zza(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onContentsResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onContentsResponse.zzaiD, i, false);
        zzb.zza(parcel, 3, onContentsResponse.zzajI);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbj */
    public OnContentsResponse createFromParcel(Parcel parcel) {
        boolean zzc;
        Contents contents;
        int i;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        Contents contents2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    boolean z2 = z;
                    contents = contents2;
                    i = zza.zzg(parcel, zzai);
                    zzc = z2;
                    break;
                case 2:
                    i = i2;
                    Contents contents3 = (Contents) zza.zza(parcel, zzai, Contents.CREATOR);
                    zzc = z;
                    contents = contents3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzai);
                    contents = contents2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = z;
                    contents = contents2;
                    i = i2;
                    break;
            }
            i2 = i;
            contents2 = contents;
            z = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnContentsResponse(i2, contents2, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcX */
    public OnContentsResponse[] newArray(int i) {
        return new OnContentsResponse[i];
    }
}
