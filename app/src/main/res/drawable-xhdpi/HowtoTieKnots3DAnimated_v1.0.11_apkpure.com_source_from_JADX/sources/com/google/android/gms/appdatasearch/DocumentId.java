package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentId implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final String zzOZ;
    final String zzPa;
    final String zzPb;

    DocumentId(int versionCode, String packageName, String corpusName, String uri) {
        this.mVersionCode = versionCode;
        this.zzOZ = packageName;
        this.zzPa = corpusName;
        this.zzPb = uri;
    }

    public DocumentId(String packageName, String corpusName, String uri) {
        this(1, packageName, corpusName, uri);
    }

    public int describeContents() {
        zzc zzc = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.zzOZ, this.zzPa, this.zzPb});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc zzc = CREATOR;
        zzc.zza(this, dest, flags);
    }
}
