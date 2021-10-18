package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class Application implements SafeParcelable {
    public static final Creator<Application> CREATOR = new zza();
    public static final Application zzans = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    private final int mVersionCode;
    private final String zzOZ;
    private final String zzWs;
    private final String zzant;

    Application(int versionCode, String packageName, String version, String domainName) {
        this.mVersionCode = versionCode;
        this.zzOZ = (String) zzx.zzv(packageName);
        this.zzWs = "";
        this.zzant = domainName;
    }

    public Application(String packageName, String version, String domainName) {
        this(1, packageName, "", domainName);
    }

    private boolean zza(Application application) {
        return this.zzOZ.equals(application.zzOZ) && zzw.equal(this.zzWs, application.zzWs) && zzw.equal(this.zzant, application.zzant);
    }

    public static Application zzcQ(String str) {
        return zze(str, null, null);
    }

    public static Application zze(String str, String str2, String str3) {
        return "com.google.android.gms".equals(str) ? zzans : new Application(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Application) && zza((Application) that));
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    public String getVersion() {
        return this.zzWs;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzOZ, this.zzWs, this.zzant);
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.zzOZ, this.zzWs, this.zzant});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public String zzrt() {
        return this.zzant;
    }
}
