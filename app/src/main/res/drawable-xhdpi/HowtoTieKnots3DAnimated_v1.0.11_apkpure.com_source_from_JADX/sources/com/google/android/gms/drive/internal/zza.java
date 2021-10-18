package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

public class zza implements Creator<AddEventListenerRequest> {
    static void zza(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, addEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) addEventListenerRequest.zzags, i, false);
        zzb.zzc(parcel, 3, addEventListenerRequest.zzafk);
        zzb.zza(parcel, 4, (Parcelable) addEventListenerRequest.zzahn, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaK */
    public AddEventListenerRequest createFromParcel(Parcel parcel) {
        ChangesAvailableOptions changesAvailableOptions;
        int i;
        DriveId driveId;
        int i2;
        ChangesAvailableOptions changesAvailableOptions2 = null;
        int i3 = 0;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        DriveId driveId2 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case 1:
                    ChangesAvailableOptions changesAvailableOptions3 = changesAvailableOptions2;
                    i = i3;
                    driveId = driveId2;
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    changesAvailableOptions = changesAvailableOptions3;
                    break;
                case 2:
                    i2 = i4;
                    int i5 = i3;
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, DriveId.CREATOR);
                    changesAvailableOptions = changesAvailableOptions2;
                    i = i5;
                    break;
                case 3:
                    driveId = driveId2;
                    i2 = i4;
                    ChangesAvailableOptions changesAvailableOptions4 = changesAvailableOptions2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    changesAvailableOptions = changesAvailableOptions4;
                    break;
                case 4:
                    changesAvailableOptions = (ChangesAvailableOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, ChangesAvailableOptions.CREATOR);
                    i = i3;
                    driveId = driveId2;
                    i2 = i4;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    changesAvailableOptions = changesAvailableOptions2;
                    i = i3;
                    driveId = driveId2;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            driveId2 = driveId;
            i3 = i;
            changesAvailableOptions2 = changesAvailableOptions;
        }
        if (parcel.dataPosition() == zzaj) {
            return new AddEventListenerRequest(i4, driveId2, i3, changesAvailableOptions2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzct */
    public AddEventListenerRequest[] newArray(int i) {
        return new AddEventListenerRequest[i];
    }
}
