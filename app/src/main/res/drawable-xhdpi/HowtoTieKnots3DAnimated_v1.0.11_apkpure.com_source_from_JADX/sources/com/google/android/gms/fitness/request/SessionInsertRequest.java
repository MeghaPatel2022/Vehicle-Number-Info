package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzmh;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest implements SafeParcelable {
    public static final Creator<SessionInsertRequest> CREATOR = new zzu();
    private final int mVersionCode;
    private final String zzOZ;
    private final Session zzanp;
    private final List<DataSet> zzany;
    private final zznh zzapE;
    private final List<DataPoint> zzaqt;

    public static class Builder {
        /* access modifiers changed from: private */
        public Session zzanp;
        /* access modifiers changed from: private */
        public List<DataSet> zzany = new ArrayList();
        /* access modifiers changed from: private */
        public List<DataPoint> zzaqt = new ArrayList();
        private List<DataSource> zzaqu = new ArrayList();

        private void zzd(DataPoint dataPoint) {
            zzf(dataPoint);
            zze(dataPoint);
        }

        private void zze(DataPoint dataPoint) {
            long startTime = this.zzanp.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzanp.getEndTime(TimeUnit.NANOSECONDS);
            long startTime2 = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            long endTime2 = dataPoint.getEndTime(TimeUnit.NANOSECONDS);
            if (startTime2 != 0 && endTime2 != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (endTime2 > endTime) {
                    endTime2 = zzmh.zza(endTime2, TimeUnit.NANOSECONDS, timeUnit);
                }
                zzx.zza(startTime2 >= startTime && endTime2 <= endTime, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (endTime2 != dataPoint.getEndTime(TimeUnit.NANOSECONDS)) {
                    Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(endTime2), timeUnit}));
                    dataPoint.setTimeInterval(startTime2, endTime2, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzf(DataPoint dataPoint) {
            long startTime = this.zzanp.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzanp.getEndTime(TimeUnit.NANOSECONDS);
            long timestamp = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
            if (timestamp != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (timestamp < startTime || timestamp > endTime) {
                    timestamp = zzmh.zza(timestamp, TimeUnit.NANOSECONDS, timeUnit);
                }
                zzx.zza(timestamp >= startTime && timestamp <= endTime, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (dataPoint.getTimestamp(TimeUnit.NANOSECONDS) != timestamp) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(timestamp), timeUnit}));
                    dataPoint.setTimestamp(timestamp, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzsv() {
            for (DataSet dataPoints : this.zzany) {
                for (DataPoint zzd : dataPoints.getDataPoints()) {
                    zzd(zzd);
                }
            }
            for (DataPoint zzd2 : this.zzaqt) {
                zzd(zzd2);
            }
        }

        public Builder addAggregateDataPoint(DataPoint aggregateDataPoint) {
            zzx.zzb(aggregateDataPoint != null, (Object) "Must specify a valid aggregate data point.");
            long startTime = aggregateDataPoint.getStartTime(TimeUnit.NANOSECONDS);
            zzx.zzb(startTime > 0 && aggregateDataPoint.getEndTime(TimeUnit.NANOSECONDS) > startTime, "Aggregate data point should have valid start and end times: %s", aggregateDataPoint);
            DataSource dataSource = aggregateDataPoint.getDataSource();
            zzx.zza(!this.zzaqu.contains(dataSource), "Data set/Aggregate data point for this data source %s is already added.", dataSource);
            this.zzaqu.add(dataSource);
            this.zzaqt.add(aggregateDataPoint);
            return this;
        }

        public Builder addDataSet(DataSet dataSet) {
            boolean z = true;
            zzx.zzb(dataSet != null, (Object) "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            zzx.zza(!this.zzaqu.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            if (dataSet.getDataPoints().isEmpty()) {
                z = false;
            }
            zzx.zzb(z, (Object) "No data points specified in the input data set.");
            this.zzaqu.add(dataSource);
            this.zzany.add(dataSet);
            return this;
        }

        public SessionInsertRequest build() {
            boolean z = true;
            zzx.zza(this.zzanp != null, (Object) "Must specify a valid session.");
            if (this.zzanp.getEndTime(TimeUnit.MILLISECONDS) == 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify a valid end time, cannot insert a continuing session.");
            zzsv();
            return new SessionInsertRequest(this);
        }

        public Builder setSession(Session session) {
            this.zzanp = session;
            return this;
        }
    }

    SessionInsertRequest(int versionCode, Session session, List<DataSet> dataSets, List<DataPoint> aggregateDataPoints, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzanp = session;
        this.zzany = Collections.unmodifiableList(dataSets);
        this.zzaqt = Collections.unmodifiableList(aggregateDataPoints);
        this.zzapE = callback == null ? null : zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public SessionInsertRequest(Session session, List<DataSet> dataSets, List<DataPoint> aggregateDataPoints, zznh callback, String packageName) {
        this.mVersionCode = 2;
        this.zzanp = session;
        this.zzany = Collections.unmodifiableList(dataSets);
        this.zzaqt = Collections.unmodifiableList(aggregateDataPoints);
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    private SessionInsertRequest(Builder builder) {
        this(builder.zzanp, builder.zzany, builder.zzaqt, null, null);
    }

    public SessionInsertRequest(SessionInsertRequest request, zznh callback, String packageName) {
        this(request.zzanp, request.zzany, request.zzaqt, callback, packageName);
    }

    private boolean zzb(SessionInsertRequest sessionInsertRequest) {
        return zzw.equal(this.zzanp, sessionInsertRequest.zzanp) && zzw.equal(this.zzany, sessionInsertRequest.zzany) && zzw.equal(this.zzaqt, sessionInsertRequest.zzaqt);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionInsertRequest) && zzb((SessionInsertRequest) o));
    }

    public List<DataPoint> getAggregateDataPoints() {
        return this.zzaqt;
    }

    public List<DataSet> getDataSets() {
        return this.zzany;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    public Session getSession() {
        return this.zzanp;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanp, this.zzany, this.zzaqt);
    }

    public String toString() {
        return zzw.zzu(this).zzg("session", this.zzanp).zzg("dataSets", this.zzany).zzg("aggregateDataPoints", this.zzaqt).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzu.zza(this, dest, flags);
    }

    public IBinder zzsc() {
        if (this.zzapE == null) {
            return null;
        }
        return this.zzapE.asBinder();
    }
}
