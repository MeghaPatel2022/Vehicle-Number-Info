package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PendingCallback implements Parcelable {
    public static final Creator<PendingCallback> CREATOR = new Creator<PendingCallback>() {
        /* renamed from: zzei */
        public PendingCallback createFromParcel(Parcel parcel) {
            return new PendingCallback(parcel);
        }

        /* renamed from: zzgu */
        public PendingCallback[] newArray(int i) {
            return new PendingCallback[i];
        }
    };
    final IBinder zzacE;

    public PendingCallback(Parcel in) {
        this.zzacE = in.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getIBinder() {
        return this.zzacE;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzacE);
    }
}
