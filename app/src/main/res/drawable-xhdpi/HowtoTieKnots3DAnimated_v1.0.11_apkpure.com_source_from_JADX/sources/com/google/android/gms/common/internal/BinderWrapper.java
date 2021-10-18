package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new Creator<BinderWrapper>() {
        /* renamed from: zzad */
        public BinderWrapper createFromParcel(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        /* renamed from: zzbx */
        public BinderWrapper[] newArray(int i) {
            return new BinderWrapper[i];
        }
    };
    private IBinder zzacE;

    public BinderWrapper() {
        this.zzacE = null;
    }

    public BinderWrapper(IBinder binder) {
        this.zzacE = null;
        this.zzacE = binder;
    }

    private BinderWrapper(Parcel in) {
        this.zzacE = null;
        this.zzacE = in.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.zzacE);
    }
}
