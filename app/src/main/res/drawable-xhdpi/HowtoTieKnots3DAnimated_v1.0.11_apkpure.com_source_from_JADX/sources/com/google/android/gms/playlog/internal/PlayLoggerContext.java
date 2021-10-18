package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class PlayLoggerContext implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final String packageName;
    public final int versionCode;
    public final int zzaKR;
    public final int zzaKS;
    public final String zzaKT;
    public final String zzaKU;
    public final boolean zzaKV;
    public final String zzaKW;
    public final boolean zzaKX;
    public final int zzaKY;

    public PlayLoggerContext(int versionCode2, String packageName2, int packageVersionCode, int logSource, String uploadAccountName, String loggingId, boolean logAndroidId, String logSourceName, boolean isAnonymous, int qosTier) {
        this.versionCode = versionCode2;
        this.packageName = packageName2;
        this.zzaKR = packageVersionCode;
        this.zzaKS = logSource;
        this.zzaKT = uploadAccountName;
        this.zzaKU = loggingId;
        this.zzaKV = logAndroidId;
        this.zzaKW = logSourceName;
        this.zzaKX = isAnonymous;
        this.zzaKY = qosTier;
    }

    @Deprecated
    public PlayLoggerContext(String packageName2, int packageVersionCode, int logSource, String uploadAccountName, String loggingId, boolean logAndroidId) {
        this.versionCode = 1;
        this.packageName = (String) zzx.zzv(packageName2);
        this.zzaKR = packageVersionCode;
        this.zzaKS = logSource;
        this.zzaKW = null;
        this.zzaKT = uploadAccountName;
        this.zzaKU = loggingId;
        this.zzaKV = logAndroidId;
        this.zzaKX = false;
        this.zzaKY = 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) object;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.zzaKR == playLoggerContext.zzaKR && this.zzaKS == playLoggerContext.zzaKS && zzw.equal(this.zzaKW, playLoggerContext.zzaKW) && zzw.equal(this.zzaKT, playLoggerContext.zzaKT) && zzw.equal(this.zzaKU, playLoggerContext.zzaKU) && this.zzaKV == playLoggerContext.zzaKV && this.zzaKX == playLoggerContext.zzaKX && this.zzaKY == playLoggerContext.zzaKY;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.zzaKR), Integer.valueOf(this.zzaKS), this.zzaKW, this.zzaKT, this.zzaKU, Boolean.valueOf(this.zzaKV), Boolean.valueOf(this.zzaKX), Integer.valueOf(this.zzaKY));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayLoggerContext[");
        sb.append("versionCode=").append(this.versionCode).append(',');
        sb.append("package=").append(this.packageName).append(',');
        sb.append("packageVersionCode=").append(this.zzaKR).append(',');
        sb.append("logSource=").append(this.zzaKS).append(',');
        sb.append("logSourceName=").append(this.zzaKW).append(',');
        sb.append("uploadAccount=").append(this.zzaKT).append(',');
        sb.append("loggingId=").append(this.zzaKU).append(',');
        sb.append("logAndroidId=").append(this.zzaKV).append(',');
        sb.append("isAnonymous=").append(this.zzaKX).append(',');
        sb.append("qosTier=").append(this.zzaKY);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }
}
