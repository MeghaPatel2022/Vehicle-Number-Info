package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C1351zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<GroundOverlayOptions> {
    static void zza(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, groundOverlayOptions.getVersionCode());
        zzb.zza(parcel, 2, groundOverlayOptions.zzxc(), false);
        zzb.zza(parcel, 3, (Parcelable) groundOverlayOptions.getLocation(), i, false);
        zzb.zza(parcel, 4, groundOverlayOptions.getWidth());
        zzb.zza(parcel, 5, groundOverlayOptions.getHeight());
        zzb.zza(parcel, 6, (Parcelable) groundOverlayOptions.getBounds(), i, false);
        zzb.zza(parcel, 7, groundOverlayOptions.getBearing());
        zzb.zza(parcel, 8, groundOverlayOptions.getZIndex());
        zzb.zza(parcel, 9, groundOverlayOptions.isVisible());
        zzb.zza(parcel, 10, groundOverlayOptions.getTransparency());
        zzb.zza(parcel, 11, groundOverlayOptions.getAnchorU());
        zzb.zza(parcel, 12, groundOverlayOptions.getAnchorV());
        zzb.zzH(parcel, zzak);
    }

    /* renamed from: zzeY */
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case 1:
                    i = zza.zzg(parcel, zzai);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case 3:
                    latLng = (LatLng) zza.zza(parcel, zzai, (Creator<T>) LatLng.CREATOR);
                    break;
                case 4:
                    f = zza.zzl(parcel, zzai);
                    break;
                case 5:
                    f2 = zza.zzl(parcel, zzai);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzai, (Creator<T>) LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = zza.zzl(parcel, zzai);
                    break;
                case 8:
                    f4 = zza.zzl(parcel, zzai);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzai);
                    break;
                case 10:
                    f5 = zza.zzl(parcel, zzai);
                    break;
                case 11:
                    f6 = zza.zzl(parcel, zzai);
                    break;
                case 12:
                    f7 = zza.zzl(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C1351zza("Overread allowed size end=" + zzaj, parcel);
    }

    /* renamed from: zzhy */
    public GroundOverlayOptions[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
