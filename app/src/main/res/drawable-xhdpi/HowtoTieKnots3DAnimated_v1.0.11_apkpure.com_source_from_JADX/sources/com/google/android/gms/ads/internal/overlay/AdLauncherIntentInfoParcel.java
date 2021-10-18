package com.google.android.gms.ads.internal.overlay;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;

@zzgk
public final class AdLauncherIntentInfoParcel implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final String intentAction;
    public final String mimeType;
    public final String packageName;
    public final String url;
    public final int versionCode;
    public final String zzAa;
    public final String zzzY;
    public final String zzzZ;

    public AdLauncherIntentInfoParcel(int versionCode2, String intentAction2, String url2, String mimeType2, String packageName2, String componentName, String intentFlagsString, String intentExtrasString) {
        this.versionCode = versionCode2;
        this.intentAction = intentAction2;
        this.url = url2;
        this.mimeType = mimeType2;
        this.packageName = packageName2;
        this.zzzY = componentName;
        this.zzzZ = intentFlagsString;
        this.zzAa = intentExtrasString;
    }

    public AdLauncherIntentInfoParcel(String intentAction2, String url2, String mimeType2, String packageName2, String componentName, String intentFlagsString, String intentExtrasString) {
        this(1, intentAction2, url2, mimeType2, packageName2, componentName, intentFlagsString, intentExtrasString);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
