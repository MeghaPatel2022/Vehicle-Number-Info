package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class SnapshotContentsEntityCreator implements Creator<SnapshotContentsEntity> {
    static void zza(SnapshotContentsEntity snapshotContentsEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, (Parcelable) snapshotContentsEntity.zzqh(), i, false);
        zzb.zzc(parcel, 1000, snapshotContentsEntity.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzec */
    public SnapshotContentsEntity createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    contents = (Contents) zza.zza(parcel, zzai, Contents.CREATOR);
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
            return new SnapshotContentsEntity(i, contents);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzgl */
    public SnapshotContentsEntity[] newArray(int i) {
        return new SnapshotContentsEntity[i];
    }
}
