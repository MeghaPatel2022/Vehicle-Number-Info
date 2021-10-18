package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
    @Deprecated
    public static final Creator<Command> CREATOR = new Creator<Command>() {
        @Deprecated
        /* renamed from: zzab */
        public Command[] newArray(int i) {
            return new Command[i];
        }

        @Deprecated
        /* renamed from: zzr */
        public Command createFromParcel(Parcel parcel) {
            return new Command(parcel);
        }
    };
    private String mValue;
    private String zzMI;
    private String zzwj;

    @Deprecated
    public Command() {
    }

    @Deprecated
    Command(Parcel in) {
        readFromParcel(in);
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.zzwj = in.readString();
        this.zzMI = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzwj;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.zzwj);
        out.writeString(this.zzMI);
        out.writeString(this.mValue);
    }
}
