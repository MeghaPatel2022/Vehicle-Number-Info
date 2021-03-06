package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class Status implements Result, SafeParcelable {
    public static final Creator<Status> CREATOR = new zzn();
    public static final Status zzaaD = new Status(0);
    public static final Status zzaaE = new Status(14);
    public static final Status zzaaF = new Status(8);
    public static final Status zzaaG = new Status(15);
    public static final Status zzaaH = new Status(16);
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final int zzWu;
    private final String zzaaI;

    public Status(int statusCode) {
        this(statusCode, null);
    }

    Status(int versionCode, int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this.mVersionCode = versionCode;
        this.zzWu = statusCode;
        this.zzaaI = statusMessage;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int statusCode, String statusMessage) {
        this(1, statusCode, statusMessage, null);
    }

    public Status(int statusCode, String statusMessage, PendingIntent pendingIntent) {
        this(1, statusCode, statusMessage, pendingIntent);
    }

    private String zznI() {
        return this.zzaaI != null ? this.zzaaI : CommonStatusCodes.getStatusCodeString(this.zzWu);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.zzWu == status.zzWu && zzw.equal(this.zzaaI, status.zzaaI) && zzw.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzWu;
    }

    public String getStatusMessage() {
        return this.zzaaI;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzWu), this.zzaaI, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.zzWu == 16;
    }

    public boolean isInterrupted() {
        return this.zzWu == 14;
    }

    public boolean isSuccess() {
        return this.zzWu <= 0;
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzw.zzu(this).zzg("statusCode", zznI()).zzg("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzn.zza(this, out, flags);
    }

    /* access modifiers changed from: 0000 */
    public PendingIntent zznH() {
        return this.mPendingIntent;
    }
}
