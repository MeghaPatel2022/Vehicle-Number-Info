package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class LocalContent implements SafeParcelable {
    public static final Creator<LocalContent> CREATOR = new zzb();
    private int type;
    private final int versionCode;
    private String zzaKl;

    private LocalContent() {
        this.versionCode = 1;
    }

    LocalContent(int versionCode2, int type2, String contentUri) {
        this.versionCode = versionCode2;
        this.type = type2;
        this.zzaKl = contentUri;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LocalContent)) {
            return false;
        }
        LocalContent localContent = (LocalContent) o;
        return zzw.equal(Integer.valueOf(this.type), Integer.valueOf(localContent.type)) && zzw.equal(this.zzaKl, localContent.zzaKl);
    }

    public int getType() {
        return this.type;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.type), this.zzaKl);
    }

    public String toString() {
        return "LocalContent[contentUri=" + this.zzaKl + ", type=" + (this.type == 1 ? "PUBLIC_CONTENT" : "APP_CONTENT") + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public String zzys() {
        return this.zzaKl;
    }
}
