package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;

public class ConverterWrapper implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private final StringToIntConverter zzaeK;

    ConverterWrapper(int versionCode, StringToIntConverter stringToIntConverter) {
        this.mVersionCode = versionCode;
        this.zzaeK = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.mVersionCode = 1;
        this.zzaeK = stringToIntConverter;
    }

    public static ConverterWrapper zza(zza<?, ?> zza) {
        if (zza instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) zza);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        zza zza = CREATOR;
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza zza = CREATOR;
        zza.zza(this, out, flags);
    }

    /* access modifiers changed from: 0000 */
    public StringToIntConverter zzoW() {
        return this.zzaeK;
    }

    public zza<?, ?> zzoX() {
        if (this.zzaeK != null) {
            return this.zzaeK;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
