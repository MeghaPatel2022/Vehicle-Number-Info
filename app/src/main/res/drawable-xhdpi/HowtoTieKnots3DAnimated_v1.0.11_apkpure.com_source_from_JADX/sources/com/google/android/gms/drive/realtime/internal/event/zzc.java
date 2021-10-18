package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Creator<ParcelableEvent> {
    static void zza(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, parcelableEvent.mVersionCode);
        zzb.zza(parcel, 2, parcelableEvent.zzGY, false);
        zzb.zza(parcel, 3, parcelableEvent.zzGh, false);
        zzb.zzb(parcel, 4, parcelableEvent.zzamh, false);
        zzb.zza(parcel, 5, parcelableEvent.zzami);
        zzb.zza(parcel, 6, parcelableEvent.zzamb, false);
        zzb.zza(parcel, 7, parcelableEvent.zzaml, false);
        zzb.zza(parcel, 8, (Parcelable) parcelableEvent.zzamm, i, false);
        zzb.zza(parcel, 9, (Parcelable) parcelableEvent.zzamn, i, false);
        zzb.zza(parcel, 10, (Parcelable) parcelableEvent.zzamo, i, false);
        zzb.zza(parcel, 11, (Parcelable) parcelableEvent.zzamp, i, false);
        zzb.zza(parcel, 12, (Parcelable) parcelableEvent.zzamq, i, false);
        zzb.zza(parcel, 13, (Parcelable) parcelableEvent.zzamr, i, false);
        zzb.zza(parcel, 14, (Parcelable) parcelableEvent.zzams, i, false);
        zzb.zza(parcel, 15, (Parcelable) parcelableEvent.zzamt, i, false);
        zzb.zza(parcel, 17, parcelableEvent.zzamk);
        zzb.zza(parcel, 16, parcelableEvent.zzamj);
        zzb.zza(parcel, 18, (Parcelable) parcelableEvent.zzamu, i, false);
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzck */
    public ParcelableEvent createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        FieldChangedDetails fieldChangedDetails = null;
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
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case 4:
                    arrayList = zza.zzC(parcel, zzai);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case 7:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case 8:
                    textInsertedDetails = (TextInsertedDetails) zza.zza(parcel, zzai, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    textDeletedDetails = (TextDeletedDetails) zza.zza(parcel, zzai, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    valuesAddedDetails = (ValuesAddedDetails) zza.zza(parcel, zzai, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    valuesRemovedDetails = (ValuesRemovedDetails) zza.zza(parcel, zzai, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    valuesSetDetails = (ValuesSetDetails) zza.zza(parcel, zzai, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    valueChangedDetails = (ValueChangedDetails) zza.zza(parcel, zzai, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    referenceShiftedDetails = (ReferenceShiftedDetails) zza.zza(parcel, zzai, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    objectChangedDetails = (ObjectChangedDetails) zza.zza(parcel, zzai, ObjectChangedDetails.CREATOR);
                    break;
                case 16:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case 17:
                    z3 = zza.zzc(parcel, zzai);
                    break;
                case 18:
                    fieldChangedDetails = (FieldChangedDetails) zza.zza(parcel, zzai, FieldChangedDetails.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ParcelableEvent(i, str, str2, arrayList, z, z2, z3, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails, fieldChangedDetails);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzdZ */
    public ParcelableEvent[] newArray(int i) {
        return new ParcelableEvent[i];
    }
}
