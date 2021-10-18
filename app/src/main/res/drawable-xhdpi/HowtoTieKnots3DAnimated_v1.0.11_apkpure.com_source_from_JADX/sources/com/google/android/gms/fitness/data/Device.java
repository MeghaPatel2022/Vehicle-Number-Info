package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmi;
import com.google.android.gms.internal.zznl;

public final class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR = new zzh();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int mVersionCode;
    private final int zzUS;
    private final String zzWs;
    private final String zzanY;
    private final String zzanZ;
    private final String zzaoa;
    private final int zzaob;

    Device(int versionCode, String manufacturer, String model, String version, String uid, int type, int platformType) {
        this.mVersionCode = versionCode;
        this.zzanY = (String) zzx.zzv(manufacturer);
        this.zzanZ = (String) zzx.zzv(model);
        this.zzWs = "";
        this.zzaoa = (String) zzx.zzv(uid);
        this.zzUS = type;
        this.zzaob = platformType;
    }

    public Device(String manufacturer, String model, String uid, int type) {
        this(manufacturer, model, "", uid, type, 0);
    }

    public Device(String manufacturer, String model, String version, String uid, int type, int platformType) {
        this(1, manufacturer, model, "", uid, type, platformType);
    }

    public static Device getLocalDevice(Context context) {
        int zzaw = zzmi.zzaw(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, zzas(context), zzaw, 2);
    }

    private boolean zza(Device device) {
        return zzw.equal(this.zzanY, device.zzanY) && zzw.equal(this.zzanZ, device.zzanZ) && zzw.equal(this.zzWs, device.zzWs) && zzw.equal(this.zzaoa, device.zzaoa) && this.zzUS == device.zzUS && this.zzaob == device.zzaob;
    }

    private static String zzas(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    private boolean zzrJ() {
        return zzrI() == 1;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Device) && zza((Device) that));
    }

    public String getManufacturer() {
        return this.zzanY;
    }

    public String getModel() {
        return this.zzanZ;
    }

    /* access modifiers changed from: 0000 */
    public String getStreamIdentifier() {
        return String.format("%s:%s:%s", new Object[]{this.zzanY, this.zzanZ, this.zzaoa});
    }

    public int getType() {
        return this.zzUS;
    }

    public String getUid() {
        return this.zzaoa;
    }

    public String getVersion() {
        return this.zzWs;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanY, this.zzanZ, this.zzWs, this.zzaoa, Integer.valueOf(this.zzUS));
    }

    public String toString() {
        return String.format("Device{%s:%s:%s:%s}", new Object[]{getStreamIdentifier(), this.zzWs, Integer.valueOf(this.zzUS), Integer.valueOf(this.zzaob)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzh.zza(this, parcel, flags);
    }

    public int zzrI() {
        return this.zzaob;
    }

    public String zzrK() {
        return zzrJ() ? this.zzaoa : zznl.zzcV(this.zzaoa);
    }
}
