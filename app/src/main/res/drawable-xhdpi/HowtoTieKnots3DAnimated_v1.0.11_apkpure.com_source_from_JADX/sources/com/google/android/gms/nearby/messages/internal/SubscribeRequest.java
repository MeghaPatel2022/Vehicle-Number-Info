package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zzb.zza;

public final class SubscribeRequest implements SafeParcelable {
    public static final Creator<SubscribeRequest> CREATOR = new zzl();
    final int mVersionCode;
    public final String zzaCr;
    public final boolean zzaJJ;
    public final zzc zzaJR;
    public final Strategy zzaKd;
    public final String zzaKe;
    public final zzb zzaKf;
    public final MessageFilter zzaKg;
    public final PendingIntent zzaKh;
    public final int zzaKi;
    public final byte[] zzaKj;

    SubscribeRequest(int versionCode, IBinder messageListener, Strategy strategy, IBinder callbackAsBinder, MessageFilter filter, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName, byte[] hint, boolean isIgnoreNearbyPermission) {
        this.mVersionCode = versionCode;
        this.zzaKf = zza.zzdh(messageListener);
        this.zzaKd = strategy;
        this.zzaJR = zzc.zza.zzdi(callbackAsBinder);
        this.zzaKg = filter;
        this.zzaKh = pendingIntent;
        this.zzaKi = messageListenerKey;
        this.zzaCr = zeroPartyPackageName;
        this.zzaKe = realClientPackageName;
        this.zzaKj = hint;
        this.zzaJJ = isIgnoreNearbyPermission;
    }

    public SubscribeRequest(IBinder messageListener, Strategy strategy, IBinder callbackAsBinder, MessageFilter filter, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName, byte[] hint, boolean isIgnoreNearbyPermission) {
        this(2, messageListener, strategy, callbackAsBinder, filter, pendingIntent, messageListenerKey, zeroPartyPackageName, realClientPackageName, hint, isIgnoreNearbyPermission);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzyp() {
        if (this.zzaJR == null) {
            return null;
        }
        return this.zzaJR.asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzyq() {
        if (this.zzaKf == null) {
            return null;
        }
        return this.zzaKf.asBinder();
    }
}
