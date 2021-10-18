package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

public class zzag implements Creator<GetChangesRequest> {
    static void zza(GetChangesRequest getChangesRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getChangesRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) getChangesRequest.zzajm, i, false);
        zzb.zzc(parcel, 3, getChangesRequest.zzajn);
        zzb.zzc(parcel, 4, getChangesRequest.zzahq, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbb */
    public GetChangesRequest createFromParcel(Parcel parcel) {
        List zzc;
        int i;
        ChangeSequenceNumber changeSequenceNumber;
        int i2;
        List list = null;
        int i3 = 0;
        int zzaj = zza.zzaj(parcel);
        ChangeSequenceNumber changeSequenceNumber2 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    List list2 = list;
                    i = i3;
                    changeSequenceNumber = changeSequenceNumber2;
                    i2 = zza.zzg(parcel, zzai);
                    zzc = list2;
                    break;
                case 2:
                    i2 = i4;
                    int i5 = i3;
                    changeSequenceNumber = (ChangeSequenceNumber) zza.zza(parcel, zzai, ChangeSequenceNumber.CREATOR);
                    zzc = list;
                    i = i5;
                    break;
                case 3:
                    changeSequenceNumber = changeSequenceNumber2;
                    i2 = i4;
                    List list3 = list;
                    i = zza.zzg(parcel, zzai);
                    zzc = list3;
                    break;
                case 4:
                    zzc = zza.zzc(parcel, zzai, DriveSpace.CREATOR);
                    i = i3;
                    changeSequenceNumber = changeSequenceNumber2;
                    i2 = i4;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = list;
                    i = i3;
                    changeSequenceNumber = changeSequenceNumber2;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            changeSequenceNumber2 = changeSequenceNumber;
            i3 = i;
            list = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetChangesRequest(i4, changeSequenceNumber2, i3, list);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcP */
    public GetChangesRequest[] newArray(int i) {
        return new GetChangesRequest[i];
    }
}
