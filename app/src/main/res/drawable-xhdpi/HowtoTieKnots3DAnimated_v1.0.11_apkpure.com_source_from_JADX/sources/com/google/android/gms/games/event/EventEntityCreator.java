package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public class EventEntityCreator implements Creator<EventEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(EventEntity eventEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, eventEntity.getEventId(), false);
        zzb.zzc(parcel, 1000, eventEntity.getVersionCode());
        zzb.zza(parcel, 2, eventEntity.getName(), false);
        zzb.zza(parcel, 3, eventEntity.getDescription(), false);
        zzb.zza(parcel, 4, (Parcelable) eventEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 5, eventEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 6, (Parcelable) eventEntity.getPlayer(), i, false);
        zzb.zza(parcel, 7, eventEntity.getValue());
        zzb.zza(parcel, 8, eventEntity.getFormattedValue(), false);
        zzb.zza(parcel, 9, eventEntity.isVisible());
        zzb.zzH(parcel, zzak);
    }

    public EventEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        long j = 0;
        Player player = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case 2:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 3:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    uri = (Uri) zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 6:
                    player = (PlayerEntity) zza.zza(parcel, zzai, PlayerEntity.CREATOR);
                    break;
                case 7:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 8:
                    str = zza.zzo(parcel, zzai);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzai);
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
            return new EventEntity(i, str5, str4, str3, uri, str2, player, j, str, z);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    public EventEntity[] newArray(int size) {
        return new EventEntity[size];
    }
}
