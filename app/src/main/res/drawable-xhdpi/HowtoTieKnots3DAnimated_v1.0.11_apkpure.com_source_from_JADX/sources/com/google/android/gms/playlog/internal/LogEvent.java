package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogEvent implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String tag;
    public final int versionCode;
    public final long zzaKG;
    public final long zzaKH;
    public final byte[] zzaKI;
    public final Bundle zzaKJ;

    LogEvent(int versionCode2, long eventTime, long eventUptime, String tag2, byte[] sourceExtensionBytes, Bundle keyValuePairs) {
        this.versionCode = versionCode2;
        this.zzaKG = eventTime;
        this.zzaKH = eventUptime;
        this.tag = tag2;
        this.zzaKI = sourceExtensionBytes;
        this.zzaKJ = keyValuePairs;
    }

    public LogEvent(long eventTime, long eventUptime, String tag2, byte[] sourceExtensionBytes, String... extras) {
        this.versionCode = 1;
        this.zzaKG = eventTime;
        this.zzaKH = eventUptime;
        this.tag = tag2;
        this.zzaKI = sourceExtensionBytes;
        this.zzaKJ = zzd(extras);
    }

    private static Bundle zzd(String... strArr) {
        Bundle bundle = null;
        if (strArr != null) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("extras must have an even number of elements");
            }
            int length = strArr.length / 2;
            if (length != 0) {
                bundle = new Bundle(length);
                for (int i = 0; i < length; i++) {
                    bundle.putString(strArr[i * 2], strArr[(i * 2) + 1]);
                }
            }
        }
        return bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tag=").append(this.tag).append(",");
        sb.append("eventTime=").append(this.zzaKG).append(",");
        sb.append("eventUptime=").append(this.zzaKH).append(",");
        if (this.zzaKJ != null && !this.zzaKJ.isEmpty()) {
            sb.append("keyValues=");
            for (String str : this.zzaKJ.keySet()) {
                sb.append("(").append(str).append(",");
                sb.append(this.zzaKJ.getString(str)).append(")");
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
