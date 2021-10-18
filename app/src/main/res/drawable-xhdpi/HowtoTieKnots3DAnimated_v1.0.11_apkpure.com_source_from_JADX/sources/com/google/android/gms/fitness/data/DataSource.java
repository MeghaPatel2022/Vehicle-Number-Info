package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;

public class DataSource implements SafeParcelable {
    public static final Creator<DataSource> CREATOR = new zzf();
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private final String mName;
    private final int mVersionCode;
    private final int zzUS;
    private final Device zzanJ;
    private final Application zzanK;
    private final String zzanL;
    private final String zzanM;
    private final DataType zzanl;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String mName;
        /* access modifiers changed from: private */
        public int zzUS = -1;
        /* access modifiers changed from: private */
        public Device zzanJ;
        /* access modifiers changed from: private */
        public Application zzanK;
        /* access modifiers changed from: private */
        public String zzanL = "";
        /* access modifiers changed from: private */
        public DataType zzanl;

        public DataSource build() {
            boolean z = true;
            zzx.zza(this.zzanl != null, (Object) "Must set data type");
            if (this.zzUS < 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must set data source type");
            return new DataSource(this);
        }

        public Builder setAppPackageName(Context appContext) {
            return setAppPackageName(appContext.getPackageName());
        }

        public Builder setAppPackageName(String packageName) {
            this.zzanK = Application.zzcQ(packageName);
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzanl = dataType;
            return this;
        }

        public Builder setDevice(Device device) {
            this.zzanJ = device;
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setStreamName(String streamName) {
            zzx.zzb(streamName != null, (Object) "Must specify a valid stream name");
            this.zzanL = streamName;
            return this;
        }

        public Builder setType(int type) {
            this.zzUS = type;
            return this;
        }
    }

    DataSource(int versionCode, DataType dataType, String name, int type, Device device, Application application, String streamName) {
        this.mVersionCode = versionCode;
        this.zzanl = dataType;
        this.zzUS = type;
        this.mName = name;
        this.zzanJ = device;
        this.zzanK = application;
        this.zzanL = streamName;
        this.zzanM = zzrG();
    }

    private DataSource(Builder builder) {
        this.mVersionCode = 3;
        this.zzanl = builder.zzanl;
        this.zzUS = builder.zzUS;
        this.mName = builder.mName;
        this.zzanJ = builder.zzanJ;
        this.zzanK = builder.zzanK;
        this.zzanL = builder.zzanL;
        this.zzanM = zzrG();
    }

    public static DataSource extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataSource) zzc.zza(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private String getTypeString() {
        switch (this.zzUS) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    private boolean zza(DataSource dataSource) {
        return this.zzanM.equals(dataSource.zzanM);
    }

    private String zzrG() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTypeString());
        sb.append(":").append(this.zzanl.getName());
        if (this.zzanK != null) {
            sb.append(":").append(this.zzanK.getPackageName());
        }
        if (this.zzanJ != null) {
            sb.append(":").append(this.zzanJ.getStreamIdentifier());
        }
        if (this.zzanL != null) {
            sb.append(":").append(this.zzanL);
        }
        return sb.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSource) && zza((DataSource) that));
    }

    public String getAppPackageName() {
        if (this.zzanK == null) {
            return null;
        }
        return this.zzanK.getPackageName();
    }

    public DataType getDataType() {
        return this.zzanl;
    }

    public Device getDevice() {
        return this.zzanJ;
    }

    public String getName() {
        return this.mName;
    }

    public String getStreamIdentifier() {
        return this.zzanM;
    }

    public String getStreamName() {
        return this.zzanL;
    }

    public int getType() {
        return this.zzUS;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.zzanM.hashCode();
    }

    public String toDebugString() {
        StringBuilder append = new StringBuilder().append(this.zzUS == 0 ? "r" : "d").append(":").append(this.zzanl.zzrH());
        String str = this.zzanK == null ? "" : this.zzanK.equals(Application.zzans) ? ":gms" : ":" + this.zzanK.getPackageName();
        return append.append(str).append(this.zzanJ != null ? ":" + this.zzanJ.getModel() + ":" + this.zzanJ.getUid() : "").append(this.zzanL != null ? ":" + this.zzanL : "").toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataSource{");
        sb.append(getTypeString());
        if (this.mName != null) {
            sb.append(":").append(this.mName);
        }
        if (this.zzanK != null) {
            sb.append(":").append(this.zzanK);
        }
        if (this.zzanJ != null) {
            sb.append(":").append(this.zzanJ);
        }
        if (this.zzanL != null) {
            sb.append(":").append(this.zzanL);
        }
        sb.append(":").append(this.zzanl);
        return sb.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzf.zza(this, parcel, flags);
    }

    public Application zzrF() {
        return this.zzanK;
    }
}
