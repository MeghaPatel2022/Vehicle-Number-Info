package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;

public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzl CREATOR = new zzl();
    PendingIntent mPendingIntent;
    private final int mVersionCode;
    int zzaCZ;
    LocationRequestInternal zzaDa;
    zzd zzaDb;
    zzc zzaDc;

    LocationRequestUpdateData(int versionCode, int operation, LocationRequestInternal locationRequest, IBinder locationListenerBinder, PendingIntent pendingIntent, IBinder locationCallbackBinder) {
        zzc zzc = null;
        this.mVersionCode = versionCode;
        this.zzaCZ = operation;
        this.zzaDa = locationRequest;
        this.zzaDb = locationListenerBinder == null ? null : zza.zzbX(locationListenerBinder);
        this.mPendingIntent = pendingIntent;
        if (locationCallbackBinder != null) {
            zzc = zzc.zza.zzbW(locationCallbackBinder);
        }
        this.zzaDc = zzc;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, zzc zzc) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, null, zzc.asBinder());
    }

    public static LocationRequestUpdateData zza(zzc zzc) {
        return new LocationRequestUpdateData(1, 2, null, null, null, zzc.asBinder());
    }

    public static LocationRequestUpdateData zzb(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, pendingIntent, null);
    }

    public static LocationRequestUpdateData zzb(LocationRequestInternal locationRequestInternal, zzd zzd) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, zzd.asBinder(), null, null);
    }

    public static LocationRequestUpdateData zzb(zzd zzd) {
        return new LocationRequestUpdateData(1, 2, null, zzd.asBinder(), null, null);
    }

    public static LocationRequestUpdateData zzg(PendingIntent pendingIntent) {
        return new LocationRequestUpdateData(1, 2, null, null, pendingIntent, null);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzl.zza(this, parcel, flags);
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzvS() {
        if (this.zzaDb == null) {
            return null;
        }
        return this.zzaDb.asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzvT() {
        if (this.zzaDc == null) {
            return null;
        }
        return this.zzaDc.asBinder();
    }
}
