package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class zzbk implements Creator<OpenFileIntentSenderRequest> {
    static void zza(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, openFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, openFileIntentSenderRequest.zzagU, false);
        zzb.zza(parcel, 3, openFileIntentSenderRequest.zzagV, false);
        zzb.zza(parcel, 4, (Parcelable) openFileIntentSenderRequest.zzagX, i, false);
        zzb.zza(parcel, 5, (Parcelable) openFileIntentSenderRequest.zzajX, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbx */
    public OpenFileIntentSenderRequest createFromParcel(Parcel parcel) {
        FilterHolder filterHolder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DriveId driveId = null;
        String[] strArr = null;
        String str = null;
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
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case 4:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case 5:
                    filterHolder = (FilterHolder) zza.zza(parcel, zzai, FilterHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId, filterHolder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdl */
    public OpenFileIntentSenderRequest[] newArray(int i) {
        return new OpenFileIntentSenderRequest[i];
    }
}
