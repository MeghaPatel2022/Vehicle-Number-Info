package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR = new zzba();
    final int mVersionCode;
    final int zzafk;
    final ChangeEvent zzajN;
    final CompletionEvent zzajO;
    final QueryResultEventParcelable zzajP;
    final ChangesAvailableEvent zzajQ;
    final ProgressEvent zzajR;

    OnEventResponse(int versionCode, int eventType, ChangeEvent changeEvent, CompletionEvent completionEvent, QueryResultEventParcelable queryResultEvent, ChangesAvailableEvent changesAvailableEvent, ProgressEvent progressEvent) {
        this.mVersionCode = versionCode;
        this.zzafk = eventType;
        this.zzajN = changeEvent;
        this.zzajO = completionEvent;
        this.zzajP = queryResultEvent;
        this.zzajQ = changesAvailableEvent;
        this.zzajR = progressEvent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzba.zza(this, dest, flags);
    }

    public DriveEvent zzqS() {
        switch (this.zzafk) {
            case 1:
                return this.zzajN;
            case 2:
                return this.zzajO;
            case 3:
                return this.zzajP;
            case 4:
                return this.zzajQ;
            case 5:
            case 6:
                return this.zzajR;
            default:
                throw new IllegalStateException("Unexpected event type " + this.zzafk);
        }
    }
}
