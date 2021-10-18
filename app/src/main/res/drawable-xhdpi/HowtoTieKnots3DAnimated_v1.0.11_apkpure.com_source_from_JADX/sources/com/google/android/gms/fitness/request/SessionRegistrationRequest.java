package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;

public class SessionRegistrationRequest implements SafeParcelable {
    public static final Creator<SessionRegistrationRequest> CREATOR = new zzw();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;
    private final int zzaqz;

    SessionRegistrationRequest(int versionCode, PendingIntent intent, IBinder callback, String packageName, int sessionRegistrationOption) {
        this.mVersionCode = versionCode;
        this.mPendingIntent = intent;
        this.zzapE = callback == null ? null : zza.zzbJ(callback);
        this.zzOZ = packageName;
        this.zzaqz = sessionRegistrationOption;
    }

    public SessionRegistrationRequest(PendingIntent pendingIntent, zznh callback, String packageName, int sessionRegistrationOption) {
        this.mVersionCode = 5;
        this.mPendingIntent = pendingIntent;
        this.zzapE = callback;
        this.zzOZ = packageName;
        this.zzaqz = sessionRegistrationOption;
    }

    private boolean zzb(SessionRegistrationRequest sessionRegistrationRequest) {
        return this.zzaqz == sessionRegistrationRequest.zzaqz && zzw.equal(this.mPendingIntent, sessionRegistrationRequest.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionRegistrationRequest) && zzb((SessionRegistrationRequest) that));
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mPendingIntent, Integer.valueOf(this.zzaqz));
    }

    public String toString() {
        return zzw.zzu(this).zzg("pendingIntent", this.mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(this.zzaqz)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzw.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        if (this.zzapE == null) {
            return null;
        }
        return this.zzapE.asBinder();
    }

    public PendingIntent zzso() {
        return this.mPendingIntent;
    }

    public int zzsx() {
        return this.zzaqz;
    }
}
