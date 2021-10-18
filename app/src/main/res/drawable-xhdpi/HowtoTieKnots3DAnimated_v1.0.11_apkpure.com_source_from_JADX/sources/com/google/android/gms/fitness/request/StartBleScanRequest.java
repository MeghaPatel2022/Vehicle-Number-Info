package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zza.C1380zza;
import com.google.android.gms.fitness.request.zzn.zza;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.internal.zznh;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Creator<StartBleScanRequest> CREATOR = new zzaa();
    private final int mVersionCode;
    private final String zzOZ;
    private final List<DataType> zzanw;
    private final zznh zzapE;
    private final zzn zzaqB;
    private final int zzaqC;

    public static class Builder {
        /* access modifiers changed from: private */
        public DataType[] zzapZ = new DataType[0];
        /* access modifiers changed from: private */
        public zzn zzaqB;
        /* access modifiers changed from: private */
        public int zzaqC = 10;

        public StartBleScanRequest build() {
            zzx.zza(this.zzaqB != null, (Object) "Must set BleScanCallback");
            return new StartBleScanRequest(this);
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            zza((zzn) C1380zza.zzsa().zza(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.zzapZ = dataTypes;
            return this;
        }

        public Builder setTimeoutSecs(int stopTimeSecs) {
            boolean z = true;
            zzx.zzb(stopTimeSecs > 0, (Object) "Stop time must be greater than zero");
            if (stopTimeSecs > 60) {
                z = false;
            }
            zzx.zzb(z, (Object) "Stop time must be less than 1 minute");
            this.zzaqC = stopTimeSecs;
            return this;
        }

        public Builder zza(zzn zzn) {
            this.zzaqB = zzn;
            return this;
        }
    }

    StartBleScanRequest(int versionCode, List<DataType> dataTypes, IBinder bleScanCallback, int timeoutSecs, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzanw = dataTypes;
        this.zzaqB = zza.zzbM(bleScanCallback);
        this.zzaqC = timeoutSecs;
        this.zzapE = callback == null ? null : zznh.zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    private StartBleScanRequest(Builder builder) {
        this(zzli.zzb(builder.zzapZ), builder.zzaqB, builder.zzaqC, null, null);
    }

    public StartBleScanRequest(StartBleScanRequest request, zznh callback, String packageName) {
        this(request.zzanw, request.zzaqB, request.zzaqC, callback, packageName);
    }

    public StartBleScanRequest(List<DataType> dataTypes, zzn bleScanCallback, int timeoutSecs, zznh callback, String packageName) {
        this.mVersionCode = 3;
        this.zzanw = dataTypes;
        this.zzaqB = bleScanCallback;
        this.zzaqC = timeoutSecs;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzanw);
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    public int getTimeoutSecs() {
        return this.zzaqC;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzu(this).zzg("dataTypes", this.zzanw).zzg("timeoutSecs", Integer.valueOf(this.zzaqC)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzaa.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        if (this.zzapE == null) {
            return null;
        }
        return this.zzapE.asBinder();
    }

    public IBinder zzsy() {
        return this.zzaqB.asBinder();
    }
}
