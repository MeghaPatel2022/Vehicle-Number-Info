package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class WriteAwareParcelable implements Parcelable {
    private volatile transient boolean zzahl = false;

    public void writeToParcel(Parcel dest, int flags) {
        zzx.zzY(!zzqw());
        this.zzahl = true;
        zzI(dest, flags);
    }

    /* access modifiers changed from: protected */
    public abstract void zzI(Parcel parcel, int i);

    public final boolean zzqw() {
        return this.zzahl;
    }
}
