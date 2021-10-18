package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class zzba implements Creator<OnEventResponse> {
    static void zza(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onEventResponse.mVersionCode);
        zzb.zzc(parcel, 2, onEventResponse.zzafk);
        zzb.zza(parcel, 3, (Parcelable) onEventResponse.zzajN, i, false);
        zzb.zza(parcel, 5, (Parcelable) onEventResponse.zzajO, i, false);
        zzb.zza(parcel, 6, (Parcelable) onEventResponse.zzajP, i, false);
        zzb.zza(parcel, 7, (Parcelable) onEventResponse.zzajQ, i, false);
        zzb.zza(parcel, 8, (Parcelable) onEventResponse.zzajR, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzbo */
    public OnEventResponse createFromParcel(Parcel parcel) {
        int i = 0;
        ProgressEvent progressEvent = null;
        int zzaj = zza.zzaj(parcel);
        ChangesAvailableEvent changesAvailableEvent = null;
        QueryResultEventParcelable queryResultEventParcelable = null;
        CompletionEvent completionEvent = null;
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 3:
                    changeEvent = (ChangeEvent) zza.zza(parcel, zzai, ChangeEvent.CREATOR);
                    break;
                case 5:
                    completionEvent = (CompletionEvent) zza.zza(parcel, zzai, CompletionEvent.CREATOR);
                    break;
                case 6:
                    queryResultEventParcelable = (QueryResultEventParcelable) zza.zza(parcel, zzai, (Creator<T>) QueryResultEventParcelable.CREATOR);
                    break;
                case 7:
                    changesAvailableEvent = (ChangesAvailableEvent) zza.zza(parcel, zzai, ChangesAvailableEvent.CREATOR);
                    break;
                case 8:
                    progressEvent = (ProgressEvent) zza.zza(parcel, zzai, ProgressEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OnEventResponse(i2, i, changeEvent, completionEvent, queryResultEventParcelable, changesAvailableEvent, progressEvent);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdc */
    public OnEventResponse[] newArray(int i) {
        return new OnEventResponse[i];
    }
}
