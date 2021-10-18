package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, activityRecognitionResult.zzaBt, false);
        zzb.zzc(parcel, 1000, activityRecognitionResult.getVersionCode());
        zzb.zza(parcel, 2, activityRecognitionResult.zzaBu);
        zzb.zza(parcel, 3, activityRecognitionResult.zzaBv);
        zzb.zzc(parcel, 4, activityRecognitionResult.zzaBw);
        zzb.zzH(parcel, zzak);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        ArrayList arrayList = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzai, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzai);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ActivityRecognitionResult(i2, arrayList, j2, j, i);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
