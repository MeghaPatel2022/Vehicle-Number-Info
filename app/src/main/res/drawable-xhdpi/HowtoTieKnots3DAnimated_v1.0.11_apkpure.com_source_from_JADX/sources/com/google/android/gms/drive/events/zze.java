package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;

public class zze implements Creator<CompletionEvent> {
    static void zza(CompletionEvent completionEvent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, completionEvent.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) completionEvent.zzags, i, false);
        zzb.zza(parcel, 3, completionEvent.zzQE, false);
        zzb.zza(parcel, 4, (Parcelable) completionEvent.zzahs, i, false);
        zzb.zza(parcel, 5, (Parcelable) completionEvent.zzaht, i, false);
        zzb.zza(parcel, 6, (Parcelable) completionEvent.zzahu, i, false);
        zzb.zzb(parcel, 7, completionEvent.zzahv, false);
        zzb.zzc(parcel, 8, completionEvent.zzxJ);
        zzb.zza(parcel, 9, completionEvent.zzahw, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaH */
    public CompletionEvent createFromParcel(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        List list = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzai, DriveId.CREATOR);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzai, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
                    break;
                case 7:
                    list = zza.zzC(parcel, zzai);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 9:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, list, i, iBinder);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzcp */
    public CompletionEvent[] newArray(int i) {
        return new CompletionEvent[i];
    }
}
