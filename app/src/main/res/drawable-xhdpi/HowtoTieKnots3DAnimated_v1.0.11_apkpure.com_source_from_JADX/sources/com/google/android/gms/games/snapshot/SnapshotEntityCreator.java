package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
    static void zza(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) snapshotEntity.getMetadata(), i, false);
        zzb.zzc(parcel, 1000, snapshotEntity.getVersionCode());
        zzb.zza(parcel, 3, (Parcelable) snapshotEntity.getSnapshotContents(), i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzed */
    public SnapshotEntity createFromParcel(Parcel parcel) {
        SnapshotContentsEntity snapshotContentsEntity;
        SnapshotMetadata snapshotMetadata;
        int i;
        SnapshotContentsEntity snapshotContentsEntity2 = null;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        SnapshotMetadata snapshotMetadata2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = i2;
                    SnapshotMetadata snapshotMetadata3 = (SnapshotMetadataEntity) zza.zza(parcel, zzai, SnapshotMetadataEntity.CREATOR);
                    snapshotContentsEntity = snapshotContentsEntity2;
                    snapshotMetadata = snapshotMetadata3;
                    break;
                case 3:
                    snapshotContentsEntity = (SnapshotContentsEntity) zza.zza(parcel, zzai, (Creator<T>) SnapshotContentsEntity.CREATOR);
                    snapshotMetadata = snapshotMetadata2;
                    i = i2;
                    break;
                case 1000:
                    SnapshotContentsEntity snapshotContentsEntity3 = snapshotContentsEntity2;
                    snapshotMetadata = snapshotMetadata2;
                    i = zza.zzg(parcel, zzai);
                    snapshotContentsEntity = snapshotContentsEntity3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    snapshotContentsEntity = snapshotContentsEntity2;
                    snapshotMetadata = snapshotMetadata2;
                    i = i2;
                    break;
            }
            i2 = i;
            snapshotMetadata2 = snapshotMetadata;
            snapshotContentsEntity2 = snapshotContentsEntity;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SnapshotEntity(i2, snapshotMetadata2, snapshotContentsEntity2);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgm */
    public SnapshotEntity[] newArray(int i) {
        return new SnapshotEntity[i];
    }
}
