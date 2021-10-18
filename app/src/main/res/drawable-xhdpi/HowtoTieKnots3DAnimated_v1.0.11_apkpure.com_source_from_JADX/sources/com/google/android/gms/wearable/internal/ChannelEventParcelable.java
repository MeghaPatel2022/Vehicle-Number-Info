package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public final class ChannelEventParcelable implements SafeParcelable {
    public static final Creator<ChannelEventParcelable> CREATOR = new zzm();
    final int mVersionCode;
    final int type;
    final int zzaZP;
    final int zzaZQ;
    final ChannelImpl zzaZR;

    ChannelEventParcelable(int versionCode, ChannelImpl channel, int type2, int closeReason, int appErrorCode) {
        this.mVersionCode = versionCode;
        this.zzaZR = channel;
        this.type = type2;
        this.zzaZP = closeReason;
        this.zzaZQ = appErrorCode;
    }

    private static String zzkB(int i) {
        switch (i) {
            case 1:
                return "CHANNEL_OPENED";
            case 2:
                return "CHANNEL_CLOSED";
            case 3:
                return "INPUT_CLOSED";
            case 4:
                return "OUTPUT_CLOSED";
            default:
                return Integer.toString(i);
        }
    }

    private static String zzkC(int i) {
        switch (i) {
            case 0:
                return "CLOSE_REASON_NORMAL";
            case 1:
                return "CLOSE_REASON_DISCONNECTED";
            case 2:
                return "CLOSE_REASON_REMOTE_CLOSE";
            case 3:
                return "CLOSE_REASON_LOCAL_CLOSE";
            default:
                return Integer.toString(i);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ChannelEventParcelable[versionCode=" + this.mVersionCode + ", channel=" + this.zzaZR + ", type=" + zzkB(this.type) + ", closeReason=" + zzkC(this.zzaZP) + ", appErrorCode=" + this.zzaZQ + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }

    public void zza(ChannelListener channelListener) {
        switch (this.type) {
            case 1:
                channelListener.onChannelOpened(this.zzaZR);
                return;
            case 2:
                channelListener.onChannelClosed(this.zzaZR, this.zzaZP, this.zzaZQ);
                return;
            case 3:
                channelListener.onInputClosed(this.zzaZR, this.zzaZP, this.zzaZQ);
                return;
            case 4:
                channelListener.onOutputClosed(this.zzaZR, this.zzaZP, this.zzaZQ);
                return;
            default:
                Log.w("ChannelEventParcelable", "Unknown type: " + this.type);
                return;
        }
    }
}
