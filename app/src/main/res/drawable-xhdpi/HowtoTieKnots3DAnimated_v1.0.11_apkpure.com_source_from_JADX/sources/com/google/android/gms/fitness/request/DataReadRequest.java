package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zzms;
import com.google.android.gms.internal.zzms.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
    public static final Creator<DataReadRequest> CREATOR = new zzf();
    public static final int NO_LIMIT = 0;
    private final int mVersionCode;
    private final long zzMS;
    private final String zzOZ;
    private final long zzann;
    private final List<DataType> zzanw;
    private final int zzanz;
    private final List<DataSource> zzapG;
    private final List<DataType> zzapL;
    private final List<DataSource> zzapM;
    private final long zzapN;
    private final DataSource zzapO;
    private final int zzapP;
    private final boolean zzapQ;
    private final boolean zzapR;
    private final zzms zzapS;
    private final List<Device> zzapT;

    public static class Builder {
        /* access modifiers changed from: private */
        public long zzMS;
        /* access modifiers changed from: private */
        public long zzann;
        /* access modifiers changed from: private */
        public List<DataType> zzanw = new ArrayList();
        /* access modifiers changed from: private */
        public int zzanz = 0;
        /* access modifiers changed from: private */
        public List<DataSource> zzapG = new ArrayList();
        /* access modifiers changed from: private */
        public List<DataType> zzapL = new ArrayList();
        /* access modifiers changed from: private */
        public List<DataSource> zzapM = new ArrayList();
        /* access modifiers changed from: private */
        public long zzapN = 0;
        /* access modifiers changed from: private */
        public DataSource zzapO;
        /* access modifiers changed from: private */
        public int zzapP = 0;
        /* access modifiers changed from: private */
        public boolean zzapQ = false;
        /* access modifiers changed from: private */
        public boolean zzapR = false;
        /* access modifiers changed from: private */
        public List<Device> zzapT = new ArrayList();

        public Builder aggregate(DataSource dataSource, DataType outputDataType) {
            zzx.zzb(dataSource, (Object) "Attempting to add a null data source");
            zzx.zza(!this.zzapG.contains(dataSource), (Object) "Cannot add the same data source for aggregated and detailed");
            DataType dataType = dataSource.getDataType();
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            zzx.zzb(DataType.getAggregatesForInput(dataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", dataType, outputDataType);
            if (!this.zzapM.contains(dataSource)) {
                this.zzapM.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType inputDataType, DataType outputDataType) {
            zzx.zzb(inputDataType, (Object) "Attempting to use a null data type");
            zzx.zza(!this.zzanw.contains(inputDataType), (Object) "Cannot add the same data type as aggregated and detailed");
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(inputDataType), "Unsupported input data type specified for aggregation: %s", inputDataType);
            zzx.zzb(DataType.getAggregatesForInput(inputDataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", inputDataType, outputDataType);
            if (!this.zzapL.contains(inputDataType)) {
                this.zzapL.add(inputDataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit) {
            zzx.zzb(this.zzanz == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzanz));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzanz = 4;
            this.zzapN = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            zzx.zzb(this.zzanz == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzanz));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            zzx.zzb(activityDataSource != null, (Object) "Invalid activity data source specified");
            zzx.zzb(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.zzapO = activityDataSource;
            this.zzanz = 4;
            this.zzapN = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit) {
            zzx.zzb(this.zzanz == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzanz));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzanz = 3;
            this.zzapN = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            zzx.zzb(this.zzanz == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzanz));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            zzx.zzb(activityDataSource != null, (Object) "Invalid activity data source specified");
            zzx.zzb(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.zzapO = activityDataSource;
            this.zzanz = 3;
            this.zzapN = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketBySession(int minDuration, TimeUnit timeUnit) {
            zzx.zzb(this.zzanz == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzanz));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzanz = 2;
            this.zzapN = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByTime(int duration, TimeUnit timeUnit) {
            zzx.zzb(this.zzanz == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzanz));
            zzx.zzb(duration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(duration));
            this.zzanz = 1;
            this.zzapN = timeUnit.toMillis((long) duration);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            zzx.zza(!this.zzapG.isEmpty() || !this.zzanw.isEmpty() || !this.zzapM.isEmpty() || !this.zzapL.isEmpty(), (Object) "Must add at least one data source (aggregated or detailed)");
            zzx.zza(this.zzMS > 0, "Invalid start time: %s", Long.valueOf(this.zzMS));
            zzx.zza(this.zzann > 0 && this.zzann > this.zzMS, "Invalid end time: %s", Long.valueOf(this.zzann));
            boolean z2 = this.zzapM.isEmpty() && this.zzapL.isEmpty();
            if ((!z2 || this.zzanz != 0) && (z2 || this.zzanz == 0)) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest(this);
        }

        public Builder enableServerQueries() {
            this.zzapR = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzx.zzb(dataSource, (Object) "Attempting to add a null data source");
            zzx.zzb(!this.zzapM.contains(dataSource), (Object) "Cannot add the same data source as aggregated and detailed");
            if (!this.zzapG.contains(dataSource)) {
                this.zzapG.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzx.zzb(dataType, (Object) "Attempting to use a null data type");
            zzx.zza(!this.zzapL.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            if (!this.zzanw.contains(dataType)) {
                this.zzanw.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int limit) {
            zzx.zzb(limit > 0, "Invalid limit %d is specified", Integer.valueOf(limit));
            this.zzapP = limit;
            return this;
        }

        public Builder setTimeRange(long start, long end, TimeUnit timeUnit) {
            this.zzMS = timeUnit.toMillis(start);
            this.zzann = timeUnit.toMillis(end);
            return this;
        }
    }

    DataReadRequest(int versionCode, List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled, IBinder callback, String packageName, List<Device> filteredDevices) {
        this.mVersionCode = versionCode;
        this.zzanw = Collections.unmodifiableList(dataTypes);
        this.zzapG = Collections.unmodifiableList(dataSources);
        this.zzMS = startTimeMillis;
        this.zzann = endTimeMillis;
        this.zzapL = Collections.unmodifiableList(aggregatedDataTypes);
        this.zzapM = Collections.unmodifiableList(aggregatedDataSources);
        this.zzanz = bucketType;
        this.zzapN = bucketDurationMillis;
        this.zzapO = activityDataSource;
        this.zzapP = limit;
        this.zzapQ = flushBeforeRead;
        this.zzapR = serverQueriesEnabled;
        this.zzapS = callback == null ? null : zza.zzbu(callback);
        this.zzOZ = packageName;
        if (filteredDevices == null) {
            filteredDevices = Collections.EMPTY_LIST;
        }
        this.zzapT = filteredDevices;
    }

    private DataReadRequest(Builder builder) {
        this(builder.zzanw, builder.zzapG, builder.zzMS, builder.zzann, builder.zzapL, builder.zzapM, builder.zzanz, builder.zzapN, builder.zzapO, builder.zzapP, builder.zzapQ, builder.zzapR, null, null, builder.zzapT);
    }

    public DataReadRequest(DataReadRequest request, zzms callback, String packageName) {
        this(request.zzanw, request.zzapG, request.zzMS, request.zzann, request.zzapL, request.zzapM, request.zzanz, request.zzapN, request.zzapO, request.zzapP, request.zzapQ, request.zzapR, callback, packageName, request.zzapT);
    }

    public DataReadRequest(List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled, zzms callback, String packageName, List<Device> filteredDevices) {
        this.mVersionCode = 4;
        this.zzanw = Collections.unmodifiableList(dataTypes);
        this.zzapG = Collections.unmodifiableList(dataSources);
        this.zzMS = startTimeMillis;
        this.zzann = endTimeMillis;
        this.zzapL = Collections.unmodifiableList(aggregatedDataTypes);
        this.zzapM = Collections.unmodifiableList(aggregatedDataSources);
        this.zzanz = bucketType;
        this.zzapN = bucketDurationMillis;
        this.zzapO = activityDataSource;
        this.zzapP = limit;
        this.zzapQ = flushBeforeRead;
        this.zzapR = serverQueriesEnabled;
        this.zzapS = callback;
        this.zzOZ = packageName;
        this.zzapT = filteredDevices;
    }

    private boolean zzb(DataReadRequest dataReadRequest) {
        return this.zzanw.equals(dataReadRequest.zzanw) && this.zzapG.equals(dataReadRequest.zzapG) && this.zzMS == dataReadRequest.zzMS && this.zzann == dataReadRequest.zzann && this.zzanz == dataReadRequest.zzanz && this.zzapM.equals(dataReadRequest.zzapM) && this.zzapL.equals(dataReadRequest.zzapL) && zzw.equal(this.zzapO, dataReadRequest.zzapO) && this.zzapN == dataReadRequest.zzapN && this.zzapR == dataReadRequest.zzapR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadRequest) && zzb((DataReadRequest) that));
    }

    public DataSource getActivityDataSource() {
        return this.zzapO;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzapM;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zzapL;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzapN, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzanz;
    }

    public List<DataSource> getDataSources() {
        return this.zzapG;
    }

    public List<DataType> getDataTypes() {
        return this.zzanw;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzann, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.zzapP;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzMS, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzanz), Long.valueOf(this.zzMS), Long.valueOf(this.zzann));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataReadRequest{");
        if (!this.zzanw.isEmpty()) {
            for (DataType zzrH : this.zzanw) {
                sb.append(zzrH.zzrH()).append(" ");
            }
        }
        if (!this.zzapG.isEmpty()) {
            for (DataSource debugString : this.zzapG) {
                sb.append(debugString.toDebugString()).append(" ");
            }
        }
        if (this.zzanz != 0) {
            sb.append("bucket by ").append(Bucket.zzel(this.zzanz));
            if (this.zzapN > 0) {
                sb.append(" >").append(this.zzapN).append("ms");
            }
            sb.append(": ");
        }
        if (!this.zzapL.isEmpty()) {
            for (DataType zzrH2 : this.zzapL) {
                sb.append(zzrH2.zzrH()).append(" ");
            }
        }
        if (!this.zzapM.isEmpty()) {
            for (DataSource debugString2 : this.zzapM) {
                sb.append(debugString2.toDebugString()).append(" ");
            }
        }
        sb.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.zzMS), Long.valueOf(this.zzMS), Long.valueOf(this.zzann), Long.valueOf(this.zzann)}));
        if (this.zzapO != null) {
            sb.append("activities: ").append(this.zzapO.toDebugString());
        }
        if (this.zzapR) {
            sb.append(" +server");
        }
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public long zzkH() {
        return this.zzMS;
    }

    public long zzrw() {
        return this.zzann;
    }

    public IBinder zzsc() {
        if (this.zzapS == null) {
            return null;
        }
        return this.zzapS.asBinder();
    }

    public boolean zzsh() {
        return this.zzapR;
    }

    public boolean zzsi() {
        return this.zzapQ;
    }

    public long zzsj() {
        return this.zzapN;
    }

    public List<Device> zzsk() {
        return this.zzapT;
    }
}
