package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;

public class SubscribeRequest implements SafeParcelable {
    public static final Creator<SubscribeRequest> CREATOR = new zzac();
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;
    private final Subscription zzaqD;
    private final boolean zzaqE;

    SubscribeRequest(int versionCode, Subscription subscription, boolean serverOnly, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzaqD = subscription;
        this.zzaqE = serverOnly;
        this.zzapE = callback == null ? null : zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public SubscribeRequest(Subscription subscription, boolean serverOnly, zznh callback, String packageName) {
        this.mVersionCode = 2;
        this.zzaqD = subscription;
        this.zzaqE = serverOnly;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzu(this).zzg("subscription", this.zzaqD).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzac.zza(this, dest, flags);
    }

    public boolean zzsA() {
        return this.zzaqE;
    }

    public IBinder zzsc() {
        if (this.zzapE == null) {
            return null;
        }
        return this.zzapE.asBinder();
    }

    public Subscription zzsz() {
        return this.zzaqD;
    }
}
