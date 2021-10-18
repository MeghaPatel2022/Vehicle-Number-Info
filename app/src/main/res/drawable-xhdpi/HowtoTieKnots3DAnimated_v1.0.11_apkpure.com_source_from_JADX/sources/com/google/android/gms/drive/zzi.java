package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzi implements Creator<RealtimeDocumentSyncRequest> {
    static void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, realtimeDocumentSyncRequest.mVersionCode);
        zzb.zzb(parcel, 2, realtimeDocumentSyncRequest.zzahe, false);
        zzb.zzb(parcel, 3, realtimeDocumentSyncRequest.zzahf, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzaC */
    public RealtimeDocumentSyncRequest createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    list = zza.zzC(parcel, zzai);
                    break;
                case 3:
                    arrayList = zza.zzC(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new RealtimeDocumentSyncRequest(i, list, arrayList);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzck */
    public RealtimeDocumentSyncRequest[] newArray(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }
}
