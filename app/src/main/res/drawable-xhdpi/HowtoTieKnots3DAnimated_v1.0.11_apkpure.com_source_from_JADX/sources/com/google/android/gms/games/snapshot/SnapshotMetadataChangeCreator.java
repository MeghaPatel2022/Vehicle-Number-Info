package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChangeEntity> {
    static void zza(SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, snapshotMetadataChangeEntity.getDescription(), false);
        zzb.zzc(parcel, 1000, snapshotMetadataChangeEntity.getVersionCode());
        zzb.zza(parcel, 2, snapshotMetadataChangeEntity.getPlayedTimeMillis(), false);
        zzb.zza(parcel, 4, (Parcelable) snapshotMetadataChangeEntity.getCoverImageUri(), i, false);
        zzb.zza(parcel, 5, (Parcelable) snapshotMetadataChangeEntity.zzvc(), i, false);
        zzb.zza(parcel, 6, snapshotMetadataChangeEntity.getProgressValue(), false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzee */
    public SnapshotMetadataChangeEntity createFromParcel(Parcel parcel) {
        Long l = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Uri uri = null;
        BitmapTeleporter bitmapTeleporter = null;
        Long l2 = null;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    l2 = zza.zzj(parcel, zzai);
                    break;
                case 4:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case 5:
                    bitmapTeleporter = (BitmapTeleporter) zza.zza(parcel, zzai, BitmapTeleporter.CREATOR);
                    break;
                case 6:
                    l = zza.zzj(parcel, zzai);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new SnapshotMetadataChangeEntity(i, str, l2, bitmapTeleporter, uri, l);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgn */
    public SnapshotMetadataChangeEntity[] newArray(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }
}
