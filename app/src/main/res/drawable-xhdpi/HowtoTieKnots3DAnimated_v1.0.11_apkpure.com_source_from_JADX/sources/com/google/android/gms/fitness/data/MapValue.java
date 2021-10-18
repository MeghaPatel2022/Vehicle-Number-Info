package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class MapValue implements SafeParcelable {
    public static final Creator<MapValue> CREATOR = new zzl();
    private final int mVersionCode;
    private final int zzaoq;
    private final float zzaou;

    public MapValue(int format, float value) {
        this(1, format, value);
    }

    MapValue(int versionCode, int format, float value) {
        this.mVersionCode = versionCode;
        this.zzaoq = format;
        this.zzaou = value;
    }

    private boolean zza(MapValue mapValue) {
        if (this.zzaoq != mapValue.zzaoq) {
            return false;
        }
        switch (this.zzaoq) {
            case 2:
                return asFloat() == mapValue.asFloat();
            default:
                return this.zzaou == mapValue.zzaou;
        }
    }

    public static MapValue zzc(float f) {
        return new MapValue(2, f);
    }

    public float asFloat() {
        zzx.zza(this.zzaoq == 2, (Object) "Value is not in float format");
        return this.zzaou;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof MapValue) && zza((MapValue) o));
    }

    /* access modifiers changed from: 0000 */
    public int getFormat() {
        return this.zzaoq;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return (int) this.zzaou;
    }

    public String toString() {
        switch (this.zzaoq) {
            case 2:
                return Float.toString(asFloat());
            default:
                return "unknown";
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }

    /* access modifiers changed from: 0000 */
    public float zzrM() {
        return this.zzaou;
    }
}
